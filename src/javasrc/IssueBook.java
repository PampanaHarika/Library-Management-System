package javasrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Harika
 */
public class IssueBook extends javax.swing.JFrame {

 
    public IssueBook() {
        initComponents();
    }
    
    //To fetch  the book details from the book_details table in database
    
    public void getBookDetails(){
        int bookId= Integer.parseInt(txt_bookId.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select  * from book_details where bookid = ?");
            pst.setInt(1, bookId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                lblBookid.setText(rs.getString("bookid"));
                lblBookname.setText(rs.getString("bookname"));
                lblAuthor.setText(rs.getString("authorname"));
                lblQuantity.setText(rs.getString("quantity"));   
            }else{
                clearDetails();
                lblBookerror.setText("Invalid Book Id!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void getStudentDetails(){
        int studentId= Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select  * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                lblStudentid.setText(rs.getString("student_id"));
                lblStudentname.setText(rs.getString("name"));
                lblCourse.setText(rs.getString("course"));
                lblBranch.setText(rs.getString("branch"));   
            }else{
                clearDetails();
                lblStudenterror.setText("Invalid Student Id!!!");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //Insert issue book details to database
    
    public boolean issueBook(){
        boolean isIssued=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        String studentName=lblStudentname.getText();
        String bookName=lblBookname.getText();
        String IssueDate=issueDate.getText();
        String DueDate=dueDate.getText();
            
        try{
        Connection con=DBConnection.getConnection();
        String sql= "insert into issue_book_details(book_id,book_name,student_id,"
                + "student_name,issue_date,due_date,status) value(?,?,?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, bookId);
        pst.setString(2, bookName);
        pst.setInt(3, studentId);
        pst.setString(4, studentName);
        pst.setString(5, IssueDate);
        pst.setString(6, DueDate);
        pst.setString(7, "pending");
        
        int rowCount = pst.executeUpdate();
        if( rowCount > 0){
            isIssued=true;
        }else{
            isIssued=false;
        }
    }catch(Exception e){
        e.printStackTrace();
    }
      return isIssued;  
    }
    
    //updating Quantity in book details database
    
    public void updateBookCount(){
        
       int bookId=Integer.parseInt(txt_bookId.getText());
       
       try{
        Connection con=DBConnection.getConnection();
        String sql="update book_details set Quantity=Quantity - 1 where bookid = ? ";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, bookId);
        int rowCount = pst.executeUpdate();
        
        if( rowCount > 0){
            JOptionPane.showMessageDialog(this,"book count Updated");
            int initialCount=Integer.parseInt(lblQuantity.getText());
            lblQuantity.setText(Integer.toString(initialCount - 1));
        }else{
            JOptionPane.showMessageDialog(this,"can't issue the Book");
        }
        
       }catch(Exception e){
        e.printStackTrace();
    }
    }

    //Checking weather book already allocate to the same student or not
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql="select * from issue_book_details where book_id = ? and student_id= ? and status = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                isAlreadyIssued=true;
            }else{
                isAlreadyIssued=false;
            }
        }catch(Exception e){
        e.printStackTrace();
    }
       return isAlreadyIssued; 
    }
    
    public void clearDetails(){
                lblBookid.setText("");
                lblBookname.setText("");
                lblAuthor.setText("");
                lblQuantity.setText("");
                lblStudentid.setText("");
                lblStudentname.setText("");
                lblCourse.setText("");
                lblBranch.setText(""); 
                txt_bookId.setText("");
                txt_studentId.setText("");
                issueDate.setText("");
                dueDate.setText("");
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblStudentid = new javax.swing.JLabel();
        lblStudentname = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lblStudenterror = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Back1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblBookid = new javax.swing.JLabel();
        lblBookname = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblBookerror = new javax.swing.JLabel();
        Closepanel = new javax.swing.JPanel();
        Closelabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblBookid1 = new javax.swing.JLabel();
        lblStudentid1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dueDate = new javax.swing.JTextField();
        txt_bookId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_studentId = new javax.swing.JTextField();
        issueDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel1.setText("   STUDENT DETAILS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 370, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 380, 5));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Branch:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 120, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student Id:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Name:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 120, 30));

        lblBranch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBranch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 210, 30));

        lblStudentid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStudentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblStudentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 210, 30));

        lblStudentname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStudentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblStudentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 210, 30));

        lblCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCourse.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 210, 30));

        lblStudenterror.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblStudenterror.setForeground(new java.awt.Color(255, 255, 102));
        jPanel1.add(lblStudenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 230, 40));

        jPanelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 450, 670));

        jPanel4.setBackground(new java.awt.Color(153, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel6.setText("   BOOK DETAILS");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 320, -1));

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

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 380, 5));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Book Name:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 120, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Author:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 120, 30));

        lblQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 210, 30));

        lblBookid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblBookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 30));

        lblBookname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblBookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 210, 30));

        lblAuthor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 210, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Book Id:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Quantity:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 120, 30));

        lblBookerror.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBookerror.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lblBookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 240, 30));

        jPanelMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 670));

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

        jPanelMain.add(Closepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 40));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("  Issue Book");
        jPanelMain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 200, 80));

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

        jPanelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, 360, 5));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Id:");
        jPanelMain.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Id:");
        jPanelMain.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 30));

        lblBookid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMain.add(lblBookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 30));

        lblStudentid1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMain.add(lblStudentid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book Id:");
        jPanelMain.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Due Date :");
        jPanelMain.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 110, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Book Id:");
        jPanelMain.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, 90, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("Student Id:");
        jPanelMain.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 110, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Issue Date:");
        jPanelMain.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, 110, 40));
        jPanelMain.add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 490, 290, 30));

        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        jPanelMain.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, 290, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Issue Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelMain.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 580, 150, 40));

        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanelMain.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 350, 290, 30));
        jPanelMain.add(issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 420, 290, 30));

        getContentPane().add(jPanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 670));

        setSize(new java.awt.Dimension(1360, 675));
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
       if(!txt_bookId.getText().equals("")){
        getBookDetails();
       }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
        getStudentDetails();
       }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(lblQuantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book is Not available");
            clearDetails();
        }else{
        if(isAlreadyIssued() == false){ 
            if(issueBook() == true){
            JOptionPane.showMessageDialog(this, "Book Issued!!");
            updateBookCount();
            clearDetails();
            }else{
           JOptionPane.showMessageDialog(this, "Error occured while Book Issuing!!"); 
           clearDetails();
            }
        }else{
            JOptionPane.showMessageDialog(this,"Book is Already issued to this Student!!");
            clearDetails();
        }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back1;
    private javax.swing.JLabel Closelabel;
    private javax.swing.JPanel Closepanel;
    private javax.swing.JTextField dueDate;
    private javax.swing.JTextField issueDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookerror;
    private javax.swing.JLabel lblBookid;
    private javax.swing.JLabel lblBookid1;
    private javax.swing.JLabel lblBookname;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblStudenterror;
    private javax.swing.JLabel lblStudentid;
    private javax.swing.JLabel lblStudentid1;
    private javax.swing.JLabel lblStudentname;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
