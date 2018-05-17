package lab02.sample.common;

public interface SpaceStationModule {

	int getTemperatureInCelsius();

	void receiveSunshine();

	void coolDown(ChargableResource battery);

	void restAstronauts(Astronaut... astronauts);

}