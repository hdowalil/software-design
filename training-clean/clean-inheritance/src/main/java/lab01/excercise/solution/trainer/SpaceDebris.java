package lab01.excercise.solution.trainer;

public abstract class SpaceDebris extends Debris {

	public SpaceDebris(long positionX, long positionY, long positionZ, long mass) {
		super(positionX, positionY, positionZ, mass);
	}
	
	@Override
	public void setMass(long newMass) {
		
		if (getMass() < newMass) {
			throw new IllegalArgumentException("Space debris can only loose mass, not gain any");
		}
		
		_setMass(newMass);
	}
	
}
