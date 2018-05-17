package lab01.excercise.solution.trainer;

public abstract class Debris {
	
	private long positionX;
	private long positionY;
	private long positionZ;
	private long mass;
	
	public Debris(long positionX, long positionY, long positionZ, long mass) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.mass = mass;
	}

	protected void _setMass(long newMass) {
		this.mass = newMass;
	}
	
	public abstract void setMass(long newMass);
		
	public long getMass() {
		return mass;
	}
	
	public long getPositionX() {
		return positionX;
	}

	public long getPositionY() {
		return positionY;
	}

	public long getPositionZ() {
		return positionZ;
	}

	

}
