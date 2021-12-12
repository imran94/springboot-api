package com.imran.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repo;

    ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> all() {
        return repo.findAll();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product newProduct) {
        return repo.save(newProduct);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
        return repo.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    return repo.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repo.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
