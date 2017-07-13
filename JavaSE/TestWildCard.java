/*
  用于测试万用字符
*/

import java.util.*;

class Animal{
	String name;
	public void Sing(){
		System.out.println("Animal");
	}
}

class Dog extends Animal{
	int age;
	public void Sing(){
		System.out.println("Dog");
	}
}

public class TestWildCard{
	public static void main(String [] arge){
		TestWildCard ts = new TestWildCard();
		ArrayList <Dog> a= new ArrayList <Dog>();
		ts.go(a);
	}
	/*
	public void go(ArrayList <Dog> ab ){
	*/
	/*万用字符0001
	public void go(ArrayList <? extends Animal> ab){
	*/
	public <T extends Animal>void go(ArrayList <T> ab){   //万用字符0002
			System.out.println("WildCard :万用字符");
	}
	
}