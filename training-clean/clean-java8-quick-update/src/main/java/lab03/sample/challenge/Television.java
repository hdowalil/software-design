package lab03.sample.challenge;

public class Television {
	
	private Connections connections;

	public Television(Connections connections) {
		super();
		this.connections = connections;
	}
	
	public String getHDMIVersionIfAnyAndKnown() {
		if (connections != null && connections.getHdmi() != null) {
			return connections.getHdmi().getVersion();
		} else {
			return null;
		}
	}

	public String getUSBVersionIfAnyAndKnown() {
		if (connections != null && connections.getUsb() != null) {
			return connections.getUsb().getVersion();
		} else {
			return null;
		}
	}

	public Connections getConnections() {
		return connections;
	}
	
}
