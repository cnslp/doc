package com.nubia.test;

public class ThreadPri implements Runnable{
	
	private Runnable nextThread = null;
	private String priString;
	private Thread runRhread;
	private int priTimes = 0;
	
	public ThreadPri(String priString) {
		this.priString = priString;
		runRhread = new Thread(this);
	}
	
	public static void main(String[] args) {
		ThreadPri priA = new ThreadPri("A");
		ThreadPri priB = new ThreadPri("B");
		ThreadPri priC = new ThreadPri("C");
		priA.setNextThread(priB);
		priB.setNextThread(priC);
		priC.setNextThread(priA);
		System.out.println("字母打印\t打印次数");
		priA.start(10);
		priB.start(10);
		priC.start(10);
	}
	
	public void start(int priTimes) {
		this.priTimes = priTimes;
		runRhread.start();
		try {
			runRhread.sleep(10);//等待10毫秒.确保第一次ABC的顺序
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		if (null != nextThread) {
			int flag = 1;
			while (priTimes >= flag) {
				System.out.println(priString + "\t" + flag);
				synchronized (nextThread) {
					nextThread.notify();
				}
				flag ++;
				synchronized (this) {
					try {
						if (priTimes >= flag) {
							this.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

	public Runnable getNextThread() {
		return nextThread;
	}
	
	public void setNextThread(Runnable nextThread) {
		this.nextThread = nextThread;
	}
	
}
