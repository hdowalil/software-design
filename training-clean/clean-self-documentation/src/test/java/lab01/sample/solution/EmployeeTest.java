package lab01.sample.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EmployeeTest {
	
	@ParameterizedTest
	@CsvSource({ 
		"true, 10, 1, true, 2000", 
		"false, 10, 1, true, 1000", 
		"false, 50, 3, false, 2000" })	
	public void testCalculatedSalary(boolean relatedToManager, int percentagePatternKnowhow, int yearsExperience,
			boolean externalEmployee, long expectedSalaray) {
		
		Employee employee = new Employee(relatedToManager, percentagePatternKnowhow, yearsExperience, externalEmployee);
		Assertions.assertEquals(expectedSalaray,employee.getSalary(),"Should be: " + Long.toString(expectedSalaray));
	}

}
