/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author situsnow
 */
public class CustomerGuestUtil {
    public final static String DISCARD_CHANGE = "Your change will be discarded. Please click Yes if you want to stay.";
    public final static String EMPTY_CITIZEN_ID = "Please input Citizen ID.";
    public final static String INVALID_CITIZEN_ID = "Please input digit for Citizen ID.";
    public final static String EXISTED_CITIZEN = "Citizen Id is existed for other customer, please double check";
    public final static String FAIL_PROCEDURE = "F";
    public final static String SUCCESS_PROCEDURE = "S";
    public static boolean checkCitizenID(String citizenId, String sql){
        //If exist, return true; else return false
        try {
            int number = 1;
            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148B, 
                    sql + citizenId);
            if (rset.next()){
                number = rset.getInt(1);
            }
            rset.close();
            Database.getInstance().closeDBConnection();
            
            if (number == 0){
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
}
