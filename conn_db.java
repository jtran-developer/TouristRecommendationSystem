package register_information;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class conn_db{  
    Connection con;  
    String url = null;  
     
    public void connection() throws ClassNotFoundException{  
        url = "jdbc:mysql://localhost:3306/cpsc531?"  
                + "user=root & password=password & useUnicode=true & characterEnunicode=UTF8";  
        try{  
            con = DriverManager.getConnection(url);  
            System.out.println("Connection successful!");  
        }  
        catch(SQLException e){  
            e.printStackTrace();  
        }  
    }  
}
