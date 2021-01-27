package com.dev.app.payment.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class  DevDataSourceConfig implements DataSourceConfig{
    @Override
    public void setUp() {
        System.out.println("Set up for development profile");
    }
}
