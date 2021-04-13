/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.JdbcHelper;
import Entity.Category;
import Entity.Product;
import Entity.StockInOutDetail;
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
public class ProductDAO {

    Login login;

    // lấy số lượng và id của sản phẩm đc bán ít nhất
    public List<StockInOutDetail> getLeastSellingProduct(int num) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select top (?) *from StockInOutDetail\n"
                + "order by amountOut desc";
        List<StockInOutDetail> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = getProductById(rs.getInt("pid"));                
                list.add(new StockInOutDetail(rs.getString("date"), 
                        p,
                        rs.getInt("amountIn"), 
                        rs.getInt("amountOut"), 
                        rs.getInt("quantityStock")));
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

    public Category getCategory(String name) throws ClassNotFoundException, SQLException {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM Category\n"
                + "WHERE [name]= ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return (new Category(rs.getString(1), rs.getString(2)));
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

    public Product getProductById(int id) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT* FROM Product\n"
                + "WHERE id = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ProductDAO dao = new ProductDAO();
                Category c = dao.getCategory(rs.getString(2));
                Product p = new Product();
                p.setId(id);
                p.setCategory(c);
                p.setName(String.valueOf(rs.getString(3)));
                p.setUnitPrice(rs.getFloat(4));
                p.setDiscount(rs.getFloat(5));
                p.setOrigin(rs.getString(6));
                p.setSellPrice(rs.getFloat(7));
                return p;
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

    public List<StockInOutDetail> getTopSellingProduct(int num) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select top ? pid, totalOut = sum(amountOut) \n"
                + "from StockInOutDetail \n"
                + "group by StockInOutDetail.pid\n"
                + "order by totalOut desc";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, num);
            List<StockInOutDetail> list = new ArrayList<>();
            rs = ps.executeQuery();
            ProductDAO dao = new ProductDAO();
            while (rs.next()) {
                Product p = dao.getProductById(rs.getInt(1));
                list.add(new StockInOutDetail(p, rs.getInt(2)));
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
        
    public List<Product> getAllProduct() throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM Product";
        List<Product> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category cat = getCategory(rs.getString("category"));
                Product p = new Product(rs.getInt("id"),
                        cat, 
                        rs.getString("name"), 
                        rs.getFloat("unitPrice"), 
                        rs.getFloat("discount"), 
                        rs.getString("origin"), 
                        rs.getFloat("sellPrice"));
                list.add(p);
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

    public static void main(String[] args) throws Exception {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.getAllProduct());
    }

}
