package varun;

import java.awt.*;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;

public class MusicAniGui  extends JPanel implements ControllerEventListener {
	JFrame win;
	
	void window()
	{
	    win= new JFrame("music video");
		win.setVisible(true);
		win.setSize(600,400);
		win.setLocation(200,110);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dp.setSize(500,300);
		win.getContentPane().add(this);
	}
	
	@Override
	public void controlChange(ShortMessage event) {
		// TODO Auto-generated method stub
		System.out.println("sa ra ge ma ");
		repaint();
	}
	 public void paintComponent(Graphics g)
		{
			int r,b,gr,x,y,h,w;
			r=(int)(Math.random()*255);
			b=(int)(Math.random()*255);
			gr=(int)(Math.random()*255);
			Color c= new Color(r,b,gr);
			g.setColor(c);
			x=(int)((Math.random()*300)+100);
			y=(int)((Math.random()*300)+100);
			h=(int)((Math.random()*145)+10);
			w=(int)((Math.random()*145)+10);
			g.fillRect(x, y, w, h);
			System.out.println("lol");
	
		}
	
	
}
