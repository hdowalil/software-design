package lab02.sample.solution;

import lab02.sample.common.Astronaut;
import lab02.sample.common.ChargableResource;
import lab02.sample.common.SpaceStationModule;

abstract class SpaceStationModuleDecorator implements SpaceStationModule {
	
	private SpaceStationModule delegate;

	SpaceStationModuleDecorator(SpaceStationModule delegate) {
		super();
		this.delegate = delegate;
	}

	public int getTemperatureInCelsius() {
		return delegate.getTemperatureInCelsius();
	}

	public void receiveSunshine() {
		delegate.receiveSunshine();
	}

	public void coolDown(ChargableResource battery) {
		delegate.coolDown(battery);
	}

	public void restAstronauts(Astronaut... astronauts) {
		delegate.restAstronauts(astronauts);
	}

}
