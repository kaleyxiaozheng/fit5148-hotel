/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class Payment extends javax.swing.JPanel {

    private String customer_id;
    private MainFrame mf;
    private String book_id;
    String[] bookedInfor;
    private List<Integer> customerIds = new ArrayList();

    List<Integer> guests = new ArrayList();
    private List<String> paymentStatuses = new ArrayList();

    /**
     * Creates new form Payment
     */
    public Payment(String book_id, String[] selectedRow, String customer_id, List<Integer> guests, MainFrame mf) {
        initComponents();
        initCurrentBooking(book_id, selectedRow);

        this.guests = guests;
        this.customer_id = customer_id;
        this.mf = mf;
    }

    public Payment(MainFrame mf) {
        this.mf = mf;
        initComponents();
        this.initializeTableData();
    }

    // Initial payment GUI with current booking order
    public void initCurrentBooking(String book_id, String[] selectedRow) {

        bookedInfor = new String[5];

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        bookedInfor[0] = book_id;
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
        view = new javax.swing.JButton();
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
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox2ActionPerformed(evt);
        }
    });

    jTextField2.setText(" ");

    jTextField3.setText(" ");

    delete.setLabel("Delete");
    delete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteActionPerformed(evt);
        }
    });

    view.setLabel("View");
    view.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            viewActionPerformed(evt);
        }
    });

    jTextField4.setText(" ");
    jTextField4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField4ActionPerformed(evt);
        }
    });

    jLabel5.setText("Citizen ID");

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
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jCheckBox2))
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(76, 76, 76))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(search)
                    .addGap(41, 41, 41)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(view)
                    .addGap(46, 46, 46)
                    .addComponent(payment)
                    .addGap(57, 57, 57)
                    .addComponent(delete)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGap(18, 18, 18)
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
                .addComponent(payment)
                .addComponent(delete)
                .addComponent(view)
                .addComponent(search))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    // payment function
    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        int row = jTable1.getSelectedRow();
        String[] bookid_price = new String[2];

        bookid_price[0] = (String) jTable1.getModel().getValueAt(row, 0);
        try {
            Connection conn = Database.getInstance().getDBConnection("FIT5148B");
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery("select * from payment where booking_id=" + bookid_price[0]);
            if (rset.next()) {
                JOptionPane.showMessageDialog(this, "Already Paid");
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
                String insertBookGuests = "INSERT INTO bookingroomguest VALUES(" + this.bookedInfor[0] + ", " + getHotelId(this.bookedInfor[1]) + ", '" + this.bookedInfor[2] + "', " + guests.get(i) + ")";

                Connection conn = Database.getInstance().getDBConnection("FIT5148B");
                System.out.println(insertBookGuests);
                Statement stmt = conn.createStatement();
                stmt.execute(insertBookGuests);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(bookedInfor==null){
            String bInfo [] = new String[1];
            bInfo[0] = bookid_price[0];
            mf.RepaymentBidCid(cid, bookid_price, bInfo, guests);
        }else{
            
            mf.RepaymentBidCid(cid, bookid_price, bookedInfor, guests);
        }
    }//GEN-LAST:event_paymentActionPerformed
    // get Hotel id

    public int getHotelId(String hotelName) {
        int hotelID = 0;

        try {
            String search = "SELECT hotel_id from hotel WHERE hotel_name = '" + hotelName + "'";

            Connection conn = Database.getInstance().getDBConnection("FIT5148A");
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(search);
            if (rset.next()) {
                hotelID = rset.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hotelID;
    }
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String citizen_id = jTextField4.getText();

        boolean avaliable = jCheckBox2.isSelected();
        String avail = "";

        if (avaliable) {
            avail = "true";
        } else {
            avail = "false";
        }

        try {
            String search = "SELECT citizen_id from guest WHERE citizen_id = '" + jTextField4.getText() + "'";

            System.out.println(jTextField4.getText());
            System.out.println(search);

            Connection conn = Database.getInstance().getDBConnection("FIT5148B");
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(search);
            ResultSetMetaData metadata = rset.getMetaData();
            while (rset.next()) {
                String[] rsets = new String[4];
                rsets[0] = rset.getString(1);
                rsets[1] = rset.getString(2);
                rsets[2] = rset.getString(3);
                rsets[3] = rset.getString(4);

                //System.out.println(rsets[0] + ", " + rsets[1] + ", " + rsets[2] + ", " + rsets[3]);
                model.addRow(rsets);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
        }

        // double click a row and go to the booking GUI
//        jTable1.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent e){
//                
//                if(e.getClickCount() == 2){
//                    
//                    // access seleced row data
////                    javax.swing.JTable target = (javax.swing.JTable)e.getSource();
////                    int row = target.getSelectedRow();
////                    
////                    String[] rowData = new String[4];
////                    
////                    for(int i = 0; i < 4; i++){
////                        rowData[i] = (String)target.getValueAt(row, i);
////                    }
////                        
////                    for(int i = 0; i < 4; i++){
////                        System.out.print(rowData[i]);
////                    }
//
//                 // access booking GUI
////                 MainFrame mf = new MainFrame();
////                 mf.bookingActionPerformed();
//                }
//            }
//        });
    }//GEN-LAST:event_searchActionPerformed
    /**
     * read from database to render table data
     */
    private void initializeTableData() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);
        try {
            String search = "select DISTINCT b.booking_id, brm.room_number, r.room_type, b.total_amount, brm.hotel_id, b.customer_id\n"
                    + "from booking b, bookingroomguest brm, room r\n"
                    + "where b.booking_id = brm.booking_id and brm.room_number = r.room_number ";

            Connection conn = Database.getInstance().getDBConnection("FIT5148B");
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(search);
            while (rset.next()) {
                String[] rsets = new String[5];
                rsets[0] = rset.getString(1);

                search = "select hotel_name from hotel where hotel_id = '" + rset.getString(5) + "'";
                conn = Database.getInstance().getDBConnection("FIT5148A");
                stat = conn.createStatement();
                ResultSet hrset = stat.executeQuery(search);
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

        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
