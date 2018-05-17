package lab01.excercise.challenge.universe;

import java.util.Arrays;
import java.util.function.Consumer;

public class Debris {
	
	private final static int CLOSE = 100;

	protected long positionX=0;
	protected long positionY=0;
	protected long positionZ=0;
	protected int extent=1;
	
	private Consumer<Debris> collisionConsumer = null;
	
	protected Debris(long positionX, long positionY, long positionZ,int extent) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.extent = extent;
	}
	
	/**
	 * 
	 * if this is null, the debris is unnamed. like small meteorites, or space garbage in earths orbit
	 * 
	 * @return
	 */
	public String getName() {
		return null;
	}

	/**
	 * when space detects collision with another debris, after debris movement, it will call this
	 */
	public void collide(Debris otherDebris) {
		if (otherDebris != null && collisionConsumer != null) {
			collisionConsumer.accept(otherDebris);
		}
	}
	
	public void setCollisionConsumer(Consumer<Debris> collisionConsumer) {
		this.collisionConsumer = collisionConsumer;
	}

	public int getExtent() {
		return extent;
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

	/**
	 * 
	 * this method should only be called by Space class!
	 * 
	 * @param deltaX
	 * @param deltaY
	 * @param deltaZ
	 */
	void move(int deltaX, int deltaY, int deltaZ) {
		this.positionX += deltaX;
		this.positionY += deltaY;
		this.positionZ += deltaZ;
	}

	/*
	 * Will determine the maximum distance in one coordiate.
	 * This is interesting, as it is relevant for how close another debris is.
	 * if it is far away in only one coordinate, it is far away.
	 * Imagine there is one lightyear between you and stgh else in z coordinate and others are just same 
	 */
	private long getMaxDistanceCoordinate(Debris anotherDebris) {
		
		return 
			Arrays.
				asList(Math.abs(anotherDebris.positionX-positionX),
						Math.abs(anotherDebris.positionY-positionY),
						Math.abs(anotherDebris.positionZ-positionZ)).
				stream().
				mapToLong(Long::longValue).
				max().
				// orElse will only happen when stream is empty, which it cannot be!
				orElseThrow(RuntimeException::new);
	}
	
	public boolean isCloseTo(Debris anotherDebris) {
		
		if (anotherDebris == null || this == anotherDebris) {
			// this is not a collision, it is the same debris!
			return false;
		}
		
		long distance = getMaxDistanceCoordinate(anotherDebris);
		
		return ( (distance - extent) <= CLOSE);
	}
	
	public boolean isCollision(Debris anotherDebris) {
		
		if (anotherDebris == null || this == anotherDebris) {
			// this is not a collision, it is the same debris!
			return false;
		}
		
		long distance = getMaxDistanceCoordinate(anotherDebris);
		
		int myRadius = (int) Math.ceil((double)extent / 2d);
		int otherRadius = (int) Math.ceil((double)anotherDebris.extent / 2d);
		int bothRadius = myRadius + otherRadius;
		
		return ( (distance - bothRadius) <= 0);
	}
	

}
