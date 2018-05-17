package lab03.sample.challenge;

public class UseTV {

	public static void printHDMIVersion(String hdmiVersion) {
		
		if (hdmiVersion != null) {
			System.out.println("HDMI Version: " + hdmiVersion);
		} else {
			System.out.println("HDMI Version unknown");
		}
	}
	
	public static void main(String[] args) {

		// unknown
		HDMI hdmiUnknown = new HDMI(null);
		printHDMIVersion(hdmiUnknown.getVersion());
		
		// 3.0
		HDMI hdmi3 = new HDMI("3.0");
		printHDMIVersion(hdmi3.getVersion());

		// unknown
		Television tvWithoutHdmi = new Television(new Connections(new USB("3.0"), null));
		printHDMIVersion(tvWithoutHdmi.getHDMIVersionIfAnyAndKnown());
		
		// 3.0
		Television tvWithHdmi3 = new Television(new Connections(new USB("2.0"), new HDMI("3.0")));
		printHDMIVersion(tvWithHdmi3.getHDMIVersionIfAnyAndKnown());
		
		
	}

}
