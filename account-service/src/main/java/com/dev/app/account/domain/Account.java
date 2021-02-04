package com.dev.app.account.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @Column(name = "account_no")
    private Long id;
    @NotNull
    @Column(name = "account_code")
    private String code;
    @NotNull
    @Column(name = "account_name")
    private String name;
    @Column(name = "en_name")
    private String enName;
    @Column(name = "rn_name")
    private String rnName;
    @ManyToOne
    @JoinColumn(name = "code")
    private SubCategory subCategory;
}

