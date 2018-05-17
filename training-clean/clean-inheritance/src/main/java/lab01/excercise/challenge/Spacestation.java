package lab01.excercise.challenge;

public class Spacestation extends Debris {

	public Spacestation(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, 10000L);
	}

	@Override
	public void setMass(long newMass) {
		
		if (getMass() > newMass) {
			throw new IllegalArgumentException("A Spacestation cannot get smaller, it can only be extended by adding new modules");
		}
		
		super._setMass(newMass);
	}
	
	
}
