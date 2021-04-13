/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.JdbcHelper;
import Entity.Product;
import Entity.StockInOutDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class StockDAO {

    public StockInOutDetail getStockofProduct(Product p) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT top 1*FROM StockInOutDetail\n"
                + "WHERE pid = ? \n"
                + "ORDER BY [date] desc";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return new StockInOutDetail(rs.getString(1),
                        p, rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return null;
    }

    public void updateStockIn(StockInOutDetail st, int in, int quantity) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE StockInOutDetail\n"
                + "SET amountIn = ?, StockQuantity = ?\n"
                + "WHERE [date] = ? and pid = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, in);
            ps.setInt(2, quantity);
            ps.setString(3, st.getDate());
            ps.setInt(4, st.getProduct().getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public StockInOutDetail searchStock(String date, int id) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM StockInOutDetail\n"
                + "WHERE [date] = ? and pid = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ProductDAO dao = new ProductDAO();
                Product p = dao.getProductById(id);
                return new StockInOutDetail(date, p, rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return null;
    }

    public void updateStockQuantity(StockInOutDetail st, int quantity, int amountOut) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE StockInOutDetail\n"
                + "SET StockQuantity = ?,\n"
                + "    amountOut = ?\n"
                + "WHERE [date] = ? and pid = ? ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(3, st.getDate());
            ps.setInt(4, st.getProduct().getId());
            ps.setInt(1, quantity);
            ps.setInt(2, amountOut);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public void createStock(String date, Product product, int quantity) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO StockInOutDetail([date], pid, StockQuantity, amountOut, amountIn)\n"
                + "VALUES(?,?,?,0,0) ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, product.getId());
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public void createStockIn(String date, Product product, int amountIn, int quantity) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO StockInOutDetail([date], pid, StockQuantity, amountOut, amountIn)\n"
                + "VALUES(?,?,?,0,?) ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, product.getId());
            ps.setInt(3, quantity);
            ps.setInt(4, amountIn);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

}
