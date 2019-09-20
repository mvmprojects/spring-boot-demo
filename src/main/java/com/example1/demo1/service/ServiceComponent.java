package com.example1.demo1.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan // added after null ptr exception issue in ServiceComponentTest.java/failure to @Autowire
public class ServiceComponent {

/*
skipped adding the full hamcrest dependency to the pom file:
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
    <version>1.3</version>
</dependency>*/

    public String reverseMe(String input){
        String output = new StringBuffer(input).reverse().toString();
        return output;
    }
}
