package lab01.excercise.challenge;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
	
	private List<StructuralElement> elements =  new ArrayList<StructuralElement>();
	private long oxygen = 10000L;
	private double battery = 10000d;
	
	public void logStatus (PrintStream out) {
		out.println("Number of Elements: " + Integer.toString(elements.size()) + 
				" / Oxygen: " + Long.toString(oxygen) +
				" / Battery: " + Double.toString(battery));
	}

	/**
	 * will return 0 if everything is fine, 1 if there is some problem and 2 if there is a serious problem
	 */
	public int check4Problem() {
		
		// first we check for problems level 2 (= highest severity)
		for (StructuralElement element : elements) {
			if (element.getStructuralIntegrity() < 10) {
				return 2;
			} else if (element.getTemperature() > 50) {
				return 2;
			}
		}
		
		if (oxygen < 100L) {
			return 2;
		}
		
		if (battery < 100d) {
			return 2;
		}
		
		// now check if we have a level 1 problem
		for (StructuralElement element : elements) {
			if (element.getStructuralIntegrity() < 25) {
				return 1;
			} else if (element.getTemperature() > 70) {
				return 1;
			}
		}
		
		if (oxygen < 1000L) {
			return 1;
		}
		
		if (battery < 1000d) {
			return 1;
		}
		
		// everything is fine:
		return 0;
	}

	public List<StructuralElement> getElements() {
		return elements;
	}

	public void setElements(List<StructuralElement> elements) {
		this.elements = elements;
	}

	public long getOxygen() {
		return oxygen;
	}

	public void setOxygen(long oxygen) {
		this.oxygen = oxygen;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}
	
	
}
