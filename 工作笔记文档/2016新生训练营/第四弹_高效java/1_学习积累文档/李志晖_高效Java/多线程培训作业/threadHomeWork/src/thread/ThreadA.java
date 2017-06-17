package thread;

import print.Print;

public class ThreadA implements Runnable {
	private Print print;
	private String str;
	
	public ThreadA(Print print) {
		this.print = print;
		this.str = "A";
	}
	
	@Override
	public void run() {
		for	(int i = 0; i < 10; i ++) {			
			print.printA(str);
		}
	}
}
