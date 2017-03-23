package keyming.learning.justcoding.concurrent.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MultiMap<K, V> {
	private Map<K, Collection<V>> map = new HashMap<K, Collection<V>>();

	public synchronized void put(K key, V value) {
		if (!map.containsKey(key)) {
			HashSet<V> valueSet = new HashSet<V>();
			valueSet.add(value);
			map.put(key, valueSet);
		} else {
			map.get(key).add(value);
		}
	}

	public synchronized Collection<V> get(K key) {
		return map.get(key);
	}
	
	public synchronized boolean contains(K key, V value) {
		if (map.containsKey(key)) {
			if (map.get(key).contains(value)) {
				return true;
			}
		}
		return false;
	}

	public synchronized boolean contains(K key) {
		return map.containsKey(key);
	}

	public synchronized void addAll(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	public synchronized void remove(K key, V value) {
		if (map.containsKey(key)) {
			map.get(key).remove(value);
		}
	}
}
