/*
	数字的格式化
*/

public class TestNum{
	public static void main(String [] args){
		double t = 12345678.123456;
		String a = String.format("This number is %,.4f .Gravo!!!",t);
		System.out.println(a);
	}
}