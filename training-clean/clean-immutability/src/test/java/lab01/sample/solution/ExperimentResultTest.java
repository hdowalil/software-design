package lab01.sample.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab01.sample.challenge.Experiment;
import lab01.sample.challenge.Laboratory;
import lab01.sample.common.Scientist;


public class ExperimentResultTest {

	@Test
	public void repeatableExperimentResult() {
		
		Experiment task = () -> { return 4242L; };
		
		ExperimentResult result = (new ExperimentRunner(task,new Scientist(),new Laboratory() )).run();
		
		List<ExperimentResult> allResults = new ArrayList<ExperimentResult>(Arrays.asList(result));
		
		// lets repeat a thousand times, as every lab has some distortion, we will have different results in the list
		for (int i=0; i<1000; i++) {
			allResults.add(result.rerun());
		}
		
		List<Long> allDistinctResults = allResults.stream().map(er -> er.getResultValue()).distinct().collect(Collectors.toList());
		
		// we should have plenty of different result values in the list, not just one and the same of the first run
		Assertions.assertTrue(allDistinctResults.size() > 1);
		
		// now the average should be close to original 4710
		long sum = allResults.stream().map(er -> er.getResultValue()).collect(Collectors.summarizingLong(Long::longValue)).getSum();
		long average = Math.round( (double) sum / (double) allResults.size() );
		
		Assertions.assertTrue( (4200 < average && average < 4300), "should be close to the original result +- a few" );
	}
}
