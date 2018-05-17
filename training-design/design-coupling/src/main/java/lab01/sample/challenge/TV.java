package lab01.sample.challenge;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

/**
 * TV with only 1 HDMI input connections
 */
public class TV {
	
	private HDMIConnection connectedDevice = null;
	private boolean power = false;
	private Consumer<String> out;
	
	public TV(Consumer<String> out) {
		super();
		this.out = out;
	}

	public void power(boolean on) {
		this.power = on;
	}
	
	public void plugIn(HDMIConnection input) {
		this.connectedDevice = input;
	}
	
	public void watch() {

		if (this.power && connectedDevice != null) {
			
			try {
				byte[] receivedBinary = connectedDevice.streamAudioAndVideo();
				String outputVideo = new String(receivedBinary,StandardCharsets.UTF_8.name());
				out.accept(outputVideo);
				
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
