package lab01.excercise.solution.trainer.equipment;

/**
 * TV with only 1 HDMI input connections
 */
class TV {
	
	private HDMIConnection connectedDevice = null;
	private boolean power = false;

	void power(boolean on) {
		this.power = on;
	}
	
	void plugIn(HDMIConnection input) {
		this.connectedDevice = input;
	}
	
	byte[] watch() {

		if (this.power && connectedDevice != null) {
			
			return connectedDevice.streamAudioAndVideo();
			
		} else {
			
			return new byte[] {};
		}
	}
	
}
