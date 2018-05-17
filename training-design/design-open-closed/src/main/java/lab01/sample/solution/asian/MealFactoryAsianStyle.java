package lab01.sample.solution.asian;

import lab01.sample.solution.MealFactory;
import lab01.sample.solution.Spice;
import lab01.sample.solution.Utensil;

public class MealFactoryAsianStyle extends MealFactory {

	protected Spice provideSpice() {
		return new Curry();
	}

	protected Utensil provideUtensil() {
		return new Wok();
	}

}
