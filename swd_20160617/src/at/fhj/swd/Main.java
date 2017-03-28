package at.fhj.swd;

public class Main {
	// Sinnloses Beispiel
	
	private int counter = 0;
	
	/**
	 * Lock Objekte können über mehrere Klassen verwendet werden
	 * und können daher besser das Programm steuern.
	 * Das Lock kann aber auch als:
	 * 
	 *      public synchronized void test()
	 * 
	 * verwendet werden.
	 */
	private Object syncLock = new Object();
	
	public void inc(){
		synchronized (syncLock) {
			int tmp = counter;
			counter = tmp + 1;
			System.out.println(counter);
		}
	}
	
	public void doCount() {
	
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				inc();
				inc();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				inc();
				inc();
			}
		});
		t1.start();
		t2.start();
	}
	
	public static void main(String args[]) {
		doCount();
	}
	
}
