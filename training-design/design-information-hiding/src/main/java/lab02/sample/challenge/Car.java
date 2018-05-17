package lab02.sample.challenge;

import lab02.sample.common.Engine;
import lab02.sample.common.Seatbelt;

public class Car {
	
	private Seatbelt seatbelt;
	private Engine engine;
	
	public Seatbelt getSeatbelt() {
		return seatbelt;
	}
	public void setSeatbelt(Seatbelt seatbelt) {
		this.seatbelt = seatbelt;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}

