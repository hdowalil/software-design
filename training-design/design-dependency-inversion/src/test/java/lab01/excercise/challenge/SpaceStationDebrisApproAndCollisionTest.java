package lab01.excercise.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lab01.excercise.challenge.spacestation.Alert;
import lab01.excercise.challenge.spacestation.SpaceStation;
import lab01.excercise.challenge.universe.Debris;
import lab01.excercise.challenge.universe.Space;

public class SpaceStationDebrisApproAndCollisionTest {
	
	@Test
	public void testAlerts() {
		
		Space space = new Space();
		
		Debris asteroid1 = space.deployDebris(1000,-1000,1000,25);
		@SuppressWarnings("unused")
		Debris asteroid2 = space.deployDebris(1000,1000,1000,50);

		SpaceStation station = new SpaceStation(space, 0, 0, 0);
		
		for (int i=0; i<850; i++) {
			space.moveDebris(asteroid1,-1, 1, -1);
			Assertions.assertFalse(station.getAlert().isPresent(),"There should not be an alert yet!");
		}
		
		for (int i=0; i<100; i++) {
			space.moveDebris(asteroid1,-1, 1, -1);
		}
		Assertions.assertTrue(station.getAlert().isPresent(),"There should be an alert now!");
		Assertions.assertEquals(Alert.YELLOW,station.getAlert().get(),"There should be a yellow alert now! asteroid 1 is close to our station");
		
		// lets move station out of the way
		for (int i=0; i<850; i++) {
			space.moveDebris(station, 1, 1, 1);
		}
		Assertions.assertFalse(station.getAlert().isPresent(),"There should not be an alert any more, we have moved!");
		
		for (int i=0; i<100; i++) {
			space.moveDebris(station,1, 1, 1);
		}
		Assertions.assertTrue(station.getAlert().isPresent(),"There should be an alert now!");
		Assertions.assertEquals(Alert.YELLOW,station.getAlert().get(),"There should be a yellow alert now! asteroid 2 is close to our station");
		
		for (int i=0; i<21; i++) {
			space.moveDebris(station,1, 1, 1);
		}
		Assertions.assertTrue(station.getAlert().isPresent(),"There should be an alert now!");
		Assertions.assertEquals(Alert.RED,station.getAlert().get(),"Collision with asteroid2 - RED ALERT!!");
	}

}
