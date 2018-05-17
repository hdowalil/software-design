package lab02.excercise.challenge;

import java.util.List;

import lab02.excercise.common.Battery;
import lab02.excercise.common.SolarPanel;
import lab02.excercise.common.SpaceLaboratory;

public class SpaceStation implements SpaceLaboratory {
	
	private Battery battery;
	private List<SolarPanel> solarPanels;
	
	public Battery getBattery() {
		return battery;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public List<SolarPanel> getSolarPanels() {
		return solarPanels;
	}
	public void setSolarPanels(List<SolarPanel> solarPanels) {
		this.solarPanels = solarPanels;
	}
	
}
