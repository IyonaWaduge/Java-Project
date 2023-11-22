/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.arduinoshop.view.Home;

/**
 *
 * @author Iyona Chithrasena
 */
public class DbConnection {
    
           
           public static Connection getDbConnection() {
             
               try {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");
                   return conn;
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
           }
           
}
