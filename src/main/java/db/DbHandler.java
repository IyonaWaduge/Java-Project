/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iyona Chithrasena
 */
public class DbHandler {

    private static DbHandler dbHandler = null;
    private Connection conn = null;

    public static DbHandler getDbHandler() {
        if (dbHandler == null) {
            dbHandler = new DbHandler();
        }
        return dbHandler;
    }

    public ResultSet executeQuery(String sqlQuery) {
        try {
            if (conn == null) {
                conn = DbConnection.getDbConnection();
            }
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            ResultSet resultSet = pst.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Integer upadteQuery(String sqlQuery){
        try {
            if(conn == null){
                conn = DbConnection.getDbConnection();
            }
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            Integer value= pst.executeUpdate();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public Connection getConnection(){
        if(conn == null){
            conn = DbConnection.getDbConnection();
        }
        return conn;
        
        
    }
    
}
