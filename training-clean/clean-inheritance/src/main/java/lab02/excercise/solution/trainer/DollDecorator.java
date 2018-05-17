package lab02.excercise.solution.trainer;

import java.util.Objects;

import lab02.excercise.common.SpeakingDoll;

abstract class DollDecorator implements SpeakingDoll {

	SpeakingDoll delegate;

	public DollDecorator(SpeakingDoll delegate) {
		
		super();
		
		Objects.requireNonNull(delegate);
		this.delegate = delegate;
	}

	public String speak() {
		return delegate.speak();
	}
	
}
