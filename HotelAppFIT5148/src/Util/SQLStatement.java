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
    
    public final static String SELECT_ALL_ROOM = "select room_number, hotel_id, room_type, "
                    + "price, description from room  order by room_number DESC";
    
    public final static String INSERT_ROOM = "INSERT INTO room"
                + "(room_number, hotel_id, room_type, price, description) VALUES"
                + "(?,?,?,?,?)";
    public final static String UPDATE_ROOM = "update room set "
                + "room_type = ?, price = ?, description = ? where "
                + " room_number = ? and hotel_id = ? ";
    
    public final static String CALLSP_ADDCUSTOMERTOGUEST = "{call addCustomerToGuest(?,?)}";
    
    public final static String SELECT_GUEST_WITH_CITIZEN = "select title, first_name, last_name, citizen_id, dob, country, city, street, email from guest where citizen_id = ";
    
    public final static String SELECT_CUSTOMER_WITH_CITIZEN = "select title, first_name, last_name, citizen_id, dob, country, city, street, email from customer where citizen_id=";
    
    public final static String SELECT_GUEST_WITH_GUESTID = "select title, first_name, last_name, citizen_id, dob, country, city, street, email from guest where guest_id = ";
    public final static String SELECT_GUESTID_FROM_CITIZEN = "SELECT guest_id from guest WHERE citizen_id = ";
    public final static String SELECT_CUSTID_FROM_CITIZEN = "select customer_id from customer where citizen_id = ";
    public final static String SELECT_BOOKING_ID = "SELECT booking_id FROM booking ORDER BY booking_id DESC";
    public final static String INSERT_BOOKING = "INSERT INTO booking (booking_id, customer_id, check_in_date, check_out_date, total_amount, payment_status) VALUES(null, ";
    
    public final static String INSERT_GUEST = "INSERT INTO GUEST (guest_id, title, first_name, last_name, citizen_id, dob, country, city, street, email) values(null, '";
    
    public final static String GET_MEMBERSHIP_WITH_CUSTID = "SELECT membership_tier, tier_credit, discount, other_rewards FROM membership WHERE tier_id = (SELECT tier_id FROM customer WHERE customer_id = ";
    
    public final static String INSERT_PAYMENT = "INSERT INTO PAYMENT (booking_id, payment_day, payment_method, payment_amount) VALUES(";
    
    public final static String UPDATE_PAYMENT_STATUS_WITH_BOOKING = "UPDATE BOOKING SET payment_status = 'S' where booking_id = ";
    
    public final static String SELECT_FACILITY = "select facility_number,room_number, hotel_id, description "
                    + "from facility  where hotel_id = ";
    public final static String SELECT_FACILITY_WITH_ROOM = " and room_number = '";
    
    public final static String DELETE_ROOM = "delete room where room_number = '";
    
    public final static String DELETE_ROOM_WITH_HOTEL = "' and hotel_id = ";
    
    public final static String SELECT_DISTINCT_COUNTRY = "select DISTINCT country from hotel";
    
    public final static String SELECT_DISTINCT_CITY = "select DISTINCT city from hotel";
    
    public final static String SELECT_ROOM_TYPES = "select DISTINCT room_type from room";
    
    public final static String SELECT_DISTINCT_ROOM_PIRCE = "select DISTINCT price from room";
    
    public final static String SELECT_CUSTOMERID_WITH_CITIZEN = "SELECT citizen_id from customer where citizen_id = ";
    
    public final static String LOOKUP_ROOMS = "SELECT h.hotel_name, r.room_number, r.room_type, r.price from room@FIT5148B r, hotel@FIT5148A h WHERE h.country = '";
    public final static String LOOKUP_ROOMS_WITH_CITY = "' and h.city = '";
    public final static String LOOKUP_ROOMS_JOIN_HOTEL = "' and r.hotel_id = h.hotel_id";
    
    public final static String CALLSP_INSERTORUPDATEMEMBERSHIP = "{call insertOrUpdateMembership(?,?,?,?,?,?)}";
    
    public final static String CHECK_MEMBERSHIP_EXISTANCE_B4INSERT = "SELECT COUNT(1) "
            + "FROM MEMBERSHIP WHERE MEMBERSHIP_TIER = '";
    
    public final static String SELECT_ROOM_INFO = "select room.room_number, room.hotel_id, room.room_type, room.price, room.description  "
                    + "from room ";
    
    public final static String SELECT_ROOM_INFO_WITH_FACILITY = "where exists(select * from facility "
                        + " where room.room_number = facility.room_number and room.hotel_id = facility.hotel_id"
                        + " and lower(facility.description) like '%";
    
    public final static String ORDER_ROOM_DESC = " order by room_number DESC";
    
}
