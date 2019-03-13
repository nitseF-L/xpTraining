package com.prs.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(value = "com.rps")
@PropertySource("classpath:persistence.properties")
public class ApplicationTest {

    @Test
    public void contextLoads() throws Exception {

    }
}
