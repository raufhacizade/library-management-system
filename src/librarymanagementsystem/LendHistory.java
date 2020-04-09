package librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LendHistory extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LendHistory() {

        initComponents();
        conn = DBConnect.connect();
        tablelord();
    }

    private void tablelord() {
        try {
            String sql = "SELECT "
                    + "`recordNo`, "
                    + "`member_id`, "
                    + "`bid`, "
                    + "`lDate`, "
                    + "`rDate` "
                    + "FROM `booklend`";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            lendHistoryTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    private void filter(){
        String fDate = ((JTextField) fromDate.getDateEditor().getUiComponent()).getText().toString();
        String tDate = ((JTextField) toDate.getDateEditor().getUiComponent()).getText().toString();

        if (fDate.length() > 0 && tDate.isEmpty()) {
            try {
                String sql = "SELECT "
                        + "`recordNo`, "
                        + "`member_id`, "
                        + "`bid`, "
                        + "`lDate`, "
                        + "`rDate` "
                        + "FROM `booklend` "
                        + "WHERE lDate='" + fDate + "' and mid LIKE '%" + search.getText() + "%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                lendHistoryTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "First date\n" + e);
            }
        } else if (fDate.length() > 0 && tDate.length() > 0) {
            try {
                String sql = "SELECT "
                        + "`recordNo`, "
                        + "`member_id`, "
                        + "`bid`, "
                        + "`lDate`, "
                        + "`rDate` "
                        + "FROM `booklend` "
                        + "WHERE mid LIKE '%" + search.getText() + "%'"
                        + "and lDate between '" + fDate + "' and '" + tDate + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                lendHistoryTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Secand date\n" + e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select date to filter data\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lendHistoryTable = new javax.swing.JTable();
        print = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        filter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fromDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(990, 560));
        setPreferredSize(new java.awt.Dimension(990, 560));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(37, 47, 65));
        jLabel16.setText("Member ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(37, 47, 65));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 190, 30));

        jLabel15.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(37, 47, 65));
        jLabel15.setText("Lend History");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, 310, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 60));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        lendHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        lendHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lendHistoryTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lendHistoryTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 940, 380));

        print.setBackground(new java.awt.Color(97, 212, 195));
        print.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        print.setForeground(new java.awt.Color(37, 47, 65));
        print.setText("Print");
        print.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 160, 50));

        clear.setBackground(new java.awt.Color(97, 212, 195));
        clear.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(37, 47, 65));
        clear.setText("Clear");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, 160, 50));

        filter.setBackground(new java.awt.Color(97, 212, 195));
        filter.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        filter.setForeground(new java.awt.Color(37, 47, 65));
        filter.setText("Filter");
        filter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });
        jPanel1.add(filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 90, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(37, 47, 65));
        jLabel5.setText("from");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, 30));

        fromDate.setBackground(new java.awt.Color(97, 212, 195));
        fromDate.setForeground(new java.awt.Color(37, 47, 65));
        fromDate.setDateFormatString("yyyy,MM,dd");
        jPanel1.add(fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 140, 30));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 47, 65));
        jLabel6.setText("to");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, 30));

        toDate.setBackground(new java.awt.Color(97, 212, 195));
        toDate.setForeground(new java.awt.Color(37, 47, 65));
        toDate.setDateFormatString("yyyy,MM,dd");
        jPanel1.add(toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 150, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 540, 50));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lendHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lendHistoryTableMouseClicked

    }//GEN-LAST:event_lendHistoryTableMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            lendHistoryTable.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Print command unseccess\n\n"+ e);
        }

    }//GEN-LAST:event_printActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        try {
            String sql = "SELECT "
                    + "`recordNo`, "
                    + "`member_id`, "
                    + "`bid`, "
                    + "`lDate`, "
                    + "`rDate` "
                    + "FROM `booklend` WHERE mid LIKE '%" + search.getText() + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            lendHistoryTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        search.setText("");
        ((JTextField) fromDate.getDateEditor().getUiComponent()).setText("");
        ((JTextField) toDate.getDateEditor().getUiComponent()).setText("");
        tablelord();
    }//GEN-LAST:event_clearActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        filter();
    }//GEN-LAST:event_filterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton filter;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lendHistoryTable;
    private javax.swing.JButton print;
    private javax.swing.JTextField search;
    private com.toedter.calendar.JDateChooser toDate;
    // End of variables declaration//GEN-END:variables
}
