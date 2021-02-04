package com.dev.app.common.resources.config;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
