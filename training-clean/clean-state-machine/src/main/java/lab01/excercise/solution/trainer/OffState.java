package lab01.excercise.solution.trainer;

import java.util.Objects;

import javax.annotation.Nonnull;

import lab01.excercise.challenge.OnOffState;

final class OffState  implements OnOffState {

	private OnOffContext stateMachine;
	
	OffState(@Nonnull OnOffContext stateMachine) {
		super();
		
		Objects.requireNonNull(stateMachine);
		this.stateMachine = stateMachine;
	}

	@Override
	public void switchOn() {
		stateMachine.setState(stateMachine.onState);
		stateMachine.callback.turnedOn();
	}

	@Override
	public void switchOff() {
		// nothing to do
	}

}
