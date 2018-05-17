package lab01.excercise.solution.trainer;

import java.util.function.Supplier;

import lab01.excercise.solution.trainer.asian.Curry;
import lab01.excercise.solution.trainer.asian.Wok;

public class MealFactory {

	@SuppressWarnings("unused")
	public static Meal prepare(Supplier<Utensil> utensilSupplier, Supplier<Spice> spiceSupplier) {
		
		Utensil utensil = utensilSupplier.get();
		Spice spice = spiceSupplier.get();
		
		// now do whatever steps are needed to prepare the meal...
		
		return new Meal();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Meal westernMeal = prepare(FryingPan::new,Pepper::new);
		Meal asianMeal = prepare(Wok::new,Curry::new);
		
	}
}
