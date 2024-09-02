package com.product.service.Service;

import com.product.service.Entity.Product;
import com.product.service.Exception.ResourceNotFoundException;
import com.product.service.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public void save(Product product) {
        productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product Id doesn't exists"));
    }

    public void updateProduct(Product product, long id) {
        productRepo.save(product);
        productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product Id does not exists"));
    }

    public void deleteProductById(long id) {
        productRepo.deleteById(id);
    }
}
