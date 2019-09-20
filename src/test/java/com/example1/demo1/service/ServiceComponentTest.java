package com.example1.demo1.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceComponentTest {

/*  note: don't use autowired this way. it's apparently poor practice and doesn't work in test directory
    @Autowired
    private ServiceComponent serviceComponent;*/
    private ServiceComponent serviceComponent = new ServiceComponent();

    @Test
    public void stringBehaviorTest(){
        String inputTest = "test";
        String outputTest = serviceComponent.reverseMe(inputTest);

        assertThat(inputTest, not(equalTo(outputTest)));

    }
}
