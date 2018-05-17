package lab02.sample.common;

public class Engine {
	
	boolean running = false;
	
	public void start() {
		running = true;
	}
	
	public void stop() {
		running = false;
	}

	public boolean isRunning() {
		return running;
	}
}

