/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view.quotation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import lk.arduinoshop.controller.ProductController;
import lk.arduinoshop.controller.SalesController;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Iyona Chithrasena
 */
public class CreateQuotation extends javax.swing.JPanel {

    /**
     * Creates new form testpanel
     */
    public CreateQuotation() {
        initComponents();

        // name combo
        AutoCompleteDecorator.decorate(productNameCombo);
        productNameCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewActionListnerToNameCombo();
                if (e.getActionCommand() == "comboBoxEdited") {

                    addRowToTableAction(1, 0);
                }

            }
        });

        //id combo
        AutoCompleteDecorator.decorate(productIdcombo);
        productIdcombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewActionListnerToIdCombo();
                fillProductDetails();
                if (e.getActionCommand() == "comboBoxEdited") {

                    addRowToTableAction(1, 0);
                }

            }
        });
//comboBoxEdited
        addDataToCombos();

        //table modifications
        TableColumnModel tableColumnModel = billTable.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(7));

        billTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {

                //System.out.println(billTable.getModel().getValueAt(0, 7));
                if (!event.getValueIsAdjusting() && !(billTable.getRowCount() <= 0) && billTable.getSelectedRow() > -1) {
                    productIDField.setText(billTable.getValueAt(billTable.getSelectedRow(), 0).toString());
                    productNameField.setText(billTable.getValueAt(billTable.getSelectedRow(), 1).toString());
                   // stockIDField.setText(billTable.getValueAt(billTable.getSelectedRow(), 2).toString());
                    unitPriceField.setText(billTable.getModel().getValueAt(billTable.getSelectedRow(), 3).toString());
                    quantitySpinnerField.setValue(billTable.getValueAt(billTable.getSelectedRow(), 2));
                    discountField.setText(billTable.getValueAt(billTable.getSelectedRow(), 4).toString());

                }
            }
        });

    }

    public void addDataToCombos() {
        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productList = ProductController.getProductDTOList();
        for (int i = 0; i < productList.size(); i++) {
            String productName = productList.get(i).getProductName();
            productNameCombo.addItem(productName);
            String productId = productList.get(i).getProductId();
            productIdcombo.addItem(productId);
        }

    }

    public void addNewActionListnerToNameCombo() {
        
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(productNameCombo.getSelectedItem().toString());
            productDTO.setProductId(SalesController.setItemId(productDTO));
            productIdcombo.setSelectedItem(productDTO.getProductId());
        } catch (SQLException ex) {
            Logger.getLogger(CreateQuotation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void addNewActionListnerToIdCombo() {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(productIdcombo.getSelectedItem().toString());
            productDTO.setProductName(SalesController.setItemName(productDTO));
            productNameCombo.setSelectedItem(productDTO.getProductName());

        } catch (SQLException ex) {
            Logger.getLogger(CreateQuotation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------ Row selection listner 
    public void addDataToProductDetails() {
    }

    private void deleteSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) billTable.getModel();
        int selectedRow = billTable.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productDetailPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        unitPriceField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        quantitySpinnerField = new javax.swing.JSpinner();
        productNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        productIDField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        discountByPercentage = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        jButtonAdd3 = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();
        grandTotalField = new javax.swing.JTextField();
        discountTotalField = new javax.swing.JTextField();
        productNameCombo = new javax.swing.JComboBox<>();
        productIdcombo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Product ID");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Product Name");

        productDetailPanel.setBackground(new java.awt.Color(255, 255, 255));
        productDetailPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Product Name");

        unitPriceField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Product ID");

        discountField.setText("0");
        discountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountFieldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Quantity");

        jButtonAdd.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 0, 204));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setText("        Product Details");

        quantitySpinnerField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantitySpinnerField.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        quantitySpinnerField.setEditor(new javax.swing.JSpinner.NumberEditor(quantitySpinnerField, ""));
        quantitySpinnerField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantitySpinnerFieldMouseClicked(evt);
            }
        });
        quantitySpinnerField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantitySpinnerFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantitySpinnerFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantitySpinnerFieldKeyTyped(evt);
            }
        });

        productNameField.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Discount");

        productIDField.setEditable(false);

        jLabel11.setText("OR");

        discountByPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountByPercentageActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Unit Price");

        javax.swing.GroupLayout productDetailPanelLayout = new javax.swing.GroupLayout(productDetailPanel);
        productDetailPanel.setLayout(productDetailPanelLayout);
        productDetailPanelLayout.setHorizontalGroup(
            productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productDetailPanelLayout.createSequentialGroup()
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(productDetailPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(productDetailPanelLayout.createSequentialGroup()
                                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(productIDField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(productNameField, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(productDetailPanelLayout.createSequentialGroup()
                                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                                        .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(discountByPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(quantitySpinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        productDetailPanelLayout.setVerticalGroup(
            productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productDetailPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantitySpinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(discountByPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jButtonAdd)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Unit Price", "Discount", "Discounted Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                billTableFocusGained(evt);
            }
        });
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        billTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                billTablePropertyChange(evt);
            }
        });
        billTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(billTable);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Add Items to Quotation");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 51));
        jLabel12.setText("Discount");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Total Amount");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 51));
        jLabel14.setText("Grand Total");

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        totalAmountTextField.setForeground(new java.awt.Color(0, 0, 102));

        jButtonAdd3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButtonAdd3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\clearN (2).png")); // NOI18N
        jButtonAdd3.setBorder(null);
        jButtonAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdd3ActionPerformed(evt);
            }
        });

        checkOutButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        checkOutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\checkoutN.png")); // NOI18N
        checkOutButton.setBorder(null);
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        grandTotalField.setEditable(false);
        grandTotalField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        grandTotalField.setForeground(new java.awt.Color(0, 0, 102));

        discountTotalField.setEditable(false);
        discountTotalField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        discountTotalField.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(discountTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkOutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(discountTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtonAdd3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        productNameCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productNameComboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                productNameComboFocusLost(evt);
            }
        });
        productNameCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productNameComboMouseClicked(evt);
            }
        });
        productNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameComboActionPerformed(evt);
            }
        });
        productNameCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameComboKeyPressed(evt);
            }
        });

        productIdcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdcomboActionPerformed(evt);
            }
        });
        productIdcombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productIdcomboKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(457, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(productIdcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(productNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(productNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productIdcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(productDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void discountByPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountByPercentageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountByPercentageActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) billTable.getModel();
        int rowCount = tableModel.getRowCount();
        //System.out.println(rowCount);
        if (rowCount == 0) {
            String error = "You can't checkout with empty item table !";
            JTextArea outputArea = new JTextArea(12, 10);
            outputArea.setText(error);
            JOptionPane.showMessageDialog(null, error, "Error Message", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<SalesDTO> itemList = new ArrayList<>();
            for (int row = 0; row < tableModel.getRowCount() ; row++) {
                SalesDTO salesDTO = new SalesDTO();

                salesDTO.setProductId(tableModel.getValueAt(row, 0).toString());
                salesDTO.setProductName(tableModel.getValueAt(row, 1).toString());
               // salesDTO.setStockId(tableModel.getValueAt(row, 2).toString());
                salesDTO.setQuantity(Integer.parseInt(tableModel.getValueAt(row, 2).toString()));
                salesDTO.setSellPrice(Double.parseDouble(tableModel.getValueAt(row, 3).toString()));
                salesDTO.setDiscount(Double.parseDouble(tableModel.getValueAt(row, 4).toString()));
                //salesDTO.setCurrentQuantity(Integer.parseInt(availableQuantityField1.getText())- Integer.parseInt(tableModel.getValueAt(row, 3).toString()));
                itemList.add(salesDTO);
                
            }
            

        }

    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void productNameComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productNameComboMouseClicked

    }//GEN-LAST:event_productNameComboMouseClicked

    private void productNameComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameComboKeyPressed


    }//GEN-LAST:event_productNameComboKeyPressed

    private void productNameComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameComboFocusLost

    }//GEN-LAST:event_productNameComboFocusLost

    private void productNameComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameComboFocusGained

    }//GEN-LAST:event_productNameComboFocusGained

    private void productIdcomboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productIdcomboKeyPressed


    }//GEN-LAST:event_productIdcomboKeyPressed

    private void billTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billTableFocusGained

    }//GEN-LAST:event_billTableFocusGained

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked

    }//GEN-LAST:event_billTableMouseClicked

    private void billTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_billTablePropertyChange

    }//GEN-LAST:event_billTablePropertyChange

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) billTable.getModel();
        
        
        if (tableModel.getRowCount() == 0) {
            int quantity = (int) quantitySpinnerField.getValue();
            double discount = Double.parseDouble(discountField.getText());
            addRowToTableAction(quantity, discount);

        } else {
            String productId = productIDField.getText().toString();
            String productName = productNameField.getText().toString();
           // String stockId = stockIDField.getText().toString();
            //int availabeQuantity = Integer.parseInt(quantitySpinnerField.getValue().toString());
            int quantity = Integer.parseInt(quantitySpinnerField.getValue().toString());
            double discount = Double.parseDouble(discountField.getText().toString());
            double unitPrice = Double.parseDouble(unitPriceField.getText().toString());
            double total = (unitPrice * quantity) - discount;

            int selectedRow = -1;

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(productId)) {
                    selectedRow = i;
                }

            }

            if (selectedRow == -1) {
                Object rowData[] = new Object[6];

                rowData[0] = productId;
                rowData[1] = productName;
               // rowData[2] = stockId;
                rowData[2] = quantity;
                rowData[3] = unitPrice;
                rowData[4] = discount;
                rowData[5] = total;
              //  rowData[7] = availabeQuantity;

                tableModel.addRow(rowData);

                // ------- select last row
                billTable.changeSelection(tableModel.getRowCount() - 1, 0, false, false);
            } else {
                tableModel.setValueAt(productId, selectedRow, 0);
                tableModel.setValueAt(productName, selectedRow, 1);
               // tableModel.setValueAt(stockId, selectedRow, 2);
                tableModel.setValueAt(quantity, selectedRow, 2);
                tableModel.setValueAt(unitPrice, selectedRow, 3);
                tableModel.setValueAt(discount, selectedRow, 4);
                tableModel.setValueAt(total, selectedRow, 5);
               // tableModel.setValueAt(availabeQuantity, selectedRow, 7);

            }
        }

        //  ------------
        double finalTotal = 0.0;
        double total = 0.0;
        double discountTotal = 0.0;
        for (int i = 0; i < billTable.getRowCount(); i++) {
            finalTotal += Double.parseDouble(tableModel.getValueAt(i, 5).toString());
            discountTotal = discountTotal + Double.parseDouble(tableModel.getValueAt(i, 4).toString());
            total = total + (Integer.parseInt(tableModel.getValueAt(i, 2).toString()) * Double.parseDouble(tableModel.getValueAt(i, 4).toString()));
        }

        totalAmountTextField.setText(String.valueOf(total));
        discountTotalField.setText(String.valueOf(discountTotal));
        grandTotalField.setText(String.valueOf(finalTotal));

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void discountFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_discountFieldKeyTyped

    private void quantitySpinnerFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerFieldKeyTyped
        
    }//GEN-LAST:event_quantitySpinnerFieldKeyTyped

    private void jButtonAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdd3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) billTable.getModel();
        model.setRowCount(0);
        billTable.setModel(model);


    }//GEN-LAST:event_jButtonAdd3ActionPerformed

    private void productIdcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdcomboActionPerformed

    private void billTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTableKeyPressed
        //System.out.println("gello");
        int keyCode = evt.getKeyCode();
        if (keyCode == java.awt.event.KeyEvent.VK_DELETE) {
            DefaultTableModel model = (DefaultTableModel) billTable.getModel();
            int selectedRow = billTable.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }

        }
    }//GEN-LAST:event_billTableKeyPressed

    private void productNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameComboActionPerformed

    private void quantitySpinnerFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerFieldKeyPressed
        
    }//GEN-LAST:event_quantitySpinnerFieldKeyPressed

    private void quantitySpinnerFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitySpinnerFieldKeyReleased
      
    }//GEN-LAST:event_quantitySpinnerFieldKeyReleased

    private void quantitySpinnerFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantitySpinnerFieldMouseClicked
        
    }//GEN-LAST:event_quantitySpinnerFieldMouseClicked

    //-----------
    private void addRowToTableAction(int quantity, double discount) {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setProductId(productIdcombo.getSelectedItem().toString());
        SalesDTO salesDTOReturn = SalesController.getSalesDTOList(salesDTO);
        DefaultTableModel tableModel = (DefaultTableModel) billTable.getModel();
        String productID = productIdcombo.getSelectedItem().toString();
        int selectedRow = -1;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(productID)) {
                selectedRow = i;
            }

        }
        double total = 0.0;
        if (selectedRow == -1) {
            Object rowData[] = new Object[6];

            rowData[0] = salesDTOReturn.getProductId();
            rowData[1] = salesDTOReturn.getProductName();
           // rowData[2] = salesDTOReturn.getStockId();
            rowData[2] = quantity;
            rowData[3] = salesDTOReturn.getSellPrice();
            rowData[4] = discount;
            rowData[5] = (quantity * salesDTOReturn.getSellPrice()) - discount;
            //rowData[7] = salesDTOReturn.getCurrentQuantity();

            tableModel.addRow(rowData);
            // ------- select last row
            billTable.changeSelection(tableModel.getRowCount() - 1, 0, false, false);
        } else {
            int selectedRowEnter = -1;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(productIDField.getText().toString())) {
                    selectedRowEnter = i;
                }

            }
            billTable.changeSelection(selectedRowEnter, 0, false, false);

        }
        double totalDiscount = 0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            double amount = Double.parseDouble(tableModel.getValueAt(row, 2).toString()) * Double.parseDouble(tableModel.getValueAt(row, 3).toString());
            discount = Double.parseDouble(tableModel.getValueAt(row, 5).toString());
            totalDiscount = totalDiscount + discount;
            total += amount;
            //  System.out.println(total);
        }
        totalAmountTextField.setText(String.valueOf(total));
        discountTotalField.setText("0");
        grandTotalField.setText(String.valueOf(total));
        //billTable.setRowSelectionInterval(tableModel.getRowCount()-1, 0);

    }

    private void fillProductDetails() {

        String productId = null;
        String productName = null;
        String stockId = null;
        String availabeQuantity = null;
        int quantity = 1;
        String discount = null;
        String unitPrice = null;

        // --------- check entered item already exist in table 
        DefaultTableModel tableModel = (DefaultTableModel) billTable.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(productIdcombo.getSelectedItem().toString())) {

                SalesDTO salesDTO = new SalesDTO();
                salesDTO.setProductId(productIdcombo.getSelectedItem().toString());
                SalesDTO salesDTOReturn = SalesController.getSalesDTOList(salesDTO);

                productId = tableModel.getValueAt(i, 0).toString();
                productName = tableModel.getValueAt(i, 1).toString();
                //stockId = tableModel.getValueAt(i, 2).toString();
                quantity = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
               // availabeQuantity = String.valueOf((salesDTOReturn.getCurrentQuantity()));
                unitPrice = tableModel.getValueAt(i, 3).toString();
                discount = tableModel.getValueAt(i, 4).toString();

                // ----- change selected row
                billTable.changeSelection(i, 0, false, false);

                break;

//                tableModel.setValueAt(total, i, 6);
            }
        }

        if (productId == null) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(productIdcombo.getSelectedItem().toString());
            SalesDTO salesDTOReturn = SalesController.getSalesDTOList(salesDTO);

            productId = salesDTOReturn.getProductId();
            productName = salesDTOReturn.getProductName();
           // stockId = salesDTOReturn.getStockId();
           // availabeQuantity = String.valueOf(salesDTOReturn.getCurrentQuantity());
            unitPrice = String.valueOf(salesDTOReturn.getSellPrice());

            discount = "0";
            // TODO fill others
        }

        productIDField.setText(productId);
        productNameField.setText(productName);
        //stockIDField.setText(stockId);
      //  availableQuantityField1.setText(String.valueOf(availabeQuantity));
        unitPriceField.setText(unitPrice);
        quantitySpinnerField.setValue(quantity);
        discountField.setText(discount);

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billTable;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JTextField discountByPercentage;
    private javax.swing.JTextField discountField;
    public static javax.swing.JTextField discountTotalField;
    public static javax.swing.JTextField grandTotalField;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAdd3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel productDetailPanel;
    private javax.swing.JTextField productIDField;
    private javax.swing.JComboBox<String> productIdcombo;
    private javax.swing.JComboBox<String> productNameCombo;
    private javax.swing.JTextField productNameField;
    private javax.swing.JSpinner quantitySpinnerField;
    public static javax.swing.JTextField totalAmountTextField;
    private javax.swing.JTextField unitPriceField;
    // End of variables declaration//GEN-END:variables
}
