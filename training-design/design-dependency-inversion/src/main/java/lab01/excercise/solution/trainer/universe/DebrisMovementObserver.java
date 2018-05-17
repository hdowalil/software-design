package lab01.excercise.solution.trainer.universe;

import javax.annotation.Nonnull;

@FunctionalInterface
public interface DebrisMovementObserver {
	
	public void debrisHasMoved(@Nonnull Debris debrisThatHasMoved);

}
