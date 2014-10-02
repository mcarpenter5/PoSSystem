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
public class LineItem {
   private Product product;
   private DatabaseAccessStrategy db;
   private double qty;

    public LineItem(String productId, DatabaseAccessStrategy db, double qty) {
        product = db.findProduct(productId);
        this.db = db;
        this.qty = qty;
    }

    public double getQty() {
        return qty;
    }

    public double getSubtotalAfterDiscount() {
        return (product.getProductPrice() * qty) - getDiscountAmt();
    }
    
    public double getDiscountAmt() {
        return product.getDiscountAmount(qty);
    }
    
    private double getSubtotal() {
        return (product.getProductPrice() * qty) - getDiscountAmt();
    }

    public String getLineItemData() {
        // ID     Desc     Qty   UnitPrice    Discount   Subtotal
        
        return 
                product.getProductId() + "\t" + product.getProductDescription()
                + "\t" + qty + "\t\t" + product.getProductPrice() + "\t"
                + getDiscountAmt() + "\t\t" + getSubtotal();
    }
   
    
}
