/*
客户端的Socket
*/
import java.net.*;
import java.io.*;
public class Client{
	public static void main(String [] args){
		
		//客户端接收数据
		try{
			Socket socket = new Socket("127.0.0.1",5000);
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader brf = new BufferedReader(isr);
			String message = brf.readLine();
			System.out.println(message);
			brf.close();
		}catch(UnknownHostException a){
			a.printStackTrace();	
		}catch(ConnectException ae){
			System.out.println("服务器未响应！！！");
		}catch(IOException e){
			e.printStackTrace();	
		}
		/*
		//客户端发送数据
		try{
			Socket socket = new Socket("192.168.112.7",5000);  //11行的socket作用域为try的｛｝内部
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("人间喜剧！！！");
			writer.print("永垂不朽！！！");
		}catch(IOException e){
			e.printStackTrace();
		}*/
	}
}