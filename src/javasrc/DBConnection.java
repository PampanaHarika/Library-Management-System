package javasrc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Harika
 */

    //creating class for connection with database

public class DBConnection {
    
    static Connection con=null;
    
    public static Connection getConnection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");   
    }catch(Exception e){
        e.printStackTrace();
    }
   return con;
}
}
