/*
用于实现包装类型、String和基础数据类型的转换
*/

import static  java.lang.System.*;
public class Test{
	public static void main(String [] args){
		try{
			int s = Integer.parseInt(args[0]);
			out.println(s);
		}catch(ArrayIndexOutOfBoundsException ex){
			out.println("请输入数据");
		}
		boolean c = new Boolean("true").booleanValue();
	
		out.println(c);
		
		double d = 3.14;
		out.println("" + d);
		out.println(Double.toString(d));
	}

}