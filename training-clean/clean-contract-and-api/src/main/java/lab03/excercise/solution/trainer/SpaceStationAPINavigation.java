package lab03.excercise.solution.trainer;


public interface SpaceStationAPINavigation {

	public void moveLeft();
	
	public void moveRight();
	
	public void moveUp();
	
	public void moveDown();
	
	public void moveBackwards();
	
	public void moveForward();
	
	public long getPositionX();

	public long getPositionY();

	public long getPositionZ();
}
