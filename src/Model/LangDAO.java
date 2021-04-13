/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Helper.JdbcHelper;
import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class LangDAO {

    Login login;

    public void setLang(String lang1, String lang2) throws Exception {
        JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE [Language]\n"
                + "set lang = ?\n"
                + "WHere lang = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, lang2);
            ps.setString(2, lang1);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
    }

    public String getLang() throws Exception {
         JdbcHelper db = new JdbcHelper();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT*FROM [Language]";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return (rs.getString(1));
            }
        } catch (Exception ex) {
            throw ex;
        } finally{
            db.closeResusult(rs);
            db.closePreparedStatement(ps);
            db.closeConnection(conn);
        }
        return null;
    }
}
