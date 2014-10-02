/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 * This class represents a register in a PoS system situation.
 *
 * @author Michael Carpenter, mcarpenter5@my.wctc.edu
 * @version 1.00
 */
public class Register {
   
    private Receipt receipt;
    
    public void startTransaction(String custId, DatabaseAccessStrategy db){
        receipt = new Receipt(custId,db);
    }
    
    public void addItem(double qty,String productId){
        receipt.addLineItem(qty, productId);
    }

    
    public void endSaleAndOutputReceipt() {
        receipt.printReceipt();
    }
        
        
        
        
        
        
        
    }
    
   

