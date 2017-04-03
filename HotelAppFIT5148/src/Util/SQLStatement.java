/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author situsnow
 */
public class SQLStatement {
    public final static String SELECT_CUSTOMER = "SELECT CUSTOMER_ID, TITLE, FIRST_NAME, LAST_NAME, "
                    + "CITIZEN_ID, DOB, COUNTRY, CITY, STREET, POSTAL_CODE, "
                    + "MEMBERSHIP_TIER, MEMBERSHIP_CREDITS, PHONE_NUM, EMAIL FROM CUSTOMER "
            + "INNER JOIN MEMBERSHIP ON CUSTOMER.TIER_ID = MEMBERSHIP.TIER_ID";
    public final static String SELECT_CUSTOMER_WITH_TIER = " AND MEMBERSHIP.MEMBERSHIP_TIER = '";
    public final static String SELECT_MEMBERSHIP_TIER = "SELECT MEMBERSHIP_TIER FROM MEMBERSHIP";
    public final static String DELETE_CUSTOMER = "DELETE CUSTOMER WHERE CUSTOMER_ID = ";
    
    public final static String CHECK_CUST_EXISTANCE_B4INSERT = "SELECT COUNT(1) "
            + "FROM CUSTOMER WHERE CITIZEN_ID = ";
    
    public final static String CALLSP_INSERTORUPDATECUSTOMER = "{call insertOrUpdateCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    
    public final static String SELECT_GUEST = "SELECT GUEST_ID, TITLE, FIRST_NAME, "
            + "LAST_NAME, CITIZEN_ID, DOB, COUNTRY, CITY, STREET, EMAIL FROM GUEST";
    public final static String SELECT_GUEST_WITH_FIRSTNAME = " WHERE FIRST_NAME LIKE '%";
    public final static String SELECT_GUEST_WITH_LASTNAME = "%' OR LAST_NAME LIKE '%";  
    
    public final static String CHECK_GUEST_EXISTANCE_B4INSERT = "SELECT COUNT(1) "
            + "FROM GUEST WHERE CITIZEN_ID = ";
    
    public final static String CALLSP_INSERTORUPDATEGUEST = "{call insertOrUpdateGuest(?,?,?,?,?,?,?,?,?,?,?,?)}";
    
    public final static String DELETE_MEMBERSHIP = "DELETE MEMBERSHIP WHERE TIER_ID = ";
    public final static String SELECT_MEMBERSHIP = "SELECT TIER_ID, MEMBERSHIP_TIER, "
            + "TIER_CREDIT, DISCOUNT, OTHER_REWARDS FROM MEMBERSHIP";
    public final static String SELECT_MEMBERSHIP_BY_CREDIT = " WHERE TIER_CREDIT <= ";
    
    public final static String SELECT_ROOM = "select room_number, hotel_id, room_type, "
                    + "price, description from room  order by room_number DESC";
}
