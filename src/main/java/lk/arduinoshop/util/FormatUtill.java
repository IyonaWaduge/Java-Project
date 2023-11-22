/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.view.Product.AddNewItemFrame;

/**
 *
 * @author Iyona Chithrasena
 */
public class FormatUtill {
    
    
    public static java.sql.Date convertStrinDateToSQLDateDDMMYYYY(String stringDate) {
        java.sql.Date sqlStartDate = null;

        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf1.parse(stringDate);
            sqlStartDate = new java.sql.Date(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(AddNewItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sqlStartDate;
    }
}
