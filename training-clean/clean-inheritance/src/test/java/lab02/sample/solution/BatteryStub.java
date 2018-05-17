package lab02.sample.solution;

import lab02.sample.common.ChargableResource;

public class BatteryStub implements ChargableResource {

	double ampereHours = 0.0d;
	
	public double consume(double ampereHours) {
		this.ampereHours -= ampereHours;
		return this.ampereHours;
	}

	public double charge(double ampereHours) {
		this.ampereHours += ampereHours;
		return this.ampereHours;
	}
	
	

}
