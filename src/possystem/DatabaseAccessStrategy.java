/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package possystem;

/**
 *
 * @author mcarpenter5
 */
public interface DatabaseAccessStrategy {

   public abstract Customer findCustomer(String custId);

   public abstract Product findProduct(String productId);
    
}
