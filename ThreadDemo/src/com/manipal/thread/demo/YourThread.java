package com.manipal.thread.demo;

public class YourThread implements Runnable {

		@Override
	public void run() {
			for(int i = 0; i<5; i++){
				System.out.println(i + " - I am running....." + Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public static void main(String[] args) {
			
		YourThread runnableThread1 = new YourThread();
		Thread thread1 = new Thread(runnableThread1);		
		thread1.start();
	
		Thread thread2 = new Thread(new YourThread()); //anonymous object
		thread2.start();
	
	}
	
	


}
