package com.crudspring.apicrud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.apicrud.Entities.Product;
import com.crudspring.apicrud.Repositories.ProductRepository;

@RestController // For API REST
@RequestMapping("/products") // In url /products there are the products view

public class ProductController {
    
    // Intance reposotory of products
    @Autowired
    private ProductRepository productRepository;

    // Method to get all products 
    @GetMapping
    public List<Product> getAllProducts() {
        // Get all products of the DB
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        // Find the product, if the product is not found launch a exception
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with id: " + id +" was not found"));
    }


    // Method to post all products
    // Need a body with the attributes of the entity
    @PostMapping
    public Product createProduct (@RequestBody Product product) {
        // Save a product in the DB
        return productRepository.save(product);
    }

    // Method to put product and update details
    // Receive the id of the product in the path(path parameter)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        
        // Search the product or throw a exception
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with id: " + id +" was not found"));
        
        // If the product exist update
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        // return the updated product
        return productRepository.save(product);
    }
    
    // This method is used to delete products by the id
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        // Search the product or throw a exception
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with id: " + id +" was not found"));
        

        productRepository.delete(product);

        return "The product with the id " + id + 2 "was deleted";

    }
    
}
