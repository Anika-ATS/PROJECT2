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

public class applyform extends JFrame{
 
	
	 JTextField t1,t2,t3,t4;
	 JPanel p1,p2;
	   Font fn;
	   ImageIcon img;
	   JLabel L1,imgLable,l1,l2,l3,l4;
	   JButton Save,Back,Clear;
	    
	//constructor   
	   applyform()
	
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150,50,560,600);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("APPLICATION FORM");
		
		
		fn= new Font("Arial", Font.BOLD,14);
		p1= new JPanel();
		p1.setBounds(0, 0, 560, 50);
		p1.setBackground(new Color(255,102,0));
		p1.setLayout(null);
		add(p1);

		  
		  L1= new JLabel("APPLICATION FORM");
		  L1.setBounds(200,0,450,50);
		  L1.setFont(fn);
		  L1.setForeground( Color.black);
		  p1.add(L1);
		  
		  img =new ImageIcon(getClass().getResource("pngtree-scene-withg1.jpg"));
		  imgLable=new JLabel(img);
		  imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		  add(imgLable);
		
		//panel 2
		  
		    p2= new JPanel();
			p2.setBounds(0,240,560,340);
			p2.setLayout(null);
			p2.setBackground( Color.BLACK);
			add(p2);
			 
		  
		    l1= new JLabel("NAME:");
			l1.setBounds(10,30,100,50);
			l1.setOpaque(true);
			l1.setForeground(Color.white);
			l1.setBackground(Color.BLACK);
			l1.setFont(fn);
			p2.add(l1);
		
			t1= new JTextField(""); 
			t1.setBounds(120,40,150,30);			  
			p2.add(t1); 
			
			l2= new JLabel("EMAIL:");
			l2.setBounds(10,70,100,50);
			l2.setOpaque(true);
		    l2.setForeground(Color.white);
			l2.setBackground(Color.BLACK);
			l2.setFont(fn);
		    p2.add(l2);
		
			t2= new JTextField(""); 
			t2.setBounds(120,80,150,30);			  
			p2.add(t2);  
			
			 
			l3= new JLabel("ADDRESS:");
			l3.setBounds(10,130,100,50);
		    l3.setOpaque(true);
			l3.setForeground(Color.white);
			l3.setBackground(Color.BLACK);
			l3.setFont(fn);
			p2.add(l3);
			
			t3= new JTextField(""); 
			t3.setBounds(120,140,150,30);			  
			p2.add( t3);  
			 
			l4= new JLabel("MOBILE:");
			l4.setBounds(10,180,100,50);
			l4.setOpaque(true);
			l4.setForeground(Color.white);
			l4.setBackground(Color.BLACK);
			l4.setFont(fn);
			p2.add(l4);
			
			t4= new JTextField(""); 
			t4.setBounds(120,190,150,30);			  
			p2.add(t4);  
			
			Back= new JButton("Back");
			 Back.setBounds(430,250,100,50);
			 p2.add(Back);
			 Back.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new userArea();
				}
				});	  
			 
			 
			 
			 Clear= new JButton("Clear");
			 Clear.setBounds(230,250,100,50);
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
					
									}
				});	
			 
			 
			 Save= new JButton("Save");
			 Save.setBounds(10,250,100,50);
			 p2.add( Save);
			 
			 Save.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     	String NAME = t1.getText();
						String EMAIL = t2.getText();
						String ADDRESS = t3.getText();
						String MOBILE = t4.getText();
						
			
	
			
	//validation
						
			
			String NAMERegex = "[a-zA-Z]+";
		    String EMAILRegex= "[a-z]+@(yahoo|gmail|outlook).com";				
			String MOBILERegex="(\\+88)?-?01[3-9]\\d{8}+";
			String ADDRESSRegex="[a-zA-Z]+"; 
	
			if(!Pattern.matches(NAMERegex, NAME))
			{
				
				JOptionPane.showMessageDialog(null, "Correct your UsesrName");	
				
			}
			
			
			else if(!Pattern.matches(EMAILRegex, EMAIL))				
			 {
			
				JOptionPane.showMessageDialog(null, "Correct your Email");	
				
			}
	   
			    
			else if(!Pattern.matches(MOBILERegex, MOBILE))
				{
					
					JOptionPane.showMessageDialog(null, "Correct your mobile number");	
					
				}	 
			 


		else	
		{  
			
			String insertQuery= "INSERT INTO `applyform`( `Name`, `Email`, `Address`, `Mobile`) VALUES('"+NAME+"','"+EMAIL+"','"+ADDRESS+"','"+MOBILE+"')";
			
	
			dbConnect3 db= new dbConnect3();
			
			db.RegisterInsert4(insertQuery);
			
		}
 } 

   }
 );
			
		
			
	setVisible(true);
		
		
		
		
		
		
	}
	   
	
}
