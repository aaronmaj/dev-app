package com.dev.app.payment.controller;

import com.dev.app.payment.api.PaymentService;
import com.dev.app.payment.domain.Payment;
import com.dev.app.payment.dto.PaymentDto;
import com.google.common.base.Preconditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
@RefreshScope
class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<PaymentDto> getAllPayments() {
        return paymentService.getAll()
                .stream()
                .map(payment -> modelMapper.map(payment,PaymentDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@RequestBody Payment payment){
        Preconditions.checkNotNull(payment);
        return null; // to be implemented
    }

    private PaymentDto convertToDto(Payment payment){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(payment,PaymentDto.class);
    }
}
