package lab01.sample.challenge;

import java.util.HashMap;
import java.util.Random;

public class WeatherStation extends HashMap<Long, Integer> {

	private static final long serialVersionUID = 4546643639218753568L;
	
	public int measure() {
		
		// now let´s assume this is a very complex thing to do:
		Random rnd = new Random();
		int temperature = rnd.nextInt(100);
		
		return temperature;
	}
	
	public int measureAndLog() {
		
		int temperature = measure();
		put(System.currentTimeMillis(), temperature);
		return temperature;
	}
		
}
