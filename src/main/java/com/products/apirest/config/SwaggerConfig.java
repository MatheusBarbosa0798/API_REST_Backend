package com.products.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket meterApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.products.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }


	private ApiInfo metaInfo() {

        @SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "Meters API REST",
                "Registry and management, API REST of meters.",
                "1.0",
                "Terms of Service",
                new Contact("Matheus Barbosa", "",
                        "matheusbarbosa0798@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
