/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author situsnow
 */
public class DBConnection {
    
    private static final String DB_DRIVER
            = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148A";
    private static final String DB_USER = "S27530264";
    private static final String DB_PASSWORD = "student";
 
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
    
    public static boolean closeDBConnection(Connection dbConnection){
        boolean result = false;
        if (dbConnection != null) {
            try {
                dbConnection.close();
                result = true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                result = false;
            }
        }
        
        return result;
    }
}
