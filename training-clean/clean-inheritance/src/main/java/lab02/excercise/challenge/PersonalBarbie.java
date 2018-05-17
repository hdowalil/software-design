package lab02.excercise.challenge;

import lab02.excercise.common.Barbie;

public class PersonalBarbie extends Barbie {

	String ownersName;

	public PersonalBarbie(String ownersName) {
		super();
		this.ownersName = ownersName;
	}

	@Override
	public String speak() {
		return "Hello " + ownersName + ", " + super.speak();
	}
	
}
