package lab02.sample.challenge;

public class Particle {
	
	private double speed = 0.0;
	private double mass = 0.0;

	public Particle(double speed, double mass) {
		super();
		this.mass = mass;
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public double getMass() {
		return mass;
	}
	
	
}
