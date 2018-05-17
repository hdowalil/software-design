package lab01.excercise.solution.trainer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class Pizza {

	private Set<String> ingredients;
	private int size;
	private boolean cheesyCrust = false;
	private boolean folded = false;

	private Pizza(@Nonnegative int size, boolean cheesyCrust, boolean folded, @Nonnull Set<String> ingredients) {
		super();
		this.size = size;
		this.cheesyCrust = cheesyCrust;
		this.folded = folded;

		Objects.requireNonNull(ingredients);
		this.ingredients = ingredients;
	}

	public static class Builder {

		private Set<String> ingredients = new HashSet<>();
		private int size = -1;
		private boolean folded = false;
		private boolean cheesyCrust = false;

		public Builder addIngredient(String newIngredient) {
			ingredients.add(newIngredient);
			return this;
		}

		public Builder diameterInInches(int size) {
			this.size = size;
			return this;
		}

		public Builder cheesyCrust() {
			this.cheesyCrust = true;
			return this;
		}

		public Builder fold() {
			this.folded = true;
			return this;
		}
		
		public Builder margherita() {
			ingredients.clear();
			addIngredient("Tomatoes").addIngredient("Cheese");
			return this;
		}

		public Builder cardinale() {
			margherita().addIngredient("Ham");
			return this;
		}

		public Pizza build() {
			return new Pizza(this.size, this.cheesyCrust, this.folded, this.ingredients);
		}

	}
	
	public void eat() {
		// ...
	}

	public Set<String> getIngredients() {
		return ingredients;
	}

	public int getSize() {
		return size;
	}

	public boolean isCheesyCrust() {
		return cheesyCrust;
	}

	public boolean isFolded() {
		return folded;
	}

}
