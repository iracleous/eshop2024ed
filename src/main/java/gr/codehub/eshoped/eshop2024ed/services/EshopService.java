/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.eshop2024ed.services;

import gr.codehub.eshoped.eshop2024ed.exception.ProductException;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public interface EshopService {
    Product createProduct(String name);
    Long saveProduct(Product product)throws ProductException;
    List<Product> getProducts();
}
