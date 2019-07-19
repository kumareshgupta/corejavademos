package com.manipal.thread.demo;

public class MyThread extends Thread {
	public MyThread(){}	
	public MyThread(String name){
		super(name);
	}	
	//task for thread
	@Override
	public void run(){
		for(int i = 0; i<5; i++){
			System.out.println(i + " - I am running....." + this.getName());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// create object of thread
		System.out.println("Starting of main.....");
		MyThread thread1 = new MyThread("myThread One"); //New Thread 1
		MyThread thread2 = new MyThread("myThread Two"); //New Thread 1
		
		thread1.setPriority(10);
		thread2.setPriority(MIN_PRIORITY);
		
		System.out.println(MAX_PRIORITY + "\t" + MIN_PRIORITY + "\t" + NORM_PRIORITY);
		
		thread1.start(); // Runnable -> running		
		thread2.start(); // Runnable -> running
		
		System.out.println("End of Main.....");
		
		System.out.println(thread1.getPriority());
		
	}

}
