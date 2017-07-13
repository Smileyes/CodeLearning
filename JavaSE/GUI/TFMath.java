/*
在两个输入框输入数据，在第三个输入框得出两数之和
*/
import java.awt.*;
import java.awt.event.*;

public class TFMath{
	public static void main(String [] args){
		new TFFrame("计算器");
	}
}

class TFFrame extends Frame{
	TextField num1 = new TextField(10);
	TextField num2 = new TextField(10);
	TextField num3 = new TextField(15);
	public TFFrame(String s){
		super(s);
		setBackground(Color.GRAY);
		Label l = new Label("+");
		Button b = new Button("=");
		setLayout(new FlowLayout());
		add(num1);
		add(l);
		add(num2);
		add(b);
		add(num3);
		setVisible(true);
		pack();
		b.addActionListener(new Mox());
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}	
		class Mox implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int n = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
				num3.setText(""+n);
			}
		}
		
}
