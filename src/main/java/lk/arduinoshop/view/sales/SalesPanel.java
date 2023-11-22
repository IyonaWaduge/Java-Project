/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import lk.arduinoshop.controller.ProductController;
import lk.arduinoshop.controller.SalesController;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;
import lk.arduinoshop.view.sales.PrintBillPanel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Iyona Chithrasena
 */
public class SalesPanel extends javax.swing.JPanel {

    /**
     * Creates new form testpanel
     */
    public SalesPanel() {
        initComponents();
        billTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // name combo
        AutoCompleteDecorator.decorate(productNameCombo);
        productNameCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewActionListnerToNameCombo();

                if (e.getActionCommand() == "comboBoxEdited") {
                    if (!isQuantityValid()) {
                        return;
                    }
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
                    if (!isQuantityValid()) {
                        return;
                    }
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
                    stockIDField.setText(billTable.getValueAt(billTable.getSelectedRow(), 2).toString());
                    unitPriceField.setText(billTable.getModel().getValueAt(billTable.getSelectedRow(), 4).toString());
                    quantitySpinnerField.setValue(billTable.getValueAt(billTable.getSelectedRow(), 3));
                    discountField.setText(billTable.getValueAt(billTable.getSelectedRow(), 5).toString());

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
            Logger.getLogger(SalesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewActionListnerToIdCombo() {
        try {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(productIdcombo.getSelectedItem().toString());
            productDTO.setProductName(SalesController.setItemName(productDTO));
            productNameCombo.setSelectedItem(productDTO.getProductName());

        } catch (SQLException ex) {
            Logger.getLogger(SalesPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        stockIDField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        quantitySpinnerField = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        productNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        productIDField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        availableQuantityField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
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
        unitPriceField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Product ID");

        stockIDField.setEditable(false);
        stockIDField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Available Quantity");

        discountField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
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

        quantitySpinnerField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Stock ID");

        productNameField.setEditable(false);
        productNameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Discount");

        productIDField.setEditable(false);
        productIDField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Unit Price");

        availableQuantityField1.setEditable(false);
        availableQuantityField1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout productDetailPanelLayout = new javax.swing.GroupLayout(productDetailPanel);
        productDetailPanel.setLayout(productDetailPanelLayout);
        productDetailPanelLayout.setHorizontalGroup(
            productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(productIDField)
                            .addComponent(productNameField)
                            .addComponent(stockIDField)
                            .addComponent(availableQuantityField1)
                            .addComponent(unitPriceField)
                            .addComponent(discountField))
                        .addGap(25, 25, 25))
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(productDetailPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantitySpinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(productDetailPanelLayout.createSequentialGroup()
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productDetailPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(productIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(stockIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(availableQuantityField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantitySpinnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(productDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButtonAdd)
                .addGap(22, 22, 22))
        );

        billTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "StockID", "Quantity", "Unit Price", "Discount", "D. Total", "AvailableQuantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        if (billTable.getColumnModel().getColumnCount() > 0) {
            billTable.getColumnModel().getColumn(0).setMinWidth(80);
            billTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            billTable.getColumnModel().getColumn(0).setMaxWidth(80);
            billTable.getColumnModel().getColumn(1).setMinWidth(150);
            billTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            billTable.getColumnModel().getColumn(1).setMaxWidth(150);
            billTable.getColumnModel().getColumn(2).setMinWidth(80);
            billTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            billTable.getColumnModel().getColumn(2).setMaxWidth(80);
            billTable.getColumnModel().getColumn(3).setMinWidth(80);
            billTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            billTable.getColumnModel().getColumn(3).setMaxWidth(80);
            billTable.getColumnModel().getColumn(4).setMinWidth(100);
            billTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            billTable.getColumnModel().getColumn(4).setMaxWidth(100);
            billTable.getColumnModel().getColumn(5).setMinWidth(100);
            billTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            billTable.getColumnModel().getColumn(5).setMaxWidth(100);
            billTable.getColumnModel().getColumn(6).setMinWidth(100);
            billTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            billTable.getColumnModel().getColumn(6).setMaxWidth(100);
            billTable.getColumnModel().getColumn(7).setMinWidth(0);
            billTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            billTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Billing Order");

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

        clearButton.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\clearN (2).png")); // NOI18N
        clearButton.setBorder(null);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
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
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(clearButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        productNameCombo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
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

        productIdcombo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productIdcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                SalesDTO salesDTO = new SalesDTO();

                salesDTO.setProductId(tableModel.getValueAt(row, 0).toString());
                salesDTO.setProductName(tableModel.getValueAt(row, 1).toString());
                salesDTO.setStockId(tableModel.getValueAt(row, 2).toString());
                salesDTO.setQuantity(Integer.parseInt(tableModel.getValueAt(row, 3).toString()));
                salesDTO.setSellPrice(Double.parseDouble(tableModel.getValueAt(row, 4).toString()));
                salesDTO.setDiscount(Double.parseDouble(tableModel.getValueAt(row, 5).toString()));
                salesDTO.setCurrentQuantity(Integer.parseInt(availableQuantityField1.getText()) - Integer.parseInt(tableModel.getValueAt(row, 3).toString()));
                itemList.add(salesDTO);

            }
            PrintBillPanel printBillPanel = new PrintBillPanel(itemList,this);
            JFrame rootFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

            JDialog printBillDialog = new JDialog(rootFrame, "Print Bill", true);

            printBillDialog.setSize(560, 500);
            printBillDialog.setLocationRelativeTo(rootFrame);
            printBillDialog.getContentPane().add(printBillPanel);
            printBillDialog.setVisible(true);

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

        if (!isQuantityValid()) {
            return;
        }
        if (tableModel.getRowCount() == 0) {
            int quantity = (int) quantitySpinnerField.getValue();
            double discount = Double.parseDouble(discountField.getText());
            addRowToTableAction(quantity, discount);

        } else {
            String productId = productIDField.getText().toString();
            String productName = productNameField.getText().toString();
            String stockId = stockIDField.getText().toString();
            int availabeQuantity = Integer.parseInt(quantitySpinnerField.getValue().toString());
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
                Object rowData[] = new Object[8];

                rowData[0] = productId;
                rowData[1] = productName;
                rowData[2] = stockId;
                rowData[3] = quantity;
                rowData[4] = unitPrice;
                rowData[5] = discount;
                rowData[6] = total;
                rowData[7] = availabeQuantity;

                tableModel.addRow(rowData);

                // ------- select last row
                billTable.changeSelection(tableModel.getRowCount() - 1, 0, false, false);
            } else {
                tableModel.setValueAt(productId, selectedRow, 0);
                tableModel.setValueAt(productName, selectedRow, 1);
                tableModel.setValueAt(stockId, selectedRow, 2);
                tableModel.setValueAt(quantity, selectedRow, 3);
                tableModel.setValueAt(unitPrice, selectedRow, 4);
                tableModel.setValueAt(discount, selectedRow, 5);
                tableModel.setValueAt(total, selectedRow, 6);
                tableModel.setValueAt(availabeQuantity, selectedRow, 7);

            }
        }

        //  ------------
        double finalTotal = 0.0;
        double total = 0.0;
        double discountTotal = 0.0;
        for (int i = 0; i < billTable.getRowCount(); i++) {
            finalTotal += Double.parseDouble(tableModel.getValueAt(i, 6).toString());
            discountTotal = discountTotal + Double.parseDouble(tableModel.getValueAt(i, 5).toString());
            total = total + (Integer.parseInt(tableModel.getValueAt(i, 3).toString()) * Double.parseDouble(tableModel.getValueAt(i, 4).toString()));
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

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();


    }//GEN-LAST:event_clearButtonActionPerformed

    private void productIdcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdcomboActionPerformed

    private void billTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billTableKeyPressed
        System.out.println("gello");
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
            Object rowData[] = new Object[8];

            rowData[0] = salesDTOReturn.getProductId();
            rowData[1] = salesDTOReturn.getProductName();
            rowData[2] = salesDTOReturn.getStockId();
            rowData[3] = quantity;
            rowData[4] = salesDTOReturn.getSellPrice();
            rowData[5] = discount;
            rowData[6] = (quantity * salesDTOReturn.getSellPrice()) - discount;
            rowData[7] = salesDTOReturn.getCurrentQuantity();

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
            double amount = Double.parseDouble(tableModel.getValueAt(row, 3).toString()) * Double.parseDouble(tableModel.getValueAt(row, 4).toString());
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
                stockId = tableModel.getValueAt(i, 2).toString();
                quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
                availabeQuantity = String.valueOf((salesDTOReturn.getCurrentQuantity()));
                unitPrice = tableModel.getValueAt(i, 4).toString();
                discount = tableModel.getValueAt(i, 5).toString();

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
            stockId = salesDTOReturn.getStockId();
            availabeQuantity = String.valueOf(salesDTOReturn.getCurrentQuantity());
            unitPrice = String.valueOf(salesDTOReturn.getSellPrice());

            discount = "0";
            // TODO fill others
        }

        productIDField.setText(productId);
        productNameField.setText(productName);
        stockIDField.setText(stockId);
        availableQuantityField1.setText(String.valueOf(availabeQuantity));
        unitPriceField.setText(unitPrice);
        quantitySpinnerField.setValue(quantity);
        discountField.setText(discount);

    }

    private boolean isQuantityValid() {
        boolean status = true;
        int availableQuantity = Integer.parseInt(availableQuantityField1.getText());
        int quantity = Integer.parseInt(quantitySpinnerField.getValue().toString());
        if (quantity > availableQuantity) {
            JOptionPane.showMessageDialog(null, "You can not select more than available quantity", "Error Message", JOptionPane.ERROR_MESSAGE);
            status = false;
        }
        return status;
    }
    
    //-----clear fields
    public void clearFields(){
        DefaultTableModel model = (DefaultTableModel) billTable.getModel();
        model.setRowCount(0);
        billTable.setModel(model);
        totalAmountTextField.setText("");
        discountTotalField.setText("");
        grandTotalField.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availableQuantityField1;
    private javax.swing.JTable billTable;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField discountField;
    public static javax.swing.JTextField discountTotalField;
    public static javax.swing.JTextField grandTotalField;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel productDetailPanel;
    private javax.swing.JTextField productIDField;
    private javax.swing.JComboBox<String> productIdcombo;
    private javax.swing.JComboBox<String> productNameCombo;
    private javax.swing.JTextField productNameField;
    private javax.swing.JSpinner quantitySpinnerField;
    private javax.swing.JTextField stockIDField;
    public static javax.swing.JTextField totalAmountTextField;
    private javax.swing.JTextField unitPriceField;
    // End of variables declaration//GEN-END:variables
}
