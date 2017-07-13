/*
按照要求显示十个Button
*/
import java.awt.*;
public class TenButtons{
	public static void main(String [] args){
		Frame f = new Frame("Java Frame");
		f.setLayout(new GridLayout(2,1));
		Panel p1 = new Panel(new BorderLayout());
		p1.add(new Button("Button"),BorderLayout.EAST);
		p1.add(new Button("Button"),BorderLayout.WEST);
		Panel pp1 = new Panel(new GridLayout(2,1));
		pp1.add(new Button("Button"));
		pp1.add(new Button("Button"));
		p1.add(pp1,BorderLayout.CENTER);
		f.add(p1);
		Panel p2 = new Panel(new BorderLayout());
		p2.add(new Button("Butoon"),BorderLayout.EAST);
		p2.add(new Button("Button"),BorderLayout.WEST);
		Panel pp2 = new Panel(new GridLayout(2,2));
		for(int i = 0;i<4;i++){
			pp2.add(new Button("Button"));
		}
		p2.add(pp2,BorderLayout.CENTER);
		f.add(p2);
		f.pack();
		f.setVisible(true);

	}
}