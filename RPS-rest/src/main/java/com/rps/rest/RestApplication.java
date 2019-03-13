package com.rps.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(value = "com.rps")
@PropertySource("classpath:persistence.properties")
public class RestApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {

        SpringApplication.run( RestApplication.class, args);
    }
}
