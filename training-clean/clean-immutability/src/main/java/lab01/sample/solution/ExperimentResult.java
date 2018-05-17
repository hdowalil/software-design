package lab01.sample.solution;

import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class ExperimentResult {

	private ExperimentRunner runner = null;
	private long result;
	
	ExperimentResult(ExperimentRunner runner, long result) {
		super();
		this.runner = runner;
		this.result = result;
	}

	@CheckReturnValue
	public ExperimentResult rerun() {
		return runner.run();
	}

	public long getResultValue() {
		return result;
	}
	
}
