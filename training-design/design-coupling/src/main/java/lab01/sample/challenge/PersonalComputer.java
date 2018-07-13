package lab01.sample.challenge;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class PersonalComputer implements DVIConnection {

	private Consumer<byte[]> monitor;
	
	@Override
	public void provide(Consumer<byte[]> monitor) {
		this.monitor = monitor;	
	}
	
	public void vlc(String illegallyDownloadedMovie) {
		stream(illegallyDownloadedMovie);
	}
	
	public void stream(String movie) {
		
		// as a dummy implementation we watch star-trek
		try {
			monitor.accept(movie.getBytes(StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
