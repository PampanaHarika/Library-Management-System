package javasrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Harika
 */
public class ReturnBook extends javax.swing.JFrame {

 
    public ReturnBook() {
        initComponents();
    }
    
    //To fetch  the issued book details from the  database
    
    public void getIssueBookDetails(){
        
        int bookId= Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2,studentId);
            pst.setString(3, "pending");
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                
                lblBookid.setText(rs.getString("book_id"));
                lblBookname.setText(rs.getString("book_name"));
                lblStudentName.setText(rs.getString("student_name"));
                lblIssuedate.setText(rs.getString("issue_date"));
                lblDuedate.setText(rs.getString("due_date"));
                lblBookerror.setText("");
            }else{
                lblBookid.setText("");
                lblBookname.setText("");
                lblStudentName.setText("");
                lblIssuedate.setText("");
                lblDuedate.setText("");
                lblBookerror.setText("No Record Found!!");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    //Return the book
    
    public boolean returnBook(){
        boolean isReturned=false;
        int bookId= Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
         
        try{
            Connection con=DBConnection.getConnection();
            String sql="update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ?";
            
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, "Returned");
            pst.setInt(2,studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "pending");
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isReturned= true;
            }else{
               isReturned= false; 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       return isReturned; 
    }
 
  //update book count   
   public void updateBookCount(){
        
       int bookId=Integer.parseInt(txt_bookId.getText());
       
       try{
        Connection con=DBConnection.getConnection();
        String sql="update book_details set Quantity=Quantity + 1 where bookid = ? ";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, bookId);
        int rowCount = pst.executeUpdate();
        
        if( rowCount > 0 ){
            JOptionPane.showMessageDialog(this,"Book count Updated");
            lblBookid.setText("");
            lblBookname.setText("");
            lblStudentName.setText("");
            lblIssuedate.setText("");
            lblDuedate.setText("");
            txt_bookId.setText("");
            txt_studentId.setText("");
        }else{
            JOptionPane.showMessageDialog(this,"Book count can't updated!");
        }
        
       }catch(Exception e){
        e.printStackTrace();
    }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblDuedate = new javax.swing.JLabel();
        lblBookid = new javax.swing.JLabel();
        lblBookname = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblBookerror = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblIssuedate = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Back1 = new javax.swing.JLabel();
        Closepanel = new javax.swing.JPanel();
        Closelabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblBookid1 = new javax.swing.JLabel();
        lblStudentid1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        returnBookButton = new javax.swing.JButton();
        txt_studentId = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel6.setText("   BOOK DETAILS");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 320, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 380, 5));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Book Name:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 120, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Student Name:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, 30));

        lblDuedate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDuedate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblDuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 210, 30));

        lblBookid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblBookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 30));

        lblBookname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblBookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 210, 30));

        lblStudentName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStudentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 210, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Issue Id:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Due Date:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 120, 30));

        lblBookerror.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblBookerror.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lblBookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 250, 40));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Issue Date:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, 30));

        lblIssuedate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIssuedate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblIssuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 210, 30));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Back1.setForeground(new java.awt.Color(255, 255, 255));
        Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        Back1.setText("Back");
        Back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back1MouseClicked(evt);
            }
        });
        jPanel5.add(Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 28));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jPanelMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 700));

        Closepanel.setBackground(new java.awt.Color(255, 51, 51));
        Closepanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClosepanelMouseClicked(evt);
            }
        });
        Closepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Closelabel.setBackground(new java.awt.Color(255, 51, 51));
        Closelabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Closelabel.setForeground(new java.awt.Color(255, 255, 255));
        Closelabel.setText("X");
        Closelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloselabelMouseClicked(evt);
            }
        });
        Closepanel.add(Closelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jPanelMain.add(Closepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, 40));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("  Return Book");
        jPanelMain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 200, 80));

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 360, 5));

        lblBookid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMain.add(lblBookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 210, 30));

        lblStudentid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMain.add(lblStudentid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Book Id:");
        jPanelMain.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Student Id:");
        jPanelMain.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 110, 40));

        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        jPanelMain.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 250, 30));

        returnBookButton.setBackground(new java.awt.Color(255, 0, 51));
        returnBookButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        returnBookButton.setForeground(new java.awt.Color(255, 255, 255));
        returnBookButton.setText("Return Book");
        returnBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookButtonActionPerformed(evt);
            }
        });
        jPanelMain.add(returnBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, 150, 50));

        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanelMain.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 250, 30));

        findButton.setBackground(new java.awt.Color(255, 0, 51));
        findButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setText("FIND");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        jPanelMain.add(findButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 150, 50));

        getContentPane().add(jPanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        setSize(new java.awt.Dimension(1005, 703));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back1MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Back1MouseClicked

    private void CloselabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloselabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_CloselabelMouseClicked

    private void ClosepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClosepanelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ClosepanelMouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        
      
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void returnBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookButtonActionPerformed
       if (returnBook() == true){
           JOptionPane.showMessageDialog(this,"Book returned Successfully!!");
           updateBookCount();
       }else{
           JOptionPane.showMessageDialog(this,"Error occured while returning the Book !!");
       }
    }//GEN-LAST:event_returnBookButtonActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
       getIssueBookDetails();
    }//GEN-LAST:event_findButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back1;
    private javax.swing.JLabel Closelabel;
    private javax.swing.JPanel Closepanel;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JLabel lblBookerror;
    private javax.swing.JLabel lblBookid;
    private javax.swing.JLabel lblBookid1;
    private javax.swing.JLabel lblBookname;
    private javax.swing.JLabel lblDuedate;
    private javax.swing.JLabel lblIssuedate;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblStudentid1;
    private javax.swing.JButton returnBookButton;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
