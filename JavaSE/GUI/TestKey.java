/*
³¢ÊÔKeyEvent
*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TestKey{
	public static void main(String [] args){
		new TFrame("utorrent");
	}
}
class TFrame extends Frame{
	Label l = new Label();
	//TextField t2 = new TextField(10);
	ArrayList <Integer> photo= new ArrayList<Integer>();
	public TFrame(String s){
		super(s);
		setBounds(100,100,500,350);
		setLayout(new FlowLayout());
		add(l);
		//add(t2,BorderLayout.EAST);
		setVisible(true);
		addKeyListener(new KeyMonitor());
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(true);
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics g){
		Iterator <Integer>i = photo.iterator();
		while(i.hasNext()){
			int c = i.next();
			switch(c){
				case 37:{
					g.setColor(Color.RED);
					l.setText("×ó");
					g.fillOval(50,50,10,10);
					break;
				}
				case 39:{
					g.setColor(Color.BLUE);
					g.fillOval(150,150,10,10);
					l.setText("ÓÒ");
					break;
				}default:{
					g.setColor(Color.GREEN);
					g.fillOval(50,150,10,10);
					l.setText("Error!");
				}
			}	
		}
	}
	
	class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int c = e.getKeyCode();
			photo.add(c);
			repaint();
		}
	}
}