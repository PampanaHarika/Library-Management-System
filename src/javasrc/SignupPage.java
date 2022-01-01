package javasrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Harika
 */

public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    
    public SignupPage() {
        initComponents();
    }
    
    
    //Sign method to insert values into database
public void insertSignUpDetails(){
    String uname=txt_uname.getText();
    String stuid=txt_sid.getText();
    String pwd=txt_password.getText();
    String mail=txt_email.getText();
    
    try{
        
        Connection con=DBConnection.getConnection();
        String sql="insert into users(name,rollno,Password,email) values(?,?,?,?)";
       PreparedStatement pst=con.prepareStatement(sql);
       
       pst.setString(1, uname);
       pst.setString(2, stuid);
       pst.setString(3, pwd);
       pst.setString(4, mail);
       
       int updatedRowCount=pst.executeUpdate();
       
       if(updatedRowCount>0){
           JOptionPane.showMessageDialog(this, "Created Account Successfully");
           txt_uname.setText("");
           txt_sid.setText("");
           txt_password.setText("");
           txt_email.setText("");
       }else{
           JOptionPane.showMessageDialog(this, "Error occured in Account Creation");
           txt_uname.setText("");
           txt_sid.setText("");
           txt_password.setText("");
           txt_email.setText("");
       }
          
    }catch(Exception e){
        e.printStackTrace();
    }
    
}
    
 //validation method

    public boolean validateSignup(){
        
    String uname=txt_uname.getText();
    String stuid=txt_sid.getText();
    String pwd=txt_password.getText();
    String mail=txt_email.getText();
    
    if(uname.equals("")){
        JOptionPane.showMessageDialog(this, "Please Enter UserName");
        return false;
    }
    if(stuid.equals("")){
        JOptionPane.showMessageDialog(this, "Please Enter StudentId");
        return false;
    }
    if(pwd.equals("")){
        JOptionPane.showMessageDialog(this, "Please Enter Password");
        return false;
    }
    if(mail.equals("") || !mail.matches("^.+@.+\\..+$")){
        JOptionPane.showMessageDialog(this, "Please Enter vaild Email address");
        return false;
    }
    return true;
    }
    
    //checking for duplicate users method
    
    public boolean checkDuplicateUser(){
        String stuid=txt_sid.getText();
        boolean isExists=false;
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from users where rollno=?");
            pst.setString(1, stuid);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                isExists=true;
            }else{
                isExists=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExists;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_uname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_sid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        loginbutton = new javax.swing.JButton();
        signupbutton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Welcome To");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 310, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Student Signup");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 250, 40));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 670, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 600));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 20, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Create New Account");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 190, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UserName");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 110, 30));
        jPanel2.add(txt_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 420, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 90, 30));

        txt_sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_sidFocusLost(evt);
            }
        });
        jPanel2.add(txt_sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 420, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 50, 50));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 420, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 50, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Id");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 50, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Email");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 130, 30));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 420, 30));

        loginbutton.setBackground(new java.awt.Color(0, 255, 255));
        loginbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(255, 255, 255));
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(loginbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 170, 40));

        signupbutton.setBackground(new java.awt.Color(153, 0, 153));
        signupbutton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signupbutton.setForeground(new java.awt.Color(255, 255, 255));
        signupbutton.setText("SignUp");
        signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(signupbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 170, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("SIGNUP PAGE");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 520, 600));

        setSize(new java.awt.Dimension(1190, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        //Signup button method 
    
    private void signupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbuttonActionPerformed
    if(validateSignup() == true){
        if(checkDuplicateUser()==false){
        insertSignUpDetails(); 
        LoginPage lp=new LoginPage();
        lp.setVisible(true);
        this.dispose();
    }else{
         JOptionPane.showMessageDialog(this,"Student id already exists");   
        }
    }
    }//GEN-LAST:event_signupbuttonActionPerformed

    //Mouse click event to close the screen
    
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked
    
    //focus on the Studentid to validate duplicate users
    
    private void txt_sidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_sidFocusLost
        if(checkDuplicateUser()==true){
            JOptionPane.showMessageDialog(this,"Student id already exists");
        }
    }//GEN-LAST:event_txt_sidFocusLost

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
    LoginPage lp=new LoginPage();
    lp.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_loginbuttonActionPerformed

   
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginbutton;
    private javax.swing.JButton signupbutton;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_sid;
    private javax.swing.JTextField txt_uname;
    // End of variables declaration//GEN-END:variables
}
