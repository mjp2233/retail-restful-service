package com.retail.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("pricing")
public class ProductPrice {

    @Id //ID fields need to be type String, BigInteger, or ObjectId
    private BigInteger tcin;

    private BigDecimal value;
    
    @JsonProperty("currency_code")
    private String currencyCode; 

    public ProductPrice(BigInteger tcin, String currencyCode, BigDecimal value) {
        this.currencyCode = currencyCode;
        this.tcin = tcin;
        this.value = value;
    }

    public BigInteger getTcin() {
        return tcin;
    }

    public void setTcin(BigInteger tcin) {
        this.tcin = tcin;
    }

    public BigDecimal getValue() {
        return value;
    }   
    
    public void setValue(BigDecimal value) {
        this.value = value;
    }   
    
    public String getCurrencyCode() {
        return currencyCode;
    }   
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}