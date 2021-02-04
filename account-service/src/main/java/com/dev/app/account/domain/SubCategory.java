package com.dev.app.account.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="sub_categories")
public class SubCategory implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "code")
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
