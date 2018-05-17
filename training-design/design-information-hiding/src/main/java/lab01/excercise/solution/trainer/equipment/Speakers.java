package lab01.excercise.solution.trainer.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

class Speakers {
	
	Consumer<String> out = null;
	
	Speakers(Consumer<String> out) {
		super();
		this.out = out;
	}

	void makeSomeNoise (byte[] audio) {
		
		try {
			
			String outputAudio = new String(audio,StandardCharsets.UTF_8.name());
			out.accept(String.format("Audio Output: %s", outputAudio));
			
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
