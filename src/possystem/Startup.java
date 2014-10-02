/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author dominicalaus
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Register r = new Register();
        r.startTransaction("101", new FakeDatabaseAccess());
        r.addItem(4.00,"A10");
        r.addItem(2.00,"B10");
        r.endSaleAndOutputReceipt();
        
        Register r2 = new Register();
        r2.startTransaction("102", new FakeDatabaseAccess());
        r2.addItem(4.00,"C10");
        r2.addItem(2.00,"B10");
        r2.addItem(4.00,"A10");
        r2.endSaleAndOutputReceipt();
    }
    
}