package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceAlreadyFound;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.models.Product;
import com.example.demo.services.ProductServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Product> getProducts(@RequestBody Product product) throws ResourceAlreadyFound {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ResourceNotFound {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) throws ResourceNotFound {
        productService.delectBtyId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
