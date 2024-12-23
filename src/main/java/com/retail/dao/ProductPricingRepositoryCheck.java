package com.retail.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.retail.objects.ProductPrice;

@Component
public class ProductPricingRepositoryCheck {
	Logger logger = LoggerFactory.getLogger(ProductPricingRepositoryCheck.class);

	@Autowired
	MongoTemplate mongoTemplate;
	
	public ProductPrice findProductQuery(Integer id) {
        logger.info("ProductPricingRepository for tcin: {}", id);
		System.out.println(mongoTemplate.getCollectionNames());
		System.out.println(mongoTemplate.getDb());
		ProductPrice result = mongoTemplate.findById(id, ProductPrice.class);
	
		if(result == null)
			System.out.println("No products found");
		else
			System.out.println(result.getTcin());


		return result;

	}

}