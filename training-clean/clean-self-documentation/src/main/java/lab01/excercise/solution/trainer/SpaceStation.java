package lab01.excercise.solution.trainer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
	
	private final static long INITIAL_LEVEL_OF_OXYGEN = 10000L;
	private final static double INITIAL_LEVEL_OF_AMPERE_HOURS_IN_A_BATTERY = 10000d;
	
	private final static long YELLOW_ALERT_OXYGEN = 1000L;
	private final static long RED_ALERT_OXYGEN = 100L;
	private final static double YELLOW_ALERT_BATTERY_AMPERE_HOURS = 1000d;
	private final static double RED_ALERT_BATTERY_AMPERE_HOURS = 100d;

	private List<StructuralElement> elements =  new ArrayList<StructuralElement>();
	private long oxygen = INITIAL_LEVEL_OF_OXYGEN;
	private double batteryAmpereHours = INITIAL_LEVEL_OF_AMPERE_HOURS_IN_A_BATTERY;

	public void logStatus (PrintStream out) {
		out.println(
				String.format("Number of Elements: %d / Oxygen: %d / Battery: %.2f",
						elements.size(), oxygen, batteryAmpereHours));
	}

	private Alert checkOxygen4Alert() {
		if (this.oxygen < RED_ALERT_OXYGEN) {
			return Alert.RED; 
		} else if (this.oxygen < YELLOW_ALERT_OXYGEN) {
			return Alert.YELLOW;
		} else {
			return Alert.GREEN;
		}
	}
	
	private Alert checkBattery4Alert() {
		if (this.batteryAmpereHours < RED_ALERT_BATTERY_AMPERE_HOURS) {
			return Alert.RED; 
		} else if (this.batteryAmpereHours < YELLOW_ALERT_BATTERY_AMPERE_HOURS) {
			return Alert.YELLOW;
		} else {
			return Alert.GREEN;
		}
	}
	
	public Alert check4Problem() {
		
		return Alert.getMaximumSeverity(
				StructuralElement.checkElements4Alert(this.elements),
				checkOxygen4Alert(),
				checkBattery4Alert());
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

	public double getBatteryAmpereHours() {
		return batteryAmpereHours;
	}

	public void setBatteryAmpereHours(double batteryAmpereHours) {
		this.batteryAmpereHours = batteryAmpereHours;
	}
	
	
}
