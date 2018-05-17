package lab02.excercise.common;

import java.util.Objects;
import java.util.Random;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class Experiment {
	
	private int input1;
	private int input2;

	public Experiment(@Nonnegative int input1, @Nonnegative int input2) {
		super();
		this.input1 = input1;
		this.input2 = input2;
	}

	public int runExperiment(@Nonnull SpaceLaboratory lab, @Nonnull Battery energySource) {
		
		Objects.requireNonNull(lab);
		Objects.requireNonNull(energySource);
		
		energySource.use(2d);
		Random rnd = new Random(input1);
		return rnd.nextInt(input2);
	}

}
