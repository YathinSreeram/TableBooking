package com.yathin.TableBookingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TableBookingApplication {

	public static void main(String[] args) {

		SpringApplication.run(TableBookingApplication.class, args);
	}
}
