package lab02.sample.challenge;

import lab02.sample.common.Astronaut;
import lab02.sample.common.ChargableResource;
import lab02.sample.common.SpaceStationModule;

public class SpaceStationModuleBasic implements SpaceStationModule {
	
	public static int TEMPERATURE_TOO_HIGH = 80;
	
	private int temperatureInCelsius = 20;

	/* (non-Javadoc)
	 * @see lab02.sample.challenge.SpaceStationModule#getTemperatureInCelsius()
	 */
	public int getTemperatureInCelsius() {
		return temperatureInCelsius;
	}

	/* (non-Javadoc)
	 * @see lab02.sample.challenge.SpaceStationModule#receiveSunshine()
	 */
	public void receiveSunshine() {
		
		if (this.temperatureInCelsius > TEMPERATURE_TOO_HIGH) {
			throw new IllegalStateException("This module got too hot!");
		}
		
		this.temperatureInCelsius += 1;
	}
	
	/* (non-Javadoc)
	 * @see lab02.sample.challenge.SpaceStationModule#coolDown(lab02.sample.challenge.ChargableResource)
	 */
	public void coolDown(ChargableResource battery) {
		this.temperatureInCelsius -= 5;
	}
	
	/* (non-Javadoc)
	 * @see lab02.sample.challenge.SpaceStationModule#restAstronauts(lab02.sample.challenge.Astronaut)
	 */
	public void restAstronauts (Astronaut... astronauts) {
		
		for (Astronaut astronaut : astronauts) {
			astronaut.rest(1);
		}
	}

}
