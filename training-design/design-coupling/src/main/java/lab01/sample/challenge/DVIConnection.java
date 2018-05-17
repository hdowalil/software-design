package lab01.sample.challenge;

import java.util.function.Consumer;

public interface DVIConnection {

	public void provide(Consumer<byte[]> videoPresenter);
	public void stream(String movie);
	
}
