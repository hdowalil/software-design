package lab01.sample.challenge;

public class PersonalComputer implements DVIConnection {

	private byte[] picture2Stream = new byte[] {};
	
	public void vlc(AudioAndVideo illegallyDownloadedMovie) {
		
		picture2Stream = illegallyDownloadedMovie.getVideo();
		
		System.out.println("AUDIO on PC Speakers: "+ AudioAndVideo.convertByteArrayToString(illegallyDownloadedMovie.getAudio()));
	}
	
	@Override
	public byte[] transmitVideo() {
		return picture2Stream;
	}

}
