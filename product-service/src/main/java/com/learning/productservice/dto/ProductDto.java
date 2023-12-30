package com.learning.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductDto {

    private String name;

    private String description;

    private BigDecimal price;
}
