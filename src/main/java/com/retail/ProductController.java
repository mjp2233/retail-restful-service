package com.retail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retail.services.MyRetailService;

@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);


	@Autowired
	private MyRetailService myRetailService;

	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable String id) {
		logger.info("getProductById with ID: {}", id);
		
		String response = myRetailService.getPricingInformationForId(id);

		return "Greetings from Spring Boot!"  + response;
	}

}
