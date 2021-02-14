package com.dev.app.payment;

import com.dev.app.common.resources.config.MapperConfig;
import com.dev.app.common.resources.config.SwaggerConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCircuitBreaker
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableAspectJAutoProxy
@EnableSwagger2
@Import({SwaggerConfig.class, MapperConfig.class})
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
	/* Wrap third-party components and incorporate their properties into the application’s Environment”

	@Bean
	@ConfigurationProperties(prefix = "security")
	DefinedClass createBean(){
		return new DefinedClass();
	}

	 */
}
