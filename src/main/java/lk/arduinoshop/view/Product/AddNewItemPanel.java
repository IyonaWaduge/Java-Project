/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.Product;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lk.arduinoshop.controller.CategoryController;
import lk.arduinoshop.controller.ProductController;
import lk.arduinoshop.model.CategoryDTO;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.util.FormatUtill;

/**
 *
 * @author Iyona Chithrasena
 */
public class AddNewItemPanel extends javax.swing.JPanel {

     private String selectedImagePath = null;
    public AddNewItemPanel() {
        initComponents();
        productTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        addDataToCombo();
        addDataToTable();
    }

    public void addDataToTable() {
        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productList = ProductController.getProductDTOList();

        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        Object rowData[] = new Object[2];
        for (int i = 0; i < productList.size(); i++) {
            rowData[0] = productList.get(i).getProductId();
            rowData[1] = productList.get(i).getProductName();
            tableModel.addRow(rowData);
        }

    }

    public void addDataToCombo() {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<CategoryDTO> categoryList = CategoryController.getCategoryDTOList();
        for (int i = 0; i < categoryList.size(); i++) {
            String categoryName = categoryList.get(i).getCategoryName();
            categoryCombo.addItem(categoryName);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox<>();
        productIdField = new javax.swing.JTextField();
        orderPriceField = new javax.swing.JTextField();
        stockIdField = new javax.swing.JTextField();
        productNameField = new javax.swing.JTextField();
        sellPriceField = new javax.swing.JTextField();
        quantitySpinner = new javax.swing.JSpinner();
        dateField = new javax.swing.JFormattedTextField();
        imageLabel = new javax.swing.JLabel();
        imageUploadButton = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(760, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 600));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Add New Product");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel3.setText("Product Name");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel4.setText("Product ID");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel5.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel7.setText("Order Price");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel8.setText("Stock ID");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel9.setText("Date");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel10.setText("Sell Price");

        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        productIdField.setEditable(false);
        productIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productIdFieldFocusLost(evt);
            }
        });

        orderPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                orderPriceFieldKeyTyped(evt);
            }
        });

        stockIdField.setEditable(false);
        stockIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockIdFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockIdFieldFocusLost(evt);
            }
        });

        productNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productNameFieldFocusLost(evt);
            }
        });
        productNameField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                productNameFieldInputMethodTextChanged(evt);
            }
        });
        productNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameFieldActionPerformed(evt);
            }
        });
        productNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productNameFieldKeyTyped(evt);
            }
        });

        sellPriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sellPriceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sellPriceFieldFocusLost(evt);
            }
        });
        sellPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sellPriceFieldKeyTyped(evt);
            }
        });

        quantitySpinner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        quantitySpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantitySpinnerFocusLost(evt);
            }
        });
        quantitySpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantitySpinnerKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantitySpinnerKeyTyped(evt);
            }
        });

        dateField.setEditable(false);
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageLabel.setPreferredSize(new java.awt.Dimension(150, 150));

        imageUploadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        imageUploadButton.setText("UPLOAD AN IMAGE");
        imageUploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageUploadButtonActionPerformed(evt);
            }
        });

        addbutton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        addbutton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\addIcon (1).png")); // NOI18N
        addbutton.setText("Add");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productIdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(orderPriceField)
                            .addComponent(sellPriceField)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantitySpinner)
                            .addComponent(stockIdField))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(imageUploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageUploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stockIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sellPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboActionPerformed

    private void productIdFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productIdFieldFocusLost

    }//GEN-LAST:event_productIdFieldFocusLost

    private void orderPriceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderPriceFieldKeyTyped
        int code = evt.getKeyCode();
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && code != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_orderPriceFieldKeyTyped

    private void stockIdFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockIdFieldFocusGained

    }//GEN-LAST:event_stockIdFieldFocusGained

    private void stockIdFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockIdFieldFocusLost

    }//GEN-LAST:event_stockIdFieldFocusLost

    private void productNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameFieldFocusLost
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(productNameField.getText());
        productDTO.setProductId(productIdField.getText());
        String productName = productNameField.getText();
        Integer quantity = (Integer) quantitySpinner.getValue();
        if (!productName.trim().isEmpty()) {
            try {
                productDTO.setStockId(ProductController.autoStockID(productDTO));
                String stockID1 = productDTO.getStockId();

                stockIdField.setText(productDTO.getStockId());

            } catch (SQLException ex) {
                Logger.getLogger(AddNewItemFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_productNameFieldFocusLost

    private void productNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameFieldActionPerformed

    }//GEN-LAST:event_productNameFieldActionPerformed

    private void productNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameFieldKeyPressed
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(productNameField.getText());
            String productName = productNameField.getText();
            if (!productName.trim().isEmpty()) {
                productDTO.setProductId(ProductController.autoID(productDTO));
                productIdField.setText(productDTO.getProductId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageCategoryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel productTableModel = (DefaultTableModel) productTable.getModel();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(productTableModel);
        productTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(productNameField.getText().trim()));
    }//GEN-LAST:event_productNameFieldKeyPressed

    private void productNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameFieldKeyTyped
        
        
    }//GEN-LAST:event_productNameFieldKeyTyped

    private void sellPriceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellPriceFieldFocusGained
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        java.util.Date cal = Calendar.getInstance().getTime();
        String date = dateFormat.format(cal);

        dateField.setText(date);
    }//GEN-LAST:event_sellPriceFieldFocusGained

    private void sellPriceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellPriceFieldFocusLost

    }//GEN-LAST:event_sellPriceFieldFocusLost

    private void sellPriceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellPriceFieldKeyTyped
        int code = evt.getKeyCode();
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && code != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_sellPriceFieldKeyTyped

    private void quantitySpinnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantitySpinnerFocusLost

    }//GEN-LAST:event_quantitySpinnerFocusLost

    private void quantitySpinnerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerKeyPressed

    }//GEN-LAST:event_quantitySpinnerKeyPressed

    private void quantitySpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerKeyTyped
        int code = evt.getKeyCode();
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && code != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_quantitySpinnerKeyTyped

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void imageUploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageUploadButtonActionPerformed
        //Set image to the lable
        JFileChooser jFileChooser = new JFileChooser();

        //Add file extensions
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
        jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
        int showOpenDialog = jFileChooser.showOpenDialog(jPanel1);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            File selectedImage = jFileChooser.getSelectedFile();
            selectedImagePath = selectedImage.getAbsolutePath();
            JOptionPane.showMessageDialog(jPanel1, selectedImagePath);
            //Display image on the jLabel
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));

        }
    }//GEN-LAST:event_imageUploadButtonActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        if (productNameField.getText().isEmpty() || orderPriceField.getText().isEmpty() || sellPriceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item adding fail(Any field can not be empty) !", "Fail message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productIdField.getText());
        productDTO.setProductName(productNameField.getText());
        productDTO.setCategory(categoryCombo.getSelectedItem().toString());
        productDTO.setInitialQuantity((int) (quantitySpinner.getValue()));
        productDTO.setCurrentQuantity((int) quantitySpinner.getValue());
        productDTO.setStockId(stockIdField.getText());
        productDTO.setOrderPrice(Double.parseDouble(orderPriceField.getText()));
        productDTO.setSellPrice(Double.parseDouble(sellPriceField.getText()));
        // productDTO.setDate(Date.valueOf(LocalDate.now()));
        String stringDate = dateField.getText(); // DD/MM/YYYY
        productDTO.setDate(FormatUtill.convertStrinDateToSQLDateDDMMYYYY(stringDate));
        
        // ------ Add Image to ProductDTO befor sent DB
        try {
            if(selectedImagePath!=null){
                productDTO.setImageStream(new FileInputStream(new File(selectedImagePath)));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean addNewProductResult = ProductController.addNewProduct(productDTO);
        boolean addNewStockResult = ProductController.addStock(productDTO);
        boolean addItemInCAtegoryResult = ProductController.addItemInCategory(productDTO);
        if (addNewProductResult && addNewStockResult && addItemInCAtegoryResult) {
            JOptionPane.showMessageDialog(this, "Item added sucessfully !", "Confirmation message", JOptionPane.INFORMATION_MESSAGE);
            productNameField.setText("");
            productIdField.setText("");
            quantitySpinner.setValue(1);
            stockIdField.setText("");
            orderPriceField.setText("");
            sellPriceField.setText("");
            dateField.setText("");
            imageLabel.setIcon(null);
        } else {
            JOptionPane.showMessageDialog(this, "Item adding fail hello!", "Fail message", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addbuttonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked

    }//GEN-LAST:event_productTableMouseClicked

    private void productNameFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_productNameFieldInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameFieldInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JFormattedTextField dateField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton imageUploadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderPriceField;
    private javax.swing.JTextField productIdField;
    private javax.swing.JTextField productNameField;
    private javax.swing.JTable productTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField sellPriceField;
    private javax.swing.JTextField stockIdField;
    // End of variables declaration//GEN-END:variables
}
