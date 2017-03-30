/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author situsnow
 */
public class MembershipPanel extends javax.swing.JPanel {

    Object columnHeaders[] = {"TIER_ID", "MEMBERSHIP_TIER", "TIER_CREDIT", "DISCOUNT", "OTHER_REWARDS"};
    Object data[][] = {{}};
    DefaultTableModel dtm = new DefaultTableModel(data, columnHeaders);
    
    public final static String DIGIT_CREDIT_ONLY = "Please input digit for available credit only.";
    
    public final static String SELECT_MEMBERSHIP = "SELECT TIER_ID, MEMBERSHIP_TIER, "
            + "TIER_CREDIT, DISCOUNT, OTHER_REWARDS FROM MEMBERSHIP";
    public final static String SELECT_MEMBERSHIP_BY_CREDIT = " WHERE TIER_CREDIT <= ";
    public final static String MULTIPLE_SELECTION = "Please select one membership only.";
    public final static String NO_SELECTION = "Please select at least one membership.";
    public final static String UPDATE_MEMBERSHIP = "UpdateMembership";
    public final static String INSERT_MEMBERSHIP = "InsertMembership";
    
    public final static String CONFIRM_DELETE_MEMBERSHIP = "The membership information will be deleted. Please click Yes to proceed.";
    public final static String UPDATE_MEMBERSHIP_S = "Membership is deleted. Please refresh.";
    public final static String UPDATE_MEMBERSHIP_F = "Fail to delete membership, there is customer attached to this membership. "
            + "Please delete correpondent customer first";
    public final static String DELETE_MEMBERSHIP = "DELETE MEMBERSHIP WHERE TIER_ID = ";
    /**
     * Creates new form MembershipFrame
     */
    public MembershipPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(701, 500));

        jLabel1.setText("Avaiable Credit");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(dtm);
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Insert Membership");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Update Membership");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete Membership");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: update
        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount > 1){
            JOptionPane.showMessageDialog(null, MULTIPLE_SELECTION);
        }else if (selectedRowCount == 0){
            JOptionPane.showMessageDialog(null, NO_SELECTION);
        }else{
            MembershipBean membership = constructMembershipBean();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MembershipInsertUpdateDialog(membership, UPDATE_MEMBERSHIP).setVisible(true);
                }
            });
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private MembershipBean constructMembershipBean(){
        
        MembershipBean membership = new MembershipBean();
        
        int selectedMembership = jTable1.getSelectedRow();
        membership.setTier_id(((BigDecimal)jTable1.getModel().getValueAt(selectedMembership, 0)).intValue());
        membership.setMembership_tier((String)jTable1.getModel().getValueAt(selectedMembership, 1));
        membership.setTier_credit(((BigDecimal)jTable1.getModel().getValueAt(selectedMembership, 2)).intValue());
        membership.setDiscount(((BigDecimal)jTable1.getModel().getValueAt(selectedMembership, 3)).intValue());
        membership.setOther_rewards((String)jTable1.getModel().getValueAt(selectedMembership, 4));
        
        
        return membership;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String availCredit = jTextField1.getText();
        StringBuffer sb = new StringBuffer(SELECT_MEMBERSHIP);
        if(!"".equals(availCredit)){        
            boolean availCredit_Numeric = availCredit.chars().allMatch(Character :: isDigit);
            if(availCredit_Numeric == false){
                JOptionPane.showMessageDialog(null, DIGIT_CREDIT_ONLY);
                return;
            }else{
                sb.append(SELECT_MEMBERSHIP_BY_CREDIT).append(Integer.valueOf(availCredit));
            }
        }
        
        //Remove table content in case there's any
        for (int i = dtm.getRowCount() - 1; i >= 0; i--){
            dtm.removeRow(i);
        }
        
        try {
            ResultSet rs = Database.getInstance().selectRecords(Database.DB_FIT5148B, sb.toString());
            ResultSetMetaData mdata = rs.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rs.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
            rs.close();
            //Close connection
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here: delete
        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount > 1){
            JOptionPane.showMessageDialog(null, MULTIPLE_SELECTION);
        }else if (selectedRowCount == 0){
            JOptionPane.showMessageDialog(null, NO_SELECTION);
        }else{
            int confirmDelete = JOptionPane.showConfirmDialog(null, CONFIRM_DELETE_MEMBERSHIP, null, JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == confirmDelete){
                int selectedCustomer = jTable1.getSelectedRow();
                int tierId = ((BigDecimal)jTable1.getModel().getValueAt(selectedCustomer, 0)).intValue();
                
                StringBuffer sb = new StringBuffer(DELETE_MEMBERSHIP);
                sb.append(tierId);
                
                boolean updateResult = Database.getInstance().updateTable(Database.DB_FIT5148B, sb.toString());
                Database.getInstance().closeDBConnection();
                if (updateResult == true){
                    JOptionPane.showMessageDialog(null, UPDATE_MEMBERSHIP_S);
                }else{
                    JOptionPane.showMessageDialog(null, UPDATE_MEMBERSHIP_F);
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: Insert
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MembershipInsertUpdateDialog(null, INSERT_MEMBERSHIP).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MembershipPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MembershipPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MembershipPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MembershipPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MembershipPanel().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
