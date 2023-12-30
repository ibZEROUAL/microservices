package com.learning.productservice.mapper;

import com.learning.productservice.dto.ProductDto;
import com.learning.productservice.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper{

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);

    List<Product> toProductList(List<ProductDto> productDtoList);

    List<ProductDto> toProductDtoList(List<Product> productList);
}
