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
   /**
    * All the register needs to know about is the receipt class, because the register delegates the job to the receipt class.
    */
    private Receipt receipt;

   
    /**
     * 
     * @param custId Takes the custId from the Startup class, and passes it to the receipt.
     * @param db Is passed in from the Startup class, and passed into the receipt class.
     */
    
    public void startTransaction(String custId, DatabaseAccessStrategy db){
        if (custId == null || custId.isEmpty() || db == null){
            throw new IllegalArgumentException();
        }
        receipt = new Receipt(custId,db);
    }
    /**
     * 
     * @param qty qty is passed in from the Startup class, which is then passed into the receipt class from this method.
     * @param productId productId is passed in from the Startup class, which is then passed into the receipt class from this method.
     */
    public void addItem(double qty,String productId){
        if (qty < 0 || productId == null || productId.isEmpty()){
            throw new IllegalArgumentException();
        }
            
        receipt.addLineItem(qty, productId);
    }

    /**
     * This method is used to end the sale, and print out the receipt in the startup class.
     */
    public void endSaleAndOutputReceipt() {
        receipt.printReceipt();
    }
        
        
        
        
        
        
        
    }
    
   

