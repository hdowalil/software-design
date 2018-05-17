package lab02.excercise.common;

import javax.annotation.Nonnegative;

/**
 * the battery is not bound to a structural element, and is more or like an independent attribute of the space station 
 */
public final class Battery {
	
	private double capacityInAmpereHours;
	private double levelOfAmpereHours = 0.0d;
	
	public Battery(@Nonnegative double capacityInAmpereHours) {
		super();
		this.capacityInAmpereHours = capacityInAmpereHours;
		checkInvariants();
	}
	
	public void checkInvariants() {
		if (this.capacityInAmpereHours <= 0.0d || 
				this.levelOfAmpereHours < 0.0d || 
				this.levelOfAmpereHours > this.capacityInAmpereHours) {
			throw new RuntimeException();
		}
	}

	public double use(@Nonnegative double ampereHours) {
		if (ampereHours > this.levelOfAmpereHours) {
			throw new RuntimeException("Out of Electricity");
		}
		
		this.levelOfAmpereHours -= ampereHours;
		
		assert this.levelOfAmpereHours >= 0.0d;
		
		return this.levelOfAmpereHours;
	}

	public double charge(@Nonnegative double ampereHours) {
		
		if (ampereHours <= 0) {
			throw new IllegalArgumentException("you cannot charge nothing or negative values");
		}
		
		double result = this.levelOfAmpereHours+ampereHours;
		
		if (result > capacityInAmpereHours) {
			// charge to the maximum, more is not possible
			this.levelOfAmpereHours = capacityInAmpereHours;
		} else {
			this.levelOfAmpereHours += ampereHours;
		}
		
		return this.levelOfAmpereHours;
	}
	
	public double energyLeftInAmpereHours() {
		return levelOfAmpereHours;
	}

}
