package lab03.excercise.solution.trainer;

import javax.annotation.Nonnegative;

import lab02.excercise.solution.trainer.Battery;

public class SpaceStation implements SpaceStationAPINavigation, SpaceStationAPIResources {
	
	private long positionX;
	private long positionY;
	private long positionZ;
	private Battery battery;
	
	public SpaceStation(long positionX, long positionY, long positionZ,@Nonnegative double batteryCapacity) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.battery = new Battery(batteryCapacity);
	}
	
	@Override
	public long getPositionX() {
		return positionX;
	}

	@Override
	public long getPositionY() {
		return positionY;
	}

	@Override
	public long getPositionZ() {
		return positionZ;
	}

	@Override
	public void moveLeft() {
		positionX--;
	}
	
	@Override
	public void moveRight() {
		positionX++;
	}
	
	@Override
	public void moveUp() {
		positionY++;
	}
	
	@Override
	public void moveDown() {
		positionY--;
	}
	
	@Override
	public void moveBackwards() {
		positionZ--;
	}
	
	@Override
	public void moveForward() {
		positionZ++;
	}

	@Override
	public double consume(@Nonnegative double ampereHours) {
		return battery.consume(ampereHours);
	}

	@Override
	public double charge(@Nonnegative double ampereHours) {
		return battery.consume(ampereHours);
	}
		
	@Override
	public double energyLeftInAmpereHours() {
		return battery.energyLeftInAmpereHours();
	}
	
}
