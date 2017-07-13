import java.awt.*;
import java.awt.event.*;

public class Tank {
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	private int x, y;
	private boolean bL = false, bR = false, bU = false, bD = false;
	private TankClient tc = null;

	public enum Driection {
		L, R, U, D, LU, LD, RU, RD, Stop
	};

	private Driection dir = Driection.Stop;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Tank(int x, int y, TankClient tc) {
		this(x, y);
		this.tc = tc;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH, HEIGHT);
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
		case KeyEvent.VK_K: {
			fire(tc);
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
			x -= xSpeed;
			break;
		}
		case R: {
			x += xSpeed;
			break;
		}
		case U: {
			y -= ySpeed;
			break;
		}
		case D: {
			y += ySpeed;
			break;
		}
		case LU: {
			x -= xSpeed;
			y -= ySpeed;
			break;
		}
		case LD: {
			x -= xSpeed;
			y += ySpeed;
			break;
		}
		case RU: {
			x += xSpeed;
			y -= ySpeed;
			break;
		}
		case RD: {
			x += xSpeed;
			y += ySpeed;
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

	public void fire(TankClient tk) {
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, dir);
		tc.m = m;
	}
}
