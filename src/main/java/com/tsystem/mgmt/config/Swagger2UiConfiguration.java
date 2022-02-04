package com.tsystem.mgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {
	
	  @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.tsystem.mgmt.controller"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiInfo());
	    }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Person Address management system")
				.description("Person Address management system")
				.termsOfServiceUrl("http://pawanpatil.in")
				.licenseUrl("pawanpatil.rocks@gmail.com").version("1.0").build();
	}

}
