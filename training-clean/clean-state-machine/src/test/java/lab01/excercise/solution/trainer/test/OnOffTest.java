package lab01.excercise.solution.trainer.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnOffTest {

	@Test
	public void testOnOff() {
		
		LightBulbOnOffStub lightBulb = new LightBulbOnOffStub();
		
		Assertions.assertFalse(lightBulb.isIlluminated());
		
		lightBulb.switchOff();
		Assertions.assertFalse(lightBulb.isIlluminated());
		
		lightBulb.switchOn();
		Assertions.assertTrue(lightBulb.isIlluminated());
		
		lightBulb.switchOn();
		Assertions.assertTrue(lightBulb.isIlluminated());
		
		lightBulb.switchOff();
		Assertions.assertFalse(lightBulb.isIlluminated());
		
	}
}
