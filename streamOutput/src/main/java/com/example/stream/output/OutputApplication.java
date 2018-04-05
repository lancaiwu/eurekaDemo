package com.example.stream.output;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OutputChannel.class)
@SpringBootApplication
public class OutputApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutputApplication.class, args);
	}
}
