package lab01.excercise.challenge.equipment;

/**
 * TV with only 1 HDMI input connections
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
	
	public byte[] watch() {

		if (this.power && connectedDevice != null) {
			
			return connectedDevice.streamAudioAndVideo();
			
		} else {
			
			return new byte[] {};
		}
	}
	
}
