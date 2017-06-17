package thread.test;

public class PrintABC extends Thread {  
    private static Object obj = new Object();  
    private static int count = 0;  
    private String name;  
    private int id;  
    private int num = 0;  
  
    public PrintABC(int id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
  
    public void run() {  
        synchronized (obj) {  
            while (num < 10) {  
                if (count % 3 == id) {  
                    System.out.print(name);  
                    ++count;  
                    ++num;  
                    obj.notifyAll();  
                } else {  
                    try {  
                    	obj.wait();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
    	Thread A=new PrintABC(0, "A");
    	Thread B=new PrintABC(1, "B");
    	Thread C=new PrintABC(2, "C");
    	A.start();
    	B.start();
    	C.start();
    }  
}  
