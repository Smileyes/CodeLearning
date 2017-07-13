import java.awt.*;
public class TT{
	public static void main(String [] args){
		Frame f = new Frame("123");
		Button a = new Button("Button");
		f.add(a,BorderLayout.WEST);
		a.add(a);
	}
}