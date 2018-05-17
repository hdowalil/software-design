package lab02.sample.solution;

public class Particle {
	
	private double speedRelativeToLightSpeed = 0.0;
	private double massInKilograms = 0.0;

	public Particle(double speedRelativeToLightSpeed, double massInKilograms) {
		super();
		this.massInKilograms = massInKilograms;
		this.speedRelativeToLightSpeed = speedRelativeToLightSpeed;
		assert relativistic();
	}

	/**
	 * This method will check if speed of light relative to light speed.
	 * It will not check mass, as it is not clear yet, if there cannot be negative mass
	 * 
	 * @return true if everything is fine
	 */
	public boolean relativistic() {
		// speed is relative to light, so cannot be 1.0 as mass would be infinite
		return speedRelativeToLightSpeed >= 0.0 && speedRelativeToLightSpeed < 1.0;
	}

	public double getSpeedRelativeToLightSpeed() {
		return speedRelativeToLightSpeed;
	}

	public double getMassInKilograms() {
		return massInKilograms;
	}
	
	
}
