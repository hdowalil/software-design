package lab01.excercise.solution.trainer;

import lab01.excercise.challenge.OnOffState;

final class OnState  implements OnOffState {

	private OnOffContext stateMachine;
	
	OnState(OnOffContext stateMachine) {
		super();
		this.stateMachine = stateMachine;
	}

	@Override
	public void switchOn() {
		// nothing to do
	}

	@Override
	public void switchOff() {
		stateMachine.setState(stateMachine.offState);
		stateMachine.callback.turnedOff();
	}

}
