package com.dev.app.customer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @NotNull
    @Column(name ="first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name ="last_name", nullable = false)
    private String lasttName;
    @Column(name="customer_name")
    private String customerNaame;
    private String msisdn;
    @Column(name="id_number", unique = true)
    private String idNumber;



}
