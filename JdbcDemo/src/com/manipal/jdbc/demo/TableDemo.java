package com.manipal.jdbc.demo;

class Table{
	public synchronized void printTable(int n){
		System.out.println("--Table of " + n + "---");
		for(int i = 1; i<=10; i++){
			System.out.println(n*i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TableThread extends Thread{
	Table t;
	int num;
	public TableThread(Table t, int num){
		this.t = t;
		this.num = num;
	}
	
	public void run(){
		t.printTable(num);
	}
	
}

public class TableDemo {

	public static void main(String[] args) {
		Table t = new Table();
		TableThread thread1 = new TableThread(t, 5);
		TableThread thread2 = new TableThread(t, 100);
		thread1.start();
		thread2.start();
	}

}
