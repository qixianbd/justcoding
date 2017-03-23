package keyming.learning.justcoding.concurrent.map;

import org.junit.Test;

import junit.framework.TestCase;
import keyming.learning.justcoding.concurrent.SilentSleep;
import lombok.extern.log4j.Log4j;

@Log4j
public class ExpiredHashMapTest {
	private ExpiredHashMap<Integer, Integer> map = new ExpiredHashMap(2000);

	@Test
	public void SimpleTest() {
		for (int i = 0; i < 10; ++i) {
			map.put(i, i);
			SilentSleep.sleep(900);
			logHelper();
		}

	}

	private void logHelper() {
		for (int key = 0; key < 10; ++key) {
			Integer v = map.get(key);
			if (v != null) {
				log.error(v.intValue());
			}
		}
		// SilentSleep.sleep(1000);
	}
}
