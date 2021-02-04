package com.dev.app.account.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @Column(name = "accountNo")
    private Long id;
    @Column(name = "accountCode")
    private String code;
    private String name;
    @Column(name = "en_name")
    private String enName;
    @Column(name = "rn_name")
    private String rnName;
    @ManyToOne
    @JoinColumn(name = "code")
    private SubCategory subCategory;
}

