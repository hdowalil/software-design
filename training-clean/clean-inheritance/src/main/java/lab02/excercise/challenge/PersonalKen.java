package lab02.excercise.challenge;

import lab02.excercise.common.Barbie;

public class PersonalKen extends Barbie {

	String ownersName;

	public PersonalKen(String ownersName) {
		super();
		this.ownersName = ownersName;
	}

	@Override
	public String speak() {
		return "Hello " + ownersName + ", " + super.speak();
	}
	
}
