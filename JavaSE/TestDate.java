/*
用于测试日期的相关程序
*/

import java.util.*;

public class TestDate{
	public static void main(String [] args){
		Date a = new Date();
		System.out.println(String.format("%tc",a));
		System.out.println(String.format("%tA,%<tB %<td",a));
		System.out.println(String.format("%tr",a));  //Date方法的使用，String.format("%tc",a);
		Calendar c = Calendar.getInstance();//Calendar方法的使用
		c.set(2016,11,06,13,35,24);  //设置时间
		System.out.println(c.getTime()); 
		long day = c.getTimeInMillis(); 
		day += 10*24*60*60*1000; 
		c.setTimeInMillis(day);  //增加10天，以毫秒为单位
		System.out.println(c.getTime());
		c.add(c.DATE,22);//增加22天
		System.out.println(c.getTime());
		c.roll(c.DATE,50);//DATE滚动50天，月份不变
		System.out.println(c.getTime());
		c.set(c.DATE,10);//DATE设置为10号
		System.out.println(c.getTime());
	}
}
