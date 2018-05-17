package lab01.sample.challenge;

public class MealFactory {

	@SuppressWarnings("unused")
	public Meal prepare() {
		FryingPan utensil = new FryingPan();
		Pepper spice = new Pepper();
		// now do whatever steps are needed to prepare the meal...
		return new Meal();
	}
}

