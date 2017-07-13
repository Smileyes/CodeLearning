/*
 测试非静态方法是否可以引用静态变量和静态方法？
 
 答案：可以！！！
*/
public class staticTest{
	public static void main(String [] args){
		test t = new test();
		System.out.println(test.m);
		for(int i = 0;i<5;i++){
			t.Enjoy();
		}
		test.Say();
	}
} 

class test{
	public static int m = 1;
	public static void Say(){
		System.out.println("唱歌"+ m+" 次");
		m++;
	}
	
	public void Enjoy(){
		Say();
	}
}