/*
���ڲ������ڵ���س���
*/

import java.util.*;

public class TestDate{
	public static void main(String [] args){
		Date a = new Date();
		System.out.println(String.format("%tc",a));
		System.out.println(String.format("%tA,%<tB %<td",a));
		System.out.println(String.format("%tr",a));  //Date������ʹ�ã�String.format("%tc",a);
		Calendar c = Calendar.getInstance();//Calendar������ʹ��
		c.set(2016,11,06,13,35,24);  //����ʱ��
		System.out.println(c.getTime()); 
		long day = c.getTimeInMillis(); 
		day += 10*24*60*60*1000; 
		c.setTimeInMillis(day);  //����10�죬�Ժ���Ϊ��λ
		System.out.println(c.getTime());
		c.add(c.DATE,22);//����22��
		System.out.println(c.getTime());
		c.roll(c.DATE,50);//DATE����50�죬�·ݲ���
		System.out.println(c.getTime());
		c.set(c.DATE,10);//DATE����Ϊ10��
		System.out.println(c.getTime());
	}
}
