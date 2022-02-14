package com.onlineretailerstore.customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlineretailerstore.customer.models.Customer;
import com.onlineretailerstore.customer.models.CustomerBillingAddress;
import com.onlineretailerstore.customer.models.CustomerShippingAddress;
import com.onlineretailerstore.customer.repository.CustomerRepository;

@EnableEurekaClient
@SpringBootApplication
public class OnlineRetailerStoreCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineRetailerStoreCustomerApplication.class, args);
	}
/*
@Configuration
class LoadDatabase {

  private final org.jboss.logging.Logger log = LoggerFactory.logger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CustomerRepository repository) {
	 
    return args -> {
    	int i=1;
    	for(i=1;i<5;i++) {
    	CustomerBillingAddress add=new CustomerBillingAddress("1-171","guntur"+i,"abc"+i,"523181","middle");
     Set<CustomerShippingAddress> shipp=new  HashSet<CustomerShippingAddress>();
 	CustomerShippingAddress ship=new CustomerShippingAddress("1-171","guntur"+i,"abc"+i,"523181","middle");
        
     shipp.add(ship);
     Set<CustomerBillingAddress> bill=new  HashSet<CustomerBillingAddress>();
  	bill.add(add);
     Customer cust=new Customer("jagadeesh", "jagadeesh@wipro.com",shipp, bill);
    	log.info("Preloading " + repository.save(cust));
    	} 
    };
  }
}*/

}
