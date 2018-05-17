package lab01.sample.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class WeatherStation {
	
	private Map<Long, Integer> log = new HashMap<>();

	public void measureAndLog() {
		
		int temperatue = measure();
		log.put(System.currentTimeMillis(), temperatue);
	}
	
	public Optional<Integer> getMeasuredHistory(long time) {
		return Optional.of(log.get(time));
	}

	public Set<Long> allMeasuredHistoryLogs() {
		
		Set<Long> keys = log.keySet();
		// the keyset is not immutable, removing a key would remove it from our map!
		return Collections.unmodifiableSet(keys);
	}

	private int measure() {
		
		// now let´s assume this is a very complex thing to do:
		Random rnd = new Random();
		int temperature = rnd.nextInt(100);
		return temperature;
	}
	
}
