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
public class FakeDatabaseAccess implements DatabaseAccessStrategy {
    private Customer[] customers = {
        new Customer ("101","Mike Carpenter"),
        new Customer ("102", "Min Latus")
    };
    
    @Override
    public Customer findCustomer(String custId)
    {
        Customer customer = null;
        for (Customer c : customers){
            if(custId.equals(c.getCustId())){
                 customer = c;
                 break;
            }
            
        }
        return customer;
}

    private Product [] products = {
        new Product("A10","Baseball ", 5.00 , new PercentDiscount()),
        new Product("B10", "Football", 10.00, new FlatRateDiscount(5.00)),
        new Product ("C10", "Hockey Stick", 25.00,new PercentDiscount())
    };
    
    @Override
    public Product findProduct(String productId){
        Product product = null;
        for (Product p : products){
            if(productId.equals(p.getProductId())){
                product = p;
                break;
            }
                
        }
        return product;
    }

   
}
