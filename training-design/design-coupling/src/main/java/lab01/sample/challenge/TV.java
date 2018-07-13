package lab01.sample.challenge;

/**
 * TV with only 1 HDMI input connection
 */
public class TV {
	
	private HDMIConnection connectedDevice = null;
	private boolean power = false;
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void plugIn(HDMIConnection input) {
		this.connectedDevice = input;
	}
	
	public void watch() {

		if (this.power && connectedDevice != null) {
			
			VideoAndAudio receivedBinary = connectedDevice.transmitVideoAndAudio();
			System.out.println("VIDEO on TV: " + VideoAndAudio.convertByteArrayToString(receivedBinary.getVideo()));
			System.out.println("AUDIO on TV: " + VideoAndAudio.convertByteArrayToString(receivedBinary.getAudio()));
		}
	}
	
}
