package lab01.excercise.challenge;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import lab01.excercise.challenge.equipment.AVReceiver;
import lab01.excercise.challenge.equipment.BluRayPlayer;
import lab01.excercise.challenge.equipment.SatelliteReceiver;
import lab01.excercise.challenge.equipment.Speakers;
import lab01.excercise.challenge.equipment.TV;

public class Viewer {

	public static void main(String[] args) {
		
		// Let´s watch The Dark Knight on channel 3
		SatelliteReceiver sat = new SatelliteReceiver();
		sat.power(true);
		sat.switchChannel(3);
		
		AVReceiver avr = new AVReceiver();
		Speakers speakers = new Speakers();
		avr.power(true);
		avr.plugIn(1, sat);
		avr.connectSpeakers(speakers);
		avr.changeSource(1);
		
		TV tv = new TV();
		tv.power(true);
		tv.plugIn(avr);
		
		try {
			String outputVideo = new String(tv.watch(),StandardCharsets.UTF_8.name());
			System.out.println("Picture Output: " + outputVideo);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
			
		// Now let´s watch Life of Brian on BluRay
		String bluRay = 
				"All right, but apart from the sanitation, medicine, education, wine, public order, "+
				"irrigation, roads, the fresh water system and public health, what have the Romans ever done for us?";
		
		BluRayPlayer bp = new BluRayPlayer();
		bp.power(true);
		bp.insertDisc(bluRay);
		
		avr.plugIn(2, bp);
		avr.changeSource(2);
		
		try {
			String outputVideo = new String(tv.watch(),StandardCharsets.UTF_8.name());
			System.out.println("Picture Output: " + outputVideo);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
