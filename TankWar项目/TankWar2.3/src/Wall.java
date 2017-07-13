import java.awt.*;

public class Wall {
	private int x;
	private int y;
	private int wall_width = 50;
	private int wall_height = 100;
	private TankClient tc = null;

	public Wall(int x, int y, int wall_width, int wall_height, TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.wall_width = wall_width;
		this.wall_height = wall_height;
		this.tc = tc;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(x, y, wall_width, wall_height);
		g.setColor(c);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, wall_width, wall_height);
	}

}
