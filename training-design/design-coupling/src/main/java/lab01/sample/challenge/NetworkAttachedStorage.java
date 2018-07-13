package lab01.sample.challenge;

import java.nio.charset.StandardCharsets;

public class NetworkAttachedStorage {

	private final static String STAR_TREK_VIDEO = "The USS Enterprise floating through the galaxy";
	private final static String STAR_TREK_AUDIO = "Space: the final frontier. These are the voyages of the starship Enterprise."
			+" Its five-year mission: to explore strange new worlds, to seek out new life and new civilizations,"
			+" to boldly go where no man has gone before.";
	
	private final static String KNIGHT_RIDER_VIDEO = "David Hasselhoff in a black Pontiac Trans Am with a red light";
	private final static String KNIGHT_RIDER_AUDIO = "Knight Rider, a shadowy flight into the dangerous world of a man who does not exist."
			+" Michael Knight, a young loner on a crusade to champion the cause of the innocent, the helpless,"
			+" the powerless, in a world of criminals who operate above the law.";

	public final static AudioAndVideo STAR_TREK = 
			new AudioAndVideo(STAR_TREK_VIDEO.getBytes(StandardCharsets.UTF_8), 
					STAR_TREK_AUDIO.getBytes(StandardCharsets.UTF_8));
	
	public final static AudioAndVideo KNIGHT_RIDER = 
			new AudioAndVideo(KNIGHT_RIDER_VIDEO.getBytes(StandardCharsets.UTF_8), 
					KNIGHT_RIDER_AUDIO.getBytes(StandardCharsets.UTF_8));
	
}
