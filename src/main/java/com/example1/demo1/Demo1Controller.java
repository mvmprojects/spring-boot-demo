package com.example1.demo1;

import com.example1.demo1.service.ServiceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
// for method revstring()
import org.springframework.http.HttpStatus; // new
import org.springframework.http.ResponseEntity; // new
import org.springframework.web.bind.annotation.PostMapping; // new
import org.springframework.web.bind.annotation.RequestParam; // new

@RestController
public class Demo1Controller { // "build a controller with an endpoint that takes a string and returns the reverse str"

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
/*   after starting, use "curl localhost:8080" in cmd and it should return "Greetings from Spring Boot!"
     next, try:
        curl -d "input=abcdefg" http://localhost:8080/revstring/
     expected result: "Hello World! abcdefg gfedcba"
     for the unit test that asserts string reversal, see: ServiceComponentTest.java
     for an integration test, go to Demo1ControllerTest.java or Demo1ControllerIT.java
     finally, try:
        curl -d "input=one two three" http://localhost:8080/countwords/
     */

/*  note: avoid using autowired like this, for little components anyway. it's apparently poor practice
    @Autowired
    private ServiceComponent serviceComponent;*/
    private ServiceComponent serviceComponent = new ServiceComponent();

/*  private int lastWordCount = 0;
    private String lastCountWordsInput = "";*/

    @PostMapping("/revstring")
    public ResponseEntity<?> revstring(@RequestParam("input") String input) {
        //String output = new StringBuffer(input).reverse().toString(); moved to separate component "serviceComponent"
        String output = serviceComponent.reverseMe(input);
        return new ResponseEntity<>("Hello World! " + input + " " + output, HttpStatus.OK);
    }

    @PostMapping("/countwords")
    public ResponseEntity<?> countwords(@RequestParam("input") String input) {
/*        if (!lastCountWordsInput.equals(input)) { // only calculate again upon fresh input
            lastCountWordsInput = input;
            lastWordCount = serviceComponent.countWords(input);
        }*/
        int wordCount = serviceComponent.countWords(input);
        return new ResponseEntity<>("Hello World! " + input + " contains " + wordCount + " word(s)", HttpStatus.OK);
    }
}
