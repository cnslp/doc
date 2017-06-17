package thread;

import print.Print;

public class ThreadC implements Runnable {
	private Print print;
	private String str;
	
	public ThreadC(Print print) {
		this.print = print;
		this.str = "C";
	}
	
	@Override
	public void run() {
		for	(int i = 0; i < 10; i ++) {			
			print.printC(str);
		}
	}

}
