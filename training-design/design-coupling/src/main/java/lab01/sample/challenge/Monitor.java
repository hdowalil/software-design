package lab01.sample.challenge;

public class Monitor {

	private DVIConnection connectedDevice = null;
	
	public void plugIn (DVIConnection device) {
		connectedDevice = device;
	}
	
	public void display () {
		
		String video = AudioAndVideo.convertByteArrayToString(connectedDevice.transmitVideo());
		System.out.println("VIDEO on Montor: " + video);
	}
}
