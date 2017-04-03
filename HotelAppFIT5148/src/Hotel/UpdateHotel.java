/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import Util.WarningMessage;
import hotelappfit5148.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author thaonguyen
 */
public class UpdateHotel extends javax.swing.JFrame {

    /**
     * Creates new form UpdateHotel
     */
    private HotelBean hotel;

    public UpdateHotel(HotelBean hoteltempt) {
        initComponents();
        viewHotelDetail(hoteltempt);

    }

    private void viewHotelDetail(HotelBean hoteltempt) {
        this.hotel = hoteltempt;
        this.addressText.setText(hotel.getAddress());
        this.cityText.setText(hotel.getCity());
        this.constructionYearText.setText(Integer.toString(hotel.getConstructionYear()));
        this.contactNumberText.setText(hotel.getContactNumber());
        this.countryText.setText(hotel.getCountry());
        this.emailText.setText(hotel.getEmail());
        this.hotelNameText.setText(hotel.getHotelName());
        this.hotelIdLable.setText("Hotel number " + hotel.getHotelId().toString());
        this.typeComboBox.setSelectedItem(hotel.getHotelType());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hotelIdLable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        countryText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        hotelNameText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox();
        contactNumberText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        constructionYearText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        Save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hotelIdLable.setText("Update hotel");

        jLabel2.setText("Name *");

        countryText.setText("Country");

        jLabel3.setText("Type");

        cityText.setText("City");

        hotelNameText.setText("Hotel Name");

        addressText.setText("Address");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 star", "2 star", "3 star", "4 star", "5 star" }));

        contactNumberText.setToolTipText("");

        jLabel4.setText("Construction year");

        constructionYearText.setText("2017");

        jLabel5.setText("Country");

        jLabel6.setText("City");

        jLabel7.setText("Address");

        jLabel8.setText("Contact number");

        jLabel9.setText("Email");

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hotelIdLable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(constructionYearText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(close)
                                .addGap(33, 33, 33)
                                .addComponent(Save)))))
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9)
                                .addGap(87, 87, 87))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(75, 75, 75)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
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
                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hotelIdLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(constructionYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close)
                    .addComponent(Save))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(54, 54, 54)
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
                                .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(hotelNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(contactNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(64, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        if (hotelNameText.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, WarningMessage.MANDATORY_FIELD_EMPTY);
            return;
        }
        if (emailText.getText().trim().contains("@") == false) {
            JOptionPane.showMessageDialog(null, WarningMessage.INCORRECT_EMAIL);
            return;
        }

        try {
            hotel.setAddress(addressText.getText().trim());
            hotel.setCity(cityText.getText().trim());
            hotel.setConstructionYear(Integer.parseInt(constructionYearText.getText().trim()));
            hotel.setContactNumber(contactNumberText.getText().trim());
            hotel.setCountry(countryText.getText().trim());
            hotel.setEmail(emailText.getText().trim());
            hotel.setHotelName(hotelNameText.getText().trim());
            hotel.setHotelType(String.valueOf(typeComboBox.getSelectedItem()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, WarningMessage.INCORRECT_DATA_TYPE);
            return;
        }
        PreparedStatement preparedStatement = null;
        Connection dbConnection = Database.getInstance().getDBConnection(Database.DB_FIT5148A);
        String insertTableSQL = "update  hotel set "
                + "hotel_name = ?, hotel_type = ?, construction_year = ?, "
                + "country = ?, city = ?, address = ?, contact_number = ?, email = ? where hotel_id = ?";

        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getHotelType());
            preparedStatement.setInt(3, hotel.getConstructionYear());
            preparedStatement.setString(4, hotel.getCountry());
            preparedStatement.setString(5, hotel.getCity());
            preparedStatement.setString(6, hotel.getAddress());
            preparedStatement.setString(7, hotel.getContactNumber());
            preparedStatement.setString(8, hotel.getEmail());
            preparedStatement.setLong(9, hotel.getHotelId());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, WarningMessage.UPDATE_S);
            preparedStatement.close();
            Database.getInstance().closeDBConnection();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        this.dispose();
//        new UpdateHotel(hotel).setVisible(true);

    }//GEN-LAST:event_SaveActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UpdateHotel().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField cityText;
    private javax.swing.JButton close;
    private javax.swing.JTextField constructionYearText;
    private javax.swing.JTextField contactNumberText;
    private javax.swing.JTextField countryText;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel hotelIdLable;
    private javax.swing.JTextField hotelNameText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
