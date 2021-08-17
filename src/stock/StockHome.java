/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;
import java.lang.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dulshan
 */
public class StockHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form Stock
     */
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String sqr;
    
    public StockHome() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        setDefaultsValues();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(680, 550));
        setPreferredSize(new java.awt.Dimension(680, 550));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setAlignmentX(0.0F);
        contentPanel.setAlignmentY(0.0F);
        contentPanel.setAutoscrolls(true);
        contentPanel.setLayout(null);

        jButton7.setBackground(new java.awt.Color(131, 168, 212));
        jButton7.setText("Consumable Inventory Stock In");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton7);
        jButton7.setBounds(150, 420, 220, 70);

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Stock Management");
        jLabel1.setToolTipText("");
        contentPanel.add(jLabel1);
        jLabel1.setBounds(30, 50, 167, 24);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(152, 152, 152))
        );

        contentPanel.add(jPanel2);
        jPanel2.setBounds(20, 140, 350, 190);

        jButton6.setBackground(new java.awt.Color(131, 168, 212));
        jButton6.setText("Consumable Inventory Stock Out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        contentPanel.add(jButton6);
        jButton6.setBounds(150, 340, 220, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        StockIn stockIn = new StockIn();
        contentPanel.removeAll();
        contentPanel.add(stockIn).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        StockOut stockOut = new StockOut();
        contentPanel.removeAll();
        contentPanel.add(stockOut).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

   
    
    
               private void loadTableData(){
//        ResultSet resultSet = null;
//        DefaultTableModel tableModel = (DefaultTableModel) stockTable.getModel();
//        tableModel.setNumRows(0);
//        try {
//            resultSet = conn.createStatement().executeQuery("SELECT * FROM receivestock WHERE iStatus='Available'");
//            while (resultSet.next()) {
//                String itemList[] = {resultSet.getString(1), resultSet.getString(3), resultSet.getString(4), String.valueOf(resultSet.getDouble(6)), String.valueOf(resultSet.getDouble(8)),String.valueOf(resultSet.getDouble(9)),String.valueOf(resultSet.getDouble(12)), String.valueOf(resultSet.getDouble(13)),resultSet.getString(2), resultSet.getString(14)};
//                
//                tableModel.addRow(itemList);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, ex);
//        } finally {
//            try {
//                resultSet.close();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(rootPane, ex);
//            }
//        }
    }
    private boolean updateQuantityAndDiscount() {
        boolean result = false;
//        if (!rnNoTextField.getText().isEmpty()) {
//            try {
//                String updateQuerry = "UPDATE receivestock SET quentity='" + Double.valueOf(oldItemQuantityTextField.getText()) +"', iDiscount='"+Double.valueOf(discountTextField.getText() )+"' WHERE item_number='" + itemNoTextField.getText()+ "'";
//                pst = conn.prepareStatement(updateQuerry);
//                pst.execute();
//                result = true;
//                JOptionPane.showMessageDialog(rootPane, "Stock Updated Successfully");
//                setDefaultsValues();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(rootPane, e);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Please Select a Record from table to Update");
//        }
        return result;
    }
    private boolean updatePricingInfo(){
        boolean result = true;
//        if(!rnNoTextField.getText().isEmpty()){
//            if(withdrawOldItem()){
//                try {
//                    String querry = "INSERT INTO receivestock(receive_no, receive_date, item_number, item_name, quentity, buying_price, selling_price, iWPrice, iDiscount, iStatus) VALUES ('" 
//                            + generateReceiveNumber() + "','" + Home.date + "','" + itemNoTextField.getText() + "','" + itemNameTextField.getText() + "','"
//                            + (Double.valueOf(oldItemQuantityTextField.getText()) +Double.valueOf(newItemQuantityTextField.getText())) + "','" 
//                            + Double.valueOf(bPriceTextField.getText()) + "','" + Double.valueOf(rPriceTextField.getText()) 
//                            + "','" + Double.valueOf(wPriceTextField.getText()) + "','" + Double.valueOf(discountTextField.getText()) + "','" + "Available" + "')";
//                    pst = conn.prepareStatement(querry);
//                    pst.execute();
//                    JOptionPane.showMessageDialog(rootPane, "Item Re-Stocked successfully");
//                    setDefaultsValues();
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(rootPane, e);
//                } 
//            }else JOptionPane.showMessageDialog(rootPane, "Error Occured on discarding data");
//        }else JOptionPane.showMessageDialog(rootPane, "Please Select a Record from table to Re Pricing");
        return result;
    }
    private boolean withdrawOldItem() {
        boolean result = false;
//        try {
//            String updateQuerry = "UPDATE receivestock SET quentity='0', iStatus='Discarded' WHERE item_number='" + itemNoTextField.getText() + "'";
//            pst = conn.prepareStatement(updateQuerry);
//            pst.execute();
//            result = true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
        return result;
    }
    private String generateReceiveNumber() {
        String receiveID = null;
//        try {
//            String sql = "SELECT receive_no FROM receivestock ORDER BY receive_no DESC LIMIT 1";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                String rnno = rs.getString("receive_no");
//                String txt = rnno.substring(0, 2);
//                String num = rnno.substring(2, rnno.length());
//                int n = Integer.parseInt(num);
//                n++;
//                String snum = Integer.toString(n);
//                receiveID= txt + snum;
//            } else {
//                receiveID = "RN1000";
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
        return receiveID;
    }
    private void setDefaultsValues(){
    }
    private void setQuantityAndDiscount(){
    }
    private void setPrices(){
       
    }
    private void setDefaults(){
        
    }
    private void searchItemData(String filter) {
//        DefaultTableModel tableModel = (DefaultTableModel) stockTable.getModel();
//        TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(tableModel);
//        stockTable.setRowSorter(tableRow);
//        tableRow.setRowFilter(RowFilter.regexFilter("(?i)"+filter));
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}