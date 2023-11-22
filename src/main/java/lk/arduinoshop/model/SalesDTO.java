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
public class SalesDTO {
    private String productId;
    private String productName;
    private String categoryID;
    private int initialQuantity;
    private int currentQuantity;
    private String stockId;
    private double orderPrice;
    private double sellPrice;
    private Date date;
    private String categoryName;
    private int orderId;
    private String userID;
    private double discount;
    private int quantity;
    private ProductDTO productDTO;
    private ReturnDTO returnDTO;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getCategory() {
        return categoryID;
    }

    public void setCategory(String category) {
        this.categoryID = category;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     public String categoryName() {
        return categoryName;
    }

    public void categoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ReturnDTO getReturnDTO() {
        return returnDTO;
    }

    public void setReturnDTO(ReturnDTO returnDTO) {
        this.returnDTO = returnDTO;
    }

    
    
    @Override
    public String toString() {
        return "SalesDTO{" + "productId=" + productId + ", productName=" + productName + ", categoryID=" + categoryID + ", initialQuantity=" + initialQuantity + ", currentQuantity=" + currentQuantity + ", stockId=" + stockId + ", orderPrice=" + orderPrice + ", sellPrice=" + sellPrice + ", date=" + date + ", categoryName=" + categoryName + '}';
    }

    
}
