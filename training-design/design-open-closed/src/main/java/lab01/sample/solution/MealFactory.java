package lab01.sample.solution;

// GOF: 107
public class MealFactory {

	protected Spice provideSpice() {
		return new Pepper();
	}

	protected Utensil provideUtensil() {
		return new FryingPan();
	}

	@SuppressWarnings("unused")
	public Meal prepare() {
		Utensil utensil = provideUtensil();
		Spice spice = provideSpice();
		// now do whatever steps are needed to prepare the meal...
		return new Meal();
	}
}

