package lab02.sample.solution;

import javax.annotation.Nonnull;

import lab02.sample.challenge.SpaceStationModuleBasic;
import lab02.sample.common.ChargableResource;
import lab02.sample.common.SpaceStationModule;

public final class SpaceStationModuleDecoratorSolarPanels extends SpaceStationModuleDecorator {

	private ChargableResource batteryToLoad;
	
	public SpaceStationModuleDecoratorSolarPanels(@Nonnull SpaceStationModule delegate,@Nonnull ChargableResource batteryToLoad) {
		super(delegate);
		this.batteryToLoad = batteryToLoad;
	}
	
	public SpaceStationModuleDecoratorSolarPanels(@Nonnull ChargableResource batteryToLoad) {
		this(new SpaceStationModuleBasic(),batteryToLoad);
	}
	
	/**
	 * this will not  call super, as instead heating up, we produce electricity
	 */
	@Override
	public void receiveSunshine() {

		this.batteryToLoad.charge(0.1d);
	}
	

}
