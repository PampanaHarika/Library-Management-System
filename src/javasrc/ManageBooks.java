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

public class ManageBooks extends javax.swing.JFrame {
    String bookName,author;
        int bookId,quantity;
        DefaultTableModel model;
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }
    
    //To set the book details into the table in managebooks module
    
    public void setBookDetailsToTable(){
        try{
       Connection con=DBConnection.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select * from book_details");
       
       while(rs.next()){
           String bookid=rs.getString("bookid");
           String bookname=rs.getString("bookname");
           String author=rs.getString("authorname");
           int quantity=rs.getInt("Quantity");
           
           Object[] obj={bookid,bookname,author,quantity};
           model=(DefaultTableModel)book_table.getModel();
           model.addRow(obj);
       }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
    //To add book to the database on clicking add button 
    
    public boolean addBook(){
        boolean isAdded = false;
        bookId=Integer.parseInt(txt_bid.getText());
        bookName=txt_bname.getText();
        author=txt_Author.getText();
        quantity=Integer.parseInt(txt_Quantity.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into book_details values(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setString(3,author);
            pst.setInt(4,quantity);
            
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
    
    //method to clear table before fetching
    
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) book_table.getModel();
        model.setRowCount(0);
    }
    
    //method to update the details in table inserted earlier

    public boolean updateBook(){
        boolean isUpdated = false;
        bookId=Integer.parseInt(txt_bid.getText());
        bookName=txt_bname.getText();
        author=txt_Author.getText();
        quantity=Integer.parseInt(txt_Quantity.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="update book_details set bookname = ? ,authorname = ? ,Quantity = ? where bookid = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,bookName);
            pst.setString(2,author);
            pst.setInt(3,quantity);
            pst.setInt(4,bookId);
            
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

    public boolean deleteBook(){
        boolean isDeleted = false;
        bookId=Integer.parseInt(txt_bid.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="delete from book_details where bookid = ?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            
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
        txt_bid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_bname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Author = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
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
        jLabel7.setText("Enter Book Id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, 30));
        jPanel1.add(txt_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 420, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 30, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 40, 40));

        txt_bname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bnameFocusLost(evt);
            }
        });
        jPanel1.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 420, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Book Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 160, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Author Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 130, 30));
        jPanel1.add(txt_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 420, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 30, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 30, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 130, 30));
        jPanel1.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 420, 30));

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
        jLabel2.setText("BOOK DETAILS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 190, 50));

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
                "Book Id", "Book Name", "Author", "Quantity"
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 520, 210));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("  Manage Books");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 260, 60));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 370, 5));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 550, 600));

        setSize(new java.awt.Dimension(1086, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void txt_bnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bnameFocusLost
       
    }//GEN-LAST:event_txt_bnameFocusLost

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(deleteBook() == true){
            JOptionPane.showMessageDialog(this,"Book Deleted!!");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Error occured while Deleting a book");
        }     
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(addBook() == true){
            JOptionPane.showMessageDialog(this,"Book Added!!");
            clearTable();
            setBookDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Error occured while adding a book");
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(updateBook() == true){
            JOptionPane.showMessageDialog(this,"Book Record Updated!!");
            clearTable();
            setBookDetailsToTable();
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
        
        txt_bid.setText(model.getValueAt(rowNo, 0).toString());
        txt_bname.setText(model.getValueAt(rowNo, 1).toString());
        txt_Author.setText(model.getValueAt(rowNo, 2).toString());
        txt_Quantity.setText(model.getValueAt(rowNo, 3).toString());
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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JLabel Closelabel;
    private javax.swing.JPanel Closepanel;
    private javax.swing.JButton add;
    private javax.swing.JTable book_table;
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
    private javax.swing.JTextField txt_Author;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_bid;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
