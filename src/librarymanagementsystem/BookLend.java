package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class BookLend extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public BookLend() {
        initComponents();
        conn = DBConnect.connect();
        autoId();

        LocalDate today = LocalDate.now();
        LocalDate reday = today.plus(10, ChronoUnit.DAYS);
        lendDate.setText(today.toString());
        returnDate.setText(reday.toString());

        tablelord();

    }

    private void clear() {
        bookId.setText("");
        memberId.setText("");
        memberName.setText("");
        memberType.setText("");
        bookName.setText("");
        bookType.setText("");
    }

    private void autoId() {
        try {
            String sql = "SELECT `recordNo` FROM `bookLend`  ORDER BY recordNo DESC LIMIT 1";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("recordNo");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                recordNo.setText(ftxt);
            } else {
                recordNo.setText("RN1000");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error\n\n" + e);
        }
    }

    private void tablelord() {
        try {
            String sql = "SELECT `recordNo`, `mid`, `bid`, `lDate`, `rDate` FROM `booklend`";
            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pst.executeQuery();

            bookLandTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void update() {
        try {
            String sql = "UPDATE `addbook` SET `mark`='1' WHERE bid='" + bookId.getText() + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Mark update success");
            tablelord();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Mark update unsuccess\n\n" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        lend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookLandTable = new javax.swing.JTable();
        memberId = new javax.swing.JTextField();
        memberName = new javax.swing.JTextField();
        memberType = new javax.swing.JTextField();
        lendDate = new javax.swing.JTextField();
        bookId = new javax.swing.JTextField();
        recordNo = new javax.swing.JTextField();
        bookName = new javax.swing.JTextField();
        bookType = new javax.swing.JTextField();
        returnDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setMinimumSize(new java.awt.Dimension(990, 560));
        setPreferredSize(new java.awt.Dimension(990, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 47, 65));
        jLabel7.setText("Member ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 47, 65));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(37, 47, 65));
        jLabel9.setText("Member Type");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(37, 47, 65));
        jLabel10.setText("Book ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(37, 47, 65));
        jLabel11.setText("Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(37, 47, 65));
        jLabel12.setText("Type");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(37, 47, 65));
        jLabel13.setText("Lend Date");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(37, 47, 65));
        jLabel14.setText("Return Date");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        clear.setBackground(new java.awt.Color(97, 212, 195));
        clear.setFont(new java.awt.Font("Sitka Text", 3, 30)); // NOI18N
        clear.setForeground(new java.awt.Color(37, 47, 65));
        clear.setText("Clear");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 230, 60));

        lend.setBackground(new java.awt.Color(97, 212, 195));
        lend.setFont(new java.awt.Font("Sitka Text", 3, 30)); // NOI18N
        lend.setForeground(new java.awt.Color(37, 47, 65));
        lend.setText("Lend");
        lend.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lendActionPerformed(evt);
            }
        });
        jPanel1.add(lend, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 230, 60));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        bookLandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(bookLandTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 950, 200));

        memberId.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        memberId.setForeground(new java.awt.Color(37, 47, 65));
        memberId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIdActionPerformed(evt);
            }
        });
        memberId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memberIdKeyReleased(evt);
            }
        });
        jPanel1.add(memberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 40, 150, 30));

        memberName.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        memberName.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(memberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 150, 30));

        memberType.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        memberType.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(memberType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, 30));

        lendDate.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        lendDate.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(lendDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 150, 30));

        bookId.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        bookId.setForeground(new java.awt.Color(37, 47, 65));
        bookId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookIdKeyReleased(evt);
            }
        });
        jPanel1.add(bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 180, 30));

        recordNo.setEditable(false);
        recordNo.setBackground(new java.awt.Color(97, 212, 195));
        recordNo.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        recordNo.setForeground(new java.awt.Color(37, 47, 65));
        recordNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recordNo.setBorder(null);
        jPanel1.add(recordNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 230, 60));

        bookName.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        bookName.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 180, 30));

        bookType.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        bookType.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(bookType, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 180, 30));

        returnDate.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        returnDate.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 270, 170, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 230));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 340, 230));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 250, 290));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 690, 50));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookIdKeyReleased
        try {
            String sql = "SELECT `name`, `book_type` FROM `addbook` WHERE bid='" + bookId.getText() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                bookName.setText(rs.getString("name"));
                bookType.setText(rs.getString("book_type"));
            } else {
                bookName.setText("");
                bookType.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bookIdKeyReleased

    private void memberIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberIdKeyReleased
        try {
            String sql = "SELECT `name`, `type` FROM `addmember` WHERE mid='" + memberId.getText() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                memberName.setText(rs.getString("name"));
                memberType.setText(rs.getString("type"));
            } else {
                memberName.setText("");
                memberType.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_memberIdKeyReleased

    private void memberIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIdActionPerformed

    }//GEN-LAST:event_memberIdActionPerformed

    private void lendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendActionPerformed

        try {
            String sql = "INSERT INTO `booklend`"
                    + "(`recordNo`, `mid`, `bid`, `lDate`, `rDate`,`mark`)"
                    + " VALUES ('" + recordNo.getText()
                    + "','" + memberId.getText()
                    + "','" + bookId.getText()
                    + "','" + lendDate.getText()
                    + "','" + returnDate.getText()
                    + "','0')";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Successfully Insert");
            update();
            tablelord();
            clear();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Unsuccessfully Insert\n\n" + e);
        }
        autoId();
    }//GEN-LAST:event_lendActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clear();
    }//GEN-LAST:event_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookId;
    private javax.swing.JTable bookLandTable;
    private javax.swing.JTextField bookName;
    private javax.swing.JTextField bookType;
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lend;
    private javax.swing.JTextField lendDate;
    private javax.swing.JTextField memberId;
    private javax.swing.JTextField memberName;
    private javax.swing.JTextField memberType;
    private javax.swing.JTextField recordNo;
    private javax.swing.JTextField returnDate;
    // End of variables declaration//GEN-END:variables
}
