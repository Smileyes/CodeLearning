/*
测试线程同步
方法：使用synchronized
*/

public class TestSync implements Runnable{ 
		Timer timer = new Timer();
	public static void main(String [] args){
		TestSync a = new TestSync();
		Thread t1 = new Thread(a);
		Thread t2= new Thread(a);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	
	public void run(){
		timer.add(Thread.currentThread().getName());
	}
}

class Timer{
	static int num = 0;
	public  void add(String s){
		synchronized(this){
		num++;
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
				
		}
		
			System.out.println(s + ",你是第"+ num +"个使用该方法的线程");
		}
	}
	
}