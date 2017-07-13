import java.awt.*;

public class Explode {
	private int x, y;
	private int[] diameter = { 4, 10, 16, 22, 28, 40, 28, 13, 7, 3 };
	private int step = 0;
	private boolean bAlive = true;
	private TankClient tc = null;

	public void draw(Graphics g) {
		if (!bAlive) {
			tc.explode.remove(this);
			return;
		}
		if (step == diameter.length) {
			bAlive = false;
			step = 0;
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step++;
	}

	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

}
