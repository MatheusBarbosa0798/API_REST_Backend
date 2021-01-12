package com.products.apirest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.products.apirest.resources.URLConnection1;

@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ApirestApplication.class, args);
		
		URLConnection1.sendGET();
		
	}

}
