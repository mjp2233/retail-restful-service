package com.retail.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MyRetailService  {
	Logger logger = LoggerFactory.getLogger(MyRetailService.class);

    private static final String myRetail_url
  = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin=13860428";

    public String getPricingInformationForId(String productId) {
        logger.info("getPricingInformationForId with productId: {}", productId);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response
        = restTemplate.getForEntity(myRetail_url, String.class);

        //Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        System.out.println(response.getBody());
        return response.getBody();
    }

}