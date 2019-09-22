package com.example1.demo1.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceComponent { // "move the logic that reverses a string to a separate component"

/*
skipped adding the full hamcrest dependency to the pom file:
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
    <version>1.3</version>
</dependency>*/

    private int lastWordCount = 0;
    private String lastCountWordsInput = "";

    private boolean calcFlag = false; // ugly workaround for now, to test if a conditional branch was touched
    public boolean getCalcFlag() {
        return calcFlag;
    }

    public String reverseMe(String input){
        return new StringBuffer(input).reverse().toString();
    }

    public int countWords(String input){
        if (input == null || input.isEmpty()) {
            calcFlag = false;
            return 0;
        }
        if (!lastCountWordsInput.equals(input)) { // only calculate again upon fresh input
            lastCountWordsInput = input;
            String[] words = input.split("\\s+");
            // \s detects spaces and needs to be escaped with a \. the + accounts for multiple spaces between words
            lastWordCount = words.length;
            calcFlag = true;
            return lastWordCount; // words.length;
        }
        else {
            calcFlag = false;
            return lastWordCount;
        }
    }
}
