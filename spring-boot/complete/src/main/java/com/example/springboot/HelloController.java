package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
//	static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
