package com.productservice.productcontroller;

import com.productservice.productmodel.Product;
import com.productservice.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id)
    {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Integer id)
    {
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/{id}")
    public void deletepProduct(@PathVariable Integer id)
    {
        productService.deleteProduct(id);
    }

}
