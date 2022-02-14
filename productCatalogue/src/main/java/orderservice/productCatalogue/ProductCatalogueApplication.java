package orderservice.productCatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableEurekaClient
@SpringBootApplication
public class ProductCatalogueApplication {



	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueApplication.class, args);
	}

}
