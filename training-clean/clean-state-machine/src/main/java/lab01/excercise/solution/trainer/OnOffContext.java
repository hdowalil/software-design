package lab01.excercise.solution.trainer;

import java.util.Objects;

import javax.annotation.Nonnull;

import lab01.excercise.challenge.OnOffState;

public final class OnOffContext implements OnOffState {

	OnOffState onState=null;
	OnOffState offState=null;
	
	private OnOffState currentState = null; 
	
	OnOffCallback callback = null;

	public OnOffContext(@Nonnull OnOffCallback callback) {
		super();
		
		Objects.requireNonNull(callback);
		
		this.callback = callback;
		this.onState = new OnState(this);
		this.offState = new OffState(this);
		this.currentState = offState;
	}
	
	void setState(OnOffState newState) {
		currentState = newState;
	}

	@Override
	public void switchOn() {
		currentState.switchOn();
	}

	@Override
	public void switchOff() {
		currentState.switchOff();
	}
	
}
