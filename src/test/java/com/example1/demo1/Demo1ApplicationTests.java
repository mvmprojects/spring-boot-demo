package com.example1.demo1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.assertj.core.api.Assertions.assertThat;

import com.example1.demo1.service.ServiceComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; // new
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// class automatically created by Spring Initizalizr; use assertThat on controller for basic integration test
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	//@Autowired
	//private Demo1Controller demoController; // again, this autowire can blow up as seen in ServiceComponentTest
	// note: change the JUnit Run configuration for this class, to start Demo1Application before trying contextLoads():
	// messing with the Run configuration for just one test is rather annoying though
	private Demo1Controller demoController = new Demo1Controller();

	@Test
	public void contextLoads() throws Exception { // "throws exception" apparently not needed with hamcrest assertThat
		assertThat(demoController).isNotNull();

		//assertThat(demoController, not(null)); // this hamcrest version doesn't seem to work properly
	}

}
