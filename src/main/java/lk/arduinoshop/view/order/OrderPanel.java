/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.arduinoshop.view;

import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lk.arduinoshop.controller.OrderController;
import lk.arduinoshop.model.OrderDTO;
import lk.arduinoshop.view.order.DetailOrder;

/**
 *
 * @author Iyona Chithrasena
 */
public class OrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form testpanel
     */
    public OrderPanel() {
        initComponents();
        addDataToTable();
        orderTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        
      }
    public void addDataToTable(){
        OrderDTO orderDTO= new OrderDTO();
        List<OrderDTO> orderDTOList = OrderController.getAllOrders();

        DefaultTableModel tableModel = (DefaultTableModel) orderTable.getModel();
        Object rowData[] = new Object[4];
        for (int i = 0; i < orderDTOList.size(); i++) {
            rowData[0] = orderDTOList.get(i).getOrderID();
            rowData[1] = orderDTOList.get(i).getOrderAmount();
            rowData[2] = orderDTOList.get(i).getDate();
            rowData[3] = orderDTOList.get(i).getUserID();
            tableModel.addRow(rowData);
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonViewOrderPanel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        orderTable.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oder ID", "Bill Amount", "Date", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.setAlignmentX(jLabel1.getAlignmentX());
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setMinWidth(100);
            orderTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            orderTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("View Order ");

        jButtonViewOrderPanel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButtonViewOrderPanel.setForeground(new java.awt.Color(0, 51, 102));
        jButtonViewOrderPanel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Iyona Chithrasena\\Documents\\NetBeansProjects\\MyNewArduinoshop\\src\\main\\java\\Images\\viewNew_1.png")); // NOI18N
        jButtonViewOrderPanel.setText("View");
        jButtonViewOrderPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewOrderPanelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("From");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("To");

        fromDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromDateChooserPropertyChange(evt);
            }
        });

        toDateChooser.setMaxSelectableDate(new java.util.Date());
        toDateChooser.setMinSelectableDate(new java.util.Date(-62135794690000L));
        toDateChooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                toDateChooserInputMethodTextChanged(evt);
            }
        });
        toDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDateChooserPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(360, 360, 360)
                                .addComponent(toDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addGap(77, 77, 77))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButtonViewOrderPanel)
                        .addGap(57, 57, 57)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButtonViewOrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) orderTable.getModel();
        int row=orderTable.getSelectedRow();
        int orderID = Integer.parseInt(orderTable.getValueAt(row, 0).toString());
       // System.out.println(orderID);
        DetailOrder detailOrder = new DetailOrder(orderID);
        detailOrder.setVisible(true);
    }//GEN-LAST:event_orderTableMouseClicked

    private void fromDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromDateChooserPropertyChange

        // --- Set min date to toDateChooser
        toDateChooser.setMinSelectableDate(fromDateChooser.getDate());

    }//GEN-LAST:event_fromDateChooserPropertyChange

    private void toDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDateChooserPropertyChange

        // --- Set max date to fromDateChooser
        // fromDateChooser max date should not go beyond toDateChooser  selected date
        fromDateChooser.setMaxSelectableDate(toDateChooser.getDate());
    }//GEN-LAST:event_toDateChooserPropertyChange

    private void toDateChooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_toDateChooserInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_toDateChooserInputMethodTextChanged

    private void jButtonViewOrderPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewOrderPanelActionPerformed
        //       ViewOrderFrame viewOrderFrame = new ViewOrderFrame();
        //       viewOrderFrame.setVisible(true);
        String error = "Can't view order without selecting any row";
        JTextArea outputArea = new JTextArea(12,10);
        outputArea.setText(error);
        JOptionPane.showMessageDialog(null, error,"Error Message", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_jButtonViewOrderPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JButton jButtonViewOrderPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private com.toedter.calendar.JDateChooser toDateChooser;
    // End of variables declaration//GEN-END:variables
}
