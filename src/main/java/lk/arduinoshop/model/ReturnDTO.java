/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.model;

import java.sql.Date;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReturnDTO {
    private Date date;
    private String reason;
    private String productID;
    private String productName;
    private int orderHasStockId;

    public int getOrderHasStockId() {
        return orderHasStockId;
    }

    public void setOrderHasStockId(int orderHasStockId) {
        this.orderHasStockId = orderHasStockId;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }
    private String stockID;
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    

    
    
    
}
