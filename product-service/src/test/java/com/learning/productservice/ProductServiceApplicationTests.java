package com.learning.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.productservice.dto.ProductDto;
import com.learning.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductRepository productRepository;

/*    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void shouldCreateProduct() throws Exception {

        String productDto = objectMapper.writeValueAsString(getProductDto());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
                .contentType("application/json")
                .content(productDto)
        ).andExpect(status().isOk());

    }
    @Test
    void productsSize(){
        Assertions.assertEquals(1,productRepository.findAll().size());
    }

    private ProductDto getProductDto() {
        return ProductDto.builder().name("pc").description("really bad")
                .price(BigDecimal.valueOf(340)).build();
    }*/

}
