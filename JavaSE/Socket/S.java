/*
双向传输
*/

import java.net.*;
import java.io.*;

public class S {
	public static void main(String [] args) {
		try{
			ServerSocket socket = new ServerSocket(5678);	
				Socket s = socket.accept();
				System.out.println("客户端连接");
				BufferedReader sin= new BufferedReader(new InputStreamReader(System.in));
				BufferedReader is = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter os = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				String s1 = is.readLine();   //接收
				String s2 = "base";		//发出
				while(!(s1.equalsIgnoreCase("bye")||(s2.equalsIgnoreCase("bye")))){
					if(s2 != null){
						System.out.println("Server:"+s2);
						os.print(s2);
						os.flush();
					}
					if(!s1.equalsIgnoreCase("base")){
						System.out.println("Client:"+s1);
					}
					s2 = sin.readLine();		//发出
					os.println(s2);
					os.flush();
					s1 = is.readLine();   //接收
				}
				if(s1.equalsIgnoreCase("bye")){
					System.out.println("服务器端退出");
					s.close();
					is.close();
					os.close();
				}else{
					os.println(s2);
					os.flush();
					System.out.println("客户端退出");
					s.close();
					is.close();
					os.close();
				}
			
		}catch(IOException e){
			System.out.println("Error");
		}
	}
}