package lab02.exercise.solution.trainer;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jdepend.framework.JDepend;

public class NoCyclesTest {
	
	@Test
	public void testPackagesFreeOfCycles() throws IOException {
		
		JDepend jd = new JDepend();
		jd.addDirectory("target/classes");
		jd.analyze();
		Assertions.assertFalse(jd.containsCycles());
	}

}
