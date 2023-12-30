package com.learning.productservice.service;

import com.learning.productservice.dto.ProductDto;
import com.learning.productservice.mapper.ProductMapper;
import com.learning.productservice.model.Product;
import com.learning.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<ProductDto> getProducts(){
        return productMapper.toProductDtoList(productRepository.findAll());
    }

    public ProductDto getProduct(String id){
        return productMapper.toProductDto(productRepository.findById(id).get());
    }

    public ProductDto createProduct(ProductDto productDto){

        Product product = productRepository.save(productMapper.toProduct(productDto));

        return productMapper.toProductDto(product);
    }

    public ProductDto updateProduct(String id, ProductDto productDto){
        Product product = productRepository.findById(id).get();

        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return productMapper.toProductDto(productRepository.save(product));
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }

}
