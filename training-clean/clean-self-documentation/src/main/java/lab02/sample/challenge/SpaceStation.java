package lab02.sample.challenge;

import lab02.sample.solution.StructuralElement;

/**
 * This class represents a Space Station. 
 * You can add and remove {@link StructuralElement} with it.
 * You can also send {@link Astronaut} and get them back home.
 * You can also evacuate the station in case of emergency.
 * With the according method you can run experiments in the station.
 */
public class SpaceStation {

	public void addElement (StructuralElement element) {
		// ...
	}
	
	public void removeElement (StructuralElement element) {
		// ...
	}

	public void sendAstronauts(Astronaut... astronauts) {
		// ...
	}
	
	public void getAstronautBackHome(Astronaut astronaut) {
		// ...
	}
	
	public int emergencyEvacuate() {
		// ...
		return 0;
	}
	
	public long runExperiment(Experiment experiment) {
		// ...
		return 0;
	}
	
}
