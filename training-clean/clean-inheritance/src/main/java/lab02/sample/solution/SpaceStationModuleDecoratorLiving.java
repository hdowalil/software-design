package lab02.sample.solution;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import lab02.sample.challenge.SpaceStationModuleBasic;
import lab02.sample.common.Astronaut;
import lab02.sample.common.SpaceStationModule;

public final class SpaceStationModuleDecoratorLiving extends SpaceStationModuleDecorator {

	private int numberOfBeds;
	private int bedQuality;

	public SpaceStationModuleDecoratorLiving(@Nonnull SpaceStationModule delegate, @Nonnegative int numberOfBeds, @Nonnegative int bedQuality) {
		super(delegate);
		this.numberOfBeds = numberOfBeds;
		this.bedQuality = bedQuality;
	}
	
	public SpaceStationModuleDecoratorLiving(@Nonnegative int numberOfBeds, @Nonnegative int bedQuality) {
		this(new SpaceStationModuleBasic(),numberOfBeds,bedQuality);
	}
	
	@Override
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
