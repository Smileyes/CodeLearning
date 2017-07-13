import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMenu {
	private static JFrame frame = new JFrame("记事本");
	private static FileDialog fd = new FileDialog(frame, "请打开文件",
			FileDialog.LOAD);

	public static void main(String[] args) {

		JScrollPane jsPanel = new JScrollPane();
		JTextArea text = new JTextArea(15,15);
		text.setLineWrap(true);
		JMenuBar bar = new JMenuBar();
		frame.add(bar, BorderLayout.NORTH);
		JMenu fileMenu = new JMenu("打开");
		JMenu test = new JMenu("测试");
		JMenuItem openMenu = new JMenuItem("打开文件");
		openMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fd.setVisible(true);
			}
		});
		bar.add(fileMenu);
		fileMenu.add(openMenu);
		fileMenu.add(test);
		JMenuItem ok = new JMenuItem("复合菜单");
		test.add(ok);
		frame.setVisible(true);
		jsPanel.add(text);
/*		frame.add(text);*/
		frame.add(jsPanel);
		frame.pack();
	}
}
