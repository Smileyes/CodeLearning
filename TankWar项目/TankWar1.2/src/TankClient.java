import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {
	public static final int GAME_WIDETH = 800;
	public static final int GAME_HEIGHT = 600;
	Image offScreen = null;
	Tank myTank = new Tank(50, 50, this);
	Missile m = null;

	public void paint(Graphics g) {
		if (m != null) {
			m.draw(g);
		}
		myTank.draw(g);

	}

	public void update(Graphics g) {
		if (offScreen == null) {
			offScreen = this.createImage(GAME_WIDETH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreen.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDETH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreen, 0, 0, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TankClient().launchFrame();
	}

	private void launchFrame() {
		setTitle("TankWar");
		this.setVisible(true);
		this.setBounds(100, 100, GAME_WIDETH, GAME_HEIGHT);
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		new Thread(new move()).start();
	}

	private class move implements Runnable {// 采用线程进行重画

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private class KeyMonitor extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			myTank.keyReleased(key);
		}

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();
			myTank.keyPressed(key);

		}

	}

}
