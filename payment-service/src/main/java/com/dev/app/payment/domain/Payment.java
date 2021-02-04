package com.dev.app.payment.domain;

import com.dev.app.common.resources.domain.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity {

    @Id
    private Long id;
    private String externalPaymentId;
    private String referenceNo;
    private PaymentStatus paymentStatus;
    private String status;
    private double amount;
    private String description;



}
