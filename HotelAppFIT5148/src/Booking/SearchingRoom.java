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

    /**
     * Creates new form Searching
     */
    public SearchingRoom(MainFrame mf) {
        initComponents();
        initDate();
        countries = initCountries();
        cities = initCities();
        roomTypes = initRoomType();

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

    // Set current date as value of check-in and check-out
    public void initDate() {
        //jXDatePicker1.setDate(Calendar.getInstance().getTime());
        //jXDatePicker2.setDate(Calendar.getInstance().getTime());
    }

    // search country in order to add it into jComboBox1
    public List initCountries() {
        
        List countries = new ArrayList();
        try {
            
            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148A, SQLStatement.SELECT_DISTINCT_COUNTRY);
            while (rset.next()) {
                countries.add(rset.getString(1));
            }
            rset.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return countries;
    }

    // search city in order to add it into jComboBox1
    public List initCities() {
        
        List cities = new ArrayList();
        try {
            
            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148A, SQLStatement.SELECT_DISTINCT_CITY);
            while (rset.next()) {
                cities.add(rset.getString(1));
            }
            rset.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return cities;
    }

    // search room type in order to add it into jComboBox4
    public List initRoomType() {
        
        List roomType = new ArrayList();
        try {
            
            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148B, SQLStatement.SELECT_ROOM_TYPES);
            
            while (rset.next()) {
                roomType.add(rset.getString(1));
            }
            rset.close();
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
        return roomType;
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
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        search.setLabel("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel1.setText("Country:");

        jLabel2.setText("City:");

        jLabel3.setText("Check-in");

        jLabel4.setText("Check-out");

        jLabel5.setText("Room type:");

        jLabel6.setText("Rate range:");

        jLabel7.setText("Room:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1-200", "200-400", "400-600", "600-800", "800-1000", ">1000" }));

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

    jCheckBox1.setText("available");

    jLabel8.setForeground(new java.awt.Color(255, 0, 51));
    jLabel8.setText("*");

    jLabel9.setForeground(new java.awt.Color(255, 0, 0));
    jLabel9.setText("*");
    jLabel9.setToolTipText("");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search)
                    .addGap(67, 67, 67)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8)
                .addComponent(jLabel1))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel9))
            .addGap(25, 25, 25)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(jCheckBox1))
            .addGap(18, 18, 18)
            .addComponent(search)
            .addGap(33, 33, 33))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(17, 17, 17))
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
            Date checkinDate = this.jXDatePicker1.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(checkinDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 58);
            checkinDate = calendar.getTime();
            Date checkoutDate = this.jXDatePicker2.getDate();
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
            
            // sb= sb
        }
//
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
//
//        String country = String.valueOf(jComboBox2.getSelectedItem());
//        String city = String.valueOf(jComboBox1.getSelectedItem());
//        String room_type = String.valueOf(jComboBox4.getSelectedItem());
//        String rate_range = String.valueOf(jComboBox3.getSelectedItem());
//
//        SimpleDateFormat formater = new SimpleDateFormat(Database.DB_DATE_FORMAT);
//        String check_in = formater.format(jXDatePicker1.getDate());
//        String check_out = formater.format(jXDatePicker2.getDate());
//
//        boolean avaliable = jCheckBox1.isSelected();
//        String avail = "";
//
//        if (avaliable) {
//            avail = "true";
//        } else {
//            avail = "false";
//        }
//
            try {
//            String search = "SELECT hotel_name, r.room_number, r.room_type, r.price from room@FIT5148B r, hotel@FIT5148A h WHERE h.country =  '"
//                    + country + "' and h.city = '" + city + "'" + " and h.hotel_id = r.hotel_id and r.room_type = '"
//                    + room_type + "' ";
//            String selectedPriceRange = this.jComboBox3.getSelectedItem().toString();
//            int priceStart = Integer.MIN_VALUE;
//            int priceEnd = Integer.MAX_VALUE;
//            if (selectedPriceRange.contains("-")) {
//                priceStart = Integer.parseInt(selectedPriceRange.split("-")[0]);
//                priceEnd = Integer.parseInt(selectedPriceRange.split("-")[1]);
//            } else if (selectedPriceRange.contains(">")) {
//                priceStart = Integer.parseInt(selectedPriceRange.split(">")[1].trim());
//            }
//            search += " and r.price >= " + priceStart + " and r.price <=" + priceEnd;
//            if (this.jCheckBox1.isSelected()) {
//                search += " and  not EXISTS (select bgm.room_number from bookingroomguest@FIT5148B bgm)  ";
//            }
//
//            System.out.println(search);
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
        
//
//        // double click a row and go to the booking GUI
//        jTable1.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//
//                if (e.getClickCount() == 2) {
//
//                    // access seleced row data
//                    javax.swing.JTable target = (javax.swing.JTable) e.getSource();
//                    int row1 = target.getSelectedRow();
//
//                    String[] rowData = new String[4];
//
//                    for (int i = 0; i < 4; i++) {
//                        rowData[i] = (String) target.getValueAt(row1, i);
//                    }
////                        
////                    for(int i = 0; i < 4; i++){
////                        System.out.print(rowData[i]);
////                    }
//
//                    String citizen_id = javax.swing.JOptionPane.showInputDialog(WarningMessage.EMPTY_CITIZEN_ID);
//                    //System.out.println(customer_id);
//
//                    if (citizen_id == null) {
//                        return;
//                    }
//                    target = (javax.swing.JTable) e.getSource();
//                    int row2 = target.getSelectedRow();
//                    String room_type = (String) target.getValueAt(row2, 2);
//                    double price = Double.valueOf((String) target.getValueAt(row2, 3));
//                    //System.out.println(room_type);
//
//                    // access booking GUI
//                    if (whetherExistCitizenId(citizen_id)) {
//                        mf.bookingActionPerformed(room_type, check_in, check_out, price, citizen_id, rowData);
//                    } else {
//                        javax.swing.JOptionPane.showMessageDialog(SearchingRoom.this, "customer does not exist");
//                    }
//                }
//            }
//        });
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
