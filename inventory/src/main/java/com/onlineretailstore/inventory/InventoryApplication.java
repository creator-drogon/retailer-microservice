package com.onlineretailstore.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InventoryApplication {

	@Value("${server.port}")
	private static String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
		System.out.println("------------------Inventory service is Running with the port: "+serverPort);
	}

}
