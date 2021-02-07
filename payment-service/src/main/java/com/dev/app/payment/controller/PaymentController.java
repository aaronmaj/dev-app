package com.dev.app.payment.controller;

import com.dev.app.common.resources.dto.PaymentDto;
import com.dev.app.payment.service.PaymentService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.dev.app.common.resources.util.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/payments")
@RefreshScope
class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> getAllPayments() {
        return paymentService.findAll();

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
        return new ResponseEntity<>(paymentService.save(paymentDto), HttpStatus.CREATED); // to be implemented
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PaymentDto> update(@PathVariable("id") Long id, @RequestBody PaymentDto paymentDto) {


        return (!paymentService.existsById(id)) ?
                new ResponseEntity<>(paymentService.save(paymentDto), HttpStatus.CREATED) :
                ResponseEntity.ok(paymentService.update(id, paymentDto));

    }

    @DeleteMapping(value = "/id")
    public PaymentDto delete(@PathVariable("id") Long id) {
        //paymentService.findAll().removeIf(paymentDto -> paymentDto.getId().equals(id));
        return paymentService.delete(id);
    }


}
