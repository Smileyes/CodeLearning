/*
±àÐ´UDPµÄ¿Í»§¶Ë³ÌÐò
*/

import java.net.*;
import java.io.*;

 public class ClientUDP{
 	public static void main(String [] args){
 		try{
 			byte [] buf = ("Hello World!").getBytes();
 			DatagramSocket ds = new DatagramSocket(5566);
 			DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",4396));
 			byte [] buff = new byte[1024];;
 			DatagramPacket dp2 = new DatagramPacket(buff,buff.length);
 			ds.send(dp);
 			ds.receive(dp2);
 			System.out.println(new String (buff,0,dp2.getLength()));
 			ds.close();
 		}catch(SocketException ae){
 			System.out.println("ÍøÂçÁ¬½ÓÊ§°Ü£¡£¡£¡");
 		}catch(IOException e){
 			System.out.println("ÍøÂçÁ¬½ÓÊ§°Ü£¡");
 		}
 	}
 }