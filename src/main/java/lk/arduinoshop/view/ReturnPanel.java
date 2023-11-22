/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lk.arduinoshop.controller.OrderController;
import lk.arduinoshop.controller.ReturnItemController;
import lk.arduinoshop.model.OrderDTO;
import lk.arduinoshop.model.ReturnDTO;
import lk.arduinoshop.model.SalesDTO;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReturnPanel extends javax.swing.JPanel {

    /**
     * Creates new form testpanel
     */
    public ReturnPanel() {
        initComponents();
        orderDetailBillTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        returnOrderTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        AutoCompleteDecorator.decorate(orderIDCombo);
        orderIDCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
                addDataToTable();

//                if (e.getActionCommand() == "comboBoxEdited") {
//                    addDataToTable();
//                }
            }

        });

        addDataToCombos();
    }

    public void addDataToCombos() {
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDTO> orderDTOList = ReturnItemController.getOrderIDList();
        for (int i = 0; i < orderDTOList.size(); i++) {
            String orderId = orderDTOList.get(i).getOrderID() + "";
            orderIDCombo.addItem(orderId);
        }

    }

    public void addDataToTable() {
        SalesDTO salesDTO = new SalesDTO();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderID(Integer.parseInt(orderIDCombo.getSelectedItem().toString()));
        List<SalesDTO> orderDTOList = OrderController.getOrderDetail(orderDTO);

        DefaultTableModel tableModel = (DefaultTableModel) orderDetailBillTable.getModel();
        tableModel.setRowCount(0);

        DefaultTableModel tableModelReturn = (DefaultTableModel) returnOrderTable.getModel();
        tableModelReturn.setRowCount(0);
        Object rowData[] = new Object[7];
        for (int i = 0; i < orderDTOList.size(); i++) {
            rowData[0] = orderDTOList.get(i).getProductId();
            rowData[1] = orderDTOList.get(i).getProductName();
            rowData[2] = orderDTOList.get(i).getStockId();
            rowData[3] = orderDTOList.get(i).getQuantity();
            rowData[4] = orderDTOList.get(i).getSellPrice();
            rowData[5] = orderDTOList.get(i).getDiscount();
            rowData[6] = orderDTOList.get(i).getQuantity() * orderDTOList.get(i).getSellPrice() - orderDTOList.get(i).getDiscount();
            tableModel.addRow(rowData);
        }
    }

    private void clearFields() {
        productIDField.setText("");
        productNameField.setText("");
        stockIdField.setText("");
        quantitySpinnerField.setValue(1);
        reasonCombo.setSelectedIndex(0);

        DefaultTableModel defaultTableModel = (DefaultTableModel) returnOrderTable.getModel();
        defaultTableModel.setRowCount(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelOrderid = new javax.swing.JLabel();
        jPanelProductSummery = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stockIdField = new javax.swing.JTextField();
        productNameField = new javax.swing.JTextField();
        productIDField = new javax.swing.JTextField();
        quantitySpinnerField = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        reasonCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderDetailBillTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        orderIDCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chekoutButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        returnOrderTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelOrderid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelOrderid.setText("Order ID");

        jPanelProductSummery.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductSummery.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Product Name");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Product ID");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Stock ID");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Quantity");

        stockIdField.setEditable(false);
        stockIdField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        productNameField.setEditable(false);
        productNameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        productIDField.setEditable(false);
        productIDField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        quantitySpinnerField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        quantitySpinnerField.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        quantitySpinnerField.setRequestFocusEnabled(false);

        jLabel8.setBackground(new java.awt.Color(51, 0, 204));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setText("        Return Product");

        addButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Reason");

        reasonCombo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        reasonCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Change to Another", "Not Working" }));

        javax.swing.GroupLayout jPanelProductSummeryLayout = new javax.swing.GroupLayout(jPanelProductSummery);
        jPanelProductSummery.setLayout(jPanelProductSummeryLayout);
        jPanelProductSummeryLayout.setHorizontalGroup(
            jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductSummeryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelProductSummeryLayout.createSequentialGroup()
                        .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productIDField)
                            .addComponent(productNameField)
                            .addComponent(quantitySpinnerField)
                            .addComponent(stockIdField)
                            .addComponent(reasonCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductSummeryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanelProductSummeryLayout.setVerticalGroup(
            jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductSummeryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stockIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitySpinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(jPanelProductSummeryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(reasonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        orderDetailBillTable.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        orderDetailBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "StockID", "Quantity", "Unit Price", "Discount", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderDetailBillTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderDetailBillTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderDetailBillTable);
        if (orderDetailBillTable.getColumnModel().getColumnCount() > 0) {
            orderDetailBillTable.getColumnModel().getColumn(0).setMinWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(0).setMaxWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(1).setMinWidth(170);
            orderDetailBillTable.getColumnModel().getColumn(1).setPreferredWidth(170);
            orderDetailBillTable.getColumnModel().getColumn(1).setMaxWidth(170);
            orderDetailBillTable.getColumnModel().getColumn(2).setMinWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(2).setMaxWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(3).setMinWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(3).setMaxWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(4).setMinWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(4).setMaxWidth(80);
            orderDetailBillTable.getColumnModel().getColumn(5).setMinWidth(100);
            orderDetailBillTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            orderDetailBillTable.getColumnModel().getColumn(5).setMaxWidth(100);
            orderDetailBillTable.getColumnModel().getColumn(6).setMinWidth(120);
            orderDetailBillTable.getColumnModel().getColumn(6).setPreferredWidth(120);
            orderDetailBillTable.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Return Order");

        jLabel7.setBackground(new java.awt.Color(51, 0, 204));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setText("Return Order");

        jLabel9.setBackground(new java.awt.Color(51, 0, 204));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setText("Order Details");

        chekoutButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        chekoutButton.setText("Checkout");
        chekoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekoutButtonActionPerformed(evt);
            }
        });

        returnOrderTable.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        returnOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "StockID", "Quantity", "Unit Price", "Discount", "Total", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnOrderTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(returnOrderTable);
        if (returnOrderTable.getColumnModel().getColumnCount() > 0) {
            returnOrderTable.getColumnModel().getColumn(0).setMinWidth(60);
            returnOrderTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            returnOrderTable.getColumnModel().getColumn(0).setMaxWidth(60);
            returnOrderTable.getColumnModel().getColumn(1).setMinWidth(150);
            returnOrderTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            returnOrderTable.getColumnModel().getColumn(1).setMaxWidth(150);
            returnOrderTable.getColumnModel().getColumn(2).setMinWidth(60);
            returnOrderTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            returnOrderTable.getColumnModel().getColumn(2).setMaxWidth(60);
            returnOrderTable.getColumnModel().getColumn(3).setMinWidth(60);
            returnOrderTable.getColumnModel().getColumn(3).setPreferredWidth(60);
            returnOrderTable.getColumnModel().getColumn(3).setMaxWidth(60);
            returnOrderTable.getColumnModel().getColumn(4).setMinWidth(80);
            returnOrderTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            returnOrderTable.getColumnModel().getColumn(4).setMaxWidth(80);
            returnOrderTable.getColumnModel().getColumn(5).setMinWidth(80);
            returnOrderTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            returnOrderTable.getColumnModel().getColumn(5).setMaxWidth(80);
            returnOrderTable.getColumnModel().getColumn(6).setMinWidth(100);
            returnOrderTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            returnOrderTable.getColumnModel().getColumn(6).setMaxWidth(100);
            returnOrderTable.getColumnModel().getColumn(7).setMinWidth(120);
            returnOrderTable.getColumnModel().getColumn(7).setPreferredWidth(120);
            returnOrderTable.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelOrderid, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(orderIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelProductSummery, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(chekoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOrderid))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(chekoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelProductSummery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chekoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekoutButtonActionPerformed
        String error = "Are you sure is this add to return?";
        JTextArea outputArea = new JTextArea(12, 10);
        outputArea.setText(error);
        int response = JOptionPane.showConfirmDialog(this, "Do you want to return Items? ", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.OK_OPTION) {
            DefaultTableModel tableModel = (DefaultTableModel) returnOrderTable.getModel();
            int rowCount = tableModel.getRowCount();
            ReturnDTO returnDTO = new ReturnDTO();
            //System.out.println(rowCount);
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, "You can't checkout with empty item table !", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ArrayList<SalesDTO> itemList = new ArrayList<>();
            int maxId = OrderController.maxID();
            for (int row = 0; row < tableModel.getRowCount(); row++) {

                SalesDTO salesDTO = new SalesDTO();
                salesDTO.setUserID("1");
                salesDTO.setOrderId(Integer.parseInt(orderIDCombo.getSelectedItem().toString()));
                salesDTO.setProductId(tableModel.getValueAt(row, 0).toString());
                salesDTO.setProductName(tableModel.getValueAt(row, 1).toString());
                salesDTO.setStockId(tableModel.getValueAt(row, 2).toString());
                salesDTO.setQuantity(-1 * Integer.parseInt(tableModel.getValueAt(row, 3).toString()));
                salesDTO.setSellPrice(Double.parseDouble(tableModel.getValueAt(row, 4).toString()));
                salesDTO.setDiscount(Double.parseDouble(tableModel.getValueAt(row, 5).toString()));
                String reason = tableModel.getValueAt(row, 7).toString();
                returnDTO.setReason(reason);
                //Get Current  Date
                returnDTO.setDate(Date.valueOf(LocalDate.now()));
                returnDTO.setOrderHasStockId(maxId);
                salesDTO.setReturnDTO(returnDTO);
                itemList.add(salesDTO);
                maxId++;

                boolean status = ReturnItemController.addReturnItemsInOrder(itemList);

                if (status) {
                    JOptionPane.showMessageDialog(null, "Return Items Added Successfully !", "Confirm Message", JOptionPane.NO_OPTION);

                }
            }
        }

    }//GEN-LAST:event_chekoutButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String productId = productIDField.getText();
        ReturnDTO returnDTO = new ReturnDTO();
        returnDTO.setProductID(productId);
        returnDTO.setStockID(stockIdField.getText());
        int qtyFromDB = ReturnItemController.getTotalQuantity(returnDTO);

        DefaultTableModel tableModel = (DefaultTableModel) returnOrderTable.getModel();
        DefaultTableModel orderTableModel = (DefaultTableModel) orderDetailBillTable.getModel();
        int selectedRowOrderDetail = orderDetailBillTable.getSelectedRow();

        int spinnerQuantity = Integer.parseInt(quantitySpinnerField.getValue().toString());
       

        double sellPrice = Double.parseDouble(orderDetailBillTable.getValueAt(selectedRowOrderDetail, 4).toString());
        double discount = Double.parseDouble(orderDetailBillTable.getValueAt(selectedRowOrderDetail, 5).toString());
        int quantityFromOrder = Integer.parseInt(orderDetailBillTable.getValueAt(selectedRowOrderDetail, 3).toString());

        int selectedRow = -1;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(productId)) {
                selectedRow = i;
            }

        }
        if (quantityFromOrder < 0 || spinnerQuantity > qtyFromDB) {
            JOptionPane.showMessageDialog(null, "Return quntity should lower than or equal to order quantity", "Confirmation Message", JOptionPane.OK_CANCEL_OPTION);
            return;
        }
        if (selectedRow == -1) {
            Object rowData[] = new Object[8];

            rowData[0] = productIDField.getText();
            rowData[1] = productNameField.getText();
            rowData[2] = stockIdField.getText();
            rowData[3] = quantitySpinnerField.getValue();
            rowData[4] = orderDetailBillTable.getValueAt(selectedRowOrderDetail, 4);
            rowData[5] = orderDetailBillTable.getValueAt(selectedRowOrderDetail, 5);
            rowData[6] = (spinnerQuantity * sellPrice) - discount;
            rowData[7] = reasonCombo.getSelectedItem();

            tableModel.addRow(rowData);

            // ------- select last row
            returnOrderTable.changeSelection(tableModel.getRowCount() - 1, 0, false, false);
        } else {

            tableModel.setValueAt(productIDField.getText(), selectedRow, 0);
            tableModel.setValueAt(productNameField.getText(), selectedRow, 1);
            tableModel.setValueAt(stockIdField.getText(), selectedRow, 2);
            tableModel.setValueAt(quantitySpinnerField.getValue(), selectedRow, 3);
            tableModel.setValueAt(orderDetailBillTable.getValueAt(selectedRowOrderDetail, 4), selectedRow, 4);
            tableModel.setValueAt(orderDetailBillTable.getValueAt(selectedRowOrderDetail, 5), selectedRow, 5);
            tableModel.setValueAt((spinnerQuantity * sellPrice) - discount, selectedRow, 6);
            tableModel.setValueAt(reasonCombo.getSelectedItem(), selectedRow, 7);

        }


    }//GEN-LAST:event_addButtonActionPerformed

    private void orderDetailBillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderDetailBillTableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) orderDetailBillTable.getModel();
        int selectedRow = orderDetailBillTable.getSelectedRow();
        productIDField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        productNameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        stockIdField.setText(tableModel.getValueAt(selectedRow, 2).toString());
        quantitySpinnerField.setValue(Integer.parseInt(tableModel.getValueAt(selectedRow, 3).toString()));
    }//GEN-LAST:event_orderDetailBillTableMouseClicked

    private void returnOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnOrderTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_returnOrderTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton chekoutButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelOrderid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelProductSummery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderDetailBillTable;
    private javax.swing.JComboBox<String> orderIDCombo;
    private javax.swing.JTextField productIDField;
    private javax.swing.JTextField productNameField;
    private javax.swing.JSpinner quantitySpinnerField;
    private javax.swing.JComboBox<String> reasonCombo;
    private javax.swing.JTable returnOrderTable;
    private javax.swing.JTextField stockIdField;
    // End of variables declaration//GEN-END:variables
}
