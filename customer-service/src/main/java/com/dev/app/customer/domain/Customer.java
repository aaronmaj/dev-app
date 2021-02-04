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
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @NotNull
    @Column(name ="first_name", nullable = false)
    private String firstName;
    @NotNull
    @Column(name ="last_name", nullable = false)
    private String lastName;
    @Column(name="customer_name")
    private String customerName;
    private String msisdn;
    @Column(name="id_number", unique = true)
    private String idNumber;



}
