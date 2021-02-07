package com.dev.app.payment.domain;

import com.dev.app.common.resources.domain.AbstractEntity;
import com.dev.app.payment.domain.enumeration.CollectionStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@Entity
@Table(name="collections")
public class Collection extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CollectionStatus status;
    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @OneToMany(mappedBy = "collection")
    private Set<CollectionItem> items;

}
