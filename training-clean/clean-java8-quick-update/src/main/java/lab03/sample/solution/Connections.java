package lab03.sample.solution;

import java.util.Optional;

public class Connections {
	
	private USB usb;
	private HDMI hdmi;
	
	public Connections(USB usb, HDMI hdmi) {
		super();
		this.usb = usb;
		this.hdmi = hdmi;
	}
	
	public Optional<USB> getUsb() {
		return Optional.ofNullable(usb);
	}
	public Optional<HDMI> getHdmi() {
		return Optional.ofNullable(hdmi);
	}

}
