/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import Util.WarningMessage;
import hotelappfit5148.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author thaonguyen
 */
public class NewHotel extends javax.swing.JFrame {

    /**
     * Creates new form NewHotel
     */
    public NewHotel() {
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

        jLabel1 = new javax.swing.JLabel();
        newHotelButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hotelNameText = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        constructionYearText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        countryText = new javax.swing.JTextField();
        cityText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        contactNumberText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("New Hotel");

        newHotelButton.setText("Submit");
        newHotelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newHotelButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                CancelButtonAncestorRemoved(evt);
            }
        });
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Name *");

        jLabel3.setText("Type");

        hotelNameText.setText("Hotel Name");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 star", "2 star", "3 star", "4 star", "5 star" }));

        jLabel4.setText("Construction year");

        constructionYearText.setText("2017");

        jLabel5.setText("Country");

        jLabel6.setText("City");

        jLabel7.setText("Address");

        jLabel8.setText("Contact number");

        jLabel9.setText("Email");

        countryText.setText("Country");

        cityText.setText("City");

        addressText.setText("Address");

        contactNumberText.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel9)
                                    .addGap(87, 87, 87))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)))
                                .addGap(75, 75, 75)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 19, Short.MAX_VALUE))
                                    .addComponent(constructionYearText)
                                    .addComponent(contactNumberText)
                                    .addComponent(emailText))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hotelNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(countryText)
                            .addComponent(cityText)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(newHotelButton)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton)))
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(countryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityText, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(hotelNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(constructionYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(contactNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newHotelButton)
                            .addComponent(CancelButton))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newHotelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newHotelButtonActionPerformed
        // TODO add your handling code here:
        HotelBean hotel = new HotelBean();
        if (hotelNameText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter hotel name.");
            return;
        }
        hotel.setAddress(addressText.getText().trim());
        hotel.setCity(cityText.getText().trim());
        hotel.setConstructionYear(Integer.parseInt(constructionYearText.getText().trim()));
        hotel.setContactNumber(contactNumberText.getText().trim());
        hotel.setCountry(countryText.getText().trim());
        hotel.setEmail(emailText.getText().trim());
        hotel.setHotelName(hotelNameText.getText().trim());
        hotel.setHotelType(String.valueOf(typeComboBox.getSelectedItem()));

        PreparedStatement preparedStatement = null;
Connection dbConnection = Database.getInstance().getDBConnection("FIT5148A");
        String insertTableSQL = "INSERT INTO hotel"
                + "(hotel_name, hotel_type, construction_year, country, city, address, contact_number, email) VALUES"
                + "(?,?,?,?,?,?,?,?)";

        try {
//            preparedStatement = DBConnection.getDBConnection("FIT5148A").prepareStatement(insertTableSQL, new String[]{"hotel_id"});
            preparedStatement = dbConnection.prepareStatement(insertTableSQL, new String[]{"hotel_id"});
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getHotelType());
            preparedStatement.setInt(3, hotel.getConstructionYear());
            preparedStatement.setString(4, hotel.getCountry());
            preparedStatement.setString(5, hotel.getCity());
            preparedStatement.setString(6, hotel.getAddress());
            preparedStatement.setString(7, hotel.getContactNumber());
            preparedStatement.setString(8, hotel.getEmail());

//            ResultSet hotel_id_set = DBConnection.insertRecord("FIT5148A", preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet hotel_id_set = preparedStatement.getGeneratedKeys();
            Long hotel_id = null;
            if (null != hotel_id_set && hotel_id_set.next()) {
                 hotel_id = hotel_id_set.getLong(1);
            }           
            hotel.setHotelId(hotel_id);
            JOptionPane.showMessageDialog(null, "Create successfully.");
            preparedStatement.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, WarningMessage.UNKNOWN_ERROR);
        }
        
//        this.dispose();
//        new UpdateHotel(hotel).setVisible(true);
        
//        this.dispose();
//        new UpdateHotel(hotel).setVisible(true);


    }//GEN-LAST:event_newHotelButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
       this.dispose();        
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CancelButtonAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_CancelButtonAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelButtonAncestorRemoved

    
    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField cityText;
    private javax.swing.JTextField constructionYearText;
    private javax.swing.JTextField contactNumberText;
    private javax.swing.JTextField countryText;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField hotelNameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton newHotelButton;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
