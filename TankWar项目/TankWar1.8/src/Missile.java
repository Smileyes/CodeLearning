import java.awt.*;
import java.util.*;

public class Missile {
	int x, y;
	Tank.Driection dir;
	public static final int xSpeed = 10;
	public static final int ySpeed = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private boolean bAlive = true;
	private TankClient tc = null;

	public Missile(int x, int y, Tank.Driection dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;

	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
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
		if ((this.getRect().intersects(t.getRect())) && (t.isbAlive())) {
			tc.missile.remove(this);
			t.setbAlive(false);
			Explode e = new Explode(x, y, tc);
			tc.explode.add(e);
			return true;
		} else
			return false;
	}

	public void hitTanks(ArrayList<Tank> tanks) {
		for (int i = 0; i < tanks.size(); i++) {
			this.hitTank(tanks.get(i));
		}

	}
}