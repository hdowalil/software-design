package lab01.solution.trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lab01.excercise.solution.trainer.Alert;
import lab01.excercise.solution.trainer.SpaceStation;
import lab01.excercise.solution.trainer.StructuralElement;

public class SpaceStationAlertTest {
	
	private Collection<StructuralElement> parseElements(String input) {
		
		List<StructuralElement> result = new ArrayList<StructuralElement>();
		
		Arrays.asList(input.split("\\;")).forEach(
				s -> {
					String[] content = s.split("\\,");
					int structuralIntegrity = Integer.parseInt(content[0]);
					int temperatureInCelsius = Integer.parseInt(content[1]);
					result.add(new StructuralElement(structuralIntegrity,temperatureInCelsius));
				}
				);
		
		return result;
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"'90,20;98,75',2000,2000.0", 
		"'3,20;98,22',2000,2000.0", 
		"'93,20;98,22',23,2000.0", 
		"'93,20;98,22',2000,12.0" })	
	public void testRedAlert(String elements, long oxygen, double battery) {
		
		SpaceStation testObject = new SpaceStation();
		testObject.getElements().addAll(parseElements(elements));
		testObject.setOxygen(oxygen);
		testObject.setBatteryAmpereHours(battery);
		
		testObject.logStatus(System.out);
		
		Assertions.assertEquals(Alert.RED, testObject.check4Problem());
	}

	@ParameterizedTest
	@CsvSource({ 
		"'90,20;98,60',2000,2000.0", 
		"'12,20;98,22',2000,2000.0", 
		"'93,20;98,22',500,2000.0", 
		"'93,20;98,22',2000,430.0" })	
	public void testYellowAlert(String elements, long oxygen, double battery) {
		
		SpaceStation testObject = new SpaceStation();
		testObject.getElements().addAll(parseElements(elements));
		testObject.setOxygen(oxygen);
		testObject.setBatteryAmpereHours(battery);
		
		testObject.logStatus(System.out);
		
		Assertions.assertEquals(Alert.YELLOW, testObject.check4Problem());
	}

	@ParameterizedTest
	@CsvSource({ 
		"'90,20;98,22',2000,2000.0" })	
	public void testGreenAlert(String elements, long oxygen, double battery) {
		
		SpaceStation testObject = new SpaceStation();
		testObject.getElements().addAll(parseElements(elements));
		testObject.setOxygen(oxygen);
		testObject.setBatteryAmpereHours(battery);
		
		testObject.logStatus(System.out);
		
		Assertions.assertEquals(Alert.GREEN, testObject.check4Problem());
	}

}
