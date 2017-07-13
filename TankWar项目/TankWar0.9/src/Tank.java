import java.awt.*;
import java.awt.event.*;

public class Tank {
	public static final int xPress = 5;
	public static final int yPress = 5;
	private int x, y;
	private boolean bL = false, bR = false, bU = false, bD = false;

	private enum Driection {
		L, R, U, D, LU, LD, RU, RD, Stop
	};

	private Driection dir = Driection.Stop;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		move();
	}

	public void keyPressed(int key) {
		switch (key) {
		case KeyEvent.VK_A: {
			bL = true;
			break;
		}
		case KeyEvent.VK_D: {
			bR = true;
			break;
		}
		case KeyEvent.VK_W: {
			bU = true;
			break;
		}
		case KeyEvent.VK_S: {
			bD = true;
			break;
		}
		}
		locationDriection();

	}

	private void locationDriection() {
		if (bL && !bR && !bU && !bD) {
			dir = Driection.L;
		} else if (!bL && bR && !bU && !bD) {
			dir = Driection.R;
		} else if (!bL && !bR && bU && !bD) {
			dir = Driection.U;
		} else if (!bL && !bR && !bU && bD) {
			dir = Driection.D;
		} else if (bL && !bR && bU && !bD) {
			dir = Driection.LU;
		} else if (bL && !bR && !bU && bD) {
			dir = Driection.LD;
		} else if (!bL && bR && bU && !bD) {
			dir = Driection.RU;
		} else if (!bL && bR && !bU && bD) {
			dir = Driection.RD;
		} else if (!bL && !bR && !bU && !bD) {
			dir = Driection.Stop;
		}
	}

	private void move() {
		switch (dir) {
		case L: {
			x -= xPress;
			break;
		}
		case R: {
			x += xPress;
			break;
		}
		case U: {
			y -= yPress;
			break;
		}
		case D: {
			y += yPress;
			break;
		}
		case LU: {
			x -= xPress;
			y -= yPress;
			break;
		}
		case LD: {
			x -= xPress;
			y += yPress;
			break;
		}
		case RU: {
			x += xPress;
			y -= yPress;
			break;
		}
		case RD: {
			x += xPress;
			y += yPress;
			break;
		}
		case Stop: {
			break;
		}
		}
	}

	public void keyReleased(int key) {
		switch (key) {
		case KeyEvent.VK_A: {
			bL = false;
			break;
		}
		case KeyEvent.VK_D: {
			bR = false;
			break;
		}
		case KeyEvent.VK_W: {
			bU = false;
			break;
		}
		case KeyEvent.VK_S: {
			bD = false;
			break;
		}
		}
		locationDriection();

	}
}
