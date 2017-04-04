/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facility;

import Util.SQLStatement;
import Util.WarningMessage;
import hotelappfit5148.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author thaonguyen
 */
public class InsertUpdateFacilityDialog extends javax.swing.JDialog {

    FacilityBean facility;

    /**
     * Creates new form InsertUpdateFacilityDialog
     */
    public InsertUpdateFacilityDialog(FacilityBean facilityTemp, String action) {
        initComponents();
        if (WarningMessage.UPDATE_ACT.equals(action)) {
            facility = facilityTemp;
            viewFacilityDetail(facilityTemp);
            this.roomNumberText.setEditable(false);
            this.hotelIdText.setEditable(false);
            this.facilityNumberText.setEditable(false);
            newFacilityjButton1.setVisible(false);
        } else {
            facility = new FacilityBean();
            this.facilityNumberText.setText(Database.getInstance().getSequenceNextval(Database.DB_FIT5148B, "facility_seq").toString());
            updateFacilityjButton2.setVisible(false);
        }
    }

    private void viewFacilityDetail(FacilityBean facilitytempt) {
        this.facility = facilitytempt;
        this.hotelIdText.setText(facility.getHotelId().toString());
        this.roomNumberText.setText(facility.getRoomNumber());
        this.facilityNumberText.setText(facility.getFacilityNumeber());
        this.descriptionTextArea.setText(facility.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        roomNumberLabel = new javax.swing.JLabel();
        newFacilityjButton1 = new javax.swing.JButton();
        roomNumberText = new javax.swing.JTextField();
        updateFacilityjButton2 = new javax.swing.JButton();
        hotelIdLabel = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        hotelIdText = new javax.swing.JTextField();
        facilityLabel = new javax.swing.JLabel();
        facilityNumberText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        descriptionLabel.setText("Description *");

        roomNumberLabel.setText("Room Number *");

        newFacilityjButton1.setText("New Facility");
        newFacilityjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFacilityjButton1ActionPerformed(evt);
            }
        });

        updateFacilityjButton2.setText("Update Facility");
        updateFacilityjButton2.setActionCommand("Update Facility");
        updateFacilityjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFacilityjButton2ActionPerformed(evt);
            }
        });

        hotelIdLabel.setText("Hotel ID *");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        facilityLabel.setText("Facility Number");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newFacilityjButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateFacilityjButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomNumberLabel)
                            .addComponent(hotelIdLabel)
                            .addComponent(facilityLabel)
                            .addComponent(descriptionLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(facilityNumberText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roomNumberText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(hotelIdText, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNumberLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(hotelIdLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(hotelIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facilityLabel)
                    .addComponent(facilityNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateFacilityjButton2)
                    .addComponent(CancelButton)
                    .addComponent(newFacilityjButton1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFacilityjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFacilityjButton1ActionPerformed

        if (this.hotelIdText.getText().trim().isEmpty() || this.roomNumberText.getText().trim().isEmpty() || this.facilityNumberText.getText().trim().isEmpty() || this.descriptionTextArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, WarningMessage.MANDATORY_FIELD_EMPTY);
            return;
        }

        try {
            facility.setRoomNumber(this.roomNumberText.getText().trim());
            facility.setHotelId(Long.parseLong(this.hotelIdText.getText().trim()));
            facility.setFacilityNumeber(this.facilityNumberText.getText().trim());

            facility.setDescription(this.descriptionTextArea.getText().trim());
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, WarningMessage.INPUT_FORMAT_ER);
            return;
        }

        PreparedStatement preparedStatement = null;
        Connection dbConnection = Database.getInstance().getDBConnection(Database.DB_FIT5148B);

        try {
            preparedStatement = dbConnection.prepareStatement(SQLStatement.INSERT_FACILITY);
            preparedStatement.setString(1, facility.getRoomNumber());
            preparedStatement.setLong(2, facility.getHotelId());
            preparedStatement.setString(3, facility.getFacilityNumeber());
            preparedStatement.setString(4, facility.getDescription());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, WarningMessage.CREATE_S);
            preparedStatement.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            if (ex.getErrorCode() == 1) {
                JOptionPane.showMessageDialog(null, WarningMessage.UNIQUE_CONSTRAINT_FACILITY);
                return;

            };
            if (ex.getErrorCode() == 2291) {

                JOptionPane.showMessageDialog(null, WarningMessage.NOT_EXIST_HOTEL_ROOM_ID_ER);
                return;
            }
            JOptionPane.showMessageDialog(null, WarningMessage.UNKNOWN_ERROR);
        };
    }//GEN-LAST:event_newFacilityjButton1ActionPerformed

    private void updateFacilityjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFacilityjButton2ActionPerformed
        if (this.descriptionTextArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, WarningMessage.MANDATORY_FIELD_EMPTY);
            return;
        }
        try {

            facility.setDescription(this.descriptionTextArea.getText().trim());
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, WarningMessage.INPUT_FORMAT_ER);
            return;
        }

        PreparedStatement preparedStatement = null;
        Connection dbConnection = Database.getInstance().getDBConnection(Database.DB_FIT5148B);

        try {
            preparedStatement = dbConnection.prepareStatement(SQLStatement.UPDATE_FACILITY);
            preparedStatement.setString(1, facility.getDescription());
            preparedStatement.setString(2, facility.getRoomNumber());
            preparedStatement.setLong(3, facility.getHotelId());
            preparedStatement.setString(4, facility.getFacilityNumeber());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, WarningMessage.UPDATE_S);
            preparedStatement.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, WarningMessage.UNKNOWN_ERROR);
        };
    }//GEN-LAST:event_updateFacilityjButton2ActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InsertUpdateFacilityDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertUpdateFacilityDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertUpdateFacilityDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertUpdateFacilityDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                InsertUpdateFacilityDialog dialog = new InsertUpdateFacilityDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel facilityLabel;
    private javax.swing.JTextField facilityNumberText;
    private javax.swing.JLabel hotelIdLabel;
    private javax.swing.JTextField hotelIdText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newFacilityjButton1;
    private javax.swing.JLabel roomNumberLabel;
    private javax.swing.JTextField roomNumberText;
    private javax.swing.JButton updateFacilityjButton2;
    // End of variables declaration//GEN-END:variables
}