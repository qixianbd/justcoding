package keyming.learning.justcoding.concurrent;

import lombok.extern.log4j.Log4j;

@Log4j
public class SilentSleep {
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			log.error("Failed to make thread sleep:", e);
		}
	}
}
