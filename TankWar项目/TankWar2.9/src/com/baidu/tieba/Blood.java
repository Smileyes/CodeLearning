package com.baidu.tieba;
import java.awt.*;

public class Blood {
	private int x, y;
	private TankClient tc = null;
	private boolean bAlive = true;
	public static int BLOOD_WIDTH = 10;
	public static int BLOOD_HEIGHT = 10;
	private int step = 0;
	// 指明血块运动的轨迹，从int [][] pos中获得
	private int[][] pos = { { 200, 200 }, { 300, 200 }, { 250, 250 },
			{ 300, 300 }, { 200, 300 } };

	public void draw(Graphics g) {
		this.hitTank(tc.myTank);
		this.move();
		if (bAlive) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.fillRect(x, y, BLOOD_WIDTH, BLOOD_HEIGHT);
			g.setColor(c);
		}
	}

	public void move() {
		x = pos[step][0];
		y = pos[step][1];
		step++;
		if (step >= pos.length)
			step = 0;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, BLOOD_WIDTH, BLOOD_HEIGHT);
	}

	public Blood(TankClient tc) {
		this.tc = tc;
	}

	public void hitTank(Tank t) {
		if (t.isbAlive() && this.bAlive
				&& this.getRect().intersects(t.getRect())) {
			this.bAlive = false;
			tc.setLife(tc.getLife() + 1);
		}
	}
}