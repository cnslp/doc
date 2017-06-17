package main;

import print.Print;
import thread.ThreadA;
import thread.ThreadB;
import thread.ThreadC;

public class Main {

	public static void main(String[] args) {	
		Print print = new Print();
		
		ThreadA threadA = new ThreadA(print);
		Thread threada = new Thread(threadA);
		
		ThreadB threadB = new ThreadB(print);
		Thread threadb = new Thread(threadB);

		ThreadC threadC = new ThreadC(print);
		Thread threadc = new Thread(threadC);

		System.out.println("print begin");
		System.out.println();

		
		threada.start();
		threadb.start();
		threadc.start();
		
		try {
			threada.join();
			threadb.join();
			threadc.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();

		System.out.println("print over");
	}
}
