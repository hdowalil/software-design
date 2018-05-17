package lab03.sample.challenge;

public class Connections {
	
	private USB usb;
	private HDMI hdmi;
	
	public Connections(USB usb, HDMI hdmi) {
		super();
		this.usb = usb;
		this.hdmi = hdmi;
	}
	
	public USB getUsb() {
		return usb;
	}
	public HDMI getHdmi() {
		return hdmi;
	}

}
