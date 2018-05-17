package lab03.sample.solution;

import java.util.Optional;

public class HDMI {
	
	private String version;

	public HDMI(String version) {
		super();
		this.version = version;
	}

	public Optional<String> getVersion() {
		return Optional.ofNullable(version);
	}
	
}
