/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author dominicalaus
 */
public class Receipt implements ReceiptStrategy {
    private static int receiptNo;
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private DatabaseAccessStrategy db;
    private double grandTotalDue;
    private double tax=.051;
    private double totalDueBeforeTax;
    private double taxes;
    private int storeNumber=1311;
    
    public static int receiptNumber = 1;
    
    public Receipt(String custId, DatabaseAccessStrategy db) {
        this.db = db;
        customer = db.findCustomer(custId);
        receiptNo++;
        
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    /**
     * adds a line item to the receipt
     * @param qty is the quantity of the product purchase
     * @param productId unique id for a product
     */
    
     public void addLineItem(double qty, String productId){ 
        LineItem item = new LineItem(productId,db,qty);
        addToArray(item);
        
    }
     private void addToArray(LineItem item) {
        
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    } 

    @Override
    public void printReceipt(){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
        String getDate= f.format(c.getTime());
        System.out.println("\n\n\n\t\t\t\t\t Welcome To Kohl's!\n\n\n");
        System.out.println("Store number: "+ storeNumber+"\n\n");
        System.out.println("\n"+"Current Date: "+ " "+getDate+"\n\n");
        System.out.println("Customer number: " + customer.getCustId()+"\n");
        System.out.println("Customer name: "+ " " +customer.getName()+"\n");
        System.out.println("Receipt number:" + " " + receiptNo+"\n\n\n");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("ID"+"\t"+"Item"+"\t\t"+"Quanity"+"\t\t"+"Price"+"\t"+"Discount"+"\t"+"Discounted Price");
        for(LineItem item : lineItems) {
            
            
            System.out.println(item.getLineItemData());
            totalDueBeforeTax += item.getSubtotalAfterDiscount();
            
        }
        
        taxes = totalDueBeforeTax * tax;
        grandTotalDue =(totalDueBeforeTax*tax)+totalDueBeforeTax ;
        System.out.printf("\n\n\n\n\n\t\t\t\t\t\t\t\tSubTotal Due: %.2f \n\t\t\t\t\t\t\t\t Tax:%.2f \n\t\t\t\t\t\t\t\t Grand Total:%.2f",totalDueBeforeTax,taxes,grandTotalDue);
        System.out.println("\n\n\n\t\t\t\t Thank you, have a nice day!");
        System.out.println("\t\t\t---------------------------------------------");
        
        
        
        
    }
    
    
}
