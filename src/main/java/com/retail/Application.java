package com.retail;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

import com.mongodb.client.MongoClients;
import com.retail.objects.ProductPrice;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Application.class);

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		logger.info("Setting up ProductPricing table...");

		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "myRetail");

		List<ProductPrice> currentRecords = mongoOps.findAll(ProductPrice.class);

		if(!currentRecords.isEmpty()) {
			mongoOps.dropCollection(ProductPrice.class);
		}

		ProductPrice pp1 = new ProductPrice(BigInteger.valueOf(13860428), "USA", BigDecimal.valueOf(13.49));
		mongoOps.insert(pp1);

		ProductPrice pp2 = new ProductPrice(BigInteger.valueOf(54456119), "USA", BigDecimal.valueOf(19.99));
		mongoOps.insert(pp2);
		
		logger.info("ProductPricing records initialized");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
