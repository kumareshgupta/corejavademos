package com.manipal.thread.demo;
class Table{
	public  void printTable(int num){
		System.out.println("--Table of " + num +"--");
		for(int i = 1; i<=10; i++){
			System.out.println(num*i);	
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class TableThread extends Thread{
	Table table;
	int num;
	public TableThread(Table table, int num){
		this.table = table;
		this.num = num;
	}	
	public void run(){
		synchronized(table){
			table.printTable(num);
		}
	}
}
public class SynchronizationDemo {
	public static void main(String[] args) {
		Table table = new Table();
		TableThread thread1 = new TableThread(table,5);
		TableThread thread2 = new TableThread(table,100);
		thread1.start();
		thread2.start();
		
	}

}
















