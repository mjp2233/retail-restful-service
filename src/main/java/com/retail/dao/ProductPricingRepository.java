package com.retail.dao;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.retail.objects.ProductPrice;

public interface ProductPricingRepository extends MongoRepository<ProductPrice, BigInteger> {

  public ProductPrice findByTcin(BigInteger id);

  @Query("{ 'tcin' : ?0 }")
  @Update("{ '$set' : { 'value' : ?1 } }")
  public void updateByTcin(BigInteger id, BigDecimal value);

}