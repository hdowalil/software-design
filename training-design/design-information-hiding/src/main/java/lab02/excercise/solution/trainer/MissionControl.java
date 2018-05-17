package lab02.excercise.solution.trainer;

public class MissionControl {

	public static void main(String[] args) {

		SpaceStation station = new SpaceStation(5000d);
		station.addSolarPanel(50);
		station.addSolarPanel(50);
		station.hoursOfSunshine(1);
		
		System.out.println(String.format("The meaning of life: %d",station.runExperiment(5311, 100)));

	}

}
