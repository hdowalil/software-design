package lab01.sample.challenge;

import java.util.Random;

@FunctionalInterface
public interface Experiment {
	
	static Experiment defaultExperiment = ()-> {
		   return (new Random()).nextLong();
		};
		
	public long run();

}
