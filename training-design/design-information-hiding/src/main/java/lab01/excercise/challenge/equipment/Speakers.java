package lab01.excercise.challenge.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Speakers {
	
	public void makeSomeNoise (byte[] audio) {
		
		try {
			
			String outputAudio = new String(audio,StandardCharsets.UTF_8.name());
			System.out.println("Audio Output: " + outputAudio);
			
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
