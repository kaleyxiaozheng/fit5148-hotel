/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking;


import Util.SQLStatement;
import Util.WarningMessage;
import hotelappfit5148.Database;
import hotelappfit5148.MainFrame;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaley
 */
public class PaymentInfo extends javax.swing.JPanel {

    private boolean mode;
    private String customer_id;
    private MainFrame mf;
    String[] bookedInfor;
    private List<Integer> customerIds = new ArrayList();

    List<Integer> guests = new ArrayList();
    private List<String> paymentStatuses = new ArrayList();

    /**
     * Creates new form Payment
     */
    public PaymentInfo(int book_id, String[] selectedRow, String customer_id, List<Integer> guests, MainFrame mf) {
        initComponents();
        initCurrentBooking(book_id, selectedRow);
        mode = false;
        setVisiable(mode);
        
        this.guests = guests;
        this.customer_id = customer_id;
        this.mf = mf;
    }

    public PaymentInfo(MainFrame mf) {
        mode = true;
        this.mf = mf;
        initComponents();
        this.initializeTableData();
        setVisiable(mode);
    }
    
    // set visiable 
    public void setVisiable(boolean mode){
        jLabel5.setVisible(mode);
        jTextField4.setVisible(mode);
        jLabel1.setVisible(mode);
        jTextField2.setVisible(mode);
        jLabel2.setVisible(mode);
        jTextField3.setVisible(mode);
        jCheckBox2.setVisible(mode);
        search.setVisible(mode);
    }

    // Initial payment GUI with current booking order
    public void initCurrentBooking(int book_id, String[] selectedRow) {

        bookedInfor = new String[5];

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        bookedInfor[0] = String.valueOf(book_id);
        bookedInfor[1] = selectedRow[0];
        bookedInfor[2] = selectedRow[1];
        bookedInfor[3] = selectedRow[2];
        bookedInfor[4] = selectedRow[3];

        model.addRow(bookedInfor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        payment = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [0][0],
            new String [] {
                "Booking ID", "Hotel name", "Room number", "Room type", "Total price"
            }
        )
        {public boolean isCellEditable(int row, int column) {return false;}}
    );
    jScrollPane1.setViewportView(jTable1);

    jLabel1.setText("First name:");

    jLabel2.setText("Last name:");

    payment.setLabel("Payment");
    payment.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            paymentActionPerformed(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    jLabel4.setText("Booking Information");

    jCheckBox2.setText("Unpaid");

    jTextField2.setText(" ");

    jTextField3.setText(" ");

    delete.setLabel("Delete");
    delete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteActionPerformed(evt);
        }
    });

    jTextField4.setText(" ");

    jLabel5.setText("Customer ID");

    search.setLabel("Search");
    search.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jCheckBox2)
            .addGap(524, 524, 524))
        .addGroup(layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(38, 38, 38))
        .addGroup(layout.createSequentialGroup()
            .addGap(107, 107, 107)
            .addComponent(search)
            .addGap(89, 89, 89)
            .addComponent(payment)
            .addGap(80, 80, 80)
            .addComponent(delete)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(jCheckBox2))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(payment))
                .addComponent(search))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    // payment function
    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            return;
        }
        String[] bookid_price = new String[2];

        bookid_price[0] = (String) jTable1.getModel().getValueAt(row, 0);
        try {
            Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(SQLStatement.SELECT_PAYMENT_WITH_BOOKINGID + bookid_price[0]);
            if (rset.next()) {
                JOptionPane.showMessageDialog(this, WarningMessage.BOOKING_IS_PAYED);
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        bookid_price[1] = (String) jTable1.getModel().getValueAt(row, 4);

        //System.out.println("customer " + customer_id);
        String cid = this.customer_id;
        if (cid == null) {
            cid = this.customerIds.get(row) + "";
        }
        try {
            for (int i = 0; i < guests.size(); i++) {
                String insertBookGuests = SQLStatement.INSERT_BOOKINGROOMGUEST + this.bookedInfor[0] 
                        + ", " + getHotelId(this.bookedInfor[1]) + ", '" + this.bookedInfor[2] + "', " + guests.get(i) + ")";

                Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);
                //System.out.println(insertBookGuests);
                Statement stmt = conn.createStatement();
                stmt.execute(insertBookGuests);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (bookedInfor == null) {
            String bInfo[] = new String[1];
            bInfo[0] = bookid_price[0];
            mf.RepaymentBidCid(cid, bookid_price, bInfo, guests);
        } else {

            mf.RepaymentBidCid(cid, bookid_price, bookedInfor, guests);
        }
    }//GEN-LAST:event_paymentActionPerformed
    // get Hotel id

    public int getHotelId(String hotelName) {
        int hotelID = 0;

        try {
            String search = SQLStatement.SELECT_HOTELID_WITH_NAME + hotelName + "'";

            Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148A);
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(search);
            if (rset.next()) {
                hotelID = rset.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SearchingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hotelID;
    }
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row < 0) {
            return;
        }
        String bookId = (String) jTable1.getModel().getValueAt(row, 0);
        String deleteSql = SQLStatement.DELETE_BOOKING + bookId;
        String deleteRelSql = SQLStatement.DELETE_BOOKINGROOMGUEST + bookId;
        try {
            Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);
            Statement stat = conn.createStatement();
            stat.executeUpdate(deleteRelSql);
            stat.executeUpdate(deleteSql);
            this.initializeTableData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        boolean unpaid = this.jCheckBox2.isSelected();
        int customerId = -1;
        try{
            customerId = Integer.parseInt(this.jTextField4.getText().trim());
        }catch(Exception e){
            //e.printStackTrace();
        }
        this.filterData(customerId, this.jTextField2.getText(), this.jTextField3.getText(), unpaid);
    }//GEN-LAST:event_searchActionPerformed
    /**
     * read from database to render table data
     */
    private void initializeTableData() {
        this.filterData(-1, null, null, false);
    }

    /**
     * filter data on the table
     */
    private void filterData(int customerId, String firstName, String lastName, boolean unPaid) {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);
        try {
            StringBuffer sb = new StringBuffer(SQLStatement.SEARCH_BOOKING);
            //String search = SQLStatement.SEARCH_BOOKING;
            if (customerId > 0) {
                sb.append(SQLStatement.SEARCH_BOOKING_WITH_CUSTID + customerId + " ");
            }
            if (firstName != null && !firstName.trim().isEmpty()) {
                sb.append(SQLStatement.SEARCH_BOOKING_WITH_CUSTFNAME + firstName.trim() + "%' ");
            }
            if (lastName != null && !lastName.trim().isEmpty()) {
                sb.append(SQLStatement.SEARCH_BOOKING_WITH_CUSTLNAME + lastName.trim() + "%' ");
            }
            if(unPaid){
                sb.append(SQLStatement.SEARCH_BOOKING_WITH_UPAID);
            }
            
            //System.out.println("search "+search);
            Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(sb.toString());
            while (rset.next()) {
                String[] rsets = new String[5];
                rsets[0] = rset.getString(1);
                sb = new StringBuffer(SQLStatement.SELECT_HOTELNAME_WITH_ID);
                sb.append(rset.getString(5) + "'");
                conn = Database.getInstance().getDBConnection(Database.DB_FIT5148A);
                stat = conn.createStatement();
                ResultSet hrset = stat.executeQuery(sb.toString());
                if (hrset.next()) {
                    rsets[1] = hrset.getString(1);
                }
                rsets[2] = rset.getString(2);
                rsets[3] = rset.getString(3);
                rsets[4] = rset.getString(4);
                this.customerIds.add(Integer.parseInt(rset.getString(6)));
                //System.out.println(rsets[0] + ", " + rsets[1] + ", " + rsets[2] + ", " + rsets[3]);
                model.addRow(rsets);
            }
            model.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(SearchingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton delete;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton payment;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
