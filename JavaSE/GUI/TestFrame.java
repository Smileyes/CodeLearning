/*
用于实现Frame的基本功能
*/

import java.awt.*;

public class TestFrame{
	public static void main(String [] args){
		Frame f = new Frame("uTorrent");
		myPanel(f,100,100);

	}
	public static void myPanel(Frame f,int w,int h){
		f.setBounds(50,50,w,h);
		f.setBackground(Color.GRAY);
		f.setLayout(null);
		Panel p1 = new Panel(null);
		Panel p2 = new Panel(null);
		Panel p3 = new Panel(null);
		Panel p4 = new Panel(null);
		p1.setBounds(0,0,w/2,h/2);
		p2.setBounds(w/2,0,w/2,h/2);
		p3.setBounds(0,h/2,w/2,h/2);
		p4.setBounds(w/2,h/2,w/2,h/2);	
		p1.setBackground(Color.green);
		p2.setBackground(Color.RED);
		p3.setBackground(Color.yellow);
		p4.setBackground(Color.BLUE);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.setVisible(true);
	}
}