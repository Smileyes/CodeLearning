import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TankClient().launchFrame();
	}

	private void launchFrame() {
		setTitle("TankWar");
		this.setVisible(true);
		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}

}
