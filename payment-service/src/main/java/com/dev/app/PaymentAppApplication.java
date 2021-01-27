package com.dev.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PaymentAppApplication {
	//you can use -Dspring.profiles.active=dev when starting app instead of hardcoding it
	//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");

	public static void main(String[] args) {
		SpringApplication.run(PaymentAppApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
