package lab01.excercise.solution.trainer;

public final class Spaceship extends Debris {
	
	private final static long SPACESHIP_EXTENT = 5000L;

	public Spaceship(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, SPACESHIP_EXTENT);
	}

	@Override
	public void setMass(long newMass) {
		
		if (getMass() != newMass) {
			throw new IllegalArgumentException("A Spaceship cannot grow or lose weight");
		}
	}
	
}
