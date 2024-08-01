/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.eshop2024ed.services;

import gr.codehub.eshoped.eshop2024ed.exception.ProductException;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import gr.codehub.eshoped.eshop2024ed.repositories.ProductRepository;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public class EshopServiceImpl implements EshopService{
     private final ProductRepository productRepository;

    public EshopServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String name) {
        
      return new Product();
    }

    @Override
    public Long saveProduct(Product product) throws ProductException {
        productRepository.save(product);
        return product.getId();
    
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    
}
