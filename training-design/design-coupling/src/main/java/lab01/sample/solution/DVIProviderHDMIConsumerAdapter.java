package lab01.sample.solution;

import lab01.sample.challenge.VideoAndAudio;
import lab01.sample.challenge.DVIConnection;
import lab01.sample.challenge.HDMIConnection;

public class DVIProviderHDMIConsumerAdapter implements HDMIConnection {

	private DVIConnection delegate;
	
	public DVIProviderHDMIConsumerAdapter(DVIConnection delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public VideoAndAudio transmitVideoAndAudio() {
		byte[] video = delegate.transmitVideo();
		VideoAndAudio result = new VideoAndAudio(video, VideoAndAudio.SILENCE);
		return result;
	}

}
