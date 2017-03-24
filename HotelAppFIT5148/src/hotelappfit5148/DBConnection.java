/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.*;


/**
 *
 * @author situsnow
 */
public class DBConnection {
    
    private static final String DB_DRIVER
            = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION_FIT5148A
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148A";
    private static final String DB_CONNECTION_FIT5148B
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148B";
    private static final String DB_USER = "S27530264";
    private static final String DB_PASSWORD = "student";
 
    private static Connection getDBConnection(String databaseName) {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if ("FIT5148A".equalsIgnoreCase(databaseName))
                dbConnection = DriverManager.getConnection(DB_CONNECTION_FIT5148A, DB_USER, DB_PASSWORD);
            else
                dbConnection = DriverManager.getConnection(DB_CONNECTION_FIT5148B, DB_USER, DB_PASSWORD);
            
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
    
    public static ResultSet selectRecords(String dbName, String sqlStatement){
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        try{
            dbConnection = getDBConnection(dbName);
            preparedStatement = dbConnection.prepareStatement(sqlStatement);
            
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
