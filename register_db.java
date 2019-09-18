package register_information;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.Statement;  
  
import javax.swing.*;  
  
public class register_db extends conn_db implements ActionListener{  
  
    JTextField textusername,textpassword;  
    JButton okButton,resetButton;  
    Statement stmt;  
    ResultSet rs;  
      
    public void setusernameField(JTextField a){  
        textusername = a;  
    }  
    public void setpasswordField(JTextField n){  
        textpassword = n;  
    }  
    public void setokButton(JButton b1){  
        okButton = b1;  
    }  
    public void setresetButton(JButton b2){  
        resetButton = b2;  
    }  
      
    public void actionPerformed(ActionEvent e){  
        if(e.getSource() == okButton){  
            if(textusername.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Please Enter Your Username","Warning!!!",JOptionPane.WARNING_MESSAGE);  
            else if(textpassword.getText().equals(""))  
                JOptionPane.showMessageDialog(null,"Please Enter Your Password","Warning!!!",JOptionPane.WARNING_MESSAGE);  
            else{  
                String uname = textusername.getText();  
                String name = textpassword.getText();  
                try {  
                    connection();  
                    writeInSql(uname,name);  
                } catch (Exception e1) {  
                    // System.out.println("Insert Failed");  
                	JOptionPane.showMessageDialog(null, "That username is taken.","Try Another!!!",JOptionPane.WARNING_MESSAGE);
                    e1.printStackTrace();  
                }  
            }  
        }  
        else if(e.getSource() == resetButton){  
            textusername.setText("");  
            textpassword.setText("");  
        }  
    }  
      
    void writeInSql(String uname,String pword) throws Exception{  
        String sql;  
          
        Connection con = super.con;  
        Statement stmt = con.createStatement();  
          
        sql = "create table if not exists users(username varchar(45),password varchar(45))";  
          
        stmt.executeUpdate(sql);  
        System.out.println("Table Creation Was Successful");					// Checking users exist!!  
          
        sql = "insert into users(username,password) values('"+uname+"','"+pword+"')";  
        int rw = stmt.executeUpdate(sql);  
        if(rw <= 0){ 
            JOptionPane.showMessageDialog(null,"Registration Failed!");  
        }  
        else{  
            JOptionPane.showMessageDialog(null, "Registration Successful!");  
        }  
    }  
}  