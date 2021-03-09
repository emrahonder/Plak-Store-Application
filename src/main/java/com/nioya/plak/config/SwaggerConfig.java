package com.nioya.plak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nioya.plak.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .produces(new HashSet<>(
                        Arrays.asList("application/json")))
                .useDefaultResponseMessages(false);
    }
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Plak App API",
                "Plak Application API",
                "API TOS",
                "Terms of service",
                new Contact("Emrah Onder", "https://www.nioya.com", "emrah@nioya.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
        return apiInfo;
    }
}
