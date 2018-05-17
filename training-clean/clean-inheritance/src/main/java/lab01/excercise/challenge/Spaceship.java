package lab01.excercise.challenge;

public class Spaceship extends Debris {

	public Spaceship(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, 5000L);
	}

	@Override
	public void setMass(long newMass) {
		
		if (getMass() != newMass) {
			throw new IllegalArgumentException("A Spaceship cannot grow or lose weight");
		}
	}
	
}
