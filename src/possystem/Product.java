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
public class Product {
    private String productId;
    private String productDescription;
    private double productPrice;
    
    private DiscountStrategy discount;

    public Product(String productId, String productDescription, double productPrice, DiscountStrategy ds) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.discount = ds;
    }

 

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if(productId == null || productId.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        if(productPrice <=0){
            throw new IllegalArgumentException();
        }
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        if(productDescription == null || productDescription.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.productDescription = productDescription;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }
    
    public double getDiscountAmount(double qty) {
        return discount.getDiscountAmount(productPrice, qty);
    }

    public void setDiscount(DiscountStrategy ds) {
        if(ds==null){
            throw new IllegalArgumentException();
        }
            
        
        this.discount = ds;
    }
    
}
