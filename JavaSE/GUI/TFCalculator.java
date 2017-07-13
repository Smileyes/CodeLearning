/*
用内部类实现计算器功能
*/
import java.awt.*;
import java.awt.event.*;
public class TFCalculator{
	public static void main(String [] args){
		new TFrame().frameLaunch();
	}
}

class TFrame extends Frame{
	TextField num1 = new TextField(10);
	TextField num2 = new TextField(10);
	TextField num3 = new TextField(20);
	public void frameLaunch(){
		Label plus = new Label("+");
		Button b=  new Button("=");
		setLayout(new FlowLayout());
		add(num1);
		add(plus);
		add(num2);
		add(b);
		add(num3);
		pack();
		setVisible(true);
		NumMonitor m = new NumMonitor();
		b.addActionListener(m);
		setTitle("计算器");
	}
	
	class NumMonitor implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int n1 = Integer.parseInt(num1.getText());
			int n2 = Integer.parseInt(num2.getText());
			num3.setText("" + (n1 + n2));
		}
	}
}

