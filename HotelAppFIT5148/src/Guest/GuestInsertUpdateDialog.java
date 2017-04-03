/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guest;

import Customer.CustomerPanel;
import Customer.CustomerInsertUpdateDialog;
import Util.CustomerGuestUtil;
import Util.WarningMessage;
import hotelappfit5148.Database;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author situsnow
 */
public class GuestInsertUpdateDialog extends javax.swing.JDialog {

    
    public final static String CHECK_GUEST_EXISTANCE_B4INSERT = "SELECT COUNT(1) "
            + "FROM GUEST WHERE CITIZEN_ID = ";
    
    
    private static CallableStatement cstmt;
    private final static String CALLSP_INSERTORUPDATEGUEST = "{call insertOrUpdateGuest(?,?,?,?,?,?,?,?,?,?,?,?)}";
    /**
     * Creates new form GuestInsertUpdateDialog
     */
    public GuestInsertUpdateDialog(GuestBean guest, String action) {
        initComponents();
        if (GuestPanel.UPDATE_GUEST.equals(action)){
            setGuestInformation(guest);
            jButton1.setVisible(false);
        }else{
            
            jButton2.setVisible(false);
        }
    }
    
    private void setGuestInformation(GuestBean guest){
        jTextField1.setText(String.valueOf(guest.getGuest_id()));
        
        jComboBox1.setSelectedItem(guest.getTitle());
        jTextField2.setText(guest.getFirstName());
        jTextField3.setText(guest.getLastName());
        jTextField4.setText(String.valueOf(guest.getCitizenID()));
        
        try {
            if (guest.getDOB()!= null && !"".equals(guest.getDOB())){
                Date dob = new SimpleDateFormat(Database.DB_DATE_FORMAT).parse(guest.getDOB());
                jXDatePicker1.setDate(dob);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTextField5.setText(guest.getCountry());
        jTextField6.setText(guest.getCity());
        jTextField7.setText(guest.getStreet());
        jTextField8.setText(guest.getEmail());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Guest ID");

        jTextField1.setEnabled(false);

        jLabel2.setText("Title");

        jButton1.setLabel("Insert Guest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("First Name");

        jButton2.setLabel("Update Guest");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr", "Miss" }));

        jLabel4.setText("Last Name");

        jLabel5.setText("Citizen ID");

        jLabel6.setText("DOB");

        jLabel7.setText("Country");

        jLabel8.setText("City");

        jLabel9.setText("Street");

        jLabel10.setText("Email");

        jButton3.setLabel("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int cancelInput = JOptionPane.showConfirmDialog(null, WarningMessage.DISCARD_CHANGE, null, JOptionPane.YES_NO_OPTION);
        if (JOptionPane.NO_OPTION == cancelInput){
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: Insert
        String citizenID = jTextField4.getText();
        if (null == citizenID || "".equals(citizenID)){
            JOptionPane.showMessageDialog(null, WarningMessage.EMPTY_CITIZEN_ID);
            return;
        }
        boolean citizenId_Numeric = citizenID.chars().allMatch(Character :: isDigit);
        if (citizenId_Numeric == true){
            if (!CustomerGuestUtil.checkCitizenID(citizenID, CHECK_GUEST_EXISTANCE_B4INSERT)){
                boolean insertResult = performInsertOrUpdate(CustomerPanel.INSERT_CUST);
                if (insertResult == true){
                    JOptionPane.showMessageDialog(null, WarningMessage.GUEST_INSERT_UPDATE_S);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, WarningMessage.GUEST_INSERT_UPDATE_F);
                }
            }else{
                JOptionPane.showMessageDialog(null, WarningMessage.EXISTED_CITIZEN);
            }
        }else{
            JOptionPane.showMessageDialog(null, WarningMessage.INVALID_CITIZEN_ID);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: Update
        boolean updateResult = performInsertOrUpdate(GuestPanel.UPDATE_GUEST);
        if (updateResult == true){
            JOptionPane.showMessageDialog(null, WarningMessage.GUEST_INSERT_UPDATE_S);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, WarningMessage.GUEST_INSERT_UPDATE_F);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean performInsertOrUpdate(String action){
        GuestBean guest = getUserInputOfGuest();
        boolean result = callSPInsertOrUpdateGuest(guest, 
                        Database.DB_FIT5148B, action);
        Database.getInstance().closeDBConnection();
        
        return result;
        
    }
    
    public boolean callSPInsertOrUpdateGuest(GuestBean guest, String dbName, String action){
        Connection dbConnection = null;
        
        try{
            dbConnection = Database.getInstance().getDBConnection(dbName);
            cstmt = dbConnection.prepareCall(CALLSP_INSERTORUPDATEGUEST);
            
            cstmt.setInt(1, guest.getGuest_id());
            cstmt.setString(2, guest.getTitle());
            cstmt.setString(3, guest.getFirstName());
            cstmt.setString(4, guest.getLastName());
            cstmt.setInt(5, guest.getCitizenID());
            cstmt.setString(6, guest.getDOB());
            cstmt.setString(7, guest.getCountry());
            cstmt.setString(8, guest.getCity());
            cstmt.setString(9, guest.getStreet());
            
            cstmt.setString(10, guest.getEmail());
            
            cstmt.setString(11, action);
            cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
            
            cstmt.executeUpdate();
            
            String result = cstmt.getString(12);
            
            cstmt.close();
            if (CustomerGuestUtil.FAIL_PROCEDURE.equals(result)){
                return false;
            }
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
        
    }
    
    private GuestBean getUserInputOfGuest(){
        GuestBean guest = new GuestBean();
        
        if (null != jTextField1.getText() && !"".equals(jTextField1.getText())){
            guest.setGuest_id(Integer.valueOf(jTextField1.getText()));
        }
        
        guest.setTitle((String)jComboBox1.getSelectedItem());
        guest.setFirstName(jTextField2.getText());
        guest.setLastName(jTextField3.getText());
        guest.setCitizenID(Integer.valueOf(jTextField4.getText()));
        
        if (jXDatePicker1.getDate() != null){
            Date dob = jXDatePicker1.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat(Database.DB_DATE_FORMAT);
            guest.setDOB(dateFormat.format(dob));
        }
        
        guest.setCountry(jTextField5.getText());
        guest.setCity(jTextField6.getText());
        guest.setStreet(jTextField7.getText());
        
        guest.setEmail(jTextField8.getText());
        
        return guest;
    }
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(GuestInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GuestInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GuestInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GuestInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GuestInsertUpdateDialog().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
