package lab01.sample.solution;

public class Employee {
	
	private static long BASIC_SALARY = 1000L;
	private static int BONUS_FACTOR = 2;
	
	private static int MINIMUM_PATTERN_KNOWHOW_PERCENTAGE_OF_SENIOR = 50;
	private static int MINIMUM_YEARS_EXPERIENCE_OF_SENIOR = 2;
	
	
	private long salary;
	private boolean relatedToManager;
	private int percentagePatternKnowHow;
	private int yearsExperience;
	private boolean externalEmployee;
	
	public Employee(boolean relatedToManager, int percentagePatternKnowHow, int yearsExperience, 
			boolean externalEmployee) {
		
		this.relatedToManager = relatedToManager;
		this.percentagePatternKnowHow = percentagePatternKnowHow;
		this.yearsExperience = yearsExperience;
		this.externalEmployee = externalEmployee;
		
		if (shouldGetABonus()) {
			salary = BASIC_SALARY * BONUS_FACTOR;
		} else {
			salary = BASIC_SALARY;
		}
		
	}
	
	private boolean shouldGetABonus() {
		return ( (isSeniorDeveloper() && !externalEmployee) || relatedToManager);
	}

	private boolean isSeniorDeveloper() {
		return (percentagePatternKnowHow >= MINIMUM_PATTERN_KNOWHOW_PERCENTAGE_OF_SENIOR 
				&& yearsExperience > MINIMUM_YEARS_EXPERIENCE_OF_SENIOR);
	}
	
	public long getSalary() {
		return salary;
	}

	public boolean isRelatedToManager() {
		return relatedToManager;
	}

	public int getPercentagePatternKnowHow() {
		return percentagePatternKnowHow;
	}

	public int getYearsExperience() {
		return yearsExperience;
	}

	public boolean isExternalEmployee() {
		return externalEmployee;
	}

}
