package com.dev.app.gateway.config;

import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApiGatewayConfig {

    private final ZuulProperties zuulProperties;


    public ApiGatewayConfig(ZuulProperties zuulProperties) {
        this.zuulProperties = zuulProperties;
    }

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider() {
        return ()->{
            List<SwaggerResource> resources = new ArrayList();
            zuulProperties.getRoutes()
                    .values()
                    .forEach(zuulRoute -> resources.add(createSwaggerResource(zuulRoute.getId(), "2.0")));
            return resources;
        };
    }

    private SwaggerResource createSwaggerResource(ZuulProperties.ZuulRoute route) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(route.getServiceId());
        swaggerResource.setLocation("/" + route.getId() + "/v2/api-docs");
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

    private SwaggerResource createSwaggerResource(String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(location);
        swaggerResource.setLocation("/" + location + "/v2/api-docs");
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;

    }

}
