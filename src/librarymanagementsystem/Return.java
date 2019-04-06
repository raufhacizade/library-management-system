package librarymanagementsystem;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Return extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Return() {
        initComponents();
        conn = DBConnect.connect();
    }
    
    private void update(){
        try{
            String sql="UPDATE `addbook` SET `mark`='0' WHERE bid='"+bookId.getText()+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Mark update success");
            //tablelord();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Mark update unsuccess\n\n"+e);
        }
    }
    
     private void returnMark(){
        try{
            String sql="UPDATE `booklend` SET `mark`='1' WHERE bid='"+bookId.getText()+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Mark update success");
            //tablelord();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Mark update unsuccess\n\n"+e);
        }
    }
    
    private void bill(){
        bill.setText("======================\n"
                       +"Library Name \n"
                       +"NO of Date\t"+lateDate.getText()+"\n"
                       +"Amount\t"+fine.getText()+"\n"
                       +"======================");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookId = new javax.swing.JTextField();
        memberId = new javax.swing.JTextField();
        lateDate = new javax.swing.JTextField();
        fine = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setMinimumSize(new java.awt.Dimension(990, 560));
        setPreferredSize(new java.awt.Dimension(990, 560));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(37, 47, 65));
        jLabel5.setText("Book ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 47, 65));
        jLabel6.setText("Member ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 47, 65));
        jLabel7.setText("Fine");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 47, 65));
        jLabel8.setText("Late Date");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        bookId.setForeground(new java.awt.Color(37, 47, 65));
        bookId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookIdKeyReleased(evt);
            }
        });
        jPanel1.add(bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 160, 30));

        memberId.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(memberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 160, 30));

        lateDate.setForeground(new java.awt.Color(37, 47, 65));
        jPanel1.add(lateDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 160, 30));

        fine.setForeground(new java.awt.Color(37, 47, 65));
        fine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fineActionPerformed(evt);
            }
        });
        jPanel1.add(fine, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 160, 30));

        bill.setColumns(20);
        bill.setForeground(new java.awt.Color(37, 47, 65));
        bill.setRows(5);
        jScrollPane1.setViewportView(bill);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 230, 280));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 380, 300));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 250, 300));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 47, 65));
        jLabel2.setText("    Book Return");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 950, 70));

        btnReturn.setBackground(new java.awt.Color(97, 212, 195));
        btnReturn.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(37, 47, 65));
        btnReturn.setText("Return");
        btnReturn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 380, 80));

        print.setBackground(new java.awt.Color(97, 212, 195));
        print.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        print.setForeground(new java.awt.Color(37, 47, 65));
        print.setText("Print");
        print.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 250, 80));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookIdKeyReleased
        try {
            String sql = "SELECT `mid`,`rDate` FROM `booklend` WHERE bid='" + bookId.getText() + "' and mark='0'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                memberId.setText(rs.getString("mid"));
                String rDate = rs.getString("rDate");
                LocalDate today = LocalDate.now();
                LocalDate rday = LocalDate.parse(rDate);

                Long dayGap = ChronoUnit.DAYS.between(rday, today);

                if (dayGap > 0) {
                    
                    lateDate.setText(dayGap.toString());
                    long finePrice = 2 * dayGap;
                    fine.setText(String.valueOf(finePrice)+" $");
                    
                } else {
                    lateDate.setText("0");
                    fine.setText("0");
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_bookIdKeyReleased

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
         try {
            String sql = "INSERT INTO `bookreturn`"
                    + "(`bid`, `mid`, `lateDate`, `fine`)"
                    + " VALUES ('" + bookId.getText()
                           + "','" + memberId.getText()
                           + "','" + lateDate.getText()
                           + "','" + fine.getText()+ "')";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.execute();
            update();
            bill();
            returnMark();
            JOptionPane.showMessageDialog(rootPane, "Successfully Insert");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Unsuccessfully Insert\n\n"+e);
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            bill.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Print command unseccess\n\n"+ e);
        }
    }//GEN-LAST:event_printActionPerformed

    private void fineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill;
    private javax.swing.JTextField bookId;
    private javax.swing.JButton btnReturn;
    private javax.swing.JTextField fine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lateDate;
    private javax.swing.JTextField memberId;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
