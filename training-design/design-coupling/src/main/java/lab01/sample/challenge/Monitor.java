package lab01.sample.challenge;

public class Monitor {

	private DVIConnection connectedDevice = null;
	
	public void plugIn (DVIConnection device) {
		connectedDevice = device;
	}
	
	public void display () {
		
		if (connectedDevice != null) {
			String video = VideoAndAudio.convertByteArrayToString(connectedDevice.transmitVideo());
			System.out.println("VIDEO on Montor: " + video);
		}
	}
}
