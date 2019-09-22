package com.example1.demo1.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceComponentTest {

/*  note: don't use autowired like this, for little components. it's apparently poor practice and the test blows up
    @Autowired
    private ServiceComponent serviceComponent;*/
    private ServiceComponent serviceComponent = new ServiceComponent();
    // note: autowiring of a private field DOES work for Demo1ControllerTest
    // note: changing JUnit Run configuration helps. you can run Demo1Application before doing a test with an autowire

    @Test
    public void stringBehaviorTest(){ // basic unit test
        String inputTest = "test";
        String outputTest = serviceComponent.reverseMe(inputTest);

        assertThat(inputTest, not(equalTo(outputTest)));
    }

    @Test
    public void wordCountTest(){
        String inputTest = "one two three";
        int wordCount = serviceComponent.countWords(inputTest);
        assertThat(wordCount, equalTo(3));
    }

    @Test
    public void wordCountBehaviorTest(){
        String inputStr = "one two three";
        int wordCount1 = serviceComponent.countWords(inputStr);
        boolean calcFlag = serviceComponent.getCalcFlag();
        assertThat(calcFlag, equalTo(true));
        int wordCount2 = serviceComponent.countWords(inputStr);
        calcFlag = serviceComponent.getCalcFlag();
        assertThat(calcFlag, equalTo(false));

        assertThat(wordCount1, equalTo(wordCount2));
    }
}
