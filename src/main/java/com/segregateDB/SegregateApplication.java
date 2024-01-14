package com.segregateDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SegregateApplication {
	public final static String MODEL_PACKAGE = "com.segregateDB.model";

	public static void main(String[] args) {
		SpringApplication.run(SegregateApplication.class, args);
	}

}
