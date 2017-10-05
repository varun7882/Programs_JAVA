package varun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Gui1  {
	int cs=1;
	void run() 
	{
		JFrame win1= new JFrame();
		JButton b1= new JButton("b1");
		JButton b2= new JButton("click count");
		JLabel l1= new JLabel("0");
		l1.setSize(100, 350);
		Border padding= BorderFactory.createEmptyBorder(100,50,100,50);
		Border clr= BorderFactory.createLineBorder(Color.BLACK);
		l1.setBorder(BorderFactory.createCompoundBorder(clr,padding));
		
		b1.setBounds(100, 100, 100, 50);
		b2.setSize(100,50);;
	//	win1.setLayout(null);
		b1.setLabel("hello");
		
		win1.setBounds(300, 100, 600, 400);
		win1.setVisible(true);
		win1.setTitle("hola amigos");
		
		win1.getContentPane().add(BorderLayout.SOUTH,b1);
		win1.getContentPane().add(BorderLayout.EAST,b2);
		win1.getContentPane().add(BorderLayout.WEST,l1);
		win1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// int x,y,i;
		
		class innerEventHandler1 implements ActionListener
		{
		 	
		public void actionPerformed(ActionEvent e)
			{
			
		//	JOptionPane.showMessageDialog(win1, f);
			win1.repaint();
			}
		}
		class innerEventHandler2 implements ActionListener
		{
		 	int f=0;
	
		public void actionPerformed(ActionEvent e)
			{
			
					f++;
					l1.setText(""+f);
			}
		}
	
		innerEventHandler1 h1= new innerEventHandler1();
		b1.addActionListener(h1);

		innerEventHandler2 h2= new innerEventHandler2();
		b2.addActionListener(h2);
		 class GraphicsJava extends JPanel {
			int x=10;
			int y=10;
			public void paintComponent(Graphics g)
			{
				Graphics2D g2d= (Graphics2D) g;
				//int x,y;
				g.setColor(Color.DARK_GRAY);
				g.fillRect(0,0, this.getWidth(), this.getHeight());
				int red= (int)(Math.random()*255);
				int blue= (int)(Math.random()*255);
				int green= (int)(Math.random()*255);
				Color sclr= new Color(red,blue,green);
				 red= (int)(Math.random()*255);
				 blue= (int)(Math.random()*255);
				 green= (int)(Math.random()*255);
				Color eclr= new Color(red,blue,green);
				GradientPaint gd= new GradientPaint(10,10, sclr,250,250,eclr);
				g2d.setPaint(gd);
				red= (int)(Math.random()*255);
				 blue= (int)(Math.random()*255);
				 if(cs==1)
				 {
					 x=x+5;
						y=x;
						
					 g2d.fillOval(x, y, 100, 100);
					 if(x==250)
						{
							cs=0;
							
						}
				 }
				 else
				 {
					 x=x-5;
						y=x;
					 g2d.fillOval(y, x, 100, 100);
					 if(x==10)
						{
							cs=1;
							
						}
				 }
				
				
				
			}
			
		}
		 GraphicsJava gj = new GraphicsJava();
		 win1.getContentPane().add(BorderLayout.CENTER,gj);
		while(true)
		{
			
			win1.repaint();
			try{
			Thread.sleep(150);
		}
			catch(Exception ex){}
		}
	
	}
	 
	 
	
}

