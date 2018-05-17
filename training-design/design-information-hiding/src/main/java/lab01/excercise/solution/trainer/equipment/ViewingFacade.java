package lab01.excercise.solution.trainer.equipment;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class ViewingFacade {
	
	Consumer<String> out = null;
	TV tv = null;
	AVReceiver avr = null;
	BluRayPlayer bp = null;
	SatelliteReceiver sat = null;

	public ViewingFacade(Consumer<String> videoOut, Consumer<String> audioOut) {
		
		super();
		
		this.out = videoOut;
		
		sat = new SatelliteReceiver();
		sat.power(true);
		sat.switchChannel(3);
		
		avr = new AVReceiver();
		Speakers speakers = new Speakers(audioOut);
		avr.power(true);
		avr.plugIn(1, sat);
		avr.connectSpeakers(speakers);
		
		tv = new TV();
		tv.plugIn(avr);
		
		bp = new BluRayPlayer();
		avr.plugIn(2, bp);
	}
	
	public void watchSatChannel(int channel) {

		tv.power(true);
		avr.power(true);
		bp.power(false);
		sat.power(true);
		avr.changeSource(1);
		sat.switchChannel(channel);

		view(tv.watch());
	}
	
	public void watchBluRay(String disc) {
		
		tv.power(true);
		avr.power(true);
		bp.power(true);
		bp.insertDisc(disc);
		sat.power(false);
		avr.changeSource(2);
		
		view(tv.watch());
	}
	
	public void stopWatching() {
		
		tv.power(false);
		avr.power(false);
		bp.power(false);
		sat.power(false);
	}
	
	private void view(byte[] input) {
		
		try {
			String outputVideo = new String(input,StandardCharsets.UTF_8.name());
			out.accept(String.format("Picture Output: %s", outputVideo));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
