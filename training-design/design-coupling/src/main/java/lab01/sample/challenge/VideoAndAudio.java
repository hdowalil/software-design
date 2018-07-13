package lab01.sample.challenge;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class VideoAndAudio {
	
	public static byte[] SILENCE = new byte[] {};

	private byte[] video;
	private byte[] audio;
	
	public VideoAndAudio(byte[] video, byte[] audio) {
		super();
		this.video = video;
		this.audio = audio;
	}

	public byte[] getVideo() {
		return video;
	}

	public byte[] getAudio() {
		return audio;
	}
	
	public static String convertByteArrayToString(@Nullable byte[] input) {
		
		if (input == null || input.length == 0) {
			return "";
		}
		
		try {
			return new String(input,StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] convertStringToByteArry(@Nullable String input) {
		
		if (input == null || input.length() == 0) {
			return new byte[] {};
		}
		
		return input.getBytes(StandardCharsets.UTF_8);
	}
	
}
