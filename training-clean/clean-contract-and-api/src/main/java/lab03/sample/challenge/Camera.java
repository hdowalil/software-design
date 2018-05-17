package lab03.sample.challenge;

public class Camera {
	
	public byte[] shoot(boolean film) {
		
		if (film) {
			return "This is a fancy film that you just shot".getBytes();
		} else {
			return "Picture".getBytes();
		}
		
	}
	
}
