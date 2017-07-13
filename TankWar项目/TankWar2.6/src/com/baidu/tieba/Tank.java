package com.baidu.tieba;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank {
	private static Random r = new Random();
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
	private int step = r.nextInt(12) + 3;
	private int oldX;
	private int oldY;
	private int life = 1;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isGood() {
		return good;
	}

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
		this.oldX = x;
		this.oldY = y;
	}

	public Tank(int x, int y, boolean good, Tank.Driection dir, TankClient tc) {
		this(x, y, good);
		this.tc = tc;
		this.dir = dir;
	}

	public void draw(Graphics g) {
		if (!bAlive) {
			if (!good) {
				tc.enemyTank.remove(this);
			}
			return;
		}
		Color c = g.getColor();
		if (good)
			g.setColor(Color.red);
		else
			g.setColor(Color.BLUE);
		move();
		if (this.hitWall(tc.w1) || this.hitWall(tc.w2) || this.hitWall(tc.w3)) {
			stay();
		}
		this.hitTanks(tc.enemyTank);
		if (good) {
			new BloodBar().draw(g);
		}
		g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);
		g.setColor(Color.BLACK);
		showPt(g);
		g.setColor(c);
		if (!good) {
			if (step == 0)
				act();
			step--;
			if (r.nextInt(40) > 38)
				this.fire();
		}

	}

	private void act() {
		Driection[] dirs = Driection.values();
		int rn = r.nextInt(dirs.length);
		this.dir = dirs[rn];
		step = r.nextInt(12) + 3;
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
		oldX = x;
		oldY = y;
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
			fire();
			break;
		}
		case KeyEvent.VK_F2: {
			if (!tc.myTank.isbAlive()) {
				tc.myTank.setbAlive(true);
				tc.makeNewTank();
				tc.myTank.tc.setLife(3);

			}
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
		case KeyEvent.VK_J: {
			superFire();
			break;
		}
		}
		locationDriection();

	}

	public void fire() {
		if (bAlive == false)
			return;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, ptDir, good, tc);
		tc.missile.add(m);
	}

	public void fire(Driection dir) {
		if (bAlive == false)
			return;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
		Missile m = new Missile(x, y, dir, good, tc);
		tc.missile.add(m);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
/**
 * 
 * @param w：被撞的墙
 * @return被撞为true,否则为false
 */
	private boolean hitWall(Wall w) {
		return this.getRect().intersects(w.getRect());
	}

	public boolean hitTank(Tank t) {
		if ((this.getRect().intersects(t.getRect())) && (t.isbAlive())) {
			if (this.good != t.isGood()) {
				Explode e = new Explode(x, y, tc);
				tc.explode.add(e);
				t.bAlive = false;
				this.bAlive = false;
				tc.enemyTank.remove(this);
				tc.setLife(tc.getLife() - 1);
				if (tc.getLife() > 0) {
					tc.makeNewTank();
				}
				return true;
			} else {
				stay();
				return false;
			}
		} else
			return false;
	}

	private void hitTanks(ArrayList<Tank> enemyTank) {
		for (int i = 0; i < enemyTank.size(); i++) {
			Tank t = enemyTank.get(i);
			if (this != t && this.hitTank(t)) {
				stay();
			}
		}

	}

	private void stay() {
		x = oldX;
		y = oldY;
	}

	private void superFire() {
		Driection[] dirs = Driection.values();
		for (int i = 0; i < dirs.length - 1; i++) {
			fire(dirs[i]);
		}
	}

	private class BloodBar {
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.GRAY);
			if (tc.getLife() <= 3)
				g.drawRect(x, y - 10, WIDTH, 10);
			else
				g.drawRect(x, y - 10, (int) (WIDTH / 3.0 * tc.getLife()), 10);
			g.setColor(Color.ORANGE);
			g.fillRect(x, y - 10, (int) (WIDTH * tc.getLife() / 3.0), 10);
			g.setColor(c);
		}
	}
}
