import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMenu {
	private static JFrame frame = new JFrame("���±�");
	private static FileDialog fd = new FileDialog(frame, "����ļ�",
			FileDialog.LOAD);

	public static void main(String[] args) {

		JScrollPane jsPanel = new JScrollPane();
		JTextArea text = new JTextArea(15,15);
		text.setLineWrap(true);
		JMenuBar bar = new JMenuBar();
		frame.add(bar, BorderLayout.NORTH);
		JMenu fileMenu = new JMenu("��");
		JMenu test = new JMenu("����");
		JMenuItem openMenu = new JMenuItem("���ļ�");
		openMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fd.setVisible(true);
			}
		});
		bar.add(fileMenu);
		fileMenu.add(openMenu);
		fileMenu.add(test);
		JMenuItem ok = new JMenuItem("���ϲ˵�");
		test.add(ok);
		frame.setVisible(true);
		jsPanel.add(text);
/*		frame.add(text);*/
		frame.add(jsPanel);
		frame.pack();
	}
}
