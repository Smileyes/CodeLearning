/*
����ʵ�ְ�װ���͡�String�ͻ����������͵�ת��
*/

import static  java.lang.System.*;
public class Test{
	public static void main(String [] args){
		try{
			int s = Integer.parseInt(args[0]);
			out.println(s);
		}catch(ArrayIndexOutOfBoundsException ex){
			out.println("����������");
		}
		boolean c = new Boolean("true").booleanValue();
	
		out.println(c);
		
		double d = 3.14;
		out.println("" + d);
		out.println(Double.toString(d));
	}

}