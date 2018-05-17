package lab02.excercise.solution.trainer;

import java.util.Objects;

import javax.annotation.Nonnull;

import lab02.excercise.common.Barbie;
import lab02.excercise.common.Ken;
import lab02.excercise.common.SpeakingDoll;

public final class PersonalDollDecorator extends DollDecorator {

	String ownersName;

	public PersonalDollDecorator(@Nonnull String ownersName, @Nonnull SpeakingDoll delegate) {
		
		super(delegate);
		
		Objects.requireNonNull(ownersName);
		this.ownersName = ownersName;
	}

	public String speak() {
		return "Hello " + ownersName + ", " + delegate.speak();
	}
	
	public static void main (String[] args) {
		
		SpeakingDoll personalKen = new PersonalDollDecorator("Valentina", new Ken());
		System.out.println("Ken should say Hello to Valentina: " + personalKen.speak());
		
		SpeakingDoll personalBarbie = new PersonalDollDecorator("Valentina", new Barbie());
		System.out.println("Barbie should say Hello to Valentina: " + personalBarbie.speak());
	}
}
