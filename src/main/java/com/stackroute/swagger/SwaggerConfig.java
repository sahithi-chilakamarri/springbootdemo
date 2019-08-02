package com.stackroute.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
// the @EnableSwagger2 annotation enables Swagger support in the class.
public class SwaggerConfig {
    @Bean
    public Docket productApi(){
       // The select() method called on the Docket bean instance returns an ApiSelectorBuilder,
        // which provides the apis() and paths() methods
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.stackroute"))
                .build();
    }

}
