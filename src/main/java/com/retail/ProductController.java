package com.retail;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.retail.objects.ProductPrice;
import com.retail.objects.ProductPriceResponse;
import com.retail.services.MyRetailService;

@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	MyRetailService myRetailService;;

	@GetMapping("/product/{id}")
	public ProductPriceResponse getProductById(@PathVariable long id) {
		logger.info("getProductById with ID: {}", id);
		
		String productTitle = myRetailService.getProductTitleForId(BigInteger.valueOf(id));
		
		ProductPrice currentPrice = myRetailService.getCurrentProductPrice(BigInteger.valueOf(id));
		
		ProductPriceResponse response = new ProductPriceResponse();
		response.setId(BigInteger.valueOf(id));
		response.setName(productTitle);
		response.setCurrentPrice(response.CurrentPrice(currentPrice.getValue(),currentPrice.getCurrencyCode()));

		return response;
	}

}
