package com.retail.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPriceStructured {

    private BigInteger id;
    private String name;

    @JsonProperty("current_price")
    private CurrentPrice currentPrice;


    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }


    public CurrentPrice CurrentPrice(BigDecimal value, String currency_code) {
        CurrentPrice cp = new CurrentPrice();
        cp.setValue(value);
        cp.setCurrencyCode(currency_code);
        return cp;
    }

    public class CurrentPrice {

        @JsonProperty("value")
        private BigDecimal value;

        @JsonProperty("currency_code")
        private String currencyCode;

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

    }

    @Override
    public String toString() {
        return "ProductPriceStructured [id=" + id + ", name=" + name + ", current price value=" + currentPrice.getValue() + "]";
    }

}