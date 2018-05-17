package lab02.sample.challenge;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import lab02.sample.common.Astronaut;
import lab02.sample.common.ChargableResource;

/**
 * 
 * This class is a code smell!
 *
 */
public class SpaceStationModuleLivingWithSolarPanels extends SpaceStationModuleBasic {
	
	private ChargableResource batteryToLoad;
	private int numberOfBeds;
	private int bedQuality;

	public SpaceStationModuleLivingWithSolarPanels(@Nonnull ChargableResource batteryToLoad, @Nonnegative int numberOfBeds, @Nonnegative int bedQuality) {
		super();
		this.numberOfBeds = numberOfBeds;
		this.bedQuality = bedQuality;
		this.batteryToLoad = batteryToLoad;
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
	
	/**
	 * this will not  call super, as instead heating up, we produce electricity
	 */
	@Override
	public void receiveSunshine() {

		this.batteryToLoad.charge(0.1d);
	}
}
