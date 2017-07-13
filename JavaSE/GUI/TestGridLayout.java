/*
 ≤‚ ‘GridLayout
*/
 import java.awt.*;
 public class TestGridLayout{
 	public static void main(String [] args){
 		Frame f = new Frame("uTorrent");
 		f.setLayout(new GridLayout(3,3));
 		for(int i = 0;i<6;i++) {
 			String  s = "Button" + i;
 			f.add(new Button(s));
 		}
 		//f.pack();
 		f.setVisible(true);
 	}
 }