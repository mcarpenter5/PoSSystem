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
public class FlatRateDiscount implements DiscountStrategy {
    private double flatAmount = 5.00;

    public FlatRateDiscount(double flatAmount) {
        this.flatAmount = flatAmount;
    }



    @Override
    public double getDiscountAmount(double productPrice, double qty) {
        return (productPrice - 5);
    
    }

    public double getFlatAmount() {
        return flatAmount;
    }

    public void setFlatAmount(double flatAmount) {
        this.flatAmount = flatAmount;
    }
    
    
}
