package com.example.adminka.controller;

import com.example.adminka.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private List<Product> allProducts = Arrays.asList(
            new Product(1L, "Tablet", 2999.99),
            new Product(2L, "Phone", 699.99),
            new Product(3L, "Laptop", 399.99)
    );

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public List<Product> getProductsByIds(List<Long> productIds) {
        return allProducts.stream()
                .filter(product -> productIds.contains(product.getId()))
                .collect(Collectors.toList());
    }
}
