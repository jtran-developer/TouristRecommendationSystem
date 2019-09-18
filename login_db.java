package register_information;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class login_db extends conn_db implements ActionListener {
	JTextField userpasswordT,passwordT;
	JButton okB,registB;
	register re;
	ResultSet rs;
	JFrame frame;
	
	public void setusernameT(JTextField a){
		userpasswordT = a;
	}
	public void setpasswordT(JTextField n){
		passwordT = n;
	}
	public void setButton(JButton b1,JButton b2){
		okB = b1;
		registB = b2;
	}
	
	public void actionPerformed(ActionEvent e){
		SearchPage sp;
		
		if(e.getSource() == okB){
			if(userpasswordT.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please Enter your username！");
			else if(passwordT.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please Enter Your Password!");
			else{
				String accountT = userpasswordT.getText();
				String namesT = passwordT.getText();
				try {
					connection();
					boolean com = compareWithSql(accountT,namesT);
					if(com) {
						JOptionPane.showMessageDialog(null, "LogIn successful!");
						sp = new SearchPage();
					}
					else{
						JOptionPane.showMessageDialog(null, "Please check your username or password again!");
						userpasswordT.setText("");
						passwordT.setText("");
					}
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == registB){
			new JFrame().dispose();
			re = new register();
		}
	}
	

	boolean compareWithSql(String accountT,String namesT) throws Exception{
		String sql;		
		Connection con = super.con;
		Statement stmt = con.createStatement();
		sql = "select * from users";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			String acc = rs.getString(1);
			String names = rs.getString(2);
			if(acc.equals(accountT) && names.equals(namesT)){
				return true;
			}	
		}
		return false;
	}
}
