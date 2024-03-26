package com.learning.productservice.exceptions;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(){
        super("this product is not available");
    }
}
