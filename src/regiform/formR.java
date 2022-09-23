package regiform;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class formR extends JFrame {
	 JTextField t1,t2,t3,t4,t5;
	 JPanel p1,p2;
	   Font fn;
	   ImageIcon img;
	   JLabel Username, Email, Mobile,Password,ConfirmPassword,Address,L1,imgLable;
	   JButton Login,Register,Clear,Back;
	  
	   
	   formR()
	   
	   {
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(150,50,450,550);
			setLayout(null);
			setTitle("REGISTRATION FORM");
			
			
			fn= new Font("Arial", Font.BOLD,14);
			p1= new JPanel();
			p1.setBounds(0, 0, 450, 50);
			p1.setBackground(Color.GRAY);
			p1.setLayout(null);
			add(p1);

			  
			  L1= new JLabel("REGISTRATION FORM");
			  L1.setBounds(150,0,450,50);
			  L1.setFont(fn);
			  L1.setForeground(	new Color(255,102,0));
			  p1.add(L1);
			
			//panel 2
			  
			    p2= new JPanel();
				p2.setBounds(0, 50,450, 500);
				p2.setLayout(null);
				p2.setBackground( Color.BLACK);
				add(p2);
				
				

				
		//Username 		
				Username= new JLabel( "UserName: ");
				Username.setBounds(10,20,100,50);				
				Username.setFont(fn);
				Username.setForeground(Color.WHITE);
				 p2.add(Username);
				 
				 t1= new JTextField(""); //username
				 t1.setBounds(180,30,150,30);
				 t1.setFont(fn);
				  
				  p2.add(t1);  
				  
							
				  Email= new JLabel("Email: ");
				  Email.setBounds(10,80,100,50);
				  Email.setForeground(Color.WHITE);
				  Email.setFont(fn);
				  p2.add(Email);
					 
				 t2= new JTextField(""); //email
				 t2.setBounds(180,90,150,30);
				 t2.setFont(fn);
				 
				 p2.add(t2);  
				
		// Password
				 Password = new JLabel("Password: ");
				 Password.setBounds(10,130,100,50);
				 Password.setForeground(Color.WHITE);
				 Password.setFont(fn);
				 p2.add(Password);
					 
				 t3= new JTextField(""); // pass
				 t3.setBounds(180,140,150,30);
				 t3.setFont(fn);
				 
				 p2.add(t3); 
			
		//ConfirmPassword
				 
				 ConfirmPassword = new JLabel("Confirm Password : ");
				 ConfirmPassword.setBounds(10,190,150,50);
				 ConfirmPassword.setForeground(Color.WHITE);
				 ConfirmPassword.setFont(fn);
				 p2.add(ConfirmPassword	);
					 
				 t4= new JTextField(""); 
				 t4.setBounds(180,200,150,30);
				 t4.setFont(fn);
				 
				 p2.add(t4);  
		
		//Mobile
				 Mobile = new JLabel("Mobile Number : ");
				 Mobile.setBounds(10,250,150,50);
				 Mobile.setForeground(Color.WHITE);
				 Mobile.setFont(fn);
				 p2.add(Mobile);
					 
				 t5= new JTextField(""); 
				 t5.setBounds(180,260,150,30);
				 t5.setFont(fn);
				
				 p2.add(t5); 
				 
 
				 
		
			//Login,Register,Clear,Back;	 
				 Register= new JButton("Save");
				 Register.setBounds(150,350,100,50);
				 p2.add(Register);
				 setVisible(true); 
				 

				 Login= new JButton("Login");
				 Login.setBounds(10,350,100,50);
				 p2.add(Login);
				 Login.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					dispose();
					new formLogin();
					}
					});	
				 
				 
				 Clear= new JButton("Clear");
				 Clear.setBounds(280,350,100,50);
				 p2.add(Clear);
				 Clear.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
										}
					});	
				 
				 
				 
				 
				 Back= new JButton("Back");
				 Back.setBounds(150,410,100,50);
				 p2.add(Back);
				 Back.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					dispose();
					new welcome();
					}
					});	  
				 
				 
		//connect with database          
	 Register.addActionListener(new ActionListener(){
	                 @Override
	                 public void actionPerformed(ActionEvent e) {
	                     	String Username = t1.getText();
							String Email = t2.getText();
							String Password = t3.getText();
							String ConfirmPassword = t4.getText();
							String Mobile = t5.getText();
							//String Address = t6.getText();
				
		
				
		//validation
							
				
				String UsernameRegex = "[a-zA-Z]+";
			    String EmailRegex= "[a-z]+@(yahoo|gmail|outlook).com";		
				String PasswordRegex = "(?=.*\\d)" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=]).{6,20}";
				String MobileRegex="(\\+88)?-?01[3-9]\\d{8}+";
			//	String AddressRegex="[a-zA-Z]+"; 
		
				if(!Pattern.matches(UsernameRegex, Username))
				{
					
					JOptionPane.showMessageDialog(null, "Correct your UsesrName");	
					
				}
				
				
				else if(!Pattern.matches(EmailRegex, Email))				
				 {
				
					JOptionPane.showMessageDialog(null, "Correct your Email");	
					
				}
		   
			   
		        
				else if(!Pattern.matches(PasswordRegex, Password))
				{
					
					JOptionPane.showMessageDialog(null, "Correct your  Password");	
					
				}
		        
		      //checking of pass and Confirmpassword
				
				else if(!Password.equals(ConfirmPassword))
					
				{
							
					JOptionPane.showMessageDialog(null, "Please Check your Password again.");
					
				  
			     }
		        
				    
				else if(!Pattern.matches(MobileRegex, Mobile))
					{
						
						JOptionPane.showMessageDialog(null, "Correct your mobile number");	
						
					}	 
				 
			
	
	
			else	
			{  
				
				String insertQuery= "INSERT INTO `home`(`Username`, `Email`, `Password`, `Mobile`) VALUES('"+Username+"','"+Email+"','"+Password+"','"+Mobile+"')";
				
		
				dbConnect3 db= new dbConnect3();
				
				db.RegisterInsert(insertQuery);
				
			}
	 } 
	
	   }
	 );
	 }
	  
   
}
