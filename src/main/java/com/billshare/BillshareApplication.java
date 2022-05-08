package com.billshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillshareApplication.class, args);
		System.out.println("Billshare application running.");
	}
}
