package com.dev.app.payment.domain;

import com.dev.app.common.resources.domain.AbstractEntity;
import com.dev.app.payment.domain.enumeration.PaymentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity {

    @Id
    private Long id;
    @NotNull
    @Column(name="ext_payment_id")
    private String externalPaymentId;
    @NotNull
    @Column(name="ref_no")
    private String referenceNo;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private PaymentStatus status;
    private double amount;
    private String description;



}
