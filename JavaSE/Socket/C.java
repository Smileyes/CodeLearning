import java.net.*;
import java.io.*;

public class C {
	public static void main(String [] args) {
		try{
			Socket s = new Socket("127.0.0.1",5678);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader is = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter os = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			String s2 = sin.readLine();		//发出
			os.println(s2);
			os.flush();
			String s1 = "base";   //接收
			while(!(s1.equalsIgnoreCase("bye"))||(s2.equalsIgnoreCase("bye"))){
				if(s2 != null){
					System.out.println("Client:"+s2);
					os.print(s2);
					os.flush();
				}
				if(!s1.equalsIgnoreCase("base")){
					System.out.println("Server:"+s1);
				}
				s1 = is.readLine();   //接收
				s2 = sin.readLine();	
				os.println(s2);
				os.flush();
			}
			if(s1.equalsIgnoreCase("bye")){
				System.out.println("服务器端退出");
				s.close();
				is.close();
				os.close();
			}else{
				os.print(s2);
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