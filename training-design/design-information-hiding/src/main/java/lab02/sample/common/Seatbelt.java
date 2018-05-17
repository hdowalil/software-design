package lab02.sample.common;

public class Seatbelt {
	
	boolean fastened = false;
	
	public void buckleUp() {
		fastened=true;
	}
	
	public void undo() {
		fastened=false;
	}

	public boolean isFastened() {
		return fastened;
	}
}

