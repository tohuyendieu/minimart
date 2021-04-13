/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.JdbcHelper;
import Entity.Bill;
import Entity.BillDetail;
import Entity.StockInOutDetail;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BillDAO {
     public int createBill(User user, String date, Float total) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        String query = "INSERT INTO Bill ([date], seller, total)\n"
                + "VALUES (?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, user.getId());
            ps.setFloat(3, total);
            n = ps.executeUpdate();
            return n;
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return n;
    }
    
    public Bill getBill(String date, int id) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM Bill\n"
                + "WHERE [date] = ? and seller = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill();
                bill.setUser(new UserDAO().getUserByID(id));
                bill.setDate(date);
                bill.setTotal(rs.getFloat(4));
                bill.setId(rs.getInt(1));

                return bill;
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

    public void insertBillDetail(BillDetail detail, Bill b) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO BillDetail (bid, pid, quantity, sellPrice)\n"
                + "VALUES(?,?,?,?)";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, b.getId());
            ps.setInt(2, detail.getProduct().getId());
            ps.setInt(3, detail.getQuantity());
            ps.setFloat(4, detail.getSellPrice());
            ps.executeUpdate();
            StockDAO dao = new StockDAO();
            String date = java.time.LocalDate.now().toString();
            StockInOutDetail st = dao.searchStock(date, detail.getProduct().getId());
            if (st != null) {
                dao.updateStockQuantity(st,
                        st.getQuantityStock() - detail.getQuantity(),
                        st.getAmountOut() + detail.getQuantity());
            } else {
                dao.createStock(date, detail.getProduct(), detail.getQuantity());
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }

    }

    public List<Bill> getTopBill(int num) throws Exception{
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT TOP (?) id, date, seller, total\n"
                + "FROM Bill\n"
                + "ORDER BY total desc";
        try {
            conn = db.getConnection();
            List<Bill> list = new ArrayList<>();
            ps = conn.prepareStatement(query);
            ps.setInt(1, num);
            rs = ps.executeQuery();
            ProductDAO dao = new ProductDAO();
            while (rs.next()) {
                User u = new UserDAO().getUserByID(rs.getInt(3));
                list.add(new Bill(rs.getInt(1), rs.getString(2),
                        u, rs.getInt(4)));
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
}
