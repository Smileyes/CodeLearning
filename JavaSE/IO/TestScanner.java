/*
���ڲ���Scanner��
*/
import java.util.*;
public class TestScanner{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.println("�����룺");
		String str = s.next();
		System.out.println(str);
		Float sa = s.nextFloat();
		String as = String.format("%.4f",sa);
		System.out.println(as);
	}
}