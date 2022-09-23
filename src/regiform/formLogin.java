package regiform;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formLogin extends JFrame {

	JLabel L1,Name,Password,imgLable,AdminL;
	Font fn;
	ImageIcon img;
   JTextField  t1,t2;
   JButton LoginBtn,RegistrationBtn, Clearbtn,Backbtn, Adminlogin;
 
  //constructor 
   formLogin()
   
   {
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,400,350);
		setLayout(null);
		setLocationRelativeTo(null); //used to get frame in center area
		setTitle("Login FORM");
		//setLayout(new BorderLayout());	        
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("b1.jpg")))); // image set in frame
		
		fn= new Font("Arial", Font.BOLD,14);
		


			Name= new JLabel("Name : ");
			Name.setBounds(10,30,100,50);		
			Name.setForeground(Color.BLACK);
			Name.setFont(fn);
		    add(Name);
			 
		 t1= new JTextField(""); //Name
		 t1.setBounds(90,40,150,30);
		 t1.setFont(fn);		
		 add(t1);  
		  
		 
		//Password	
		 Password = new JLabel("Password : ");
		 Password.setBounds(10,70,100,50);
		 Password.setForeground(Color.BLACK);
		// Password.setLayout(null);
		 Password.setFont(fn);
		 add(Password	);
			 
		 t2= new JTextField(""); //Password	
		 t2.setBounds(90,80,150,30);
		 t2.setFont(fn);
		 t2.setLayout(null);
		 add(t2); 
		 
		 AdminL= new JLabel("ADMIN PANEL");
		 AdminL.setBounds(10,160,100,50);
		 AdminL.setOpaque(true);
		 AdminL.setBackground(Color.white);
		 AdminL.setForeground(Color.black);
		 AdminL.setFont(fn);
		 add(AdminL);

   // Login,Registration
		 LoginBtn= new JButton("Login");
		 LoginBtn.setBounds(280,20,100,50);
		 LoginBtn.setFont(fn);
		add(LoginBtn);
	// LoginBtn.addActionListener(this);
		 
		 RegistrationBtn= new JButton("SIGN UP");
		 RegistrationBtn.setBounds(280,90,100,50);
		add(RegistrationBtn);
  
// Clearbtn
		 
		 Clearbtn= new JButton("Clear");
		 Clearbtn.setBounds(280,160,100,50);
		
		 add(Clearbtn);
		 
	//Backbtn	 

		 Backbtn= new JButton("Back");
		 Backbtn.setBounds(280,230,100,50);
		
		 add(Backbtn);
		 
	// Adminloginbtn
		 Adminlogin= new JButton("Admin Login");
		 Adminlogin.setBounds(10,230,200,50);
		
		 add(Adminlogin);
		 
		 setVisible(true);

		 
		 LoginBtn.addActionListener(new ActionListener()
		 
		 {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = t1.getText();
				String pass = t2.getText();
				String f = "select * from home";
				dbConnect3 db = new dbConnect3();
				try {
					int flag = 0;
					ResultSet rs = db.st.executeQuery(f);
					while(rs.next()) {
						if(name.equals(rs.getString("Username"))&& pass.equals(rs.getString("Password"))) {
							JOptionPane.showMessageDialog(null, "logged in");
							dispose();
							 new userArea();
							flag = 1;
							break;
						}
					}
					if(flag == 0) JOptionPane.showMessageDialog(null, "this is invalid");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			
			
			});	 
		 
		 
		 RegistrationBtn.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 
            	 dispose();
 				new formR();
 				
                           }
             }); 
		 
		 
		 Clearbtn.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
            	t1.setText(null);
 				 t2.setText(null);
            	
 				
                           }
             }); 
		 
		 Backbtn.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 
            	 dispose();
 				new welcome();
 				
                           }
             });  
		 
		 Adminlogin.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 
            	 String name = t1.getText();
 				String pass = t2.getText();
 				String j = "select * from admin";
 				dbConnect3 db = new dbConnect3();
 				try {
 					int flag = 0;
 					ResultSet rs3 = db.st.executeQuery(j);
 					while(rs3.next()) {
 						if(name.equals(rs3.getString("Name"))&& pass.equals(rs3.getString("Password"))) {
 							JOptionPane.showMessageDialog(null, "logged in");
 							dispose();
 							new home();
 							flag = 1;
 							break;
 						}
 					}
 					if(flag == 0) JOptionPane.showMessageDialog(null, "this is invalid");
 				} catch (SQLException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 				 
            	 
            }
             });  
		 
		 
		 
   }
   
 
       
       }

