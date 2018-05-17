package lab03.sample.solution;

import java.util.Optional;

public class Television {
	
	private Connections connections;

	public Television(Connections connections) {
		super();
		this.connections = connections;
	}
	
	public Optional<String> getHDMIVersion() {
		return getConnections().flatMap(Connections::getHdmi).flatMap(HDMI::getVersion);
	}

	public Optional<String> getUSBVersionIfAnyAndKnown() {
		return getConnections().flatMap(Connections::getUsb).flatMap(USB::getVersion);
	}

	public Optional<Connections> getConnections() {
		return Optional.ofNullable(connections);
	}
	
}
