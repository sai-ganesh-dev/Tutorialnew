package com.example.tutorial.thirdpartyapi;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.util.Duration;
@SpringBootApplication
public class Consumingrest {
	
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Consumingrest.class);
	
	     final int TIMEOUT = 500;
	 
	
	public static void main(String[] args) {
		
		SpringApplication.run(Consumingrest.class, args);
	}
	
	
	
	
    @GetMapping("/get")
	public CommandLineRunner run(RestTemplate resttemplate) {
		
		         return arg ->{
		Quote quote = resttemplate.getForObject("https://jarvisuat.aerchain.io/api/whatsapp/integration/payment-vouchers?startDate=01-02-2022&endDate=02-02-2022", Quote.class);
		         
		              log.info(quote.toString());
		         };
		         
		         
				
		
	}

}
