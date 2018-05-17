package lab01.sample.challenge;

import java.util.Objects;
import java.util.Random;

import javax.annotation.Nonnull;

import lab01.sample.common.Scientist;

public class Laboratory {

	public long runExperiment (@Nonnull Experiment task, @Nonnull Scientist scientist) {
		
		Objects.requireNonNull(task);
		Objects.requireNonNull(scientist);
		
		long experimentResult = task.run();
		long distortion = (new Random()).nextInt(100) - 50;
		
		return experimentResult + distortion; 
	}
}
