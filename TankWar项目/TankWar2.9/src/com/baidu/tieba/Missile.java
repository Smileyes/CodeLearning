package com.baidu.tieba;

import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Missile {
	int x, y;
	Direction dir;
	public static final int xSpeed = 10;
	public static final int ySpeed = 10;
	private boolean bAlive = true;
	private static Map<String, Image> missileImgs = new HashMap<String, Image>();
	private static Image[] imgs = null;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	public static final int WIDTH = new ImageIcon(tk.getImage(Tank.class
			.getClassLoader().getResource("imges/missileU.gif")))
			.getIconWidth();
	public static final int HEIGHT = new ImageIcon(tk.getImage(Tank.class
			.getClassLoader().getResource("imges/missileU.gif")))
			.getIconHeight();
	static {
		imgs = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileL.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileR.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileLU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileLD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileRU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource(
						"imges/missileRD.gif")) };
		missileImgs.put("U", imgs[0]);
		missileImgs.put("D", imgs[1]);
		missileImgs.put("L", imgs[2]);
		missileImgs.put("R", imgs[3]);
		missileImgs.put("LU", imgs[4]);
		missileImgs.put("LD", imgs[5]);
		missileImgs.put("RU", imgs[6]);
		missileImgs.put("RD", imgs[7]);
	}

	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}

	private TankClient tc = null;
	private boolean good;
	private Color color;

	public boolean isGood() {
		return good;
	}

	public Missile(int x, int y, Direction dir, boolean good, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
		this.good = good;
		if (good)
			color = Color.RED;
		else
			color = Color.BLACK;
	}

	public void draw(Graphics g) {
		if (this.hitWall(tc.w1) || this.hitWall(tc.w2) || this.hitWall(tc.w3)) {
			this.bAlive = false;
			tc.missile.remove(this);
			return;
		}
		switch (dir) {
		case L: {
			g.drawImage(missileImgs.get("L"), x, y, null);
			break;
		}
		case R: {
			g.drawImage(missileImgs.get("R"), x, y, null);
			break;
		}
		case U: {
			g.drawImage(missileImgs.get("U"), x, y, null);
			break;
		}
		case D: {
			g.drawImage(missileImgs.get("D"), x, y, null);
			break;
		}
		case LU: {
			g.drawImage(missileImgs.get("LU"), x, y, null);
			break;
		}
		case LD: {
			g.drawImage(missileImgs.get("LD"), x, y, null);
			break;
		}
		case RU: {
			g.drawImage(missileImgs.get("RU"), x, y, null);
			break;
		}
		case RD: {
			g.drawImage(missileImgs.get("RD"), x, y, null);
			break;
		}
		}
		move();
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
		}
		if (x < 0 || x > TankClient.GAME_WIDTH || y < 0
				|| y > TankClient.GAME_HEIGHT) {
			bAlive = false;
			tc.missile.remove(this);
		}
	}

	public boolean isAlive() {
		return bAlive;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitTank(Tank t) {
		if ((this.getRect().intersects(t.getRect())) && (t.isbAlive())
				&& t.isbAlive() && this.bAlive && (t.isGood() != good)) {
			tc.missile.remove(this);
			t.setbAlive(false);
			Explode e = new Explode(x, y, tc);
			tc.explode.add(e);
			if (t.isGood()) {
				tc.setLife(tc.getLife() - 1);
				if (tc.getLife() > 0) {
					tc.makeNewTank();
				}
			}
			return true;
		} else
			return false;
	}

	public void hitTanks(ArrayList<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			this.hitTank(tanks.get(i));
		}
		if (tc.enemyTank.size() == 0) {
			tc.makeEnemy(Integer.parseInt(PropertyMgr
					.getProperty("reproducedAccount")));
		}
	}

	public boolean hitWall(Wall w) {
		return this.getRect().intersects(w.getRect());

	}
}