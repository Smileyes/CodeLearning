/*
˫����
*/

import java.net.*;
import java.io.*;

public class S {
	public static void main(String [] args) {
		try{
			ServerSocket socket = new ServerSocket(5678);	
				Socket s = socket.accept();
				System.out.println("�ͻ�������");
				BufferedReader sin= new BufferedReader(new InputStreamReader(System.in));
				BufferedReader is = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter os = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				String s1 = is.readLine();   //����
				String s2 = "base";		//����
				while(!(s1.equalsIgnoreCase("bye")||(s2.equalsIgnoreCase("bye")))){
					if(s2 != null){
						System.out.println("Server:"+s2);
						os.print(s2);
						os.flush();
					}
					if(!s1.equalsIgnoreCase("base")){
						System.out.println("Client:"+s1);
					}
					s2 = sin.readLine();		//����
					os.println(s2);
					os.flush();
					s1 = is.readLine();   //����
				}
				if(s1.equalsIgnoreCase("bye")){
					System.out.println("���������˳�");
					s.close();
					is.close();
					os.close();
				}else{
					os.println(s2);
					os.flush();
					System.out.println("�ͻ����˳�");
					s.close();
					is.close();
					os.close();
				}
			
		}catch(IOException e){
			System.out.println("Error");
		}
	}
}