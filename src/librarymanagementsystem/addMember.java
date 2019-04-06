package librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class addMember extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public addMember() {

        initComponents();
        conn = DBConnect.connect();
        autoId();
        tablelord();
    }
    
    private String date(){
        return ((JTextField) birthday.getDateEditor().getUiComponent()).getText();
    }
    private String gender() {
        return gender.getSelectedItem().toString();
    }
    
    private String memberType(){
        return memberType.getSelectedItem().toString();
    }    
    
    private boolean controlEmail(){
        if(email.getText().indexOf("@")!=-1) {
           return true;
        
        }else{
            JOptionPane.showMessageDialog(rootPane, "invalid email address\n"
                                                  + "Please re-enter your email address");
            return false;
        }
    }
    private void clearFild() {
        memberID.setText("");
        name.setText("");
        surName.setText("");
        ((JTextField) birthday.getDateEditor().getUiComponent()).setText("");
        gender.setSelectedIndex(0);
        adress.setText("");
        email.setText("");
        contacNo.setText("");
        memberType.setSelectedIndex(0);
    }

    private void autoId() {
        try {
            
            String sql = "SELECT `mid` FROM `addmember`  ORDER BY mid DESC LIMIT 1";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("mid");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                memberID.setText(ftxt);
            } else {
                memberID.setText("MI1000");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void tablelord() {
        try {
            String sql = "SELECT `mid`, "
                    + "`name`, "
                    + "`surname`, "
                    + "`birthday`, "
                    + "`gender`, "
                    + "`address`, "
                    + "`email`, "
                    + "`contac`, "
                    + "`type` "
                    + "FROM `addmember`";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            membersTable.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        memberID = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        surName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        adress = new javax.swing.JTextArea();
        email = new javax.swing.JTextField();
        contacNo = new javax.swing.JTextField();
        birthday = new com.toedter.calendar.JDateChooser();
        gender = new javax.swing.JComboBox<>();
        memberType = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        membersTable = new javax.swing.JTable();
        clear = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
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

        jLabel15.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(37, 47, 65));
        jLabel15.setText("Members");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, 310, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 60));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(37, 47, 65));
        jLabel5.setText("Member ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 47, 65));
        jLabel6.setText("Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 50, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 47, 65));
        jLabel7.setText("Surname");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 47, 65));
        jLabel8.setText("Birthday");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(37, 47, 65));
        jLabel9.setText("Gender");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(37, 47, 65));
        jLabel10.setText("Adress");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(37, 47, 65));
        jLabel11.setText("Email");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(37, 47, 65));
        jLabel12.setText("Contac No");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(37, 47, 65));
        jLabel13.setText("Member type");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        memberID.setEditable(false);
        memberID.setBackground(new java.awt.Color(97, 212, 195));
        memberID.setForeground(new java.awt.Color(37, 47, 65));
        memberID.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(memberID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 190, -1));

        name.setForeground(new java.awt.Color(37, 47, 65));
        name.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));

        surName.setForeground(new java.awt.Color(37, 47, 65));
        surName.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(surName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, -1));

        adress.setColumns(20);
        adress.setForeground(new java.awt.Color(37, 47, 65));
        adress.setRows(5);
        jScrollPane1.setViewportView(adress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 190, 70));

        email.setForeground(new java.awt.Color(37, 47, 65));
        email.setPreferredSize(new java.awt.Dimension(30, 30));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 190, -1));

        contacNo.setForeground(new java.awt.Color(37, 47, 65));
        contacNo.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(contacNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 190, -1));

        birthday.setBackground(new java.awt.Color(97, 212, 195));
        birthday.setForeground(new java.awt.Color(37, 47, 65));
        birthday.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 190, -1));

        gender.setBackground(new java.awt.Color(97, 212, 195));
        gender.setForeground(new java.awt.Color(37, 47, 65));
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        gender.setToolTipText("");
        gender.setPreferredSize(new java.awt.Dimension(30, 30));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 190, -1));

        memberType.setBackground(new java.awt.Color(97, 212, 195));
        memberType.setForeground(new java.awt.Color(37, 47, 65));
        memberType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Student", "Other" }));
        memberType.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(memberType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 190, -1));

        membersTable.setForeground(new java.awt.Color(37, 47, 65));
        membersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        membersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(membersTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 320, 950, 200));

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
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 170, 40));

        btnadd.setBackground(new java.awt.Color(97, 212, 195));
        btnadd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnadd.setForeground(new java.awt.Color(37, 47, 65));
        btnadd.setText("Add");
        btnadd.setToolTipText("");
        btnadd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 170, 40));

        btnupdate.setBackground(new java.awt.Color(97, 212, 195));
        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(37, 47, 65));
        btnupdate.setText("Update");
        btnupdate.setToolTipText("");
        btnupdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 170, 40));

        btndelete.setBackground(new java.awt.Color(97, 212, 195));
        btndelete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btndelete.setForeground(new java.awt.Color(37, 47, 65));
        btndelete.setText("Delete");
        btndelete.setToolTipText("");
        btndelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 170, 40));

        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65)));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 190, 210));

        jLabel4.setBackground(new java.awt.Color(97, 212, 195));
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 47, 65), 2));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 950, 230));

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

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

        try {
            String sql = "INSERT INTO `addmember`"
                    + "(`mid`, `name`, `surname`, `birthday`, `gender`, `address`, `email`, `contac`, `type`)"
                    + " VALUES ('" + memberID.getText()
                           + "','" + name.getText() 
                           + "','" + surName.getText() 
                           + "','" + date()
                           + "','" + gender()
                           + "','" + adress.getText()
                           + "','" + email.getText()
                           + "','" + contacNo.getText()
                           + "','" + memberType() + "')";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            if(controlEmail()){
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Successuly insert");
            clearFild();
            autoId();
            tablelord();
            }else{
                email.setText("");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Unsuccessuly insert\n\n" + e);
        }
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void membersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membersTableMouseClicked

        DefaultTableModel tmodel = (DefaultTableModel) membersTable.getModel();
        int rowIndex = membersTable.getSelectedRow();

        memberID.setText(tmodel.getValueAt(rowIndex, 0).toString());
        name.setText(tmodel.getValueAt(rowIndex, 1).toString());
        surName.setText(tmodel.getValueAt(rowIndex, 2).toString());
        ((JTextField) birthday.getDateEditor().getUiComponent()).setText(tmodel.getValueAt(rowIndex, 3).toString());
        gender.setSelectedItem(tmodel.getValueAt(rowIndex, 4).toString());
        adress.setText(tmodel.getValueAt(rowIndex, 5).toString());
        email.setText(tmodel.getValueAt(rowIndex, 6).toString());
        contacNo.setText(tmodel.getValueAt(rowIndex, 7).toString());
        memberType.setSelectedItem(tmodel.getValueAt(rowIndex, 8).toString());

    }//GEN-LAST:event_membersTableMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        try {
            String sql = "UPDATE `addmember` SET "
                    + "`name`='" + name.getText()
                    + "',`surname`='" + surName.getText()
                    + "',`birthday`='" + date()
                    + "',`gender`='" + gender()
                    + "',`address`='" + adress.getText()
                    + "',`email`='" + email.getText()
                    + "',`contac`='" + contacNo.getText()
                    + "',`type`='" + memberType()
                    + "' WHERE `mid`='" + memberID.getText() + "'";
            pst = conn.prepareStatement(sql);
            if(controlEmail()){
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Update succes");
            clearFild();
            autoId();
            tablelord();
            }else{
                email.setText("");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "Update unsucces\n\n" + e);
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        try {

            String sql = "DELETE FROM `addmember` WHERE mid='" + memberID.getText() + "'";

            pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Delete succes");
            tablelord();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Delete unsucces\n\n" + e);
        }
        clearFild();
        autoId();


    }//GEN-LAST:event_btndeleteActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearFild();
        autoId();
    }//GEN-LAST:event_clearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea adress;
    private com.toedter.calendar.JDateChooser birthday;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton clear;
    private javax.swing.JTextField contacNo;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
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
    private javax.swing.JTextField memberID;
    private javax.swing.JComboBox<String> memberType;
    private javax.swing.JTable membersTable;
    private javax.swing.JTextField name;
    private javax.swing.JTextField surName;
    // End of variables declaration//GEN-END:variables
}
