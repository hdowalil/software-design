package lab01.excercise.challenge.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class BluRayPlayer implements HDMIConnection {

	private String disc = null;
	private boolean power = false;
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void insertDisc(String disc) {
		this.disc = disc;
	}

	@Override
	public byte[] streamAudioAndVideo() {
		if (power && disc != null) {
			try {
				return String.format(disc).getBytes(StandardCharsets.UTF_8.name());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		} else {
			return new byte[] {};
		}
	}
	
}
