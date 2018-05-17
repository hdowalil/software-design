package lab02.sample.challenge;

import javax.annotation.Nonnegative;

import lab02.sample.common.Astronaut;

public class SpaceStationModuleLiving extends SpaceStationModuleBasic {
	
	private int numberOfBeds;
	private int bedQuality;

	public SpaceStationModuleLiving(@Nonnegative int numberOfBeds, @Nonnegative int bedQuality) {
		super();
		this.numberOfBeds = numberOfBeds;
		this.bedQuality = bedQuality;
	}

	public void restAstronauts(Astronaut... astronauts) {
		
		for (int i=0; i<astronauts.length; i++) {
			
			if (i>=numberOfBeds) {
				// no bed left, has to rest standing in the closet
				astronauts[i].rest(1);
			} else {
				astronauts[i].rest(bedQuality);
			}
		}
	}
	
}
