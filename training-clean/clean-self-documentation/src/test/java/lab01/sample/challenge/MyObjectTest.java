package lab01.sample.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyObjectTest {
	
	@ParameterizedTest
	@CsvSource({ "true, 10, 1, true, 2000", "false, 10, 1, true, 1000", "false, 50, 3, false, 2000" })	
	public void testValue(boolean related, int percentage, int years, boolean ext, long expected) {
		
		MyObject myo = new MyObject(related, percentage, years, ext);
		Assertions.assertEquals(expected,myo.getValue(),"Should be: " + Long.toString(expected));
	}

}
