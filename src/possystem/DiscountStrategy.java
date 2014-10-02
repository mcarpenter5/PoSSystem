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
public interface DiscountStrategy {
    public abstract double getDiscountAmount(double productPrice, double qty);
        
    
}
