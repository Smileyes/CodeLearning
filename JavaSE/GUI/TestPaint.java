/*
使用Paint方法
*/

import java.awt.*;
import java.awt.event.*;
public class TestPaint{
	public static void main(String [] args){
		new MyFrame().launchFrame();
	}
}

class MyFrame extends Frame{
	public void launchFrame(){
		setBounds(50,50,100,100);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(25,25,15,15);
		g.setColor(Color.BLUE);
		g.fillRect(50,50,20,30);
		g.drawLine(10,30,10,50);
		g.setColor(c);
	}
}