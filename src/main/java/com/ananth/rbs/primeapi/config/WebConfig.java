package com.ananth.rbs.primeapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation (ContentNegotiationConfigurer configurer) {
        configurer.
                favorParameter(true).
                ignoreAcceptHeader(true).
                parameterName("mediaType").
                defaultContentType(APPLICATION_JSON).
                mediaType("xml", APPLICATION_XML).
                mediaType("json", APPLICATION_JSON);
    }
}
