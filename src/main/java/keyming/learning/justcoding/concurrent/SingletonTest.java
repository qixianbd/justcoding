package keyming.learning.justcoding.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Singleton {
	private static Singleton instance = null;
	public static AtomicInteger count = new AtomicInteger(0);
	private Singleton() {
		count.incrementAndGet();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (count) {
				if (instance == null) {
					instance = new Singleton();
					return instance;
				}
			}
		}
		return instance;
	}
	
	public static Singleton getInstanceUnSafe() {
		if (instance == null) {
			instance = new Singleton();
			return instance;
		}
		return instance;
	}
	
}

class SimpleTask implements Runnable {

	public void run() {
		Singleton instance = Singleton.getInstance();
		if (Singleton.count.get() != 0) {
			System.out.println("count is " + Singleton.count + ", instance is : " + instance.toString());
		}
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		ExecutorService excutors = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 16; ++i) {
			excutors.submit(new SimpleTask());
		}
		try {
			if (!excutors.awaitTermination(2, TimeUnit.SECONDS)) {
				excutors.shutdown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
