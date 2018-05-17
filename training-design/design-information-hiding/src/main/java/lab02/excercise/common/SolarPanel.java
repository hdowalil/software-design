package lab02.excercise.common;

import java.util.Objects;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class SolarPanel {
	
	private int noOfCells;
	private Battery battery2Charge;

	public SolarPanel(@Nonnegative int noOfcells, @Nonnull Battery battery2Charge) {
		super();
		Objects.requireNonNull(battery2Charge);
		this.noOfCells = noOfcells;
		this.battery2Charge = battery2Charge;
	}
	
	public void receiveHoursOfSunshine(@Nonnegative int hours) {
		
		battery2Charge.charge((double)noOfCells*hours);
	}

	public int getNoOfCells() {
		return noOfCells;
	}
	
}
