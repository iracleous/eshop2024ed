/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gr.codehub.eshoped.eshop2024ed;

import gr.codehub.eshoped.eshop2024ed.exception.ProductException;
import gr.codehub.eshoped.eshop2024ed.jpa.JpaUtil;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import gr.codehub.eshoped.eshop2024ed.repositories.ProductRepository;
import gr.codehub.eshoped.eshop2024ed.services.EshopService;
import gr.codehub.eshoped.eshop2024ed.services.EshopServiceImpl;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author DimitrisIracleous
 */

@Slf4j
public class Eshop2024ed {

    public static void main(String[] args) throws ProductException {
         
        
        
    log.info("CRM application starting...");
    EntityManager em = JpaUtil.getEntityManager();
        
    ProductRepository productRepository = new ProductRepository(em);
    EshopService eshopService = new EshopServiceImpl(productRepository);
        
   ///////////////////////////////////////////////////////////////
   
   Product product = eshopService.createProduct("chips");
   
   eshopService.saveProduct(product);
   
   List<Product> products = eshopService.getProducts();
   
  
   products.forEach(cproduct -> System.out.println(cproduct.getName()));
  // products.forEach( System.out::println);        
   
  // System.out.println(products);
   

    
    em.close();

        

    log.debug("Sample Web API started");
       
       
        
    }
}
