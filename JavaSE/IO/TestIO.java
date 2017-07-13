/*
用于测试File类/Buffered/转换流
*/

import java.io.*;

public class TestIO{
 public static void main(String [] args){
 	 //File类的使用
 	System.out.println("1:");
 	File a = new File("F:/java/io/data/a.txt");
 	if(!(a.exists())){
 		a.getParentFile().mkdirs();
 		try{
 			a.createNewFile();
 		}catch(IOException e){
 			e.printStackTrace();
 		}
 	}
 	System.out.println(a.getAbsolutePath());
 	
 	//基本的Outputstream
	System.out.println("2:");
 	try{
		FileOutputStream fos = new FileOutputStream("F:/java/io/data/b.txt");
		for(int i = 0;i<5000;i++){
 			fos.write((char)i);
 		}
 		fos.flush();
 		fos.close();
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException ae){
		ae.printStackTrace();
	}
	
	//基本的Reader和Writer的使用
		System.out.println("3:");
		try{
			int s = 0;
			FileReader fr = new FileReader("F:/java/io/data/c.txt");
			FileWriter fw = new FileWriter("F:/java/io/data/d.txt");
			while((s = fr.read()) != -1){
				System.out.print((char)s);
				fw.write(s);
			}
			fw.flush();
			fw.close();
			fr.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ae){
			ae.printStackTrace();
		}
		
	//Buffered缓冲流的使用
		System.out.println("4:");
	try{
		String s = null;
		int t = 0;
		FileReader fr = new FileReader("F:/java/io/data/c.txt");
		BufferedReader bfr = new BufferedReader(fr);
		FileWriter fw = new FileWriter("F:/java/io/data/e.txt");
		BufferedWriter bfw = new BufferedWriter(fw);
		//while((t = fr.read() )!= -1){
		while((s = bfr.readLine()) != null){
			bfw.write(s);
			bfw.newLine();
		}
		//fw.flush();
		bfw.flush();
		bfw.close();/*
		fw.close();
		bfr.close();
		fr.close();*/
		
	}catch(IOException e){
		e.printStackTrace();
	}
	
	//利用键盘输入  System.in方法
 	System.out.println("5:");
 	try{
 		String st = null;
 		InputStreamReader isr = new InputStreamReader(System.in);
 		BufferedReader bfr = new BufferedReader(isr);
 		while( !((st =bfr.readLine() ).equalsIgnoreCase("false"))){
 			System.out.println(st);
 		}
 	}catch(IOException e){
 		e.printStackTrace();
 	}

 }
 
}