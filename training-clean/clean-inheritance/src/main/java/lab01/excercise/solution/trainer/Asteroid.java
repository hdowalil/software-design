package lab01.excercise.solution.trainer;

public final class Asteroid extends SpaceDebris {

	private final static long INITIAL_ASTEROID_EXTENT = 100000L;
	
	public Asteroid(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, INITIAL_ASTEROID_EXTENT);
	}
	
}
