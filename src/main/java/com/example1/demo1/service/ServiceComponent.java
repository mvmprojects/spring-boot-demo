package com.example1.demo1.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceComponent {

    public String reverseMe(String input){
        String output = new StringBuffer(input).reverse().toString();
        return output;
    }
}
