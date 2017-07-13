import java.awt.*;
import java.awt.event.*;

public class Tank {

	private int x, y;

	public static void main(String[] args) {

	}

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
	}

	public void move(int key) {
		switch (key) {
		case KeyEvent.VK_LEFT: {
			x -= 5;
			break;
		}
		case KeyEvent.VK_RIGHT: {
			x += 5;
			break;
		}
		case KeyEvent.VK_UP: {
			y -= 5;
			break;
		}
		case KeyEvent.VK_DOWN: {
			y += 5;
			break;
		}
		}

	}
}
