package itcast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		new Server().launch();
	}

	public void launch() throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		while (true) {
			Socket s = ss.accept();
			System.out.println("connect.");
			BufferedReader bfr = new BufferedReader(new InputStreamReader(
					new FileInputStream("./src/DTD/test.html")));
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			String str = null;
			while ((str = bfr.readLine()) != null) {
				pw.write(str);
			}
			pw.close();
			bfr.close();
		}
	}

}
