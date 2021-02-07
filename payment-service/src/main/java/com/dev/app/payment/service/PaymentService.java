package com.dev.app.payment.service;

import com.dev.app.common.resources.dto.PaymentDto;
import com.dev.app.payment.domain.Payment;
import com.dev.app.payment.repository.PaymentRepository;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PaymentService {
    public final PaymentRepository paymentRepository;
    public final ModelMapper modelMapper;

    /** Let @Lombok generate the constructor with Constructor Dependency injection */
    /*
    @Autowired
    public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }
    */
    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return paymentRepository.findAll()
                .stream()
                .map(payment -> convertToDto(payment))
                .collect(Collectors.toList());
    }

    @Transactional
    public PaymentDto findById(Long id) {
        return paymentRepository.findById(id).map(payment -> convertToDto(payment)).orElse(null);
    }

    public PaymentDto save(PaymentDto paymentDto){
        return convertToDto(
                paymentRepository.save(modelMapper.map(paymentDto,Payment.class))
        );
    }
    public PaymentDto update(Long id, PaymentDto paymentDto){
        Payment payment=paymentRepository.findById(id).orElse(null);
        Preconditions.checkNotNull(payment);
        payment =paymentRepository.save(payment);
        return convertToDto(payment);

    }
    public PaymentDto delete(Long id){
        Payment payment=paymentRepository.findById(id).orElse(null);
        Preconditions.checkNotNull(payment);
        paymentRepository.deleteById(id);
        return convertToDto(payment);
    }

    public boolean existsById(Long id){
        return paymentRepository.existsById(id);
    }

    private PaymentDto convertToDto(Payment payment) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(payment, PaymentDto.class);
    }
}
