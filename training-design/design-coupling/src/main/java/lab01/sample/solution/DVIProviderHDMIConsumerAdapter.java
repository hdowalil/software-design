package lab01.sample.solution;

import lab01.sample.challenge.AudioAndVideo;
import lab01.sample.challenge.DVIConnection;
import lab01.sample.challenge.HDMIConnection;

public class DVIProviderHDMIConsumerAdapter implements HDMIConnection {

	private DVIConnection delegate;
	
	public DVIProviderHDMIConsumerAdapter(DVIConnection delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public AudioAndVideo transmitVideoAndAudio() {
		byte[] video = delegate.transmitVideo();
		AudioAndVideo result = new AudioAndVideo(video, AudioAndVideo.SILENCE);
		return result;
	}

}
