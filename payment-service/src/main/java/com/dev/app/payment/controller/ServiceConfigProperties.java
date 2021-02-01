package com.dev.app.payment.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payment.service")
@Data
public class ServiceConfigProperties {
    private String appKey;
    private String version;
    private String endpoint;
}
