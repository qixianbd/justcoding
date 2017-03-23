package keyming.learning.justcoding.concurrent.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;

class Item {
	private String itemName = "";

	Item(String itemName) {
		this.itemName = itemName;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
}

class InsertItemWorker implements Runnable {
	private Map<Item, String> map = null;
	InsertItemWorker(Map<Item, String> map) {
		this.map = map;
	}
	public void run() {
		// TODO Auto-generated method stub
		StopWatch watch = StopWatch.createStarted();
		for (int i = 0; i < HashMapPerformanceTest.ITEM_COUNT; ++i) {
			String itemName = RandomStringUtils.randomAlphanumeric(5);
			map.put(new Item(itemName), itemName);
			map.put(new Item("556677"), "556677");
		}
		watch.stop();
		System.out.printf("insert %d items cost %d ms.\n", HashMapPerformanceTest.ITEM_COUNT, watch.getTime());
	}
	
}

class ReadItemWorker implements Runnable {
	private Map<Item, String> map = null;
	ReadItemWorker(Map<Item, String> map) {
		this.map = map;
	}
	public void run() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		StopWatch watch = StopWatch.createStarted();
		for (int i = 0; i < HashMapPerformanceTest.ITEM_COUNT * 5; ++i) {
			String itemName = RandomStringUtils.randomAlphanumeric(5);
			map.get(new Item(itemName));
			map.get(new Item("556677"));
			map.get(new Item("112233"));
		}
		watch.stop();
		System.out.printf("read %d items cost %d ms.\n", HashMapPerformanceTest.ITEM_COUNT * 5, watch.getTime());
	
	}
	
}

public class HashMapPerformanceTest {
	public static final int ITEM_COUNT = 5000;
	public static void main(String[] args) throws InterruptedException {
		//Map<Item, String> mapSeq = new HashMap<Item, String>();
	    // Map<Item, String> mapSeq = new Hashtable<Item, String>();
		Map<Item, String> mapSeq = new ConcurrentHashMap<Item, String>();
		 
		ExecutorService inserts = Executors.newFixedThreadPool(100);
		ExecutorService readers = Executors.newFixedThreadPool(200);
		for (int i = 0; i < 100; ++i) {
			inserts.submit(new InsertItemWorker(mapSeq));
		}
		
		for (int i = 0; i < 200; ++i) {
			readers.submit(new ReadItemWorker(mapSeq));
		}
		
		StopWatch watch = StopWatch.createStarted();
		inserts.shutdown();
		readers.shutdown();
		inserts.awaitTermination(10, TimeUnit.SECONDS);
		readers.awaitTermination(10, TimeUnit.SECONDS);
		watch.stop();
		System.out.println("cost times in ms: " + watch.getTime());
	}

}
