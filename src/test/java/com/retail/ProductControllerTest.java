package com.retail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.retail.objects.ProductPrice;
import com.retail.objects.ProductPriceStructured;
import com.retail.services.MyRetailService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductControllerTest {

    
    @InjectMocks
    private ProductController productController;

    @Mock
    private MyRetailService myRetailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getProductById_Success() {
        long productIdL = 13860428L;
        BigInteger productId = BigInteger.valueOf(productIdL);
        String expectedTitle = "Expected Product Title";
        ProductPrice expectedPrice = new ProductPrice(productId, "USD", BigDecimal.valueOf(12.99));

        Mockito.when(myRetailService.getProductTitleForId(productId))
                .thenReturn(expectedTitle);
        Mockito.when(myRetailService.getCurrentProductPrice(productId))
                .thenReturn(expectedPrice);

        ProductPriceStructured response = productController.getProductById(productIdL);

        assertEquals(productId, response.getId());
        assertEquals(expectedTitle, response.getName());
        assertEquals(expectedPrice.getValue(), response.getCurrentPrice().getValue());
        assertEquals(expectedPrice.getCurrencyCode(), response.getCurrentPrice().getCurrencyCode());
    }
 
}