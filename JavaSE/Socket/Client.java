/*
�ͻ��˵�Socket
*/
import java.net.*;
import java.io.*;
public class Client{
	public static void main(String [] args){
		
		//�ͻ��˽�������
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
			System.out.println("������δ��Ӧ������");
		}catch(IOException e){
			e.printStackTrace();	
		}
		/*
		//�ͻ��˷�������
		try{
			Socket socket = new Socket("192.168.112.7",5000);  //11�е�socket������Ϊtry�ģ����ڲ�
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("�˼�ϲ�磡����");
			writer.print("�������࣡����");
		}catch(IOException e){
			e.printStackTrace();
		}*/
	}
}