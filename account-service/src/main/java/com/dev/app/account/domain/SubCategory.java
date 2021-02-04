package com.dev.app.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="sub_categories")
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "code")
    private Integer id;
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Account> accounts;
}
