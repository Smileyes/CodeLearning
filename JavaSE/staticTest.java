/*
 ���ԷǾ�̬�����Ƿ�������þ�̬�����;�̬������
 
 �𰸣����ԣ�����
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
		System.out.println("����"+ m+" ��");
		m++;
	}
	
	public void Enjoy(){
		Say();
	}
}