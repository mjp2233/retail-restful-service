package com.retail.dao;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retail.objects.ProductPrice;

public interface ProductPricingRepository extends MongoRepository<ProductPrice, BigInteger> {

  public ProductPrice findByTcin(BigInteger id);

}