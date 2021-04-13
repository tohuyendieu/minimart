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
public class Product {
    private int id;
    private Category category;
    private String name;
    private float unitPrice, discount;
    private String origin;
    private float sellPrice;

    public Product() {
    }

    public Product(int id, Category category, String name, float unitPrice, float discount, String origin, float sellPrice) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.origin = origin;
        this.sellPrice = sellPrice;
    }

    public Product(Category category, String name, float unitPrice, float discount, String origin, float sellPrice) {
        this.category = category;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.origin = origin;
        this.sellPrice = sellPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }
}
