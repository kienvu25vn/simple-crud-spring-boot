package com.productmaintenace.service.impl;

import com.productmaintenace.entity.Product;
import com.productmaintenace.repository.ProductRepository;
import com.productmaintenace.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return (Product) productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
