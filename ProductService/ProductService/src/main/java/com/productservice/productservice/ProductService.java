package com.productservice.productservice;

import com.productservice.productmodel.Product;
import com.productservice.productrepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Product updateProduct(Product product, Integer id) {

        Product prod=getProductById(id);

        prod.setName(product.getName());
        prod.setCompany(product.getCompany());
        prod.setQuantity(product.getQuantity());
        prod.setPrice(product.getPrice());

        return productRepository.save(prod);
    }

    public void deleteProduct(Integer id) {

        Product prod=getProductById(id);
        productRepository.delete(prod);
    }
}
