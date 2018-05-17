package lab02.sample.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpaceStationExperimentTest {

	@Test
	public void runExperiment() {
		
		 StructuralElement coreElement = new StructuralElement();
		 SpaceStation station = new SpaceStation(coreElement);
		 
		 Astronaut alice = new Astronaut();
		 Astronaut bob = new Astronaut(); 
		 station.sendAstronauts(alice, bob);
		 
		 Assertions.assertTrue(station.isAstronautOnBoard(alice),
				 "Alice should be on board now!");
		 Assertions.assertTrue(station.isAstronautOnBoard(bob),
				 "Bob should be on board now!");
		  
		 Experiment experiment2Run = new Experiment();
		 long result = station.runExperiment(experiment2Run);
		 System.out.println(String.format("Experiment result is: %d",result));
		  
		 int evacuatedAstronauts = station.emergencyEvacuate();
		 Assertions.assertEquals(2, evacuatedAstronauts,
				 "We should have been able to evacuate both astronauts, that were on board!");
	}
	
}
