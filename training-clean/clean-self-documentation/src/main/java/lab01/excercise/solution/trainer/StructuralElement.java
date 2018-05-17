package lab01.excercise.solution.trainer;

import java.util.Collection;
import java.util.Objects;

public class StructuralElement {
	
	private final static int YELLOW_ALERT_INTEGRITY = 25;
	private final static int RED_ALERT_INTEGRITY = 10;
	private final static int YELLOW_ALERT_TEMPERATURE = 50;
	private final static int RED_ALERT_TEMPERATURE = 70;

	private int structuralIntegrityPercent;
	private int temperatureInCelsius;
	
	public StructuralElement(int structuralIntegrityPercent, int temperatureInCelsius) {
		super();
		this.structuralIntegrityPercent = structuralIntegrityPercent;
		this.temperatureInCelsius = temperatureInCelsius;
	}

	private static Alert checkIntegrity4Alert(Collection<StructuralElement> elements) {
		
		int minIntegrity = elements.stream().map(e -> e.getStructuralIntegrityPercent()).min(Integer::compare).orElse(100);
		
		if (minIntegrity < RED_ALERT_INTEGRITY) {
			return Alert.RED;
		} else if (minIntegrity < YELLOW_ALERT_INTEGRITY) {
			return Alert.YELLOW;
		} else {
			return Alert.GREEN;
		}
	}
	
	private static Alert checkTemperature4Alert(Collection<StructuralElement> elements) {
		
		int maxTemperature = elements.stream().map(e -> e.getTemperatureInCelsius()).max(Integer::compare).orElse(20);
		
		if (maxTemperature > RED_ALERT_TEMPERATURE) {
			return Alert.RED;
		} else if (maxTemperature > YELLOW_ALERT_TEMPERATURE) {
			return Alert.YELLOW;
		} else {
			return Alert.GREEN;
		}
	}
	
	public static Alert checkElements4Alert(Collection<StructuralElement> elements) {
		
		Objects.requireNonNull(elements);
		
		return Alert.getMaximumSeverity(
				checkIntegrity4Alert(elements),
				checkTemperature4Alert(elements));
	}

	public int getStructuralIntegrityPercent() {
		return structuralIntegrityPercent;
	}

	public void setStructuralIntegrityPercent(int structuralIntegrityPercent) {
		this.structuralIntegrityPercent = structuralIntegrityPercent;
	}

	public int getTemperatureInCelsius() {
		return temperatureInCelsius;
	}

	public void setTemperatureInCelsius(int temperatureInCelsius) {
		this.temperatureInCelsius = temperatureInCelsius;
	}
	
	
	
}
