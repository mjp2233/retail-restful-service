package com.retail.services;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.retail.dao.ProductPricingRepository;
import com.retail.objects.ProductPrice;
import com.retail.objects.ProductResponse;


@Service
public class MyRetailService  {
	Logger logger = LoggerFactory.getLogger(MyRetailService.class);

    @Autowired
    ProductPricingRepository productPricingRepository;

    @Value("${service.url}")
    private String myRetailURL;

    public String getProductTitleForId(BigInteger productId) {
        logger.info("getProductInformationForId with productId: {}", productId);

        RestTemplate restTemplate = new RestTemplate();

        String url = myRetailURL + "&tcin=" + productId;
   
        ResponseEntity<ProductResponse> response
        = restTemplate.getForEntity(url, ProductResponse.class);
        
        if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            logger.info(response.getBody().getData().getProduct().getItem().getProductDescription().getTitle());

            return response.getBody().getData().getProduct().getItem().getProductDescription().getTitle();
        } else {
            logger.error("Unsuccessful call for productId {} with status code: {}", productId, response.getStatusCode());

        }
        return "";
    }

    
    /*
     * Returns the Current Pricing information based on product Id
     * @param tcin Integer value for the tcin (product) number in productPricing database
     * @return currentPrice object with value and currency_code representing price
     */
    public ProductPrice getCurrentProductPrice(BigInteger tcin) {
        logger.info("getCurrentProductPrice for tcin: {}", tcin);

        ProductPrice productPrice = productPricingRepository.findByTcin(tcin);

        return productPrice;

    }


}