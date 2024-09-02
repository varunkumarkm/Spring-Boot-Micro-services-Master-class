package com.product.service.Controller;

import com.product.service.Entity.Product;
import com.product.service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProducts")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllEmployees() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById (@PathVariable long id){
        return productService.getProductById(id);
    }

    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<Product> updateProduct (@RequestBody Product product, @PathVariable long id){
        productService.updateProduct(product, id);
        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product Entity Deleted Successfully", HttpStatus.OK);
    }
}