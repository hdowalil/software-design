package lab01.excercise.solution.trainer.universe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

/**
 * 
 * bears asteroids etc.
 * <br>
 * our universe is rather static, we will have to call an API to move things around, they do not move on their own
 * <br>
 * can hold space stations and will send it updates if asteroids move
 * 
 */
public final class Space {
	
	private List<Debris> allDebrisInSpace;
	private List<DebrisMovementObserver> allDebrisMovementObserver;
	
	public Space() {
		super();
		allDebrisInSpace = new ArrayList<Debris>();
	}
	
	public Debris getDebris(int index) {
		return allDebrisInSpace.get(index);
	}
	
	public int getNumberOfDebris() {
		return allDebrisInSpace.size();
	}

	public Stream<Debris> getDebrisStream() {
		return allDebrisInSpace.stream();
	}
	
	void clear() {
		allDebrisInSpace.clear();
	}
	
	public Space addObserver(@Nonnull DebrisMovementObserver observer) {
		
		Objects.requireNonNull(observer);
		
		allDebrisMovementObserver = Optional.ofNullable(allDebrisMovementObserver).orElse(new ArrayList<DebrisMovementObserver>());
		allDebrisMovementObserver.add(observer);
		
		assert allDebrisMovementObserver.size() > 0;
		
		return this;
	}
	
	public Space deployDebris(Debris debris) {
		
		if (allDebrisInSpace.contains(debris)) {
			throw new IllegalArgumentException();
		}
		
		allDebrisInSpace.add(debris);
		
		return this;
	}
	
	public Debris deployDebris(long positionX, long positionY, long positionZ,int extent) {
		
		Debris debris = new Debris(positionX, positionY, positionZ, extent);
		
		allDebrisInSpace.add(debris);
		
		return debris;
	}
	
	/**
	 * 
	 * Debris should only be moved by this method, so that we can call their collision methods
	 * 
	 * @param debris
	 * @param deltaX
	 * @param deltaY
	 * @param deltaZ
	 */
	public void moveDebris(final Debris debris, final int deltaX, final int deltaY, final int deltaZ) {
		
		Objects.requireNonNull(debris);
		
		if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1 || Math.abs(deltaZ) > 1) {
			throw new IllegalArgumentException("can move debris only slowly, 1 unit per time");
		}
		
		debris.move(deltaX, deltaY, deltaZ);
		
		allDebrisInSpace.
			stream().
			filter(d -> d.isCollision(debris)).
			forEach(d -> { d.collide(debris); debris.collide(d); });
		
		if (allDebrisMovementObserver != null) {
			allDebrisMovementObserver.forEach(o -> o.debrisHasMoved(debris));
		}
		
	}
	
	public boolean willDebrisMaybeCollideSoonWithAnyOtherDebris(@Nonnull Debris input) {
		
		Objects.requireNonNull(input);
		
		return allDebrisInSpace.
				stream().
				filter(d -> input.isCloseTo(d)).
				findAny().
				isPresent();
	}

}
