package keyming.learning.justcoding.concurrent.map;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ExpiredHashMap<K, V> {
	private final int DEFAULT_EXPIRED_MS = 1000 * 3;
	private int lived_time_ms = DEFAULT_EXPIRED_MS;
	private Map<K, ValueEntry> map = new HashMap<K, ValueEntry>();
	
	@Data
	@AllArgsConstructor
	private class ValueEntry {
		private V value;
		private long expired_at_timestamp;
	}
	
	public ExpiredHashMap() {
		
	}
	
	public ExpiredHashMap(int lived_time_ms) {
		this.lived_time_ms = lived_time_ms;
	}
	
	public void put(K key, V value) {
		ValueEntry entry = new ValueEntry(value, lived_time_ms + System.currentTimeMillis());
		synchronized (map) {
			map.put(key, entry);
		}
	}
	
	public boolean contains(K key) {
		synchronized (map) {
			if (!map.containsKey(key)) {
				return false;
			}
			ValueEntry entry = map.get(key);
			if (entry.getExpired_at_timestamp() < System.currentTimeMillis()) {
				map.remove(key);
				return false;
			}
		}
		return true;
	}
	
	public V get(K key) {
		synchronized (map) {
			ValueEntry entry = map.get(key);
			if (entry == null) {
				return null;
			} else if (entry.getExpired_at_timestamp() < System.currentTimeMillis()) {
				map.remove(key);
				return null;
			}
			return entry.getValue();
		}
	}
}
