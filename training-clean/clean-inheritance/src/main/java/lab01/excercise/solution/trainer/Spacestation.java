package lab01.excercise.solution.trainer;

public final class Spacestation extends Debris {
	
	private final static long INITIAL_SPACESTATION_EXTENT = 10000L;

	public Spacestation(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, INITIAL_SPACESTATION_EXTENT);
	}

	@Override
	public void setMass(long newMass) {
		
		if (getMass() > newMass) {
			throw new IllegalArgumentException("A Spacestation cannot get smaller, it can only be extended by adding new modules");
		}
		
		super._setMass(newMass);
	}
	
	
}
