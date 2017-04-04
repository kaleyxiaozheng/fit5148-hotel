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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaley
 */
public class SearchingRoom extends javax.swing.JPanel {

    private List countries;
    private List cities;
    private List roomTypes;
    private MainFrame mf;
    private  Date checkinDate;
    private Date checkoutDate;

    /**
     * Creates new form Searching
     */
    public SearchingRoom(MainFrame mf) {
        initComponents();
        countries = initValueOfComponents()[0];
        cities = initValueOfComponents()[1];
        roomTypes = initValueOfComponents()[2];

        jComboBox2.removeAllItems();
        jComboBox1.removeAllItems();
        jComboBox4.removeAllItems();

        for (Iterator iterator = countries.iterator(); iterator.hasNext();) {
            String country = (String) iterator.next();
            jComboBox2.addItem(country);
        }

        for (Iterator iterator = cities.iterator(); iterator.hasNext();) {
            String city = (String) iterator.next();
            jComboBox1.addItem(city);
        }

        jComboBox4.addItem("All");
        for (Iterator iterator = roomTypes.iterator(); iterator.hasNext();) {
            String roomType = iterator.next().toString();
            jComboBox4.addItem(roomType);
        }

        this.mf = mf;
    }

    public List[] initValueOfComponents() {
        List[] valueOfComponents = new List[4];

        for (int i = 0; i < valueOfComponents.length; i++) {
            valueOfComponents[i] = new ArrayList();
        }

        // search country in order to add it into jComboBox1
        try {
            ResultSet rset_country = Database.getInstance().selectRecords(Database.DB_FIT5148A, SQLStatement.SELECT_DISTINCT_COUNTRY);
            while (rset_country.next()) {
                valueOfComponents[0].add(rset_country.getString(1));
            }
            rset_country.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }

        // search city in order to add it into jComboBox1
        try {
            ResultSet rset_city = Database.getInstance().selectRecords(Database.DB_FIT5148A, SQLStatement.SELECT_DISTINCT_CITY);
            while (rset_city.next()) {
                valueOfComponents[1].add(rset_city.getString(1));
            }
            rset_city.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }

        // search room type in order to add it into jComboBox4
        try {
            ResultSet rset_roomType = Database.getInstance().selectRecords(Database.DB_FIT5148B, SQLStatement.SELECT_ROOM_TYPES);
            while (rset_roomType.next()) {
                valueOfComponents[2].add(rset_roomType.getString(1));
            }
            rset_roomType.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }

        // get room price order by ASC
        try {
            ResultSet rset_roomPrice = Database.getInstance().selectRecords(Database.DB_FIT5148B, SQLStatement.SELECT_DISTINCT_ROOM_PIRCE);
            while (rset_roomPrice.next()) {
                valueOfComponents[3].add(rset_roomPrice.getString(1));
            }
            rset_roomPrice.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }

        return valueOfComponents;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        search.setLabel("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel1.setText("Country:");

        jLabel2.setText("City:");

        jLabel3.setText("Check-in:");

        jLabel4.setText("Check-out:");

        jLabel5.setText("Room type:");

        jLabel6.setText("Rate range:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item2", "item3", "item4" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[0][0],
            new String[]{
                "Hotel name", "Room number", "Room type", "Price"
            }
        )
        {public boolean isCellEditable(int row, int column) {return false;}}
    );
    jScrollPane1.setViewportView(jTable1);

    jLabel8.setForeground(new java.awt.Color(255, 0, 51));
    jLabel8.setText("*");

    jLabel9.setForeground(new java.awt.Color(255, 0, 0));
    jLabel9.setText("*");
    jLabel9.setToolTipText("");

    jLabel10.setText("Min");

    jLabel11.setText("Max");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel6))
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel11)
                                        .addGap(27, 27, 27)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9))
                                            .addComponent(jLabel3)))
                                    .addGap(25, 25, 25)
                                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(48, 48, 48))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(search)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search)
                    .addGap(4, 4, 4)))
            .addContainerGap(24, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    // get citizen id from customer table
    public boolean whetherExistCitizenId(String citizenId) {
        boolean flag = false;
        // search customer in customer table with customer id
        StringBuffer sb = new StringBuffer(SQLStatement.SELECT_CUSTOMERID_WITH_CITIZEN);
        sb.append(Integer.valueOf(citizenId));

        try {

            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148B, sb.toString());
            flag = rset.next();

            rset.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {
            //Logger.getLogger(SearchingRoom.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return flag;
    }


    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String country = String.valueOf(jComboBox2.getSelectedItem());
        String city = String.valueOf(jComboBox1.getSelectedItem());

        // Searching room with value of country and city
        StringBuffer sb = new StringBuffer(SQLStatement.LOOKUP_ROOMS);
        sb.append(country);
        sb.append(SQLStatement.LOOKUP_ROOMS_WITH_CITY);
        sb.append(city);
        sb.append(SQLStatement.LOOKUP_ROOMS_JOIN_HOTEL);

// check check-in and check-out date
        if (this.jXDatePicker1.getDate() != null && this.jXDatePicker2.getDate() != null) {
            checkinDate = this.jXDatePicker1.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(checkinDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 58);
            checkinDate = calendar.getTime();
            
            checkoutDate = this.jXDatePicker2.getDate();
            Date todayDate = Calendar.getInstance().getTime();
            if (checkinDate.before(todayDate)) {
                JOptionPane.showMessageDialog(this, WarningMessage.CHECKIN_DATE_AFTER_TODAY);
            }
            if (checkoutDate.before(todayDate)) {
                JOptionPane.showMessageDialog(this, WarningMessage.CHECKOUT_DATE_AFTER_TODAY);
                return;
            }
            if (checkoutDate.before(checkinDate)) {
                JOptionPane.showMessageDialog(this, WarningMessage.CHECKOUT_DATE_AFTER_CHECKIN_DATE);
                return;
            }
            
            /**
             * select distinct h.hotel_id, r.* from Hotel@FIT5148A h, Room r
where h.hotel_id = r.hotel_id 
and r.room_number not in(
select brg.room_number from BookingRoomGuest brg, booking b where b.booking_id = brg.booking_id
and (TO_DATE('2017/03/31', 'yyyy/MM/dd') > b.check_in_date OR TO_DATE('2017/04/03', 'yyyy/MM/dd') < b.check_out_date));
             */
            sb.append(" and r.room_number not in(SELECT brg.room_number FROM bookingroomguest brg, booking b WHERE b.booking_id = brg.booking_id and (TO_DATE('");
            sb.append(Database.dateFormat.format(this.jXDatePicker2.getDate()));
            sb.append("', 'yyyy/MM/dd') > b.check_in_date OR TO_DATE('");
            sb.append(Database.dateFormat.format(this.jXDatePicker1.getDate()));
            sb.append("', 'yyyy/MM/dd)') < b.check_out_date))");
            
            System.out.println(sb.toString());
        }

        // search room type
        if (String.valueOf(this.jComboBox4.getSelectedItem()) != "All") {
            sb.append(" and r.room_type = '");
            sb.append(String.valueOf(this.jComboBox4.getSelectedItem()));
            sb.append("'");
        }

        // set minmum pirce
        if (!this.jTextField1.getText().isEmpty()) {
            try {
                Double.valueOf(this.jTextField1.getText());
                if (Double.valueOf(this.jTextField1.getText()) < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.NUMBER_RATERANGE);
                } else {
                    double min = Double.valueOf(this.jTextField1.getText());
                    sb.append(" and r.price > ");
                    sb.append(min);
                }
            } catch (NumberFormatException nfe) {
                javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.INVALID_NUMBER);
            }
        }

        // set maximum pirce
        if (!this.jTextField2.getText().isEmpty()) {
            try {
                Double max = Double.valueOf(this.jTextField2.getText());
                if (Double.valueOf(this.jTextField2.getText()) < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.NUMBER_RATERANGE);
                } else {
                    sb.append(" and r.price < ");
                    sb.append(max);
                }
            } catch (NumberFormatException nfe) {
                javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.INVALID_NUMBER);
            }
        }

        if (!this.jTextField1.getText().isEmpty() && !this.jTextField2.getText().isEmpty()) {
            try {
                Double min = Double.valueOf(this.jTextField1.getText());
                Double max = Double.valueOf(this.jTextField2.getText());

                if (min >= max) {
                    javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.INVALID_PRICE_COMPARISON);
                    return;
                }
            }catch(NumberFormatException nfe){
                 javax.swing.JOptionPane.showMessageDialog(this, WarningMessage.INVALID_NUMBER);
            }

        }
        //System.out.println(sb.toString());
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            Connection conn = Database.getInstance().getDBConnection(Database.DB_FIT5148A);
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery(sb.toString());
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
            Logger.getLogger(SearchingRoom.class.getName()).log(Level.SEVERE, null, ex);
        }


        // double click a row and go to the booking GUI
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    // access seleced row data
                    javax.swing.JTable target = (javax.swing.JTable) e.getSource();
                    int row1 = target.getSelectedRow();

                    String[] rowData = new String[4];

                    for (int i = 0; i < 4; i++) {
                        rowData[i] = (String) target.getValueAt(row1, i);
                    }
//                        
//                    for(int i = 0; i < 4; i++){
//                        System.out.print(rowData[i]);
//                    }


                     if(jXDatePicker1.getDate() == null || jXDatePicker2.getDate() == null){
                            JOptionPane.showMessageDialog(null, WarningMessage.NULL_DATE);
                            return;
                        }

                    String citizen_id = javax.swing.JOptionPane.showInputDialog(WarningMessage.EMPTY_CITIZEN_ID);
                    //System.out.println(customer_id);

                    if (citizen_id == null) {
                        return;
                    }else if (!citizen_id.chars().allMatch(Character :: isDigit)){
                        JOptionPane.showMessageDialog(null, WarningMessage.INVALID_CITIZEN_ID);
                        return;
                    }
                    target = (javax.swing.JTable) e.getSource();
                    int row2 = target.getSelectedRow();
                    String room_type = (String) target.getValueAt(row2, 2);
                    double price = Double.valueOf((String) target.getValueAt(row2, 3));
                    //System.out.println(room_type);

                    // access booking GUI
                    if (whetherExistCitizenId(citizen_id)) {
                        String check_IN = Database.dateFormat.format(jXDatePicker1.getDate());
                        String check_OUT = Database.dateFormat.format(jXDatePicker2.getDate());
                        
                        mf.bookingActionPerformed(room_type, check_IN, check_OUT, price, Integer.valueOf(citizen_id), rowData);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(SearchingRoom.this, "customer does not exist");
                    }
                }
            }
        });
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
