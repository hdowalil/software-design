package lab02.sample.common;

public class Astronaut {
	
	private String name;
	private long fatigueInPercent;

	public Astronaut(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public long getFatigueInPercent() {
		return fatigueInPercent;
	}

	public void doSomething() {
		if (this.fatigueInPercent >= 100) {
			throw new IllegalStateException("Astronaut with burnout!");
		}
		this.fatigueInPercent++;
	}
	
	public void rest(int quality) {
		this.fatigueInPercent -= quality;
	}
}
