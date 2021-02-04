package com.dev.app.payment.domain;

import com.dev.app.common.resources.domain.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="collection_items")
public class CollectionItem extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Collection collection;
}
