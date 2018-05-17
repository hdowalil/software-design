package lab03.excercise.solution.trainer;

import javax.annotation.Nonnegative;

public interface SpaceStationAPIResources {

	public double consume(@Nonnegative double ampereHours);

	public double charge(@Nonnegative double ampereHours);
		
	public double energyLeftInAmpereHours();
	
}
