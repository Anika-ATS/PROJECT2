package regiform;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class StaffList extends JFrame {
   Font fn;
   JPanel p1,p2;
   ImageIcon img;
   JLabel imgLable; 
   JTable table;
   JButton b1,b2,b3,b4,b5,b6,b7;
   JScrollPane scroll;
   JTextField t1,t2,t3,t4;
   JLabel l1,l2,l3,l4;
   DefaultTableModel model;
   String Name,Work, Payment,Mobile;
   

   
	StaffList()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,10,775,650);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Staff information");
	        
   
		
		fn= new Font("Arial", Font.BOLD,14);
		
		p1= new JPanel();
		p1.setBounds(0,0,775,250);
		p1.setLayout(null);
		
		add(p1);
		
		img =new ImageIcon(getClass().getResource("u8.jpg"));
		imgLable=new JLabel(img);
		imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		p1.add(imgLable);
		
		p2= new JPanel();
		p2.setBounds(0,250,775,400);
		p2.setLayout(null);
		p2.setBackground(Color.black);//255,102,0,,171,189,196..112,115,0
		add(p2);
		

		String[] columns= {"Name","Work", "Payment","Mobile"};
		String[][] data = {};
	           
		// Initializing the JTable
		  table= new JTable();
		 
          model= new DefaultTableModel(null, columns);//object
      
      //table adding
      
//	     
	      table.setModel(model);
          table.setSelectionBackground(Color.gray);
          table.setBackground(Color.WHITE);
          table.setRowHeight(20);
        
          table.setModel(model);
	      scroll= new JScrollPane(table);
	      scroll.setBounds(10, 30, 450, 200);
	      p2.add(scroll);
	      
//mouselistener
	      table.addMouseListener(new MouseAdapter() {
	    	  
	    	  public void mouseClicked(MouseEvent me) {
	    		  
	    		  int NumOfRow=table.getSelectedRow(); 
	    		  
	    		  Name=(String)model.getValueAt(NumOfRow, 0);
	    		  t1.setText(Name);	    		 
	    		  Work= model.getValueAt(NumOfRow, 1).toString();
	    		  t2.setText(Work);
	    		  Payment=model.getValueAt(NumOfRow, 2).toString();
	    		  t3.setText(Payment);
	       		  Mobile=model.getValueAt(NumOfRow, 3).toString();
	       		  t4.setText(Mobile);
	    	  }
	    	  
	      });
	      
	      
	      
//	  //txtfield
//	      
	        l1= new JLabel("NAME :");
			l1.setBounds(480,20,100,50);
			l1.setOpaque(true);
			l1.setForeground(Color.white);
			l1.setBackground(Color.BLACK);
			l1.setFont(fn);
			p2.add(l1);
		
			t1= new JTextField(""); 
			t1.setBounds(550,30,150,30);			  
			p2.add(t1); 
			
			l2= new JLabel("WORK :");
			l2.setBounds(480,80,100,50);
			l2.setOpaque(true);
			l2.setForeground(Color.white);
			l2.setBackground(Color.BLACK);
			l2.setFont(fn);
			p2.add(l2);
		
			t2= new JTextField(""); 
			t2.setBounds(550,90,150,30);			  
			p2.add(t2);  
			
			 
			l3= new JLabel(" SELLARY:");
			l3.setBounds(470,140,100,50);
			l3.setOpaque(true);
			l3.setForeground(Color.white);
			l3.setBackground(Color.BLACK);
			l3.setFont(fn);
			p2.add(l3);
			
			t3= new JTextField(""); 
			t3.setBounds(550,150,150,30);			  
			p2.add( t3);  
			 
			l4= new JLabel("MOBILE	:");
			l4.setBounds(480,200,100,50);
			l4.setOpaque(true);
			l4.setForeground(Color.white);
			l4.setBackground(Color.BLACK);
			l4.setFont(fn);
			p2.add(l4);
			
			t4= new JTextField(""); 
			t4.setBounds(550,210,150,30);			  
			p2.add(t4);  
//			 
//			 
//			//buttons--ADD,Refresh,Menu,Update,DELETE,REFRESH TABLE,CLEAR
//			 
			  b1= new JButton("ADD");  //addbtn
            b1.setBounds(10, 250, 100, 50);
            p2.add(b1);
//            b1.addActionListener(this);
            b1.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Name=t1.getText();
					Work=t2.getText();
					Payment=t3.getText();
					Mobile=t4.getText();
					
				
					
					String NameRegex = "[a-zA-Z]+";
					String WorkRegex = "[a-zA-Z]+";
					String MobileRegex="(\\+88)?-?01[3-9]\\d{8}+";
					String PaymentRegex="\\d{4}+";
					
                    if(!Pattern.matches(NameRegex,Name))
					{
						
						JOptionPane.showMessageDialog(null, "Correct your Name");	
						
					}
                    else if(!Pattern.matches( WorkRegex, Work))
					{
						
						JOptionPane.showMessageDialog(null, "Correct work data");	
						
					}
                    
         
					else if(!Pattern.matches(MobileRegex,Mobile))
					{
						
						JOptionPane.showMessageDialog(null, "Correct your phonenumber");	
						
					}
					
					else if(!Pattern.matches(PaymentRegex,Payment))
					{
						
						JOptionPane.showMessageDialog(null, "Put Again Payment Number");	
						
					}
					
					
					
					
					
					
					
					
					String insertQuery	="INSERT INTO `staff`(`Name`, `Work`, `Payment`, `Mobile`) VALUES ('"+Name+"','"+Work+"','"+Payment+"','"+Mobile+"')";
					dbConnect3 db= new dbConnect3();
					
				    db.SaveInsert2(insertQuery);
				
					
				}
				});	
            
            
            
            
            b2= new JButton("UPDATE");          
            b2.setBounds(120, 250, 100, 50);
            p2.add(b2);

            b2.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
		  		  
					Name=t1.getText();
					Work=t2.getText();
					Payment=t3.getText();
					Mobile=t4.getText();
					
					int NumOfRow=table.getSelectedRow(); 
			  		  
			  		model.setValueAt(Name,NumOfRow,0);
					model.setValueAt(Work,NumOfRow,1);
					model.setValueAt(Payment,NumOfRow,2);
					model.setValueAt( Mobile,NumOfRow,3);
					
					
				}
				});	
            
            
            
//            
            b3= new JButton("DELETE");
            b3.setBounds(230, 250, 100, 50);
            p2.add(b3);
            b3.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					
						int NumOfRow=table.getSelectedRow();
						if(NumOfRow>=0)
						{
					
							int choice= JOptionPane.showConfirmDialog(null, "Do you Want to delete?","Quit",JOptionPane.YES_NO_OPTION);
						
							if(choice==JOptionPane.YES_OPTION) {
							
							   model.removeRow(NumOfRow);
							   
							}
							else
							{
								System.out.println("You have clicked NO");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Please select any row.");
						}
					}
					
				}
				);	
           
//            
            b4= new JButton("CLEAR");
            b4.setBounds(340, 250, 100, 50);
            p2.add(b4);
            b4.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					
					
				}
				});	
            
            
            b5= new JButton("REFRESH TABLE");
            b5.setBounds(10, 310, 210, 50);
            p2.add(b5);
            b5.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
		  		  //refresh
					model.setRowCount(0);
					
				}
				});	
            b6= new JButton("MENU");
            b6.setBounds(230,310, 100, 50);
            p2.add(b6);
            b6.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
		  		  
					dispose();
					new home();	
					
				}
				});	     
            
            
            b7= new JButton("ShowData");
            b7.setBounds(340, 310, 100, 50);
            p2.add(b7);
            b7.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					

					
					Connection con;
					Statement st;
					
					 try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","");
							 								
							 st= con.createStatement();
							 String sql="select* from staff";
							 ResultSet rs = st.executeQuery(sql);
							
								while(rs.next()) {
									
									String Name = rs.getString("Name");//"Name " is a column name
									String Work = rs.getString("Work");
									String Payment = rs.getString("Payment");
									String Mobile = rs.getString("Mobile");
	
									// array of store data to jtable	
								
									String Data[] = {Name, Work, Payment, Mobile};
	                                
	                                model = (DefaultTableModel)table.getModel();
					
					model.addRow(Data);				
									
									
									
									
								}
									
									
						     } catch(Exception e1)
						     {
						    	 System.out.println(e1);
						     }
						        
						}


					
				
				
			 }	);	
		
            
            setVisible(true);
		
		
	}
	


}
