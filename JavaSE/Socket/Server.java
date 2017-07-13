/*
服务器端的Socket的简单建立
*/

import java.io.*;
import java.net.*;
import java.util.*;
public class Server{	
	public static void main(String [] args){
		ArrayList <String> saying = new ArrayList <String>();
		Elder elder = new Elder();
		elder.go(saying);
		try{
			ServerSocket serverSocket = new ServerSocket(5000);
			while(true){
				Socket socket = serverSocket.accept();
				PrintWriter pr = new PrintWriter(socket.getOutputStream());
				String message =elder.say(saying);
				pr.println(message);
				pr.close();
			}	
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class Elder{
	public void go(ArrayList <String> abc){
		try{
			File f = new File("F:/JAVA/Socket/HaHaHa.txt");
  		BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
  		while((s = br.readLine()) != null){
  			abc.add(s);
  		}
  	}catch(IOException e){
  		e.printStackTrace();
  	}
  }
  
  public String say(ArrayList <String> b){
  	int c = (int)(Math.random()*10);
  	int a = b.size()>c  ? c:c-b.size();
		return b.get(a);
  }
}