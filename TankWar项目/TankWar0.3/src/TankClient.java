import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TankClient().launchFrame();
	}

	private void launchFrame() {
		setTitle("TankWar");
		this.setVisible(true);
		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}

}
