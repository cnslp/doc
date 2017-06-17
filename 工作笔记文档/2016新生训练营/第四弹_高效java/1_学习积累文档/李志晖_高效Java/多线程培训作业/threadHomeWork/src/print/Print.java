package print;

import java.util.concurrent.LinkedBlockingDeque;

public class Print {
	
	private LinkedBlockingDeque<String> deque;
	
	public Print() {
		deque = new LinkedBlockingDeque<>();
		deque.addLast("A");
		deque.addLast("B");
		deque.addLast("C");
	}
	
	public synchronized void printA(String str) {
		while(deque.getFirst() != "A") {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		deque.remove();
		deque.addLast("A");
		System.out.print(str);
		notifyAll();
	}
	
	public synchronized void printB(String str) {
		while(deque.getFirst() != "B") {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		deque.remove();
		deque.addLast("B");
		System.out.print(str);
		notifyAll();
	}
	
	public synchronized void printC(String str) {
		while(deque.getFirst() != "C") {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		deque.remove();
		deque.addLast("C");
		System.out.print(str);
		notifyAll();
	}
}
