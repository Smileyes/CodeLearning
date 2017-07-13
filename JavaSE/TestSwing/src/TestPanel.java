import java.awt.*;

import javax.swing.*;

public class TestPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("QQ");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		frame.add(p1);
		frame.add(p2);
		p1.setLayout(new GridLayout(2, 1));
		JPanel p11 = new JPanel();
		JPanel p12 = new JPanel();
		p1.add(p11);
		p1.add(p12);
		JLabel lable = new JLabel("用户名");
		p11.add(lable);
		JTextField textField = new JTextField(10);
		p11.add(textField);
		JLabel lable2 = new JLabel("密码");
		p11.add(lable2);
		JPasswordField jpf = new JPasswordField(15);
		p11.add(jpf);
		JButton jb = new JButton("登录");
		p11.add(jb);
		JLabel l2 = new JLabel("性别");
		p12.add(l2);
		JRadioButton man = new JRadioButton("男", true);
		JRadioButton woman = new JRadioButton("女");
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		p12.add(man);
		p12.add(woman);
		JLabel cityLabel = new JLabel("城市");
		p12.add(cityLabel);
		String [] arr = {"北京" ,"上海" ," 广州"};
		JComboBox <String> jcb = new JComboBox<String>(arr);
		p12.add(jcb);
		JLabel l4 = new JLabel("爱好");
		p12.add(l4);
		JCheckBox j1 = new JCheckBox("Java",true);
		JCheckBox j2 = new JCheckBox("Python");
		JCheckBox j3 = new JCheckBox("MySQL");
		JCheckBox j4 = new JCheckBox("Oracle");
		p12.add(j1);
		p12.add(j2);
		p12.add(j3);
		p12.add(j4);
		JLabel express = new JLabel("个人介绍");
		p2.add(express,BorderLayout.WEST);
		JTextArea txt = new JTextArea(5,40);
		txt.setLineWrap(true);
		p2.add(txt);
		frame.setResizable(false);
		frame.pack();
	}

}
