package lab01.excercise.solution.trainer.equipment;

class AVReceiver implements HDMIConnection {

	private HDMIConnection[] hdmiConnections= new HDMIConnection[2];
	private Speakers connectedSpeakers = null;
	private boolean power = false;
	private int currentSource = 1;

	void power(boolean on) {
		this.power = on;
	}
	
	void changeSource(int slot) {
		this.currentSource = slot-1;
	}
	
	void connectSpeakers(Speakers speakers) {
		this.connectedSpeakers = speakers;
	}
	
	void plugIn(int slot, HDMIConnection input) {
		this.hdmiConnections[slot-1] = input;
	}
	
	@Override
	public byte[] streamAudioAndVideo() {
		
		HDMIConnection device = this.hdmiConnections[this.currentSource];
		if (this.power && device != null) {
			
			byte[] result = device.streamAudioAndVideo();
			
			if (connectedSpeakers != null) {
				connectedSpeakers.makeSomeNoise(result);
			}
			
			return result;
			
		} else {
			
			return new byte[] {};
		}
		
	}
	
}
