package lab03.sample.solution;

public class Camera implements PictureRecordingDevice, VideoRecordingDevice {
	
	private byte[] shoot(boolean film) {
		
		if (film) {
			return "This is a fancy film that you just shot".getBytes();
		} else {
			return "Picture".getBytes();
		}
		
	}

	@Override
	public byte[] recordVideo() {
		return shoot(true);
	}

	@Override
	public byte[] recordPicture() {
		return shoot(false);
	}

}
