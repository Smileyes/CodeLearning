/*
关于对象序列化的相关练习
*/

import java.io.*;

class Dog implements Serializable{
	private int a = 10;
	transient private int b = 20;
  static int c = 30;
	private String name = "LYL";
	
	public int getA(){
		return a;
	}
	public int getB(){
		return b;
	}	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return a + " " +b+"  "+c+"  "+name;
	}
}


public class TestSerial{
	public static void main(String [] args){
		Dog d = new Dog();
		System.out.println(d);
		try{
			FileOutputStream fos = new FileOutputStream("test.ser");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(d);
			os.close();
			FileInputStream fis = new FileInputStream("test.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Dog t = (Dog) ois.readObject();
			ois.close();
			System.out.println(t);
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
	}
}