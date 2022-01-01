package javasrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Harika
 */

public class ManageStudent extends javax.swing.JFrame {
    
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    
    public ManageStudent() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    //To set the Student details into the table in managestudents module
    
    public void setStudentDetailsToTable(){
        try{
       Connection con=DBConnection.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from student_details");
       
       while(rs.next()){
           String studentId=rs.getString("student_id");
           String studentName=rs.getString("name");
           String course=rs.getString("course");
           String branch=rs.getString("branch");
           
           Object[] obj={studentId,studentName,course,branch};
           model=(DefaultTableModel)book_table.getModel();
           model.addRow(obj);
       }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
    //To add Student to the database on clicking add button 
    
    public boolean addStudent(){
        boolean isAdded = false;
        studentId=Integer.parseInt(txt_sid.getText());
        studentName=txt_sname.getText();
        course=combo_CourseName.getSelectedItem().toString();
        branch=comboBranch.getSelectedItem().toString();
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into student_details values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,studentId);
            pst.setString(2,studentName);
            pst.setString(3,course);
            pst.setString(4,branch);
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isAdded=true;
            }else{
                isAdded=false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         return isAdded;    
    }
    
    //method to clear table before Fetching after performing every action
    
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) book_table.getModel();
        model.setRowCount(0);
    }
    
    //method to update the details in table inserted earlier

    public boolean updateStudent(){
        boolean isUpdated = false;
        studentId=Integer.parseInt(txt_sid.getText());
        studentName=txt_sname.getText();
        course=combo_CourseName.getSelectedItem().toString();
        branch=comboBranch.getSelectedItem().toString();
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="update student_details set name = ? ,course = ? ,branch = ? where student_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,studentName);
            pst.setString(2,course);
            pst.setString(3,branch);
            pst.setInt(4,studentId);
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isUpdated=true;
            }else{
                isUpdated=false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         return isUpdated;    
    }
    
    //method to delete the details in table inserted earlier

    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId=Integer.parseInt(txt_sid.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="delete from student_details where student_id = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,studentId);
            
            int rowCount=pst.executeUpdate();
            if(rowCount > 0){
                isDeleted=true;
            }else{
                isDeleted=false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
         return isDeleted;    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Back = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_sname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_CourseName = new javax.swing.JComboBox();
        comboBranch = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        book_table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Closepanel = new javax.swing.JPanel();
        Closelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        Back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Student Id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 150, 30));
        jPanel1.add(txt_sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 420, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 30, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 40, 40));

        txt_sname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_snameFocusLost(evt);
            }
        });
        jPanel1.add(txt_sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 420, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Student Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 190, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Course");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 130, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 30, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 30, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Select Branch");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 130, 30));

        delete.setBackground(new java.awt.Color(255, 0, 51));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 100, 40));

        add.setBackground(new java.awt.Color(255, 0, 51));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 90, 40));

        update.setBackground(new java.awt.Color(255, 0, 51));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 100, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STUDENT DETAILS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 240, 60));

        combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "C++", "Java", "Python", "Swift", " " }));
        jPanel1.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 420, 30));

        comboBranch.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        comboBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CSE", "IT", "ECE", "EEE", "MECH", "CIVIL", " " }));
        jPanel1.add(comboBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 420, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N

        book_table.setBackground(new java.awt.Color(255, 51, 51));
        book_table.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        book_table.setForeground(new java.awt.Color(255, 255, 255));
        book_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Course", "Branch"
            }
        ));
        book_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        book_table.setGridColor(new java.awt.Color(153, 153, 255));
        book_table.setRowHeight(25);
        book_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(book_table);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 520, 210));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel4.setText("  Manage Students");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 330, 100));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 360, 5));

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

        jPanel3.add(Closepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 40, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 560, 600));

        setSize(new java.awt.Dimension(1086, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void txt_snameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_snameFocusLost
       
    }//GEN-LAST:event_txt_snameFocusLost

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(deleteStudent() == true){
            JOptionPane.showMessageDialog(this,"Student Deleted!!");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Error occured while Deleting a Student");
        }     
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(addStudent() == true){
            JOptionPane.showMessageDialog(this,"Student Added!!");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Error occured while adding a Student");
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(updateStudent() == true){
            JOptionPane.showMessageDialog(this,"Student Record Updated!!");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Error occured while updating a book record");
        }
    }//GEN-LAST:event_updateActionPerformed

    private void CloselabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloselabelMouseClicked
       System.exit(0);
    }//GEN-LAST:event_CloselabelMouseClicked

    private void ClosepanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClosepanelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ClosepanelMouseClicked

    private void book_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_tableMouseClicked
        int rowNo=book_table.getSelectedRow();
        TableModel model = book_table.getModel();
        
        txt_sid.setText(model.getValueAt(rowNo, 0).toString());
        txt_sname.setText(model.getValueAt(rowNo, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        comboBranch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_book_tableMouseClicked

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JLabel Closelabel;
    private javax.swing.JPanel Closepanel;
    private javax.swing.JButton add;
    private javax.swing.JTable book_table;
    private javax.swing.JComboBox comboBranch;
    private javax.swing.JComboBox combo_CourseName;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_sid;
    private javax.swing.JTextField txt_sname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
