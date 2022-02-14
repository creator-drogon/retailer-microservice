package com.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.order.entity.LineItem;
import com.order.entity.Cart;
import com.order.service.LineItemService;
import com.order.service.OrderService;

//import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
@EnableSwagger2
public class OnlineRetailStoreApplication {
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	LineItemService itemservice;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineRetailStoreApplication.class, args);
		log.info("Server is up at 7878 port");
	}
	
//	@Bean
//	CommandLineRunner TestingCustomerAndShipping(){
//		
//		return (args)->{
//			LineItem item1 = new LineItem();
//			item1.setPrice(100.0);
//			item1.setProductId(1001);
//			item1.setProductName("TV");
//			item1.setQuantity(2);
//			
//			LineItem item2 = new LineItem(2, "Mobile", 1, 50.0);
//			
//			Cart order1 = new Cart();
//			order1.setOrderDate(LocalDate.now());
//			order1.addItem(item1);
//			order1.addItem(item2);
//			
//			log.info("############ Saving the order");
//			Cart savedOrder1 = orderservice.saveOrder(order1);
//			log.info("############ Order Saved ######## :::: " + savedOrder1.toString());
//			
//			log.info("############ Items in the orderid  : 1   "+itemservice.getLineItems(1).size());
//			log.info("############ Items in the orderid  : 1   "+itemservice.getLineItems(1).get(0).toString()+" #### "+itemservice.getLineItems(1).get(1).toString());
//			
//			log.info("########### Order : #1 " + orderservice.searchOrder(1).toString());
//		};
//	}
	
	@Bean
	public Docket swaggerImpl(){
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build();
	}

}
