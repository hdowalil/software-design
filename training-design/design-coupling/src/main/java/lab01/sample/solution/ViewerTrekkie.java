package lab01.sample.solution;

import lab01.sample.challenge.NetworkAttachedStorage;
import lab01.sample.challenge.PersonalComputer;
import lab01.sample.challenge.TV;

public class ViewerTrekkie {

	public static void main(String[] args) {
		
		PersonalComputer pc = new PersonalComputer();
		TV tv = new TV(System.out::println);
		tv.power(true);
		
		DVIProviderHDMIConsumerAdapter adapter = new DVIProviderHDMIConsumerAdapter(pc);
		tv.plugIn(adapter);
		
		// start vlc player
		pc.vlc(NetworkAttachedStorage.STAR_TREK);
		
		// and watch on tv
		tv.watch();
	}

}
