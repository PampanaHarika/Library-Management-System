package javasrc;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Harika
 */

public class HomePage extends javax.swing.JFrame {

    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    public HomePage() {
        initComponents();
        setDataToCards();
    }
 
    //setting card values from Database
    
    public void setDataToCards(){
        Statement st=null;
        ResultSet rs=null;
        
        long l = System.currentTimeMillis();
        Date todaysDate=new Date(1);
        
        try{
           Connection con=DBConnection.getConnection();
           st=con.createStatement();
           rs=st.executeQuery("select * from book_details");
           rs.last();
           lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
           
           rs=st.executeQuery("select * from student_details");
           rs.last();
           lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
           
           rs=st.executeQuery("select * from issue_book_details");
           rs.last();
           lbl_issuedBooks.setText(Integer.toString(rs.getRow()));
           
           rs=st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status='"+"pending"+"'");
           rs.last();
           lbl_defaulterList.setText(Integer.toString(rs.getRow()));
 
        }catch(Exception e){
        e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        manageStudents = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        manageBooks = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        issueBook = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        ReturnBook = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        viewRecords = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        viewIssuedBooks = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_issuedBooks = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 56, 80));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(5, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 5, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 31, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome,User");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 200, 50));

        jPanel16.setBackground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 80));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jLabel5.setText("   LMS Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 64, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("    Home Page");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 18, 205, 35));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Features");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 114, 164, 23));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageStudents.setBackground(new java.awt.Color(51, 51, 51));
        manageStudents.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageStudents.setForeground(new java.awt.Color(153, 153, 153));
        manageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        manageStudents.setText("     Manage Students");
        manageStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageStudentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageStudentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageStudentsMouseExited(evt);
            }
        });
        jPanel10.add(manageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 227, 34));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, 40));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageBooks.setBackground(new java.awt.Color(204, 204, 204));
        manageBooks.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageBooks.setForeground(new java.awt.Color(153, 153, 153));
        manageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        manageBooks.setText("     Manage Books");
        manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageBooksMouseExited(evt);
            }
        });
        jPanel9.add(manageBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 199, 34));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, 50));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueBook.setBackground(new java.awt.Color(51, 51, 51));
        issueBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueBook.setForeground(new java.awt.Color(153, 153, 153));
        issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        issueBook.setText("     Issue Book");
        issueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueBookMouseExited(evt);
            }
        });
        jPanel11.add(issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 201, 34));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 270, 40));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ReturnBook.setBackground(new java.awt.Color(51, 51, 51));
        ReturnBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ReturnBook.setForeground(new java.awt.Color(153, 153, 153));
        ReturnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        ReturnBook.setText("     Return Book");
        ReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReturnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReturnBookMouseExited(evt);
            }
        });
        jPanel12.add(ReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 201, 34));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 270, 40));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewRecords.setBackground(new java.awt.Color(51, 51, 51));
        viewRecords.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewRecords.setForeground(new java.awt.Color(153, 153, 153));
        viewRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        viewRecords.setText("     Defaulter List");
        viewRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewRecordsMouseExited(evt);
            }
        });
        jPanel13.add(viewRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 40));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 270, 40));

        jPanel15.setBackground(new java.awt.Color(255, 0, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(102, 102, 255));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        Logout.setText("      Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        jPanel15.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 40));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 270, 40));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIssuedBooks.setBackground(new java.awt.Color(51, 51, 51));
        viewIssuedBooks.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewIssuedBooks.setForeground(new java.awt.Color(153, 153, 153));
        viewIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        viewIssuedBooks.setText("     View Issued Books");
        viewIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewIssuedBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewIssuedBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewIssuedBooksMouseExited(evt);
            }
        });
        jPanel14.add(viewIssuedBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 34));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 270, 580));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setBackground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(51, 51, 51));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 110));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel15.setText("No.Of Books");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel18.setText("No.Of Students");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 190, 30));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 153, 153)));

        lbl_noOfStudents.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_noOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_noOfStudents)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 160, 110));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_issuedBooks.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        lbl_issuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lbl_issuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_issuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 160, 110));

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel20.setText("Issued Books");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 140, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel22.setText("Defaulter List");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 140, 30));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 153, 153)));

        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_defaulterList, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_defaulterList)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/Webp.net-resizeimage (1).jpg"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 780, 400));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 920, 580));

        setSize(new java.awt.Dimension(1188, 657));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void manageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseClicked
        ManageBooks mb=new ManageBooks();
        mb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageBooksMouseClicked

    private void manageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseEntered
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_manageBooksMouseEntered

    private void manageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBooksMouseExited
       jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_manageBooksMouseExited

    private void manageStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudentsMouseEntered
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_manageStudentsMouseEntered

    private void manageStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudentsMouseExited
        jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_manageStudentsMouseExited

    private void issueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBookMouseEntered
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_issueBookMouseEntered

    private void issueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBookMouseExited
       jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_issueBookMouseExited

    private void ReturnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseEntered
       jPanel12.setBackground(mouseEnterColor); 
    }//GEN-LAST:event_ReturnBookMouseEntered

    private void ReturnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseExited
        jPanel12.setBackground(mouseExitColor);
    }//GEN-LAST:event_ReturnBookMouseExited

    private void viewIssuedBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewIssuedBooksMouseEntered
        jPanel14.setBackground(mouseEnterColor);
    }//GEN-LAST:event_viewIssuedBooksMouseEntered

    private void viewIssuedBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewIssuedBooksMouseExited
        jPanel14.setBackground(mouseExitColor);
    }//GEN-LAST:event_viewIssuedBooksMouseExited

    private void issueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBookMouseClicked
       IssueBook book=new IssueBook();
       book.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_issueBookMouseClicked

    private void manageStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudentsMouseClicked
       ManageStudent student=new ManageStudent();
       student.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_manageStudentsMouseClicked

    private void ReturnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnBookMouseClicked
        ReturnBook returnBook=new ReturnBook();
        returnBook.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnBookMouseClicked

    private void viewIssuedBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewIssuedBooksMouseClicked
        IssueBookDetails bookDetails=new IssueBookDetails();
        bookDetails.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewIssuedBooksMouseClicked

    private void viewRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRecordsMouseExited
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_viewRecordsMouseExited

    private void viewRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRecordsMouseEntered
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_viewRecordsMouseEntered

    private void viewRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRecordsMouseClicked
       DefaulterList list=new DefaulterList();
       list.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_viewRecordsMouseClicked

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        LoginPage lp=new LoginPage();
        lp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel ReturnBook;
    private javax.swing.JLabel issueBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issuedBooks;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JLabel manageBooks;
    private javax.swing.JLabel manageStudents;
    private javax.swing.JLabel viewIssuedBooks;
    private javax.swing.JLabel viewRecords;
    // End of variables declaration//GEN-END:variables
}
