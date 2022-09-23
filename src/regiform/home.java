package regiform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class home extends JFrame {
    
	//JFrame ff;
	Font fn;
	JPanel p1, p2;
	JLabel L1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;//Information Table,Staff List,Cafe,Doctor Corner,Guest Information,park,Back
	home(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,50,500,600);
		setLayout(null);
		setTitle("SweetHome");
	//	setVisible(true);
		
		
		fn= new Font("Arial", Font.BOLD,16);
		
		p1= new JPanel();
		p1.setBounds(0, 0, 500, 50);
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);
		add(p1);
		
		  L1= new JLabel("Old Age Home Management");
		  L1.setBounds(140,0,400,50);
		  L1.setForeground(Color.WHITE);
		  L1.setFont(fn);		  
		  p1.add(L1);
		  
		  p2= new JPanel();
		  p2.setBounds(0, 50, 500, 550);
		  p2.setLayout(null);
		  p2.setBackground( Color.BLACK);
		  add(p2);
		  
		  //buttons(Information Table,Flat List,Cafe,Doctor Corner,Guest Information,Nursery)
		  b1= new JButton("Information Table");
		  b1.setBounds(10,20,200,50);
		  p2.add(b1);
		  b1.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new infoTable();
				}
				});	
		  b2= new JButton(" Staff List");
		  b2.setBounds(200,80,200,50);
		  p2.add(b2);
		  b2.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new StaffList();
				}
				});
		  
		  b3= new JButton("Cafe");
		  b3.setBounds(10,140,200,50);
		  p2.add(b3);
		  b3.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				
				}
				});
		  b4= new JButton("Doctor Corner");
		  b4.setBounds(200,200,200,50);
		  p2.add(b4);
		  b4.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new doctorArea();
				}
				});
		  b5= new JButton("Guest Information");
		  b5.setBounds(10,260,200,50);
		  p2.add(b5);
		  b5.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new guestInformation();
				}
				});
		  b6= new JButton("Park");
		  b6.setBounds(200,320,200,50);
		  p2.add(b6);
		  b6.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new park();
				}
				});
		  
		  b7= new JButton("LOGOUT");
		  b7.setBounds(200,450,200,50);
		  p2.add(b7);
		  b7.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new welcome();
				}
				});
		  
		  b8= new JButton("Apply Information");
		  b8.setBounds(10,380,200,50);
		  p2.add(b8);
		  b8.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
				
					dispose();
					new applyInfo();
					
					
				}
				});
		  
		  setVisible(true);
		  
		  
	}	  
	

}
