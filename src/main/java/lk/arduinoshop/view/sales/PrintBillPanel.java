/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.sales;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lk.arduinoshop.controller.OrderController;
import lk.arduinoshop.controller.SalesController;
import lk.arduinoshop.model.BillDTO;
import lk.arduinoshop.model.SalesDTO;
import lk.arduinoshop.view.SalesPanel;

public class PrintBillPanel extends javax.swing.JPanel {

    private double grandTotal;
    private ArrayList<SalesDTO> itemList;
    private SalesPanel salesPanel;

//    public PrintBillPanel() {
//        initComponents();
//        fillText();
//        orderID();
//    }
    public PrintBillPanel(ArrayList<SalesDTO> itemList, SalesPanel salesPanel) {
        this.itemList = itemList;
        this.salesPanel = salesPanel;
        initComponents();
        fillText();
        orderID();
    }

    public void fillText() {
        totalAmountBillField.setText(SalesPanel.totalAmountTextField.getText());
        totalDiscountBillField.setText(SalesPanel.discountTotalField.getText());
        grandTotal = Double.parseDouble(SalesPanel.grandTotalField.getText());
        grandTotalBillField.setText(String.valueOf(grandTotal));
    }

    public void orderID() {
        
        try {
            Integer orderID = OrderController.autoOrderID();
            invoiceNumberField.setText(orderID.toString());
        } catch (SQLException ex) {
            Logger.getLogger(PrintBillPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalAmountBillField = new javax.swing.JTextField();
        totalDiscountBillField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        grandTotalBillField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cashTenderedField = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        invoiceNumberField = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel12.setText("Discount");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel13.setText("Total Amount");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel14.setText("Grand Total");

        totalAmountBillField.setEditable(false);
        totalAmountBillField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        totalAmountBillField.setForeground(new java.awt.Color(0, 0, 102));

        totalDiscountBillField.setEditable(false);
        totalDiscountBillField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        totalDiscountBillField.setForeground(new java.awt.Color(0, 0, 102));

        balanceField.setEditable(false);
        balanceField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        balanceField.setForeground(new java.awt.Color(0, 0, 102));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setText("Cash Tendered");

        grandTotalBillField.setEditable(false);
        grandTotalBillField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        grandTotalBillField.setForeground(new java.awt.Color(0, 0, 102));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Balance");

        cashTenderedField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        cashTenderedField.setForeground(new java.awt.Color(0, 0, 102));
        cashTenderedField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashTenderedFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashTenderedFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashTenderedFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmountBillField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalDiscountBillField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grandTotalBillField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashTenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(totalDiscountBillField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(totalAmountBillField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cashTenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(grandTotalBillField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        printButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        printButton.setText("Print");
        printButton.setEnabled(false);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Final Bill");

        invoiceNumberField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(231, 231, 231)
                        .addComponent(invoiceNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cashTenderedFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTenderedFieldKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            double cashTendered = Double.parseDouble(cashTenderedField.getText());
//            double balance = cashTendered - grandTotal;
//            balanceField.setText(String.valueOf(balance));
//        }

    }//GEN-LAST:event_cashTenderedFieldKeyPressed

    private void cashTenderedFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTenderedFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
            return;
        }

    }//GEN-LAST:event_cashTenderedFieldKeyTyped

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

        SalesDTO salesDTO = new SalesDTO();
        String orderId = invoiceNumberField.getText();
        salesDTO.setOrderId(Integer.parseInt(invoiceNumberField.getText()));
        salesDTO.setDate(Date.valueOf(LocalDate.now()));
        salesDTO.setUserID("1");

        for (SalesDTO salesDTO1 : itemList) {
            salesDTO1.setOrderId(Integer.parseInt(invoiceNumberField.getText()));
            salesDTO1.setUserID("1");

        }

        boolean addOrder = OrderController.addOrder(salesDTO);
        boolean addItems = OrderController.addItemsInOrder(itemList);
        boolean updateStock = OrderController.updateCurrentQuantity(itemList);

        if (addOrder && addItems && updateStock) {
            JOptionPane.showMessageDialog(this, "Order added sucessfully !", "Confirmation message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Order adding fail !", "Fail message", JOptionPane.ERROR_MESSAGE);
        }

        BillDTO billDTO = new BillDTO();
        billDTO.setTotal(Double.parseDouble(totalAmountBillField.getText().toString()));
        billDTO.setTotalDiscount(Double.parseDouble(totalDiscountBillField.getText()));
        billDTO.setGrandTotal(Double.parseDouble(grandTotalBillField.getText()));
        billDTO.setChasTendered(Double.parseDouble(cashTenderedField.getText()));
        billDTO.setAmountDue(Double.parseDouble(balanceField.getText()));
        billDTO.setInvoiceNUmber(invoiceNumberField.getText());
        billDTO.setItemList(itemList);

        
        try {
            SalesController.generatePDF(billDTO);
        } catch (IOException ex) {
            Logger.getLogger(PrintBillPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        //---------clear sales panel
        salesPanel.clearFields();
        JDialog jDialog= (JDialog) SwingUtilities.getWindowAncestor(this);
        jDialog.dispose();
        
        

    }//GEN-LAST:event_printButtonActionPerformed

    private void cashTenderedFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTenderedFieldKeyReleased
        String tender = cashTenderedField.getText().trim().isEmpty() ? "0" : cashTenderedField.getText().trim();
        double cashTendered = Double.parseDouble(tender);
        double balance = cashTendered - grandTotal;
        balanceField.setText(String.valueOf(balance));
        if (balance > 0) {
            printButton.setEnabled(true);
        } else {
            printButton.setEnabled(false);
        }
    }//GEN-LAST:event_cashTenderedFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balanceField;
    private javax.swing.JTextField cashTenderedField;
    private javax.swing.JTextField grandTotalBillField;
    private javax.swing.JLabel invoiceNumberField;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField totalAmountBillField;
    private javax.swing.JTextField totalDiscountBillField;
    // End of variables declaration//GEN-END:variables
}
