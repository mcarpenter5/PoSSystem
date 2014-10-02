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
public class PercentDiscount implements DiscountStrategy {

    @Override
    public double getDiscountAmount(double productPrice, double qty) {
        return (productPrice * qty * .10); 
              
    }
}
