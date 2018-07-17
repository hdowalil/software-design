package lab01.excercise.challenge.spacestation;

import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnull;

import lab01.excercise.challenge.universe.Debris;
import lab01.excercise.challenge.universe.Space;

public final class SpaceStation extends Debris {
	
	private final static int STATION_SIZE = 10; 
	
	private Space space = null;
	
	private boolean collision = false;
	private Alert alert = null;
	
	public SpaceStation(Space space, long positionX, long positionY, long positionZ) {
		super(positionX, positionY, positionZ,STATION_SIZE);
		this.space=space;
		this.space.deployDebris(this);
		setCollisionConsumer((d) -> {
			collision();
		});
	}

	private void collision() {
		this.collision = true;
		check4Alert();
	}
	
	public void debrisHasMoved(@Nonnull Debris debrisThatHasMoved) {
	
		Objects.requireNonNull(debrisThatHasMoved);
		
		// we were called by space, that sthg has happend
		check4Alert();
	}
	
	public Optional<Alert> getAlert() {
		return Optional.ofNullable(alert);
	}
	
	Optional<Alert> check4Alert() {
		
		if (collision) {
			alert = Alert.RED;
			// evacuate ship!
		} else if (space.willDebrisMaybeCollideSoonWithAnyOtherDebris(this)) {
			alert = Alert.YELLOW;
		} else {
			alert = null;
		}
		
		return getAlert();
	}
	
	public void moveLeft() {
		_move (-1,0,0);
	}
	
	public void moveRight() {
		_move (1,0,0);
	}
	
	public void moveUp() {
		_move (0,1,0);
	}
	
	public void moveDown() {
		_move (0,-1,0);
	}
	
	public void moveBackwards() {
		_move (0,0,-1);
	}
	
	public void moveForward() {
		_move (0,0,1);
	}
	
	private void _move(int deltaX, int deltaY, int deltaZ) {
		space.moveDebris(this,deltaX, deltaY, deltaZ);
		// should trigger debrishasmoved, that will call check4alert to check for debris closing in
	}
	
}
