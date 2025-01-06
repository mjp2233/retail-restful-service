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
import com.retail.objects.ProductPriceStructured;
import com.retail.objects.ProductResponse;


@Service
public class MyRetailService  {
	Logger logger = LoggerFactory.getLogger(MyRetailService.class);

    @Autowired
    ProductPricingRepository productPricingRepository;

    @Value("${service.url}")
    private String myRetailURL;

    @Autowired
    private RestTemplate restTemplate;

    public String getProductTitleForId(BigInteger productId) {
        logger.info("getProductInformationForId with productId: {}", productId);

        String url = myRetailURL + "&tcin=" + productId;
   
        try {
            ResponseEntity<ProductResponse> response
                = restTemplate.getForEntity(url, ProductResponse.class);

            if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getData() != null) {
                logger.info(response.getBody().getData().getProduct().getItem().getProductDescription().getTitle());

                return response.getBody().getData().getProduct().getItem().getProductDescription().getTitle();
            }
            return "";
        } catch (RestClientException e) {
            logger.error("Unsuccessful call for productId {} with error message code: {}", productId, e.getMessage());
            return "Default Title";
        }
    }

    
    /*
     * Returns the Current Pricing information based on product Id
     * @param tcin Integer value for the tcin (product) number in productPricing database
     * @return currentPrice object with value and currency_code representing price
     */
    public ProductPrice getCurrentProductPrice(BigInteger tcin) {
        logger.info("getCurrentProductPrice for tcin: {}", tcin);

        try  {
            ProductPrice productPrice = productPricingRepository.findByTcin(tcin);
            return productPrice;
        } catch (Exception e) {
            logger.error("Error getting product price for tcin: {}", tcin);
            throw e;
        }

    }

    /*
     * Updates the price of a product based on the product Id
     * @param productPriceRequest ProductPriceStructured object with tcin, value, and currency_code
     */
    public void updateProductPrice(ProductPriceStructured productPriceRequest) {
        logger.info("saveProductPrice for tcin: {}", productPriceRequest.getId());

        ProductPrice productPrice = new ProductPrice(productPriceRequest.getId(), productPriceRequest.getCurrentPrice().getCurrencyCode(),productPriceRequest.getCurrentPrice().getValue());

        try  {
            productPricingRepository.updateByTcin(productPriceRequest.getId(),productPriceRequest.getCurrentPrice().getValue());
        } catch (Exception e) {
            logger.error("Error saving product price for tcin: {}", productPrice.getTcin());
            throw e;
        }
    }

}