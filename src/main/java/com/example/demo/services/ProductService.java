package com.example.demo.services;

import com.example.demo.exceptions.ResourceAlreadyFound;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product addProduct(Product product) throws ResourceAlreadyFound;
    boolean existProduct(Long id);
    Product getProduct(Long id) throws ResourceNotFound;
    void  delectBtyId(Long id) throws ResourceNotFound, ResourceNotFound;
}