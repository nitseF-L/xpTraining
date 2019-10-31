package com.prs.rest;

import com.rps.rest.RestApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=RestApplication.class)
public class ApplicationTest {


    @Test
    public void contextLoads() throws Exception {

    }
}
