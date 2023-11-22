/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.Product;

import lk.arduinoshop.view.Dispose.ManageItemForm;
import java.awt.Font;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lk.arduinoshop.controller.ProductController;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class ProductPanel extends javax.swing.JPanel {

   private ManageItemForm manageItemForm = null;
   private ManageCategoryPanel manageCategoryForm=null;

    public ProductPanel() {
        initComponents();
        productTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        productTable.setAutoCreateRowSorter(true);
        addDataToTable();
    }

    public void addDataToTable() {
        SalesDTO salesDTO = new SalesDTO();
        List<SalesDTO> salesDTOList = ProductController.addDataTotableController();
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();

        Object rowData[] = new Object[5];
        for (int i = 0; i < salesDTOList.size(); i++) {
            rowData[0] = salesDTOList.get(i).getProductId();
            rowData[1] = salesDTOList.get(i).getProductName();
            rowData[2] = salesDTOList.get(i).getCategory();
            rowData[3] = salesDTOList.get(i).getCurrentQuantity();
            rowData[4] = salesDTOList.get(i).getSellPrice();
            tableModel.addRow(rowData);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonAddNewItem = new javax.swing.JButton();
        manageStock = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        manageCategory = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        productTable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Category", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setMinWidth(80);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            productTable.getColumnModel().getColumn(0).setMaxWidth(80);
            productTable.getColumnModel().getColumn(3).setMinWidth(120);
            productTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            productTable.getColumnModel().getColumn(3).setMaxWidth(120);
            productTable.getColumnModel().getColumn(4).setMinWidth(150);
            productTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            productTable.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Product Details");

        jButtonAddNewItem.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonAddNewItem.setText("Manage Item");
        jButtonAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewItemActionPerformed(evt);
            }
        });

        manageStock.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        manageStock.setText("Manage Stock");
        manageStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStockActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel3.setText("Search");

        searchField.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        manageCategory.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        manageCategory.setText("Manage Category");
        manageCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(manageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addComponent(manageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageStock, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewItemActionPerformed
        if (manageItemForm == null) {
            manageItemForm = new ManageItemForm();
        }
        manageItemForm.setVisible(true);
    }//GEN-LAST:event_jButtonAddNewItemActionPerformed

    private void manageStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStockActionPerformed
        ManageStockFrame manageStockFrame = new ManageStockFrame();
        manageStockFrame.setVisible(true);
    }//GEN-LAST:event_manageStockActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
        productTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(searchField.getText().trim()));
    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped

    }//GEN-LAST:event_searchFieldKeyTyped

    private void manageCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCategoryActionPerformed
        if (manageCategoryForm == null) {
            manageCategoryForm = new ManageCategoryPanel();
        }
        manageCategoryForm.setVisible(true);

    }//GEN-LAST:event_manageCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewItem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageCategory;
    private javax.swing.JButton manageStock;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
