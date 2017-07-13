import java.util.*;

import org.junit.Test;

public class DeadLockSec {
	private static Object o1 = new Object(), o2 = new Object();

	public static void main(String[] args) {
		new DeadLockSec().launch();
	}

	private void launch() {
		new Thread(new DeadLock1()).start();
		new Thread(new DeadLock2()).start();
	}

	class DeadLock1 implements Runnable {
		public DeadLock1() {
		}

		public void run() {
			synchronized ("123"/* o1 */) {
				try {
					Thread.sleep(1000);
					System.out.print("1号醒了。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized ("456"/* o2 */) {
					System.out.print("2号开始。");
				}
			}
		}

	}

	class DeadLock2 implements Runnable {
		public void run() {
			synchronized ("456"/* o2 */) {
				try {
					Thread.sleep(1000);
					System.out.print("2号醒了。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized ("123"/* o1 */) {
					System.out.print("1号开始。");
				}
			}
		}

	}

}
