package lab01.excercise.common;

public class Vehicle {
	
	private String registrationId;
	private VehicleType type;
	private int horsePower;
	
	public Vehicle(String registrationId, VehicleType type, int horsePower) {
		super();
		this.registrationId = registrationId;
		this.type = type;
		this.horsePower = horsePower;
		assert invariant();
	}

	public boolean invariant() {
		boolean idok = registrationId != null && registrationId.trim().length() > 0;
		boolean typeok = type != null;
		boolean hpok = horsePower > 0;
		return idok && typeok && hpok;
	}
	
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public int getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	

}
