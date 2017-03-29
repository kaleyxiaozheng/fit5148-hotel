/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author situsnow
 */
public class Database {

    private static final String DB_DRIVER
            = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION_FIT5148A
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148A";
    private static final String DB_CONNECTION_FIT5148B
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148B";
    private static final String DB_USER = "student01";
    private static final String DB_PASSWORD = "student";

    private static Database dbIsntance;
    private static Connection con_5148A;
    private static Connection con_5148B;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    private Database() {
        // private constructor //
    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }

    public Connection getDBConnection(String databaseName) {
//        Connection dbConnection = null;
        

        try {
            if ("FIT5148A".equalsIgnoreCase(databaseName)) {
                if (con_5148A == null || con_5148A.isClosed()) {
                    con_5148A = DriverManager.getConnection(DB_CONNECTION_FIT5148A, DB_USER, DB_PASSWORD);
                }
                return con_5148A;
            } else {
                if (con_5148B == null || con_5148A.isClosed()) {
                    con_5148B = DriverManager.getConnection(DB_CONNECTION_FIT5148B, DB_USER, DB_PASSWORD);
                }
                
                return con_5148B;
            }
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean closeDBConnection() {
        boolean result = false;

        try {
            if (rs != null) {
                rs.close();
                result = true;
            };
            if (stmt != null) {
                stmt.close();
                result = true;
            };

            if (con_5148A != null) {
                con_5148A.close();
                result = true;
            };
            if (con_5148B != null) {
                con_5148B.close();
                result = true;
            };

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            result = false;
        }

        return result;
    }

    public ResultSet selectRecords(String dbName, String sqlStatement) throws SQLException {
        Connection dbConnection = null;
        try {
            dbConnection = getDBConnection(dbName);
            
            if(dbConnection == null){
                System.out.print("lol");
            }
            
            stmt = dbConnection.prepareStatement(sqlStatement);

            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
       
        return null;
    }

}
