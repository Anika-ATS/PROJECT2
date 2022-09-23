package regiform;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class park extends JFrame {

	JPanel p1,p2;
	JLabel imgLable,titleL;
     JButton b1;
    Font fn;
    ImageIcon img;

   //costructor
    
    park()
	{
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,10,1020,750);
		setLayout(null);
		setTitle("WELCOME");
		
		fn= new Font("Arial", Font.BOLD,18);
		p1= new JPanel();
		p1.setBounds(0,0, 1020, 50);
		p1.setLayout(null);
		p1.setBackground(Color.BLACK);
		add(p1);
		
		  titleL= new JLabel("  REFRESHMENT CORNER");
		  titleL.setBounds(400,10,250,30);
		  titleL.setFont(fn);
		  titleL.setOpaque(true);
		  titleL.setBackground(Color.WHITE);
		  titleL.setForeground(new Color(255,102,0));
		  p1.add(titleL);
		  
		  b1= new JButton("MENU");
          b1.setBounds(10,0, 250, 30);
          
          p1.add(b1);
          b1.addActionListener(new ActionListener()
			 
			 {
				@Override
				public void actionPerformed(ActionEvent e) {
		  		  
					dispose();
					new home();	
					
				}
				});	     
          

		p2= new JPanel();
		p2.setBounds(0,50,1020,700);
		p2.setLayout(null);
		p2.setBackground(Color.BLACK);//255,102,0,,171,189,196..112,115,0
		add(p2);
		
		img =new ImageIcon(getClass().getResource("p2.jpg"));
		imgLable=new JLabel(img);
		imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		p2.add(imgLable);
		
		setVisible(true);
		
		
	}
	
	

}
