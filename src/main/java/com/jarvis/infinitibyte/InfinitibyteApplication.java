package com.jarvis.infinitibyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class InfinitibyteApplication {

	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		SpringApplication.run(InfinitibyteApplication.class, args);
	}

}
