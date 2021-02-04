package com.dev.app.account.domain;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "category_name", nullable = false, unique = true)
    private String name;
    private String description;
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "category",cascade=CascadeType.ALL)
    private List<SubCategory> subCategories;


}
