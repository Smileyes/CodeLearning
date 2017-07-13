import java.io.*;
import java.net.*;
import java.net.*;

public class TomCataClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("10.2.41.82", 4396);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					"C:/Users/tesla/Desktop/abc.jpg"));
			int b = 0;
			while ((b = dis.read()) != -1) {
				dos.write(b);
			}
			dos.flush();
			dis.close();
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
