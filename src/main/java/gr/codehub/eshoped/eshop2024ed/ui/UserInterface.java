/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.eshoped.eshop2024ed.ui;

import gr.codehub.eshoped.eshop2024ed.model.Basket;
import gr.codehub.eshoped.eshop2024ed.model.Product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DimitrisIracleous
 */
public class UserInterface {
    
    
    private final UserSelections userSelections;

    public UserInterface(UserSelections userSelections) {
        this.userSelections = userSelections;
    }
    
    
    public void perform(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give your role. 1= customer, 2=EshopManager");
        int selectionRole;
        
        try{
            selectionRole = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            selectionRole = 0;
        }
        switch (selectionRole){
            case 1 -> performCustomer();
            case 2 -> performManager();
        }
    }
  
    
    
     public void performCustomer(){
         
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
       Give your choice
            1. getProductInfo 
            2. addToBasket 
            3. showBasket 
            4. pay 
        """);
        
        int selection;
        
        try{
            selection= Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            selection = 0;
        }
        switch (selection){
            case 1 -> getProductInfo();
            case 2 -> addToBasket();
            case 3 -> showBasket () ;
            case 4 -> pay();
        } 
      
     }
    
     public void performManager(){
     }
 
     
    private void  getProductInfo(){
        String productName = "";
        List<Product> products = userSelections.getProductInfo(productName);
        System.out.println(products);
    }
     
     private void addToBasket(){
         Product product = null;
         userSelections.addToBasket(product);
     }
     
      private void showBasket(){
         // userSelections.showBasket(xx);
     }
      private void pay(){
         //  userSelections.pay(xx);
     }
}
