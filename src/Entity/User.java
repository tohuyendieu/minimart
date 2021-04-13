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
public class User {
    private String username, pass;
    private int id;
    private String name, phone, mail, type;

    public User() {
    }

    public User(String username, String pass, String name, String phone, String mail, String type) {
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.type = type;
    }

    public User(String username, String pass, int id, String name, String phone, String mail, String type) {
        this.username = username;
        this.pass = pass;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
