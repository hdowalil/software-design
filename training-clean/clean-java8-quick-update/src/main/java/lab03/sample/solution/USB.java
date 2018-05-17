package lab03.sample.solution;

import java.util.Optional;

public class USB {

	private String version;

	public USB(String version) {
		super();
		this.version = version;
	}

	public Optional<String> getVersion() {
		return Optional.ofNullable(version);
	}
	
}
