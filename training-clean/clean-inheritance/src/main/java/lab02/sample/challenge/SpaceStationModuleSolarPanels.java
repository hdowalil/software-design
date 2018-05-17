package lab02.sample.challenge;

import javax.annotation.Nonnull;

import lab02.sample.common.ChargableResource;

public class SpaceStationModuleSolarPanels extends SpaceStationModuleBasic {

	private ChargableResource batteryToLoad;
	
	public SpaceStationModuleSolarPanels(@Nonnull ChargableResource batteryToLoad) {
		super();
		this.batteryToLoad = batteryToLoad;
	}

	/**
	 * this will not  call super, as instead heating up, we produce electricity
	 */
	@Override
	public void receiveSunshine() {

		this.batteryToLoad.charge(0.1d);
	}
	
}
