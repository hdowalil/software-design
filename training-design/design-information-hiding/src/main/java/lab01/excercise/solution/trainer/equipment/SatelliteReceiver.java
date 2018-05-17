package lab01.excercise.solution.trainer.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class SatelliteReceiver implements HDMIConnection {

	private final static String PROGRAM_CHANNEL_1 = 
			"The first Rule of Fight Club is, you do not talk about fight club.";
	private final static String PROGRAM_CHANNEL_2 = 
			"These aren't the droids you're looking for...";
	private final static String PROGRAM_CHANNEL_3 = 
			"You wanna know how I got these scars?";
	private final static String PROGRAM_CHANNEL_4 = 
			"A Royale with cheese. What do they call a Big Mac?";
	
	private List<byte[]> channels;
	private boolean power = false;
	private int channel = 1;
	
	SatelliteReceiver() {
		
		super();
		
		channels = new ArrayList<>();
		
		try {
			channels.add(PROGRAM_CHANNEL_1.getBytes(StandardCharsets.UTF_8.name()));
			channels.add(PROGRAM_CHANNEL_2.getBytes(StandardCharsets.UTF_8.name()));
			channels.add(PROGRAM_CHANNEL_3.getBytes(StandardCharsets.UTF_8.name()));
			channels.add(PROGRAM_CHANNEL_4.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	void power(boolean on) {
		this.power = on;
	}
	
	void switchChannel(int channel) {
		this.channel = channel;
	}
	
	@Override
	public byte[] streamAudioAndVideo() {
		if (power) {
			return channels.get(channel-1);
		} else {
			return new byte[] {};
		}
	}

}
