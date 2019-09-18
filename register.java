package register_information;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.*;
 
public class register extends JFrame{
	JLabel usernameLabel,passwordLabel;
	JButton okButton,resetButton;
	JTextField userpasswordText,passwordText;
	Box baseBox1,baseBox2, box1,box2,box3;
	register_db regist;
	
	register(){
		init();
	}
	
	
	void init(){
		setLayout(new FlowLayout());
		usernameLabel = new JLabel("Username");
		passwordLabel= new JLabel("Password");
		userpasswordText = new JTextField(10);
		passwordText = new JTextField(20);
		okButton = new JButton("Enter");
		resetButton = new JButton("Reset");
		
		regist = new register_db();
		
		box1 = Box.createVerticalBox();
		box1.add(usernameLabel);
		box1.add(Box.createVerticalStrut(8));
		box1.add(passwordLabel);
		box2 = Box.createVerticalBox();
		box2.add(userpasswordText);
		box2.add(Box.createVerticalStrut(8));
		box2.add(passwordText);
		box3 = Box.createHorizontalBox();
		box3.add(okButton);
		box3.add(Box.createHorizontalStrut(15));
		box3.add(resetButton);
		baseBox1 = Box.createHorizontalBox();
		baseBox1.add(box1);
		baseBox1.add(Box.createHorizontalStrut(8));
		baseBox1.add(box2);
		baseBox2 = Box.createVerticalBox();
		baseBox2.add(baseBox1);
		baseBox2.add(Box.createVerticalStrut(10));
		baseBox2.add(box3);
		add(baseBox2);
		
		okButton.addActionListener(regist);
		resetButton.addActionListener(regist);
		
		regist.setusernameField(userpasswordText);
		regist.setpasswordField(passwordText);
		regist.setokButton(okButton);
		regist.setresetButton(resetButton);
		
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Intelligent Tourism Recommender Systems");
	}
}

