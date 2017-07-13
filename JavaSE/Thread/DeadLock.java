/*
���Ա�д��������
������ʹ��sychronized��������ͬ���ķ����ı�Է���Ҫ��ʵ������
*/
class Timer implements Runnable{
	 int flag = 0;
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	public void run(){
		if(flag == 0){
			synchronized(o2){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					
				}
				synchronized(o1){
					System.out.println("0 ����");
				}
			}
		}
		
		if(flag == 1){
			synchronized(o1){
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					
				}
				synchronized(o2){
					System.out.println("1 ����");
				}
			}
		}
	}
}

public class DeadLock{
	public static void main(String [] args){
		Timer ti1 = new Timer();
		Timer ti2 = new Timer();
		ti1.flag = 0;
		ti2.flag = 1;
		Thread t1 = new Thread(ti1);
		Thread t2 = new Thread(ti2);
		t1.start();
		t2.start();
	}
}