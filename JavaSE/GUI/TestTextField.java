/*
 ‰»ÎøÚ
*/

import java.awt.*;
import java.awt.event.*;

public class TestTextField{
	public static void main(String [] args){	
		Frame f = new Frame("uTorrent");
		TextField tf = new TextField();
		TextField t = new TextField();
		f.setLayout(new GridLayout(2,1));
		f.add(tf);
		f.add(t);
		TextMonitor m = new TextMonitor();
		t.setEchoChar('*');
		t.addActionListener(m);
		tf.addActionListener(m);
		f.pack();
		f.setVisible(true);
	}
}

class TextMonitor implements ActionListener{
	public void actionPerformed(ActionEvent e){
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}