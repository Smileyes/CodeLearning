import java.io.*;
import java.net.*;
import java.util.*;

public class TestTomCat implements Runnable {
	Socket socket = null;

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(4396);
			while (true) {
				Socket s = ss.accept();
				new Thread(new TestTomCat(s)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TestTomCat(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream());
			/*dos.write("<html><head><title>403之家</title><body>生无可恋</body></html>"
					.getBytes());*/
			DataInputStream dis = new DataInputStream(new FileInputStream(
					"F:/Smileyes.jpg"));
			int b = 0;
			while ((b = dis.read()) != -1) {
				dos.write(b);
			}
			dos.flush();
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
