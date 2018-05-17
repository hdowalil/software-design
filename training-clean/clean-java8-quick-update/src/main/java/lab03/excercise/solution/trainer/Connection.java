package lab03.excercise.solution.trainer;

public class Connection {
	
	private boolean isConnected = false;
	
	public String speak(String input) {
		NoConnectionPossibleException.throwIf(!isConnected);
		return "I understood: " + input;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	
}
