package lab02.sample.solution;

/**
 * Please bear in mind these contraints when using this class:
 * <ul>
 * <li>There always has to be at least one {@link StructuralElement}, 
 * do not remove the Core-Element supplied in the constructor</li>
 * <li>To run an {@link Experiment} you will have to have at least one {@link Astronaut} on board</li>
 * </ul>
 * 
 * Sample usage:
 * <pre>
 * StructuralElement coreElement = new StructuralElement();
 * SpaceStation station = new SpaceStation(coreElement);
 * 
 * Astronaut alice = new Astronaut();
 * Astronaut bob = new Astronaut(); 
 * station.sendAstronauts(alice, bob);
 * assert station.isAstronautOnBoard(alice);
 * assert station.isAstronautOnBoard(bob);
 * 
 * Experiment experiment2Run = new Experiment();
 * long result = station.runExperiment(experiment2Run);
 * System.out.println(String.format("Experiment result is: %d",result));
 * 
 * assert 2 == station.emergencyEvacuate();
 * </pre>
 */
public class SpaceStation {
	
	@SuppressWarnings("unused")
	private StructuralElement coreElement;

	/**
	 * @param coreElement The core element of the station, that must not be removed with {@link SpaceStation#removeElement(StructuralElement)}
	 */
	public SpaceStation(StructuralElement coreElement) {
		super();
		this.coreElement = coreElement;
	}
	
	/**
	 * Will create a space station with a default structural core element using {@link SpaceStation#SpaceStation(StructuralElement)}
	 */
	public SpaceStation() {
		this (new StructuralElement());
	}

	public void addElement (StructuralElement element) {
		// Dummy Method Body
	}
	
	public void removeElement (StructuralElement element) {
		// Dummy Method Body
	}

	public void sendAstronauts(Astronaut... astronauts) {
		// Dummy Method Body
	}
	
	public boolean isAstronautOnBoard(Astronaut astronaut) {
		// Dummy Method Body
		return true;
	}
	
	public void getAstronautBackHome(Astronaut astronaut) {
		// Dummy Method Body
	}
	
	/**
	 * Use this method, in case of a problem on the Station. 
	 * Otherwise just bring them back using {@link #getAstronautBackHome(Astronaut)} 
	 * 
	 * @return Number of {@link Astronaut} that we were able to evacuate 
	 */
	public int emergencyEvacuate() {
		// Dummy Method Body
		return 0;
	}
	
	/**
	 * You can use this method if you have one {@link Astronaut} on board. 
	 *
	 * @param experiment The experiment, that you want to run. Must not be null
	 * @throws IllegalStateException if no Astronauts on board.
	 * @return The result of the Experiment
	 */
	public long runExperiment(Experiment experiment) {
		// Dummy Method Body
		return 0L;
	}

}
