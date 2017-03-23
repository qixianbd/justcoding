package keyming.learning.justcoding.concurrent.map;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
public class HashBag<K, V> {
	@Data
	@AllArgsConstructor
	private class CountEntry {
		private V value;
		private int count;
	}

	private Map<K, CountEntry> map = new HashMap<K, CountEntry>();

	public void put(K key, V value) {
		CountEntry entry = null;
		synchronized (map) {
			if ((entry = map.get(key)) != null) {
				entry.setCount(entry.getCount() + 1);
				map.put(key, entry);
			} else {
				entry = new CountEntry(value, 1);
				map.put(key, entry);
			}
		}
	}

	public boolean contians(K key) {
		synchronized (map) {
			if (map.containsKey(key)) {
				return true;
			}
		}
		return false;
	}

	public int count(K key, V value) {
		CountEntry entry = null;
		synchronized (map) {
			if ((entry = map.get(key)) != null) {
				return entry.getCount();
			}
		}
		return 0;
	}
	
	public void remove(K key) {
		remove(key, 1);
	}
	
	public void remove(K key, int count) {
		if (map.containsKey(key)) {
			CountEntry entry = map.get(key);
			if (entry.getCount() > count) {
				entry.setCount(entry.getCount() - count);
				return;
			}
			map.remove(key);
		}
	}
}
