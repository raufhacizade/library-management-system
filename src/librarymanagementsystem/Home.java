package librarymanagementsystem;

import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    Connection conn = null;

    public Home() {

        initComponents();
        clock();
        conn = DBConnect.connect();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bookLend = new javax.swing.JButton();
        bookReturn = new javax.swing.JButton();
        addMembers = new javax.swing.JButton();
        addBooks = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        allBooks = new javax.swing.JButton();
        allMembers = new javax.swing.JButton();
        lendHistory = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        pendingList = new javax.swing.JButton();
        homeDesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(37, 47, 65));

        jPanel1.setBackground(new java.awt.Color(37, 47, 65));
        jPanel1.setMinimumSize(new java.awt.Dimension(1220, 690));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Magneto", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("World Library");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 46, -1, 40));

        lblTime.setBackground(new java.awt.Color(255, 255, 255));
        lblTime.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTime.setForeground(new java.awt.Color(97, 212, 195));
        lblTime.setText("Time");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 190, 20));

        lblDate.setBackground(new java.awt.Color(255, 255, 255));
        lblDate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDate.setForeground(new java.awt.Color(97, 212, 195));
        lblDate.setText("Date");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 220, -1));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1200, 50));

        bookLend.setBackground(new java.awt.Color(97, 212, 195));
        bookLend.setFont(new java.awt.Font("Sitka Text", 3, 23)); // NOI18N
        bookLend.setForeground(new java.awt.Color(37, 47, 65));
        bookLend.setText("Book Lend");
        bookLend.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bookLend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookLendActionPerformed(evt);
            }
        });
        jPanel1.add(bookLend, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 50));

        bookReturn.setBackground(new java.awt.Color(97, 212, 195));
        bookReturn.setFont(new java.awt.Font("Sitka Text", 3, 23)); // NOI18N
        bookReturn.setForeground(new java.awt.Color(37, 47, 65));
        bookReturn.setText("Book Return");
        bookReturn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bookReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookReturnActionPerformed(evt);
            }
        });
        jPanel1.add(bookReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 190, 50));

        addMembers.setBackground(new java.awt.Color(97, 212, 195));
        addMembers.setFont(new java.awt.Font("Sitka Text", 3, 23)); // NOI18N
        addMembers.setForeground(new java.awt.Color(37, 47, 65));
        addMembers.setText("Add Members");
        addMembers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMembersActionPerformed(evt);
            }
        });
        jPanel1.add(addMembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 190, 50));

        addBooks.setBackground(new java.awt.Color(97, 212, 195));
        addBooks.setFont(new java.awt.Font("Sitka Text", 3, 23)); // NOI18N
        addBooks.setForeground(new java.awt.Color(37, 47, 65));
        addBooks.setText("Add Books");
        addBooks.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksActionPerformed(evt);
            }
        });
        jPanel1.add(addBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 190, 50));

        jLabel3.setBackground(new java.awt.Color(97, 212, 195));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 560));

        allBooks.setBackground(new java.awt.Color(97, 212, 195));
        allBooks.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        allBooks.setForeground(new java.awt.Color(37, 47, 65));
        allBooks.setText("All Books");
        allBooks.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        allBooks.setFocusable(false);
        allBooks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        allBooks.setMargin(new java.awt.Insets(2, 50, 2, 50));
        allBooks.setMaximumSize(new java.awt.Dimension(140, 25));
        allBooks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        allBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBooksActionPerformed(evt);
            }
        });
        jPanel1.add(allBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 40));

        allMembers.setBackground(new java.awt.Color(97, 212, 195));
        allMembers.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        allMembers.setForeground(new java.awt.Color(37, 47, 65));
        allMembers.setText("All Members");
        allMembers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        allMembers.setFocusable(false);
        allMembers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        allMembers.setMargin(new java.awt.Insets(2, 50, 2, 50));
        allMembers.setMaximumSize(new java.awt.Dimension(140, 25));
        allMembers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        allMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMembersActionPerformed(evt);
            }
        });
        jPanel1.add(allMembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 260, 40));

        lendHistory.setBackground(new java.awt.Color(97, 212, 195));
        lendHistory.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        lendHistory.setForeground(new java.awt.Color(37, 47, 65));
        lendHistory.setText("Lend History");
        lendHistory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lendHistory.setFocusable(false);
        lendHistory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lendHistory.setMargin(new java.awt.Insets(2, 50, 2, 50));
        lendHistory.setMaximumSize(new java.awt.Dimension(140, 25));
        lendHistory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lendHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lendHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(lendHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 250, 40));

        logout.setBackground(new java.awt.Color(97, 212, 195));
        logout.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        logout.setForeground(new java.awt.Color(37, 47, 65));
        logout.setText("Log out");
        logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.setFocusable(false);
        logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout.setMargin(new java.awt.Insets(2, 50, 2, 50));
        logout.setMaximumSize(new java.awt.Dimension(140, 25));
        logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 210, 40));

        pendingList.setBackground(new java.awt.Color(97, 212, 195));
        pendingList.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        pendingList.setForeground(new java.awt.Color(37, 47, 65));
        pendingList.setText("Pending List");
        pendingList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pendingList.setFocusable(false);
        pendingList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pendingList.setMargin(new java.awt.Insets(2, 50, 2, 50));
        pendingList.setMaximumSize(new java.awt.Dimension(140, 25));
        pendingList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pendingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingListActionPerformed(evt);
            }
        });
        jPanel1.add(pendingList, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 250, 40));

        homeDesktop.setBackground(new java.awt.Color(37, 47, 65));

        javax.swing.GroupLayout homeDesktopLayout = new javax.swing.GroupLayout(homeDesktop);
        homeDesktop.setLayout(homeDesktopLayout);
        homeDesktopLayout.setHorizontalGroup(
            homeDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        homeDesktopLayout.setVerticalGroup(
            homeDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel1.add(homeDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 990, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void clock() {
        Thread clock = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH)+1;
                        int year = cal.get(Calendar.YEAR);

                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);

                        lblTime.setText(hour + ":" + minute + ":" + second);
                        lblDate.setText(year + "-" + month + "-" + day);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
            }
        };
        clock.start();
    }

    private void bookReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookReturnActionPerformed
        homeDesktop.removeAll();
        Return rn = new Return();
        homeDesktop.add(rn).setVisible(true);
    }//GEN-LAST:event_bookReturnActionPerformed

    private void addMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMembersActionPerformed
        homeDesktop.removeAll();
        addMember am = new addMember();
        homeDesktop.add(am).setVisible(true);
    }//GEN-LAST:event_addMembersActionPerformed

    private void bookLendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookLendActionPerformed
        homeDesktop.removeAll();
        BookLend br = new BookLend();
        homeDesktop.add(br).setVisible(true);
    }//GEN-LAST:event_bookLendActionPerformed

    private void addBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksActionPerformed
        homeDesktop.removeAll();
        addBooks ab = new addBooks();
        homeDesktop.add(ab).setVisible(true);
    }//GEN-LAST:event_addBooksActionPerformed

    private void allBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBooksActionPerformed
        homeDesktop.removeAll();
        Allbooks allB = new Allbooks();
        homeDesktop.add(allB).setVisible(true);
    }//GEN-LAST:event_allBooksActionPerformed

    private void allMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMembersActionPerformed
        homeDesktop.removeAll();
        Allmember allM = new Allmember();
        homeDesktop.add(allM).setVisible(true);
    }//GEN-LAST:event_allMembersActionPerformed

    private void lendHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lendHistoryActionPerformed
        homeDesktop.removeAll();
        LendHistory lh=new LendHistory();
        homeDesktop.add(lh).setVisible(true);
    }//GEN-LAST:event_lendHistoryActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        Login log=new Login();
        log.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void pendingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingListActionPerformed
        homeDesktop.removeAll();
        PendingList pl=new PendingList();
        homeDesktop.add(pl).setVisible(true);
    }//GEN-LAST:event_pendingListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBooks;
    private javax.swing.JButton addMembers;
    private javax.swing.JButton allBooks;
    private javax.swing.JButton allMembers;
    private javax.swing.JButton bookLend;
    private javax.swing.JButton bookReturn;
    private javax.swing.JDesktopPane homeDesktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JButton lendHistory;
    private javax.swing.JButton logout;
    private javax.swing.JButton pendingList;
    // End of variables declaration//GEN-END:variables
}
