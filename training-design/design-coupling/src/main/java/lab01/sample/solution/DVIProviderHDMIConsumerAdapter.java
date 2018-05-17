package lab01.sample.solution;

import java.util.function.Consumer;

import lab01.sample.challenge.DVIConnection;
import lab01.sample.challenge.HDMIConnection;

public class DVIProviderHDMIConsumerAdapter implements HDMIConnection, Consumer<byte[]> {

	private DVIConnection delegate;
	private byte[] streamed;
	
	public DVIProviderHDMIConsumerAdapter(DVIConnection delegate) {
		super();
		this.delegate = delegate;
		this.delegate.provide(this);
	}

	@Override
	public void accept(byte[] receivedByDVI) {
		streamed = receivedByDVI;
	}

	@Override
	public byte[] streamAudioAndVideo() {
		return streamed;
	}

}
