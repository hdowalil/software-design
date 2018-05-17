package lab02.sample.common;

import javax.annotation.Nonnegative;

public interface ChargableResource {
	
	public double consume(@Nonnegative double ampereHours);

	public double charge(@Nonnegative double ampereHours);
	
}
