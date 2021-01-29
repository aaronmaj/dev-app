package com.dev.app.payment.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.io.Serializable;
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
}
