package lab02.excercise.challenge;

import java.util.ArrayList;

import lab02.excercise.common.Battery;
import lab02.excercise.common.Experiment;
import lab02.excercise.common.SolarPanel;

public class MissionControl {

	public static void main(String[] args) {
		
		SpaceStation station = new SpaceStation();
		
		station.setBattery(new Battery(5000d));
		station.setSolarPanels(new ArrayList<>());
		station.getSolarPanels().add(new SolarPanel(50, station.getBattery()));
		station.getSolarPanels().add(new SolarPanel(50, station.getBattery()));
		
		station.getSolarPanels().stream().forEach(p -> p.receiveHoursOfSunshine(1));
		
		Experiment theMeaningOfLifeAndEverything = new Experiment(5311, 100);
		int exResult = theMeaningOfLifeAndEverything.runExperiment(station, station.getBattery());
		System.out.println(String.format("Experiment Result: %d",exResult));
	}

}
