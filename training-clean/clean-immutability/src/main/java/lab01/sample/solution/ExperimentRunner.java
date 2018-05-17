package lab01.sample.solution;

import java.util.Objects;

import javax.annotation.Nonnull;

import lab01.sample.challenge.Experiment;
import lab01.sample.challenge.Laboratory;
import lab01.sample.common.Scientist;

/**
 * 
 * This class acts as a builder for ExperimentResult
 *
 */
public final class ExperimentRunner {
	
	private Experiment task;
	private Scientist scientist;
	private Laboratory laboratory;

	public ExperimentRunner(@Nonnull Experiment task, @Nonnull Scientist scientist, @Nonnull Laboratory laboratory) {
		
		super();
				
		Objects.requireNonNull(task);
		Objects.requireNonNull(scientist);
		Objects.requireNonNull(laboratory);
		
		this.task = task;
		this.scientist = scientist;
		this.laboratory = laboratory;
	}
	
	public ExperimentResult run () {
		
		long result = laboratory.runExperiment(task, scientist);
		return new ExperimentResult(this, result);
	}
}