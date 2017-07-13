import java.awt.FileDialog;

import javax.swing.*;

public class TestJFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("uTorrent");
		frame.setVisible(true);
		frame.setBounds(100,100,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(frame, "欢迎登录", "QQ",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(frame, "您已被禁用", "QQ",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(frame, "网络连接中断", "QQ",JOptionPane.WARNING_MESSAGE);
		String s = JOptionPane.showInputDialog(frame, "请输入");
		System.out.println(s);
		int i = JOptionPane.showConfirmDialog(frame, "您确认卸载吗？");
		System.out.println(i);
		FileDialog dialog = new FileDialog(frame,"uTorrent",FileDialog.LOAD);
		dialog.setVisible(true);
		FileDialog fd= new FileDialog(frame,"uTorrent",FileDialog.SAVE);
		fd.setVisible(true);
	}

}
