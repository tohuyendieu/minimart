/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Bill {
    private int id;
    private String date;
    private User user;
    private float total;

    public Bill() {
    }

    public Bill(int id, String date, User user, float total) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.total = total;
    }

    public Bill(String date, User user, float total) {
        this.date = date;
        this.user = user;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
