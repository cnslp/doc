package thread;

import print.Print;

public class ThreadB implements Runnable {
	private Print print;
	private String str;
	
	public ThreadB(Print print) {
		this.print = print;
		this.str = "B";
	}
	
	@Override
	public void run() {
		for	(int i = 0; i < 10; i ++) {
			print.printB(str);
		}			
	}
	
}
