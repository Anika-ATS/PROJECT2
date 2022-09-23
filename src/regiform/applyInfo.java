package regiform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class applyInfo extends JFrame{
  
	Font fn;
	   JPanel p1;
	   ImageIcon img;
	   JLabel imgLable; 
	   JTable table;
	   JButton b1,b2,b3;
	   JScrollPane scroll;
	   JTextField t1,t2,t3,t4;
	   JLabel l1,l2,l3,l4;
	   DefaultTableModel model;
	   String Name,Work, Payment,Mobile;
	  
	  //constructor 
	   
	   applyInfo()
	   {
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(300,10,520,600);
			setLayout(null);
			setLocationRelativeTo(null);
			
			setTitle("Apply Information");
		     
	   
			fn= new Font("Arial", Font.BOLD,14);
			
			p1= new JPanel();
			p1.setBounds(0,0,520,600);
			p1.setLayout(null);
			p1.setBackground(Color.black);
			add(p1);
			
			img =new ImageIcon(getClass().getResource("k.jpg"));
			imgLable=new JLabel(img);
			imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
			p1.add(imgLable);
			

		String[] columns= {"Name","Work", "Payment","Mobile"};
		String[][] data = {};
		           
			// Initializing the JTable
			  table= new JTable();
			 
	          model= new DefaultTableModel(null, columns);//object
	      
	      //adding
	      
//		     
		      table.setModel(model);
	          table.setSelectionBackground(Color.gray);
	          table.setBackground(Color.WHITE);
	          table.setRowHeight(20);
	        
	          table.setModel(model);
		      scroll= new JScrollPane(table);
		      scroll.setBounds(10, 250, 450, 200);
		      p1.add(scroll);

		        b1= new JButton("SHOW DATA");          
	            b1.setBounds(10, 500, 150, 50);
	            p1.add(b1);

	            b1.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						

						
						Connection con;
						Statement st;
						
						 try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","");
								 								
								 st= con.createStatement();
								 String sql="select* from applyform";
								 ResultSet rs = st.executeQuery(sql);
								
									while(rs.next()) {
										
										String NAME = rs.getString("Name");//"Name " is a column name
										String EMAIL = rs.getString("Email");
										String ADDRESS = rs.getString("Address");
										String MOBILE = rs.getString("Mobile");
		
										// array of store data to jtable	
									
										String Data[] = {NAME, EMAIL,ADDRESS, MOBILE};
		                                
		                                model = (DefaultTableModel)table.getModel();
						
						model.addRow(Data);				
										
										
										
										
									}
										
										
							     } catch(Exception e1)
							     {
							    	 System.out.println(e1);
							     }
							        
							}


						
					
					
				 }	);	
	            
	            
	            
	            b2= new JButton("REFRESH TABLE");
	            b2.setBounds(180, 500, 190, 50);
	            p1.add(b2);
	            b2.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
			  		  //refresh
						model.setRowCount(0);
						
					}
					});	   
	            b3= new JButton("MENU");
	            b3.setBounds(380,500, 100, 50);
	            p1.add(b3);
	            b3.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
			  		  
						dispose();
						new home();	
						
					}
					});	   
		   setVisible(true);
		   
	   }
	   

		
	
}
