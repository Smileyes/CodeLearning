import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank {
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	private int x, y;
	private boolean bL = false, bR = false, bU = false, bD = false;
	private TankClient tc = null;
	private Driection ptDir = Driection.U;
	private Driection dir = Driection.Stop;
	private boolean good;
	private boolean bAlive = true;

	public boolean isbAlive() {
		return bAlive;
	}

	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}

	public enum Driection {
		L, R, U, D, LU, LD, RU, RD, Stop
	};

	public Tank(int x, int y, boolean good) {
		this.x = x;
		this.y = y;
		this.good = good;
	}

	public Tank(int x, int y, boolean good, TankClient tc) {
		this(x, y, good);
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if (!bAlive) {
			return;
		}
		Color c = g.getColor();
		if (good)
			g.setColor(Color.red);
		else
			g.setColor(Color.BLUE);
		move();
		g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);
		g.setColor(Color.BLACK);
		showPt(g);
		g.setColor(c);

	}

	private void showPt(Graphics g) {
		int ptx = 0, pty = 0;
		switch (ptDir) {
		case L: {
			ptx = x;
			pty = y + Tank.HEIGHT / 2;
			break;
		}
		case R: {
			ptx = x + Tank.WIDTH;
			pty = y + Tank.HEIGHT / 2;
			break;
		}
		case U: {
			ptx = x + Tank.WIDTH / 2;
			pty = y;
			break;
		}
		case D: {
			ptx = x + Tank.WIDTH / 2;
			pty = y + Tank.HEIGHT;
			break;
		}
		case LU: {
			ptx = x;
			pty = y;
			break;
		}
		case LD: {
			ptx = x;
			pty = y + Tank.HEIGHT;
			break;
		}
		case RU: {
			ptx = x + Tank.WIDTH;
			pty = y;
			break;
		}
		case RD: {
			ptx = x + Tank.WIDTH;
			pty = y + Tank.HEIGHT;
			break;
		}
		}
		g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, ptx, pty);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
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
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x > TankClient.GAME_WIDTH - Tank.WIDTH)
			x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if (y > TankClient.GAME_HEIGHT - Tank.WIDTH)
			y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
		if (dir != Driection.Stop) {
			ptDir = dir;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_K: {
			fire(tc);
			break;
		}
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

	public void fire(TankClient tc) {
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, ptDir, tc);
		tc.missile.add(m);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
