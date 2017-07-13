package com.baidu.tieba;
import java.awt.*;
import java.awt.event.*;
public class MyFrame extends Frame {

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(50, 50, 50, 50);
	}
	
	public void launchFrame(){
		setBounds(400,400,300,300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}
	
	public static void main(String [] args){
		new MyFrame().launchFrame();
	}
	
}
 