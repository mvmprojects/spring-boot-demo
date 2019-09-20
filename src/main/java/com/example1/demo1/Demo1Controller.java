package com.example1.demo1;

import com.example1.demo1.service.ServiceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
// for method simpletest()
import org.springframework.http.HttpStatus; // new
import org.springframework.http.ResponseEntity; // new
import org.springframework.web.bind.annotation.PostMapping; // new
import org.springframework.web.bind.annotation.RequestParam; // new

@RestController
public class Demo1Controller {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
//    after starting, use
//      curl localhost:8080
//    in cmd and it should return "Greetings from Spring Boot!"

//    example of curl with data:
//      curl -d "username=mkyong&password=abc" http://localhost:8080/api/login/

/*  note: don't use autowired this way. it's apparently poor practice and doesn't work in the test directory for ServiceComponentTest.java
    @Autowired
    private ServiceComponent serviceComponent;*/
    private ServiceComponent serviceComponent = new ServiceComponent();

// simple test
    @PostMapping("/simpletest")
    public ResponseEntity<?> simpletest(@RequestParam("input") String input) {
        //String output = new StringBuffer(input).reverse().toString(); // moved to separate component
        String output = serviceComponent.reverseMe(input);
        // after starting, try:
        //  curl -d "input=abcdefg" http://localhost:8080/simpletest/
        // expected result: Hello World! abcdefg gfedcba
        return new ResponseEntity<>("Hello World! " + input + " " + output, HttpStatus.OK);
    }
}
