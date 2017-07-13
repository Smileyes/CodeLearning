/*
编写UDO的客户端程序
*/

import java.net.*;
import java.io.*;

public class ServerUDP{
	public static void main(String [] args){
		try{
			DatagramSocket ds = new DatagramSocket(4396);
			//DatagramPacket dp2 = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),5566);
			while(true){\
				byte [] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				System.out.println(new String(buf,0,dp.getLength()));
				String s = null;
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader bfr = new BufferedReader(isr);
				
				while((s = bfr.readLine()) != null){
					byte [] buff =s.getBytes();
					DatagramPacket dp2 = new DatagramPacket(buff,buff.length,InetAddress.getByName("127.0.0.1"),5566);
					ds.send(dp2);
				}
			}
		}catch(Exception e){
			
		}
	}
}