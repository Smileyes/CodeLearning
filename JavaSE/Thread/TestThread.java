/*
�̵߳����֪ʶ
*/
import java.io.*;

public class TestThread{
	public static void main(String [] args){
		try{
			Runner a = new Runner();
			Thread th = new Thread(a);
			th.start();
			File f2 = new File("F:/java/Thread/Test.txt");
			if(!f2.exists()){
				f2.getParentFile().mkdirs();
				f2.createNewFile();
			}
			BufferedWriter bfr2 = new BufferedWriter(new FileWriter(f2,true));
			for(int t = 0;t<30;t++){
				System.out.println("��");	
				bfr2.write("��");
				bfr2.newLine();
			}	
			bfr2.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class Runner implements Runnable{
	public void run(){
		Runner a = new Runner();
		try{
			File f = new File("F:/java/Thread/Test.txt");
			if(!f.exists()){
				f.getParentFile().mkdirs();
				f.createNewFile();
			}
			BufferedWriter bfr = new BufferedWriter(new FileWriter(f,true));
			for(int i = 0;i<20;i++){	
				System.out.println("��");	
				bfr.write("��");
				bfr.newLine();
			}	
			bfr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}