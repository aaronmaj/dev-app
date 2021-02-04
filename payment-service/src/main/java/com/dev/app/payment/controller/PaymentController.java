package com.dev.app.payment.controller;

import com.dev.app.payment.service.PaymentService;
import com.dev.app.payment.dto.PaymentDto;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import static com.dev.app.payment.util.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/payments")
@RefreshScope
class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> getAllPayments() {
        return paymentService.getAll();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto findById(@PathVariable("id") Long id) {
        return paymentService.findById(id);
    }

    @PostMapping//Equivalent to  @RequestMapping(method =RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto paymentDto) {
        Preconditions.checkNotNull(paymentDto);
        return ResponseEntity.ok(paymentService.save(paymentDto)); // to be implemented
    }


}
