/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gr.codehub.eshoped.eshop2024ed;

import gr.codehub.eshoped.eshop2024ed.exception.InvalidInputException;
import gr.codehub.eshoped.eshop2024ed.exception.NotFoundException;
import gr.codehub.eshoped.eshop2024ed.exception.ProductException;
import gr.codehub.eshoped.eshop2024ed.jpa.JpaUtil;
import gr.codehub.eshoped.eshop2024ed.model.Category;
import gr.codehub.eshoped.eshop2024ed.model.Customer;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import gr.codehub.eshoped.eshop2024ed.repositories.ProductRepository;
import gr.codehub.eshoped.eshop2024ed.services.EshopService;
import gr.codehub.eshoped.eshop2024ed.services.EshopServiceImpl;
import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */
@Slf4j
public class Eshop2024ed {

 
  public static void main(String[] args) { 

 

        
        
        log.info("CRM application starting...");
        EntityManager em = JpaUtil.getEntityManager();

        ProductRepository productRepository = new ProductRepository(em);
        EshopService eshopService = new EshopServiceImpl(productRepository);

        ///////////////////////////////////////////////////////////////
        //product table population
        try {
            Product product = eshopService.createProduct("chips");
            System.out.println("<000------------------");
            System.out.println(product.getCategory());
            product.setCategory(Category.SNACK);
            product.setPrice(1);
            eshopService.saveProduct(product);
            Product product2 = eshopService.createProduct("choco");
            eshopService.saveProduct(product2);
            
            Customer customer = new Customer();
            System.out.println(""+customer);

        } catch (ProductException ex) {
            Logger.getLogger(Eshop2024ed.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Search for a product
            System.out.println("<1.----------------------------->");
            Product product = eshopService.findProductByName("chips");
           
            System.out.println(product.getName());
            
            
            
        } catch (InvalidInputException ex) {
            Logger.getLogger(Eshop2024ed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(Eshop2024ed.class.getName()).log(Level.SEVERE, null, ex);
        }

        ///list the names of all products
         System.out.println("<2.----------------------------->");
        List<Product> products = eshopService.getProducts();
        products.forEach(cproduct -> System.out.println(cproduct.getName()));

        em.close();

        log.debug("Sample Web API started");

    }
}
