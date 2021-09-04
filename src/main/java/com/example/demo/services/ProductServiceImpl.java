package com.example.demo.services;

import com.example.demo.exceptions.ResourceAlreadyFound;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ResourceAlreadyFound {
        if(!existProduct(product.getId())){
            Product newProduct = productRepository.save(product);
            return newProduct;
        }else throw new ResourceAlreadyFound("AlreadyFound");
    }

    @Override
    public boolean existProduct(Long id) {
        return (productRepository.findById(id)).isEmpty()?false:true;
    }
    @Override
    public Product getProduct(Long id) throws ResourceNotFound {
        return productRepository.findById(id).orElseThrow(ResourceNotFound::new);
    }

    @Override
    public void delectBtyId(Long id) throws ResourceNotFound {
        if(existProduct(id)){
            productRepository.deleteById(id);
        }else throw new ResourceNotFound("No found");
    }

}
