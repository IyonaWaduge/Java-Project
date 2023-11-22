/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.Product;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.arduinoshop.controller.CategoryController;
import lk.arduinoshop.model.CategoryDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class DeleteCategoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCategoryPanel
     */
    public DeleteCategoryPanel() {
        initComponents();
        addDataToTable();
        categoryTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
    }

    public void addDataToTable() {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<CategoryDTO> categoryList = CategoryController.getCategoryDTOList();

        DefaultTableModel tableModel = (DefaultTableModel) categoryTable.getModel();
        Object rowData[] = new Object[2];
        for (int i = 0; i < categoryList.size(); i++) {
            rowData[1] = categoryList.get(i).getCategoryName();
            rowData[0] = categoryList.get(i).getCategoryId();
            tableModel.addRow(rowData);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryIDField = new javax.swing.JTextField();
        categoryNameField = new javax.swing.JTextField();
        jButtonDeleteManageCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Delete Category");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel2.setText("Category ID");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel3.setText("Category Name");

        categoryIDField.setEditable(false);
        categoryIDField.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        categoryNameField.setEditable(false);
        categoryNameField.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        categoryNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                categoryNameFieldFocusLost(evt);
            }
        });
        categoryNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryNameFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categoryNameFieldKeyTyped(evt);
            }
        });

        jButtonDeleteManageCategory.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonDeleteManageCategory.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\deleteicon (1).png")); // NOI18N
        jButtonDeleteManageCategory.setText("Delete");
        jButtonDeleteManageCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteManageCategoryActionPerformed(evt);
            }
        });

        categoryTable.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CategoryName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoryTable);
        if (categoryTable.getColumnModel().getColumnCount() > 0) {
            categoryTable.getColumnModel().getColumn(0).setMinWidth(80);
            categoryTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            categoryTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setText("Existing Categories");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDeleteManageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonDeleteManageCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoryNameFieldFocusLost

    }//GEN-LAST:event_categoryNameFieldFocusLost

    private void categoryNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryNameFieldKeyPressed

    }//GEN-LAST:event_categoryNameFieldKeyPressed

    private void categoryNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryNameFieldKeyTyped
        int code = evt.getKeyCode();
        char c = evt.getKeyChar();
        // Prevent typing numbers
        if (!Character.isLetter(c) && code != KeyEvent.VK_BACK_SPACE && code != 0) {

            evt.consume();

        }
    }//GEN-LAST:event_categoryNameFieldKeyTyped

    private void jButtonDeleteManageCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteManageCategoryActionPerformed
        try {
            CategoryDTO categoryDTO = new CategoryDTO();
            String idValue;
            DefaultTableModel tableModel = (DefaultTableModel) categoryTable.getModel();
            int selectedRowIndex = categoryTable.getSelectedRow();
            idValue = tableModel.getValueAt(selectedRowIndex, 0).toString();
            Integer totalItemCount = CategoryController.itemCount(idValue);
            System.out.println(totalItemCount);
            String nameValue = tableModel.getValueAt(selectedRowIndex, 1).toString();
            if (totalItemCount >= 1) {
                JOptionPane.showMessageDialog(this, nameValue + "  has items. Cant not be deleted !");
                return;
            }
            if (idValue != null) {
                int response = JOptionPane.showConfirmDialog(this, "Do you want to delete " + nameValue + " ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    categoryDTO.setCategoryId(idValue);
                    boolean result = CategoryController.deleteSelectedRow(categoryDTO);
                    if (result == true) {
                        tableModel.removeRow(selectedRowIndex);
                        JOptionPane.showMessageDialog(this, nameValue + "  was deleted !");
                        categoryNameField.setText("");
                        categoryIDField.setText("");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeleteCategoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonDeleteManageCategoryActionPerformed

    private void categoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryTableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) categoryTable.getModel();
        int selectedRow = categoryTable.getSelectedRow();
        categoryNameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        categoryIDField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        categoryIDField.setEditable(false);
        System.out.println("lk.arduinoshop.view.Product.DeleteCategoryPanel.categoryTableMouseClicked()");
    }//GEN-LAST:event_categoryTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoryIDField;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton jButtonDeleteManageCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
