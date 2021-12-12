package com.imran.demoapi;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(Integer id) {
        super("Could not find product " + id);
    }
}
