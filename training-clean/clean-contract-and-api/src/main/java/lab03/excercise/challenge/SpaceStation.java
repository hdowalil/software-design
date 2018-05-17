package lab03.excercise.challenge;

import javax.annotation.Nonnegative;

public class SpaceStation {
	
	private long positionX;
	private long positionY;
	private long positionZ;
	
	public SpaceStation(long positionX, long positionY, long positionZ) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
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

	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}
	
	public void moveBackwards() {
		
	}
	
	public void moveForward() {
		
	}

	public double consume(@Nonnegative double ampereHours) {
		return 0.0d;
	}

	public double charge(@Nonnegative double ampereHours) {
		return 0.0d;
	}
		
	public double energyLeftInAmpereHours() {
		return 0.0d;
	}
	
}
