package com.dev.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.AbstractEnvironment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
public class PaymentServiceApplication {
	//you can use -Dspring.profiles.active=dev when starting app instead of hardcoding it
	//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PaymentServiceApplication.class);
		app.setApplicationStartup(new BufferingApplicationStartup(2048));
		app.setLazyInitialization(false);
		//..add other behaviours
		app.setBannerMode(Banner.Mode.OFF);
		app.setAddCommandLineProperties(false); //to disable command line properties
		app.run(args);

	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
