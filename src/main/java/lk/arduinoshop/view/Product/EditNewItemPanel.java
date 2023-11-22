/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.Product;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import lk.arduinoshop.controller.ProductController;
import lk.arduinoshop.controller.SalesController;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class EditNewItemPanel extends javax.swing.JPanel {

    private String selectedImagePath = null;

    /**
     * Creates new form EditNewItemPanel
     */
    public EditNewItemPanel() {
        initComponents();
        productTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

    }

    public void clearFileds() {
        productNameField.setText("");
        productIdField.setText("");
        categoryField.setText("");
        quantitySpinner.setValue(0);
        stockIdField.setText("");
        orderPriceField.setText("");
        sellPriceField.setText("");
        dateField.setText("");
        imageLabel.setIcon(null);
        DefaultTableModel defaultTableModel = (DefaultTableModel) productTable.getModel();
        defaultTableModel.setRowCount(0);

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
        productIdField = new javax.swing.JTextField();
        orderPriceField = new javax.swing.JTextField();
        productNameField = new javax.swing.JTextField();
        sellPriceField = new javax.swing.JTextField();
        quantitySpinner = new javax.swing.JSpinner();
        dateField = new javax.swing.JFormattedTextField();
        imageLabel = new javax.swing.JLabel();
        imageUploadButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        stockIdField = new javax.swing.JTextField();
        categoryField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Edit Item Detail");

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

        productIdField.setEditable(false);
        productIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productIdFieldFocusLost(evt);
            }
        });

        orderPriceField.setEditable(false);

        productNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                productNameFieldFocusLost(evt);
            }
        });
        productNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productNameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productNameFieldKeyTyped(evt);
            }
        });

        sellPriceField.setEditable(false);
        sellPriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sellPriceFieldFocusLost(evt);
            }
        });

        quantitySpinner.setEnabled(false);
        quantitySpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantitySpinnerFocusLost(evt);
            }
        });
        quantitySpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantitySpinnerKeyPressed(evt);
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

        editButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\edit.png")); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        productTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ProductName", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setMinWidth(80);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            productTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        stockIdField.setEditable(false);
        stockIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stockIdFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockIdFieldFocusLost(evt);
            }
        });
        stockIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockIdFieldActionPerformed(evt);
            }
        });

        categoryField.setEditable(false);
        categoryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                categoryFieldFocusLost(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productIdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantitySpinner)
                                .addComponent(stockIdField)))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imageUploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(imageUploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void productIdFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productIdFieldFocusLost

    }//GEN-LAST:event_productIdFieldFocusLost

    private void productNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameFieldFocusGained

    }//GEN-LAST:event_productNameFieldFocusGained

    private void productNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameFieldFocusLost

    }//GEN-LAST:event_productNameFieldFocusLost

    private void productNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameFieldKeyPressed

    }//GEN-LAST:event_productNameFieldKeyPressed

    private void productNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameFieldKeyReleased

    }//GEN-LAST:event_productNameFieldKeyReleased

    private void productNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameFieldKeyTyped

        SalesDTO salesDTO = new SalesDTO();
        String eventCharacter = String.valueOf(evt.getKeyChar()).matches("[A-Za-z0-9]+") ? evt.getKeyChar() + "" : "";
        salesDTO.setProductName(productNameField.getText() + eventCharacter);
        
        ArrayList<SalesDTO> salesDTOReturnList = SalesController.searchProductName(salesDTO);

        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();

        tableModel.setRowCount(0);
        for (SalesDTO salesDTOReturn : salesDTOReturnList) {
            Object rowData[] = new Object[3];
            rowData[0] = salesDTOReturn.getProductId();
            rowData[1] = salesDTOReturn.getProductName();
            rowData[2] = salesDTOReturn.getProductDTO().getImageStream();

            tableModel.addRow(rowData);
        }
    }//GEN-LAST:event_productNameFieldKeyTyped

    private void sellPriceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellPriceFieldFocusLost

    }//GEN-LAST:event_sellPriceFieldFocusLost

    private void quantitySpinnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantitySpinnerFocusLost

    }//GEN-LAST:event_quantitySpinnerFocusLost

    private void quantitySpinnerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerKeyPressed

    }//GEN-LAST:event_quantitySpinnerKeyPressed

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

            // ---- Set Image From file Chooser 
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));

        }
    }//GEN-LAST:event_imageUploadButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        //int selectedRow = productTable.getRowCount();
        String nameValue = productNameField.getText();

        if (nameValue.trim() != null) {
            int response = JOptionPane.showConfirmDialog(this, "Do you want to edit " + nameValue + " ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(productIdField.getText());
                productDTO.setProductName(productNameField.getText());

                // ------ Add Image to ProductDTO befor sent DB
                try {
                    if (selectedImagePath != null) {
                        productDTO.setImageStream(new FileInputStream(new File(selectedImagePath)));
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddNewItemFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                boolean result = ProductController.updateSelectedRow(productDTO);
                if (result) {
                    JOptionPane.showMessageDialog(this, nameValue + "  was updatede successfully !");
                } else {
                    JOptionPane.showMessageDialog(this, nameValue + "  Updated Fail !");
                }

                
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        int selectedRow = productTable.getSelectedRow();
        String idValue = tableModel.getValueAt(selectedRow, 0).toString();

        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setProductId(idValue);
        System.out.println(idValue);
        SalesDTO salesDTOItem = SalesController.getSalesDTOList(salesDTO);
        productNameField.setText(salesDTOItem.getProductName());
        productIdField.setText(salesDTOItem.getProductId());
        categoryField.setText(salesDTOItem.getCategory());
        quantitySpinner.setValue(salesDTOItem.getInitialQuantity());
        stockIdField.setText(salesDTOItem.getStockId());
        orderPriceField.setText(String.valueOf(salesDTOItem.getOrderPrice()));
        sellPriceField.setText(String.valueOf(salesDTOItem.getSellPrice()));
        dateField.setText(String.valueOf(salesDTOItem.getDate()));

        // ----- SET IMAGE COMMING FROM TABLE 
        InputStream imageStream = (InputStream) tableModel.getValueAt(selectedRow, 2);
        if (imageStream != null) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(imageStream);
            } catch (IOException ex) {
                Logger.getLogger(EditNewItemPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            ImageIcon imageIcon = new ImageIcon(image);
            Image scaledInstance = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledInstance));

        }

    }//GEN-LAST:event_productTableMouseClicked

    private void stockIdFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockIdFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_stockIdFieldFocusGained

    private void stockIdFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockIdFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_stockIdFieldFocusLost

    private void stockIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockIdFieldActionPerformed

    private void categoryFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoryFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryFieldFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoryField;
    private javax.swing.JFormattedTextField dateField;
    private javax.swing.JButton editButton;
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
