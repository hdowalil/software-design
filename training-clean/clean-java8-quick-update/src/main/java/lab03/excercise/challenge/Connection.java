package lab03.excercise.challenge;

public class Connection {
	
	private boolean connected = false;
	
	public String speak(String input) {
		
		if (!connected) {
			throw new IllegalStateException("Phone cannot connect");
		}
		
		return "I understood: " + input;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
}
