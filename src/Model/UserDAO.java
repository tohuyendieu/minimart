/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.JdbcHelper;
import Entity.User;
import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserDAO {

    Login login;

    public User accountExist(String usName, String pass) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM [User] WHERE username = ? and pass = ? ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, usName);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                return u;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return null;
    }

    public List<User> getAllUser() throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM [User]";
        List<User> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public int deleteUserByID(int id) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String query = "DELETE FROM [User] WHERE id = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            result = ps.executeUpdate();
            return result;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public void updateUser(String username, String pass, int id, String name, String phone, String mail, String type) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE [User]\n"
                + "SET username = ? ,\n"
                + "    pass = ? ,\n"
                + "	[name] = ?,\n"
                + "	phone = ?,\n"
                + "	mail = ?,\n"
                + "	[type] = ?\n"
                + "WHERE id = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, mail);
            ps.setString(6, type);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public void addUser(String username, String pass, String name, String phone, String mail, String type) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO [user] (username, pass, [name], phone, mail, [type])\n"
                + "VALUES (?,?,?,?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, mail);
            ps.setString(6, type);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }
    
    public User getUserByID(int id) throws Exception{
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM [User] WHERE id = ? ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                return u;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return null;
    }
}
