/*
关于CenterPanel的小练习
*/
import java.awt.*;
public class CenterPanel{
	public static void main(String [] args){
		Frame1 f = new Frame1("FrameWithPanel",100,100,400,400);
		
	}
	
}

class Frame1 extends Frame{
	public Frame1(String s,int x,int y,int w,int h){
		super(s);
		setBackground(Color.BLUE);
		super.setBounds(x,y,w,h);
		setLayout(null);
		Panel p = new Panel(null);
		p.setBounds(w/4,h/4,w/2,h/2);
		p.setBackground(Color.yellow);
		add(p);
		setVisible(true);
	}
}