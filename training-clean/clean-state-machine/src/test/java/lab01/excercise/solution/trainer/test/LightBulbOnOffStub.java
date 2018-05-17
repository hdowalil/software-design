package lab01.excercise.solution.trainer.test;

import lab01.excercise.challenge.OnOffState;
import lab01.excercise.solution.trainer.OnOffCallback;
import lab01.excercise.solution.trainer.OnOffContext;

public class LightBulbOnOffStub implements OnOffCallback, OnOffState {

	OnOffState stateMachine = null;
	boolean light = false;
	
	public LightBulbOnOffStub() {
		super();
		stateMachine = new OnOffContext(this);
	}

	/**
	 * External API Method
	 */
	@Override
	public void switchOn() {
		stateMachine.switchOn();
	}

	/**
	 * External API Method
	 */
	@Override
	public void switchOff() {
		stateMachine.switchOff();
	}

	/**
	 * Callback Method
	 */
	@Override
	public void turnedOn() {
		this.light = true;
	}

	/**
	 * Callback Method
	 */
	@Override
	public void turnedOff() {
		this.light = false;
	}

	public boolean isIlluminated() {
		return light;
	}
	
}
