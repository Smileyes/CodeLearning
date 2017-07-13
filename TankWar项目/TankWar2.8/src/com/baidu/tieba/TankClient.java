package com.baidu.tieba;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 坦克游戏的主窗口，用于启动游戏
 * 
 * @author tesla
 *
 */
public class TankClient extends Frame {
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	Image offScreen = null;
	Tank myTank = new Tank(50, 50, true, Direction.Stop, this);
	// Tank enemyTank = new Tank(50, 400, false, this);
	// CopyOnWriteArrayList<Missile> missile = new
	// CopyOnWriteArrayList<Missile>();
	ArrayList<Missile> missile = new ArrayList<Missile>();
	ArrayList<Explode> explode = new ArrayList<Explode>();
	ArrayList<Tank> enemyTank = new ArrayList<Tank>();
	Wall w1 = new Wall(100, 200, 40, 100, this);
	Wall w2 = new Wall(400, 200, 200, 40, this);
	Wall w3 = new Wall(400, 400, 30, 100, this);
	Blood b = new Blood(this);
	private int life = 3;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void paint(Graphics g) {
		if (life <= 0)
			g.drawString("Defeat!!!", 400, 300);

		/*
		 * 指明子弹的数量； 爆炸的数量 敌军坦克的数量 己方生命值
		 */
		g.drawString("Missile Num:" + missile.size(), 10, 40);
		g.drawString("Explodes Num:" + explode.size(), 10, 60);
		g.drawString("EnemyTank Num:" + enemyTank.size(), 10, 80);
		g.drawString("Life Num:" + life, 10, 100);
		// Iterator<Missile> i = missile.iterator();
		// while (i.hasNext()) {
		// Missile m = i.next();
		// if (m.getAlive()) {
		b.draw(g);
		w1.draw(g);
		w2.draw(g);
		w3.draw(g);
		for (int i = 0; i < missile.size(); i++) {
			Missile m = missile.get(i);
			m.hitTanks(enemyTank);
			m.hitTank(myTank);
			m.draw(g);
			// }else{
			// i.remove();
			// }
		}
		for (int i = 0; i < explode.size(); i++) {
			explode.get(i).draw(g);

		}
		myTank.draw(g);
		for (int i = 0; i < enemyTank.size(); i++) {
			Tank t = enemyTank.get(i);
			if (!t.hitTank(myTank))
				enemyTank.get(i).draw(g);
		}
	}

	public void update(Graphics g) {
		if (offScreen == null) {
			offScreen = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreen.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreen, 0, 0, null);
	}

	public static void main(String[] args) {
		new TankClient().launchFrame();
	}

	/**
	 * lauchFrame ：用于显示主窗口
	 */
	private void launchFrame() {
		this.makeEnemy(10);
		setTitle("TankWar");
		this.setVisible(true);
		this.setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				makeEnemy(10);
			}

		});

		new Thread(new move()).start();
	}

	public void makeEnemy(int n) {
		for (int i = 0; i < n; i++) {
			Tank t = new Tank(50 + 40 * i, 330, false, Direction.D, this);
			this.enemyTank.add(t);
		}
	}

	private class move implements Runnable {// 采用线程进行重画

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void makeNewTank() {
		myTank = new Tank(50, 50, true, Direction.Stop, this);
		repaint();
	}

	private class KeyMonitor extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);

		}

	}

}
