/*
”√ Û±Íª≠µ„
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TestPoint{
	public static void main(String [] args){
		new MyFrame("uTorrent");
	}
}

class MyFrame extends Frame{
	ArrayList <Point> points = new ArrayList<Point>();
	public MyFrame(String s){
		super(s);
		this.launch();
	}
	
	public void launch(){
		setBounds(100,100,400,400);
		setBackground(Color.WHITE);
		setVisible(true);
		addMouseListener(new Monitor());
	}
	
	public void paint(Graphics g){
		Iterator <Point>i = points.iterator();
		while(i.hasNext()){
			g.setColor(Color.RED);
			Point p = i.next();
			g.fillOval(p.x,p.y,10,10);
		}
	}
	public void addPoint(Point p){
		points.add(p); 
	}
	
	class Monitor extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			Point p = e.getPoint();
			addPoint(p);
			repaint();
		}
	}
}