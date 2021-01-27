package com.dev.app.payment.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("integration")
public class DefaultDataSourceConfig implements DataSourceConfig{
    @Override
    public void setUp() {
        System.out.println("Set up for integration profile");
    }
}
