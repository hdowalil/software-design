package lab01.excercise.solution.trainer.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

class BluRayPlayer implements HDMIConnection {

	private String disc = null;
	private boolean power = false;
	
	void power(boolean on) {
		this.power = on;
	}
	
	void insertDisc(String disc) {
		this.disc = disc;
	}

	@Override
	public byte[] streamVideoAndAudio() {
		if (power && disc != null) {
			try {
				return disc.getBytes(StandardCharsets.UTF_8.name());
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		} else {
			return new byte[] {};
		}
	}
	
}
