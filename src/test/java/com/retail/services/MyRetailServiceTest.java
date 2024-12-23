package com.retail.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.retail.objects.ProductResponse;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyRetailServiceTest {

    @InjectMocks
    private MyRetailService myRetailService;

    @Mock
    private RestTemplate restTemplate;

    @Value("${service.url}")
    private String myRetailURL;

    @BeforeEach
    public void init (){
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(myRetailService, "myRetailURL", myRetailURL);
    }


    /**
     * Test of getProductById method, of class ProductController.
     */
    // @Test
    public void getProductTitleForIdTest() {
        
        ProductResponse productResponse = new ProductResponse();
        Mockito.when(restTemplate.getForEntity(ArgumentMatchers.anyString(), ArgumentMatchers.eq(ProductResponse.class)))
                .thenReturn(new ResponseEntity<>(productResponse, HttpStatus.OK));

        String result = myRetailService.getProductTitleForId(BigInteger.valueOf(13860428L));
        
        assertEquals("", result);
    }
}