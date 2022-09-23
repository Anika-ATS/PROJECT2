package regiform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class welcome extends JFrame implements ActionListener{
	JPanel p1,p2;
	JLabel imgLable,L1,L2,L3,L4 ,L5,titleL;
    JButton b1;
    Font fn;
    ImageIcon img;
	welcome()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,30,1000,650);
		setLayout(null);
		setTitle("WELCOME");
		
		fn= new Font("Arial", Font.BOLD,18);
		p1= new JPanel();
		p1.setBounds(0,0, 1000, 70);
		p1.setLayout(null);
		p1.setBackground(Color.BLACK);
		add(p1);
		
		  titleL= new JLabel(" OLD AGE HOME MANAGEMENT ");
		  titleL.setBounds(300,10,300,50);
		  titleL.setFont(fn);
		  titleL.setOpaque(true);
		  titleL.setBackground(Color.WHITE);
		  titleL.setForeground(new Color(255,102,0));
		  p1.add(titleL);
		

		p2= new JPanel();
		p2.setBounds(0,70,1000,570);
		p2.setLayout(null);
		p2.setBackground(Color.BLACK);//255,102,0,,171,189,196..112,115,0
		add(p2);
		
		img =new ImageIcon(getClass().getResource("old2.1.png"));
		imgLable=new JLabel(img);
		imgLable.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		p2.add(imgLable);
		

		
		  L1= new JLabel("LET'S");
		  L1.setBounds(850,80,80,50);
		  L1.setFont(fn);
		  L1.setForeground(new Color(255,102,0));
		  p2.add(L1);
				
		  L2= new JLabel("START");
		  L2.setBounds(870,120,90,50);
		  L2.setFont(fn);
		  L2.setForeground(Color.WHITE);
		  p2.add(L2);
		  
		  L5= new JLabel("A");
		  L5.setBounds(900,150,80,50);
		  L5.setFont(fn);
		  L5.setForeground(new Color(255,102,0));
		  p2.add(L5);
		  
		  
		  L3= new JLabel("NEW");
		  L3.setBounds(850,180,80,50);
		  L3.setFont(fn);
		  L3.setForeground(Color.WHITE);
		  p2.add(L3);
		   
		  L4= new JLabel("MEMORY");
		  L4.setBounds(880,220,90,50);
		  L4.setFont(fn);
		  L4.setForeground(new Color(255,102,0));
		  p2.add(L4);
		  
	 
		  b1=new JButton("START");
		  b1.setBounds(850, 400, 120,50);
		  p2.add(b1);
		  b1.addActionListener(this);
				  
		  setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) 
		{
			dispose();
			new formLogin();
			
		}
	}
	
	

}
