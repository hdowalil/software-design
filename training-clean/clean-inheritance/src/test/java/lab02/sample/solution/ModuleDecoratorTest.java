package lab02.sample.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab02.sample.common.Astronaut;

public class ModuleDecoratorTest {
	
	@Test
	public void testLivingModuleWithSolarPanels() {
		
		BatteryStub battery = new BatteryStub();
		
		SpaceStationModuleDecoratorLiving living = new SpaceStationModuleDecoratorLiving(2, 12);
		SpaceStationModuleDecoratorSolarPanels module = new SpaceStationModuleDecoratorSolarPanels(living, battery);
		
		Astronaut n1 = new Astronaut("N1");
		Astronaut n2 = new Astronaut("N1");
		Astronaut n3 = new Astronaut("N1");
		Astronaut n4 = new Astronaut("N1");
		
		for (int i=0; i<50; i++) {
			n1.doSomething();
			n2.doSomething();
			n3.doSomething();
			n4.doSomething();
		}
		
		Assertions.assertEquals(50, n1.getFatigueInPercent());
		Assertions.assertEquals(50, n2.getFatigueInPercent());
		Assertions.assertEquals(50, n3.getFatigueInPercent());
		Assertions.assertEquals(50, n4.getFatigueInPercent());
		
		for (int i=0; i<100; i++) {
			module.receiveSunshine();
		}
		
		Assertions.assertEquals(10.0d,battery.ampereHours,0.1d,"Should be charged 10 amperehours");
		
		module.restAstronauts(n1, n2, n3, n4);
		
		Assertions.assertEquals(38, n1.getFatigueInPercent(), "Should have slept in bed");
		Assertions.assertEquals(38, n2.getFatigueInPercent(), "Should have slept in bed");
		Assertions.assertEquals(49, n3.getFatigueInPercent(), "Should have slept in closet");
		Assertions.assertEquals(49, n4.getFatigueInPercent(), "Should have slept in closet");
		
	}

	public static void main(String[] args) {
		
		ModuleDecoratorTest test = new ModuleDecoratorTest();
		test.testLivingModuleWithSolarPanels();
	}
	
}
