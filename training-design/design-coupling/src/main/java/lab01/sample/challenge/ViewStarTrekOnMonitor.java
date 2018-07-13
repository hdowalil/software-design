package lab01.sample.challenge;

public class ViewStarTrekOnMonitor {
	
	public static void main(String[] args) {
		
		PersonalComputer pc = new PersonalComputer();
		Monitor monitor = new Monitor();
		monitor.plugIn(pc);
		pc.vlc(NetworkAttachedStorage.STAR_TREK);
		monitor.display();
	}

}
