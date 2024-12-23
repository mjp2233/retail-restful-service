package com.retail.objects;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPriceStructured {

    private BigInteger id;
    private String name;
    @JsonProperty("current_price")
    private CurrentPrice current_price;


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
        return current_price;
    }
    public void setCurrentPrice(CurrentPrice current_price) {
        this.current_price = current_price;
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
        private String currency_code;

        public String getCurrencyCode() {
            return currency_code;
        }

        public void setCurrencyCode(String currency_code) {
            this.currency_code = currency_code;
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
        return "ProductPriceStructured [id=" + id + ", name=" + name + ", current price value=" + current_price.getValue() + "]";
    }

}