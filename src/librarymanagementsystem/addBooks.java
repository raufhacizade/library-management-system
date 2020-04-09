package librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class addBooks extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public addBooks() {
        initComponents();
        conn = DBConnect.connect();
        autoId();
        tablelord();
    }

    private String getDate() {
        return ((JTextField) bookDate.getDateEditor().getUiComponent()).getText();
    }

    private String getCategory() {
        return category.getSelectedItem().toString();
    }

    private String getType() {
        return bookType.getSelectedItem().toString();
    }

    private void clearFild() {
        bookId.setText("");
        name.setText("");
        bookCode.setText("");
        ((JTextField) bookDate.getDateEditor().getUiComponent()).setText("");
        category.setSelectedIndex(0);
        bookType.setSelectedIndex(0);
        publisher.setText("");
        price.setText("");
    }

    private void autoId() {
        try {
            String sql = "SELECT `book_id` FROM `books`  ORDER BY book_id DESC LIMIT 1";

            pst = (PreparedStatement) conn.prepareStatement(sql);//BI1001 bazada
            rs = pst.executeQuery();//BI1001
            if (rs.next()) {
                String rnno = rs.getString("book_id");//BI1001
                int co = rnno.length();//5
                String txt = rnno.substring(0, 2);//BI
                String num = rnno.substring(2, co);//1001
                int n = Integer.parseInt(num);//int 1001
                n++;//1002
                String snum = Integer.toString(n);//string 1002
                String ftxt = txt + snum;//BI1002
                bookId.setText(ftxt);
            } else {
                bookId.setText("BI1000");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void tablelord() {
        try {
            String sql = "SELECT `book_id`as 'book ID',"
                    + " `name`,"
                    + " `book_code` as 'book code',"
                    + " `date`,"
                    + " `category`,"
                    + " `book_type` as 'book type',"
                    + " `publisher`,"
                    + " `price`,"
                    + " `number` FROM `books`";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            booksTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bookId = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        bookCode = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        bookDate = new com.toedter.calendar.JDateChooser();
        category = new javax.swing.JComboBox<String>();
        bookType = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        publisher = new javax.swing.JTextArea();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setMinimumSize(new java.awt.Dimension(990, 560));
        setPreferredSize(new java.awt.Dimension(990, 560));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(970, 970));
        jPanel1.setPreferredSize(new java.awt.Dimension(102, 54));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(37, 47, 65));
        jLabel4.setText("Books");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 240, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 47, 65));
        jLabel6.setText("Book ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 47, 65));
        jLabel7.setText("Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 47, 65));
        jLabel8.setText("Book Code");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(37, 47, 65));
        jLabel9.setText("Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(37, 47, 65));
        jLabel10.setText("Category");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(37, 47, 65));
        jLabel11.setText("Book Type");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(37, 47, 65));
        jLabel12.setText("Price");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(37, 47, 65));
        jLabel13.setText("Publisher");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 120, -1));

        add.setBackground(new java.awt.Color(97, 212, 195));
        add.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        add.setForeground(new java.awt.Color(37, 47, 65));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 190, 40));

        update.setBackground(new java.awt.Color(97, 212, 195));
        update.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        update.setForeground(new java.awt.Color(37, 47, 65));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 190, 40));

        delete.setBackground(new java.awt.Color(97, 212, 195));
        delete.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(37, 47, 65));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 190, 40));

        clear.setBackground(new java.awt.Color(97, 212, 195));
        clear.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(37, 47, 65));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 190, 40));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(booksTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 950, 200));

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(37, 47, 65));
        jLabel15.setText("Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 100, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 210, 210));

        bookId.setEditable(false);
        bookId.setBackground(new java.awt.Color(97, 212, 195));
        bookId.setForeground(new java.awt.Color(37, 47, 65));
        bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, 30));

        name.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 160, 30));

        bookCode.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(bookCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 160, 30));
        jPanel1.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 160, 30));

        bookDate.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(bookDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 160, 30));

        category.setBackground(new java.awt.Color(97, 212, 195));
        category.setForeground(new java.awt.Color(37, 47, 65));
        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select category", "Language", "Technology", "History", "Other" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 30));

        bookType.setBackground(new java.awt.Color(97, 212, 195));
        bookType.setForeground(new java.awt.Color(37, 47, 65));
        bookType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Type", "Borrow", "Read only" }));
        jPanel1.add(bookType, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 160, 30));

        jScrollPane1.setAutoscrolls(true);

        publisher.setColumns(20);
        publisher.setForeground(new java.awt.Color(37, 47, 65));
        publisher.setRows(5);
        publisher.setAutoscrolls(false);
        jScrollPane1.setViewportView(publisher);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 160, 70));

        price.setForeground(new java.awt.Color(37, 47, 65));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 160, 30));

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 950, 230));

        jLabel2.setBackground(new java.awt.Color(37, 47, 65));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 970, 460));

        jLabel1.setBackground(new java.awt.Color(37, 47, 65));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed

    }//GEN-LAST:event_priceActionPerformed

    private void bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIdActionPerformed

    }//GEN-LAST:event_bookIdActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        try {
            String sql = "UPDATE `books` SET "
                    + "`name`='" + name.getText()
                    + "',`book_code`='" + bookCode.getText()
                    + "',`date`='" + getDate()
                    + "',`category`='" + getCategory()
                    + "',`book_type`='" + getType()
                    + "',`publisher`='" + publisher.getText()
                    + "',`price`='" + price.getText()
                    + "',`number`='" + number.getText()
                    + "' WHERE `book_id`='" + bookId.getText() + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Update succes");
            tablelord();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Update unsucces\n\n" + e);
        }
        clearFild();
        autoId();


    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String sql = "DELETE FROM `books` WHERE book_id='" + bookId.getText() + "'";

            pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Delete secces");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Delete unsecces\n\n" + e);
        }
        clearFild();
        autoId();
        tablelord();
    }//GEN-LAST:event_deleteActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
    }//GEN-LAST:event_categoryActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        try {
            String sql = "INSERT INTO `books`"
                    + "(`book_id`, `name`, `book_code`, `date`, `category`, `book_type`, `publisher`, `price`, `number`,count) "
                    + "VALUES ('" + bookId.getText()
                          + "','" + name.getText()
                          + "','" + bookCode.getText()
                          + "','" + getDate()
                          + "','" + getCategory()
                          + "','" + getType()
                          + "','" + publisher.getText()
                          + "','" + price.getText()
                          + "','" + number.getText()
                          + "','" + number.getText()+"')";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Successuly insert");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Unsuccessuly insert\n\n" + e);
        }
        clearFild();
        autoId();
        tablelord();
    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       clearFild();
       autoId();
    }//GEN-LAST:event_clearActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked

    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked

        DefaultTableModel tmodel = (DefaultTableModel) booksTable.getModel();
        int rowIndex = booksTable.getSelectedRow();
                                         //row    column
        bookId.setText(tmodel.getValueAt(rowIndex, 0).toString());
        name.setText(tmodel.getValueAt(rowIndex, 1).toString());
        bookCode.setText(tmodel.getValueAt(rowIndex, 2).toString());
        ((JTextField) bookDate.getDateEditor().getUiComponent()).setText(tmodel.getValueAt(rowIndex, 3).toString());
        category.setSelectedItem(tmodel.getValueAt(rowIndex, 4).toString());
        bookType.setSelectedItem(tmodel.getValueAt(rowIndex, 5));
        publisher.setText(tmodel.getValueAt(rowIndex, 6).toString());
        price.setText(tmodel.getValueAt(rowIndex, 7).toString());
        
    }//GEN-LAST:event_booksTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField bookCode;
    private com.toedter.calendar.JDateChooser bookDate;
    private javax.swing.JTextField bookId;
    private javax.swing.JComboBox<String> bookType;
    private javax.swing.JTable booksTable;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField number;
    private javax.swing.JTextField price;
    private javax.swing.JTextArea publisher;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
