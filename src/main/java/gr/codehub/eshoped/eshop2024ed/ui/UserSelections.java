/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.eshop2024ed.ui;

import gr.codehub.eshoped.eshop2024ed.model.Basket;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DimitrisIracleous
 */
public interface UserSelections {
    //common
    List<Product> getProductInfo(String productName);
    
    //Customer
    void addToBasket(Product product);
    Basket showBasket(long basketId);
    void pay(long basketId);

    //EshopManager
    void addNewProduct(Product product);
    List<Basket> getBaskets(Date dateStart, Date dateEnd);
}
