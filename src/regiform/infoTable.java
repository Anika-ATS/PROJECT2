package regiform;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class infoTable extends JFrame implements ActionListener{
	
	private static final String DefaultTableModel = null;
	JTable table;
	JScrollPane scroll;
	DefaultTableModel model; // it is help to create a table without column and row
	JTextField t1, t2, t3, t4; //text field name with serial
	JButton b1,b2,b3,b4,b5,b6,b7;//add, update, delete, clear,Refresh,Back,save;
	JPanel p1;
	JLabel l1,l2,l3,l4;
	String Room, Name,Phone, Payment;

	
	
	infoTable()
	 {
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    setBounds(200,50,650,600);
			setLayout(null);
			setTitle("InfoCorner");
			
			
			p1= new JPanel();
			p1.setBounds(0, 0, 650, 600);
			p1.setLayout(null);
			p1.setBackground( Color.black);//new Color(255,102,0)
			add(p1);
			
		// all label and txtfield
			
	    	l1= new JLabel("Room:");
			l1.setBounds(10,10,50,50);
			l1.setForeground(Color.white);
			//l1.setLayout(null);
			p1.add(l1);
			
			t1= new JTextField(""); 
			t1.setBounds(90,20,200,30);			  
			p1.add(t1);  
			 
			 
			l2= new JLabel("Name:");
			l2.setBounds(10,70,50,50);
			l2.setForeground(Color.white);
			p1.add(l2);
			
			t2= new JTextField(""); 
			t2.setBounds(90,80,200,30);			  
			p1.add(t2);  
			 
			l3= new JLabel(" Phone:");
			l3.setBounds(10,130,50,50);
			l3.setForeground(Color.white);
			p1.add(l3);
			
			t3= new JTextField(""); 
			t3.setBounds(90,140,200,30);			  
			p1.add( t3);  
			 
			l4= new JLabel(" Payment:");
			l4.setBounds(10,200,100,50);
			l4.setForeground(Color.white);
			p1.add(l4);
			
			t4= new JTextField(""); 
			t4.setBounds(90,210,200,30);			  
			p1.add(t4);  
			 
			 
			//buttons,Refresh,Back
			 
			  b1= new JButton("ADD");
              b1.setBounds(350, 20, 100, 50);
              p1.add(b1);
              b1.addActionListener(this);
              
              b2= new JButton("UPDATE");
              b2.setBounds(350, 80, 100, 50);
              p1.add(b2);
              b2.addActionListener(this);
              
              b3= new JButton("DELETE");
              b3.setBounds(350, 140, 100, 50);
              p1.add(b3);
              b3.addActionListener(this);
              
              b4= new JButton("CLEAR");
              b4.setBounds(480, 140, 150, 50);
              p1.add(b4);
              b4.addActionListener(this);
              
              b5= new JButton("REFRESH TABLE");
              b5.setBounds(350, 210, 280, 50);
              p1.add(b5);
              b5.addActionListener(this);
                      
              b6= new JButton("MENU");
              b6.setBounds(480, 80, 150, 50);
              p1.add(b6);
              b6.addActionListener(this);
              
              b7= new JButton("SHOW DATA");
              b7.setBounds(480, 20, 150, 50);
              p1.add(b7);
              b7.addActionListener(this);
              
              
              
              
   //jtable 
              String[] columns= {"Room", "Name"," Phone", "Payment"};
            	String[][] rows = {};
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
    	      scroll.setBounds(10, 300, 500, 230);
    	      p1.add(scroll);     
              
 //mouselistener
    	      
    	      //String Room, Name,Phone, Payment;
    	      table.addMouseListener(new MouseAdapter() {
    	    	  
    	    	  public void mouseClicked(MouseEvent me) {
    	    		  int NumOfRow=table.getSelectedRow(); 
    	    		  
    	    		  Room=(String)model.getValueAt(NumOfRow, 0);
    	    		  t1.setText(Room);	    		 
    	    		  Name= model.getValueAt(NumOfRow, 1).toString();
    	    		  t2.setText(Name);
    	    		  Phone=model.getValueAt(NumOfRow, 2).toString();
    	    		  t3.setText(Phone);
    	    		  Payment=model.getValueAt(NumOfRow, 3).toString();
    	       		  t4.setText(Payment);
    	    	  }
    	    	  
    	      });   
    	      
    	      setVisible(true);
	 }            

      
 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Room, Name, Phone, Payment
	
		if(e.getSource()==b1)  //addbutton 
		{
			String Room=t1.getText();
			String Name=t2.getText();
			String Phone=t3.getText();
			String Payment=t4.getText();
			
			
			
			String RoomRegex="[A-Z]+";
		
			String NameRegex = "[a-zA-Z]+";
			
			String PhoneRegex="(\\+88)?-?01[3-9]\\d{8}+";
			String PaymentRegex="\\d{4}+";
			

			
			if(!Pattern.matches(RoomRegex,Room))
			{
				
				JOptionPane.showMessageDialog(null, "Correct your Room no");	
				
			}
			
			else if(!Pattern.matches(NameRegex,Name))
			{
				
				JOptionPane.showMessageDialog(null, "Correct your Name");	
				
			}
			else if(!Pattern.matches(PhoneRegex,Phone))
			{
				
				JOptionPane.showMessageDialog(null, "Correct your phonenumber");	
				
			}
			
			else if(!Pattern.matches(PaymentRegex,Payment))
			{
				
				JOptionPane.showMessageDialog(null, "Put Again Payment Number");	
				
			}
			
			else 
			{
				
				//Querry                                                                           //Room, Name, Phone, Payment
				String insertQuery="INSERT INTO `senior`(`Room`, `Name`, `Phone`, `Payment`) VALUES ('"+Room+"','"+Name+"','"+Phone+"','"+Payment+"')";
				dbConnect3 db= new dbConnect3();
				
			    db.SaveInsert3(insertQuery);
				
			}
			
	
		}	
		
		
		
		else if(e.getSource()==b2) //updatebtn
		{
			
  		  
  		    Room=t1.getText();		  
  	      	Name=t2.getText();
  		    Phone=t3.getText();
  		    Payment=t4.getText();
  		  
  		int NumOfRow=table.getSelectedRow(); 
		  
  		model.setValueAt(Room,NumOfRow,0);
		model.setValueAt(Name,NumOfRow,1);
		model.setValueAt(Phone,NumOfRow,2);
		model.setValueAt(Payment,NumOfRow,3);
		  
			
			
		}
		
		else if(e.getSource()==b3)  //dltbtn
		{
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
		else if(e.getSource()==b4) //clearbtn
		{
			t1.setText(""); 
			t2.setText("");  
			t3.setText("");  
			t4.setText(""); 
		}
		else if(e.getSource()==b5)
		{
			//Refreshbtn
			model.setRowCount(0);
		}
		
		else if(e.getSource()==b6)
		{
			//menubtn
			
			dispose();
			new home();
		}
		
	
		
		
		else if(e.getSource()==b7)
		{
	     	Connection con;
			Statement st;
			
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root","");
					 								
			       	st= con.createStatement();
					 String sql1="select* from senior";
					
					 ResultSet rs1 = st.executeQuery(sql1);
					 
						while(rs1.next()) {
											
						String	 Room = rs1.getString("Room");   //"Room" is a column name
						String	 Name = rs1.getString("Name");
						String	 Phone = rs1.getString("Phone");
						String	 Payment = rs1.getString("Payment");
						
							// array of store data to jtable	
						
							String rows[] = {Room, Name,Phone, Payment,};
                            
                            model = (DefaultTableModel)table.getModel();
			
		                	model.addRow(rows);				
						
						}
							
							
				     } catch(Exception e1)
				     {
				    	 System.out.println(e1);
				     }
				        
				}
				
	}
			



}
