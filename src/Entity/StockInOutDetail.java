/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class StockInOutDetail {
    private String date;
    private Product product;
    private int amountIn, amountOut, quantityStock;
    private int totalOut;

    public StockInOutDetail() {
    }

    public StockInOutDetail(String date, Product product, int amountIn, int amountOut, int quantityStock) {
        this.date = date;
        this.product = product;
        this.amountIn = amountIn;
        this.amountOut = amountOut;
        this.quantityStock = quantityStock;
    }

    public StockInOutDetail(Product product, int totalOut) {
        this.product = product;
        this.totalOut = totalOut;
    }    

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(int amountIn) {
        this.amountIn = amountIn;
    }

    public int getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(int amountOut) {
        this.amountOut = amountOut;
    }

    public int getTotalOut() {
        return totalOut;
    }

    public void setTotalOut(int totalOut) {
        this.totalOut = totalOut;
    }
    
}
