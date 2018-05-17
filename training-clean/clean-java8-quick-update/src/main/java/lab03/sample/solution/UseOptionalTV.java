package lab03.sample.solution;

public class UseOptionalTV {

	public static void printHDMIVersion(String hdmiVersion) {
		
		System.out.println("HDMI Version: " + hdmiVersion);
	}
	
	public static void main(String[] args) {

		// unknown
		HDMI hdmiUnknown = new HDMI(null);
		printHDMIVersion(hdmiUnknown.getVersion().orElse("Unknown"));
		
		// 3.0
		HDMI hdmi3 = new HDMI("3.0");
		printHDMIVersion(hdmi3.getVersion().orElse("Unknown"));

		// unknown
		Television tvWithoutConnections = new Television(null);
		printHDMIVersion(tvWithoutConnections.getHDMIVersion().orElse("Unknown"));
		
		// unknown
		Television tvWithoutHdmi = new Television(new Connections(new USB("3.0"), null));
		printHDMIVersion(tvWithoutHdmi.getHDMIVersion().orElse("Unknown"));
		
		// 3.0
		Television tvWithHdmi3 = new Television(new Connections(new USB("2.0"), new HDMI("3.0")));
		printHDMIVersion(tvWithHdmi3.getHDMIVersion().orElse("Unknown"));
		
		
	}

}
