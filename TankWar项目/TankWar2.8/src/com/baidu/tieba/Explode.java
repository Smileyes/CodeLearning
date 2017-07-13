package com.baidu.tieba;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Explode {
	private int x, y;
	private int[] diameter = { 4, 10, 16, 22, 28, 40, 28, 13, 7, 3 };
	private int step = 0;
	private boolean bAlive = true;
	private TankClient tc = null;
	private static Map<String, Image> tankImgs = new HashMap<String, Image>();
	private static Image[] imgs = null;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private boolean init = false;
	static {
		imgs = new Image[] {
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/0.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/1.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/2.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/3.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/4.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/5.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/6.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/7.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/8.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource(
						"imges/9.gif")) };
	}

	public void draw(Graphics g) {
		if (!init) {
			for (int i = 0; i < imgs.length; i++) {
				g.drawImage(imgs[i], -100, -100, null);
			}
			init = true;
		}
		if (!bAlive) {
			tc.explode.remove(this);
			return;
		}
		if (step == imgs.length) {
			bAlive = false;
			step = 0;
			return;
		}
		g.drawImage(imgs[step], x, y, null);
		step++;
	}

	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

}
