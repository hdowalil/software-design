package lab02.excercise.solution.trainer;

import javax.annotation.Nonnegative;

public final class Battery {
	
	private double capacityInAmpereHours;
	private double levelOfAmpereHours = 0.0d;
	
	public Battery(@Nonnegative double capacityInAmpereHours) {
		
		super();
		
		this.capacityInAmpereHours = capacityInAmpereHours;
		// when battery is created, it will always be filled as well
		this.levelOfAmpereHours = this.capacityInAmpereHours;
		
		assert invariant();
	}
	
	public boolean invariant() {
		return (capacityInAmpereHours > 0.0d && levelOfAmpereHours <= capacityInAmpereHours && levelOfAmpereHours >= 0.0d);
	}

	public double consume(@Nonnegative double ampereHours) {

		if (ampereHours < 0) {
			throw new IllegalArgumentException("you cannot consume negative values, use charge instead");
		}

		if (ampereHours > this.levelOfAmpereHours) {
			double result = this.levelOfAmpereHours;
			this.levelOfAmpereHours = 0.0d;
			return result;
		} else {
			this.levelOfAmpereHours -= ampereHours;
			return ampereHours;
		}
	}

	public double charge(@Nonnegative double ampereHours) {
		
		if (ampereHours < 0) {
			throw new IllegalArgumentException("you cannot charge negative values, use consumeEnergy instead");
		}

		if (this.levelOfAmpereHours + ampereHours > this.capacityInAmpereHours) {
			double result = this.capacityInAmpereHours - this.levelOfAmpereHours;
			this.levelOfAmpereHours = this.capacityInAmpereHours;
			return result;
		} else {
			this.levelOfAmpereHours += ampereHours;
			return ampereHours;
		}
	}
	
	public double energyLeftInAmpereHours() {
		return this.levelOfAmpereHours;
	}

	public static void main (String[] args) {
		
		Battery battery = new Battery(1000d);
		System.out.println("Should be true: " + Boolean.toString(battery.invariant()));
		
		double charged = battery.charge(100.0d);
		System.out.println("Should be 0.0: " + Double.toString(charged));
		System.out.println("Should be true: " + Boolean.toString(battery.invariant()));
		
		double consumed = battery.consume(100.0d);
		System.out.println("Should be 100.0: " + Double.toString(consumed));
		System.out.println("Should be true: " + Boolean.toString(battery.invariant()));
		
		consumed = battery.consume(910.0d);
		System.out.println("Should be 900.0: " + Double.toString(consumed));
		System.out.println("Should be true: " + Boolean.toString(battery.invariant()));

		charged = battery.charge(100.0d);
		System.out.println("Should be 100.0: " + Double.toString(charged));
		System.out.println("Should be true: " + Boolean.toString(battery.invariant()));
		
	}
}
