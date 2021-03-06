/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.User;
import Helper.JdbcHelper;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author ADMIN
 */
public class AdminController extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    JdbcHelper dbConn = null;
    User user = null;
    Locale loca = new Locale("en","EN");
    ResourceBundle bun = ResourceBundle.getBundle("Translation.message", loca);
    
    public AdminController(JdbcHelper dBConn, User u) {
        initComponents();
        this.dbConn=dBConn; 
        this.user = u;
        this.setVisible(true);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VN = new javax.swing.JButton();
        EN = new javax.swing.JButton();
        btUser = new javax.swing.JButton();
        btProduct = new javax.swing.JButton();
        btCategory = new javax.swing.JButton();
        btReporting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VN.setText("Vietnamese");
        VN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VNActionPerformed(evt);
            }
        });

        EN.setText("English");
        EN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENActionPerformed(evt);
            }
        });

        btUser.setText("USER MANAGEMENT");
        btUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserActionPerformed(evt);
            }
        });

        btProduct.setText("PRODUCT MANAGEMENT");
        btProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductActionPerformed(evt);
            }
        });

        btCategory.setText("CATEGORY MANAGEMENT");

        btReporting.setText("REPORTING");
        btReporting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(VN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EN)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btReporting)
                    .addComponent(btCategory)
                    .addComponent(btProduct)
                    .addComponent(btUser))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btProduct)
                .addGap(18, 18, 18)
                .addComponent(btCategory)
                .addGap(18, 18, 18)
                .addComponent(btReporting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VN)
                    .addComponent(EN))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserActionPerformed
        new UserManagement(this, true, dbConn,loca,bun);
    }//GEN-LAST:event_btUserActionPerformed

    private void btProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductActionPerformed
        new ProducManagement(this, true, dbConn,loca,bun);
    }//GEN-LAST:event_btProductActionPerformed

    private void VNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VNActionPerformed
        this.loca = new Locale("vi","VN");
        this.bun = ResourceBundle.getBundle("Translation.message", loca);
        setLanguage();
    }//GEN-LAST:event_VNActionPerformed

    private void ENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENActionPerformed
        this.loca = new Locale("en","EN");
        this.bun = ResourceBundle.getBundle("Translation.message", loca);
        setLanguage();
    }//GEN-LAST:event_ENActionPerformed

    private void btReportingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportingActionPerformed
        new Reporting(this, true,dbConn, loca, bun);
    }//GEN-LAST:event_btReportingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EN;
    private javax.swing.JButton VN;
    private javax.swing.JButton btCategory;
    private javax.swing.JButton btProduct;
    private javax.swing.JButton btReporting;
    private javax.swing.JButton btUser;
    // End of variables declaration//GEN-END:variables

    private void setLanguage() {
        VN.setText(bun.getString("VN"));
        EN.setText(bun.getString("EN"));
        btUser.setText(bun.getString("UserManagement"));
        btProduct.setText(bun.getString("ProductManagement"));
        btCategory.setText(bun.getString("CategoryManagement"));
        btReporting.setText(bun.getString("Reporting"));
        
    }
}
