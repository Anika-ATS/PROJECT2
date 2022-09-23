package regiform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class userArea extends JFrame{
	Font fn;
	JPanel p1, p2;
	JLabel L1 ,L2,L3,imgLable;
	ImageIcon img;
	JButton b1,b2;

	JComboBox cb1,cb2,cb3;
	String[] ppl= {"Senior Citizen", "Person who have not family","weak/Financially incapable"};
	String[] facilities= {"Building","Cafe","Doctor Corner","Guest Meet","Park"};
    String[] program= {"Monthly free checkup","Annual fitness checkup","Foundation day","Friday special cultural event"};
	userArea()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,200,600,350);
		setLayout(null);
		setTitle("Welcome to SweetHome");
		

		img =new ImageIcon(getClass().getResource("ni.jpg"));
		imgLable=new JLabel(img);
		imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		add(imgLable);
		
		
		p1= new JPanel();
		p1.setBounds(0,0,600,350);
		p1.setLayout(null);
		p1.setBackground(Color.black);//255,102,0,,171,189,196..112,115,0
		add(p1);
		
		L1= new JLabel("List of who can be a part of this family:");
		L1.setBounds(180,20,300,20);
		  L1.setForeground(Color.WHITE);
		  L1.setFont(fn);		  
		  p1.add(L1);
		
		cb1= new JComboBox(ppl);
		cb1.setBounds(180, 50, 250, 30);
		p1.add(cb1);
	
		//facilities list
		L2= new JLabel("List of Facilities:");
		L2.setBounds(180,100,300,20);
		L2.setForeground(Color.WHITE);
		 L2.setFont(fn);		  
		  p1.add(L2);
		
		cb2= new JComboBox(facilities);
		cb2.setBounds(180, 130, 250, 30);
		p1.add(cb2);
		
		L3= new JLabel("List of Program:");
		L3.setBounds(180,170,300,20);
		L3.setForeground(Color.WHITE);
		 L3.setFont(fn);		  
		  p1.add(L3);
		
		cb3= new JComboBox(program);
		cb3.setBounds(180, 200, 250, 30);
		p1.add(cb3);
		
		b1= new JButton("LOGOUT");
		  b1.setBounds(0,270,180,40);
		  p1.add(b1);
		  b1.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				dispose();
				new welcome();
				}
				});
	//for apply to reserve a seat
		  
		  b2= new JButton("Apply");
		  b2.setBounds(400,270,180,40);
		  p1.add(b2);
		  b2.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				 dispose();
				 new applyform();
				}
				});
		

		
		setVisible(true);
		
		
		
		
		
	}
	


}
