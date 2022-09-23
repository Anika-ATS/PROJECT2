package regiform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;



public class doctorArea extends JFrame {
	JPanel p1,p2;
	JLabel imgLable,titleL,l1,l2,l3;
  
    Font fn;
    ImageIcon img;
    JTable table;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JScrollPane scroll;
    JTextField t1,t2,t3;
   
    DefaultTableModel model;
    String Name,Specialist,FreeDay;
    
    
    
	doctorArea()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,30,700,600);
		setLayout(null);
		setTitle("WELCOME");
		
		fn= new Font("Arial", Font.BOLD,18);
		p1= new JPanel();
		p1.setBounds(0,0, 700, 60);
		p1.setLayout(null);
		p1.setBackground(Color.black);
		add(p1);
		
		  titleL= new JLabel("  Visiting Doctor");
		  titleL.setBounds(0,0,150,60);
		  titleL.setFont(fn);
		  titleL.setOpaque(true);
	
		  titleL.setBackground(Color.black);
		  titleL.setForeground(new Color(255,102,0));
		  p1.add(titleL);
		

		p2= new JPanel();
		p2.setBounds(0,60,1000,540);
		p2.setLayout(null);
		p2.setBackground(Color.BLACK);
		add(p2);
		
		img =new ImageIcon(getClass().getResource("ppi.jpg"));
		imgLable=new JLabel(img);
		imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		p2.add(imgLable);
		
		
	//jtable
		String[] columns= {"Name","Specialist","FreeDay"};
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
	      scroll.setBounds(390, 0, 250, 200);
	      p2.add(scroll);
	      
//mouselistener
	      table.addMouseListener(new MouseAdapter() {
	    	  
	    	  public void mouseClicked(MouseEvent me) {
	    //String Name,Specialist,FreeDay;		  
	    		  int NumOfRow=table.getSelectedRow(); 
	    		  
	    		  Name=(String)model.getValueAt(NumOfRow, 0);
	    		  t1.setText(Name);	    		 
	    		  Specialist= model.getValueAt(NumOfRow, 1).toString();
	    		  t2.setText(Specialist);
	    		  FreeDay=model.getValueAt(NumOfRow, 2).toString();
	    		  t3.setText(FreeDay);
	       		  
	    	  }
	    	  
	      });
		
		//txtfield
	      
	        l1= new JLabel("Name:");
			l1.setBounds(390,220,100,50);
			l1.setOpaque(true);
			l1.setForeground(Color.white);
			l1.setBackground(Color.BLACK);
			l1.setFont(fn);
			p2.add(l1);
		
			t1= new JTextField(""); 
			t1.setBounds(490,230,150,30);			  
			p2.add(t1); 
		
			l2= new JLabel("Specialist:");
			l2.setBounds(390,270,100,50);
			l2.setOpaque(true);
			l2.setForeground(Color.white);
			l2.setBackground(Color.BLACK);
			l2.setFont(fn);
			p2.add(l2);
		
			t2= new JTextField(""); 
			t2.setBounds(490,280,150,30);			  
			p2.add(t2); 
		
			l3= new JLabel("FreeDay:");
			l3.setBounds(390,320,100,50);
			l3.setOpaque(true);
			l3.setForeground(Color.white);
			l3.setBackground(Color.BLACK);
			l3.setFont(fn);
			p2.add(l3);
		
			t3= new JTextField(""); 
			t3.setBounds(490,330,150,30);			  
			p2.add(t3); 
		
			  b1= new JButton("SAVE");  //addbtn
	            b1.setBounds(540,390, 100, 50);
	            p2.add(b1);
//	            b1.addActionListener(this);
	            b1.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						 //String Name,Specialist,FreeDay;
					
						Name=t1.getText();
						Specialist=t2.getText();
						FreeDay=t3.getText();

						
					
						String NameRegex = "[a-zA-Z]+";
						String SpecialistRegex = "[a-zA-Z]+";
						String FreeDayRegex = "[a-zA-Z]+";

			
						if(!Pattern.matches(NameRegex,Name))
						{
							
							JOptionPane.showMessageDialog(null, "Correct your Name");	
							
						}
						else if(!Pattern.matches( SpecialistRegex ,Specialist))
						{
							
							JOptionPane.showMessageDialog(null, "Correct your data");	
							
						}
						
						else if(!Pattern.matches(FreeDayRegex,FreeDay))
						{
							
							JOptionPane.showMessageDialog(null, "Put again data");	
							
						}
						
						
						
						
						
						
						else {
						
						String insertQuery	="INSERT INTO  `doctorc`(`Name`, `Specialist`, `Day`)  VALUES ('"+Name+"','"+Specialist+"','"+FreeDay+"')";
						dbConnect3 db= new dbConnect3();
						
					    db.SaveInsert5(insertQuery);
					
						}
					}
					});	
		
		
	            b2= new JButton("ShowData");
	            b2.setBounds(390, 390, 100, 50);
	            p2.add(b2);
	            b2.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						

						
						Connection con;
						Statement st;
						
						 try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","");
								 								
								 st= con.createStatement();
								 String sql="select* from doctorc";
								 ResultSet rs = st.executeQuery(sql);
								
									while(rs.next()) {
										String Name,Specialist,FreeDay;
										 Name = rs.getString("Name");//"Name " is a column name
										 Specialist= rs.getString("Specialist");
										 FreeDay = rs.getString("Day");
										
										// array of store data to jtable	
									
										String Data[] = {Name,Specialist,FreeDay };
		                                
		                                model = (DefaultTableModel)table.getModel();
						
						model.addRow(Data);				
										
										
										
										
									}
										
										
							     } catch(Exception e1)
							     {
							    	 System.out.println(e1);
							     }
							        
							}


						
					
					
				 }	);	
		
	            b4= new JButton("CLEAR");
	            b4.setBounds(460, 450, 100, 50);
	            p2.add(b4);
	            b4.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
						t1.setText("");
						t2.setText("");
						t3.setText("");
						
						
						
					}
					});	
	            b3= new JButton("REFRESH TABLE");
	            b3.setBounds(10, 230, 210, 50);
	            p2.add(b3);
	            b3.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
			  		  //refresh
						model.setRowCount(0);
						
					}
					});	
	            b5= new JButton("MENU");
	            b5.setBounds(10,310, 100, 50);
	            p2.add(b5);
	            b5.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
			  		  
						dispose();
						new home();	
						
					}
					});	     
	            
	            b6= new JButton("Patient Serial");
	            b6.setBounds(10,370, 150, 50);
	            p2.add(b6);
	            b6.addActionListener(new ActionListener()
				 
				 {
					@Override
					public void actionPerformed(ActionEvent e) {
			  		  
//						dispose();
//						not completed.
						
					}
					});	          
	            
	            
	            
		
		
		setVisible(true);
		 
 
		 
		
	}
	

}
