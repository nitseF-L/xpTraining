package com.rps.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.rps")
//@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories("com.rps.persistence")
@EntityScan("com.rps.persistence")
public class  RestApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {

        SpringApplication.run( RestApplication.class, args);
    }
}
