package register_information;

import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.*;
 
public class login extends JFrame{
	JTextField userpasswordT,passwordT;
	JButton okB,registB;
	Box baseB1,baseB2,box1,box2,box3;
	login_db log;
	
	login(){
		init();
	}
	void init(){
		log = new login_db();
		
		userpasswordT = new JTextField(10);
		passwordT = new JTextField(20);
		okB = new JButton("LogIn");
		registB = new JButton("Register");
		
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("Username："));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("Password:"));
		
		box2 = Box.createVerticalBox();
		box2.add(userpasswordT);
		box2.add(Box.createVerticalStrut(8));
		box2.add(passwordT);
		
		box3 = Box.createHorizontalBox();
		box3.add(okB);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(registB);
		
		baseB1 = Box.createHorizontalBox();
		baseB1.add(box1);
		baseB1.add(Box.createHorizontalStrut(8));
		baseB1.add(box2);
		
		baseB2 = Box.createVerticalBox();
		baseB2.add(baseB1);
		baseB2.add(Box.createVerticalStrut(10));
		baseB2.add(box3);
		
		okB.addActionListener(log);
		registB.addActionListener(log);
		
		log.setusernameT(userpasswordT);
		log.setpasswordT(passwordT);
		log.setButton(okB,registB);
		
		add(baseB2);
		setLayout(new FlowLayout());
		setBounds(200,150,400,300);
		setVisible(true);
		setTitle("Intelligent Tourism Recommender Systems");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		login lo= new login();
	}
}
