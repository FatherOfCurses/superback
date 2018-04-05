package com.lmig.ci.superhero.superherosightings.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@EnableSwagger2
//@EnableWebMvc
//allows Swagger to include Spring Data REST endpoints
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})

@SwaggerDefinition(
        info = @Info(
                description = "Description",
                version = "V12.0.12",
                title = "The Hero API",
                termsOfService = "Terms",
                contact = @Contact(
                        name = "Colin Principe",
                        email = "colin@colinprincipe.com",
                        url = "http://colinprincipe.com"
                )

        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Meteorology", url = "http://theweatherapi.io/meteorology.html")
)

public class SwaggerConfig {

        private static final String API_REGEX = "/api.*";
        public static final int CURRENT_YEAR = LocalDate.now().getYear();
        public static final String COPYRIGHT = String.format("Copyright (C) %d, Liberty Mutual Group", CURRENT_YEAR);

        @Value("${spring.application.name}")
        private String applicationName;

        @Value("${swagger.api.description:}")
        private String apiDescription;

        @Bean
        public ApiInfo swaggerApiInfo() {
            return swaggerApiInfo(applicationName, apiDescription);
        }

        /**
         * Generate ApiInfo for any custom dockets you have.
         *
         * @param title The title of the docket.
         * @param description The description the user will see.
         * @return An ApiInfo with the title/description/copyright/version and license filled.
         */
        public ApiInfo swaggerApiInfo(String title, String description) {
            return new ApiInfoBuilder()
                    .title(title)
                    .description(description)
                    .version("1.0.0")
                    .license(COPYRIGHT)
                    .build();
        }

        /**
         * Swagger Springfox configuration.
         */
        @Bean
        public Docket swaggerSpringfoxDocketApi() {

            return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("UserOperations")
                    .apiInfo(swaggerApiInfo())
                    .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                    .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.regex(API_REGEX))
                    .build();
        }


    }

