package com.retail.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * Nested Java Object to represent returned JSON from  
 * myRetail External Service
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    @JsonProperty("data")
    private Data Data;

    public Data getData() {
        return Data;
    }

    public void setData(Data Data) {
        this.Data = Data;
    }

    public class Data {
        @JsonProperty("product")
        private Product product;

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public class Product {
            @JsonProperty("item")
            private Item item;
            
            @JsonProperty("tcin")
            private String tcin;

            public Item getItem() {
                return item;
            }

            public void setItem(Item item) {
                this.item = item;
            }

            public class Item {

                @JsonProperty("product_description")
                private Description productDescription;

                public Description getProductDescription() {
                    return productDescription;
                }

                public void setProductDescription(Description productDescription) {
                    this.productDescription = productDescription;
                }


                public class Description {

                    @JsonProperty("downstream_description")
                    private String downstreamDescription;

                    @JsonProperty("title")
                    private String title;

                    public String getDownstreamDescription() {
                        return downstreamDescription;
                    }

                    public void setDownstreamDescription(String downstreamDescription) {
                        this.downstreamDescription = downstreamDescription;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }

            }
        }
    }

}
