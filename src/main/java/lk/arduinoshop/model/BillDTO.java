/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.model;

import java.util.ArrayList;

/**
 *
 * @author Iyona Chithrasena
 */
public class BillDTO {
    private double total;
    private double totalDiscount;
    private double grandTotal;
    private double chasTendered;
    private double amountDue;
    private String invoiceNUmber;
     private ArrayList<SalesDTO> itemList;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public double getChasTendered() {
        return chasTendered;
    }

    public void setChasTendered(double chasTendered) {
        this.chasTendered = chasTendered;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getInvoiceNUmber() {
        return invoiceNUmber;
    }

    public void setInvoiceNUmber(String invoiceNUmber) {
        this.invoiceNUmber = invoiceNUmber;
    }

    public ArrayList<SalesDTO> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<SalesDTO> itemList) {
        this.itemList = itemList;
    }
    
    
}
