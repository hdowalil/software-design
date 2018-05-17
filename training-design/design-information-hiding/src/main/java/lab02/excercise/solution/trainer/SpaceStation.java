package lab02.excercise.solution.trainer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnegative;

import lab02.excercise.common.Battery;
import lab02.excercise.common.Experiment;
import lab02.excercise.common.SolarPanel;
import lab02.excercise.common.SpaceLaboratory;

public class SpaceStation implements SpaceLaboratory {
	
	private List<SolarPanel> solarPanels;
	private Battery battery;
	
	public SpaceStation(@Nonnegative double batteryCapacity) {
		super();
		solarPanels = new ArrayList<>();
		battery = new Battery(batteryCapacity);
	}
	
	public int getNoOfSolarPanels() {
		return solarPanels.size();
	}
	
	public int getNoOfCellsOfSolarPanel(@Nonnegative int index) {
		return solarPanels.get(index).getNoOfCells();
	}
	
	public void removeSolarPanel(@Nonnegative int index) {
		solarPanels.remove(index);
	}
	
	public void addSolarPanel(@Nonnegative int noOfCells) {
		solarPanels.add(new SolarPanel(noOfCells, battery));
	}
	
	public void hoursOfSunshine(@Nonnegative final int hours) {
		solarPanels.stream().forEach(p -> p.receiveHoursOfSunshine(hours));
	}

	public int runExperiment (int input1, int input2) {
		
		Experiment ex = new Experiment(input1, input2);
		return ex.runExperiment(this, battery);
	}
	
}
