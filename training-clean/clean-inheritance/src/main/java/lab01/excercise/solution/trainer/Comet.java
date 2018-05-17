package lab01.excercise.solution.trainer;

public final class Comet extends SpaceDebris {

	private final static long INITIAL_COMET_EXTENT = 25000L;
	
	public Comet(long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ, INITIAL_COMET_EXTENT);
	}
	
}
