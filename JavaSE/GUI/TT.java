/*
����ActioEvent
*/

import java.awt.*;
import java.awt.event.*;

public class TT{
	public static void main(String [] args){
		Frame f = new Frame("uTorrent");
		f.setLayout(new GridLayout(2,1));
		Button b = new Button("��ʼ");
		Button c = new Button("����");
		c.setActionCommand("END");
		f.add(b);
		f.add(c);
		Monitor m = new Monitor();
		b.addActionListener(m);
		c.addActionListener(m);
		f.setVisible(true);
		f.pack();
		f.setLayout(null);
	}
}

class Monitor implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("���"+e.getActionCommand()+"һ��");
	}
}