/*
≤‚ ‘BorderLayout
*/
import java.awt.*;
public class TestBorderLayout{
	public static void main(String [] args){
		Frame f = new Frame("uTorrent");
		f.setSize(100,100);
		f.add(new Button("START"),BorderLayout.CENTER);
		f.setVisible(true);
	}
}