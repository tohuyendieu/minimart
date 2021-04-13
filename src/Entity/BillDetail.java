/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class BillDetail {
    private Bill bill;
    private Product product;
    private int quantity;
    private float sellPrice;

    public BillDetail() {
    }

    public BillDetail(Bill bill, Product product, int quantity, float sellPrice) {
        this.bill = bill;
        this.product = product;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
    }

    public BillDetail(Product product, int quantity, float sellPrice) {
        this.product = product;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    
}
