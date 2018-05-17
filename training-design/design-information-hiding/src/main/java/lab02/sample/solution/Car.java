package lab02.sample.solution;

import lab02.sample.common.Engine;
import lab02.sample.common.Seatbelt;

public class Car {

	private Seatbelt seatbelt = new Seatbelt();
	private Engine engine = new Engine();

	public void secureDriver() {
		seatbelt.buckleUp();
	}
	
	public void activate() {
		if (!seatbelt.isFastened()) {
			throw new FastenSeatBeltsException();
		}
		engine.start();
	}

}

