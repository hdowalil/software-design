package lab01.excercise.challenge;

import java.util.Set;

public final class Pizza {

	private Set<String> ingredients;
	private int size;
	private boolean cheesyCrust = false;
	private boolean folded = false;

	public Pizza() {
		super();
	}

	public Pizza(int size, boolean cheesyCrust, boolean folded, Set<String> ingredients) {
		super();
		this.ingredients = ingredients;
		this.size = size;
		this.cheesyCrust = cheesyCrust;
		this.folded = folded;
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

	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setCheesyCrust(boolean cheesyCrust) {
		this.cheesyCrust = cheesyCrust;
	}

	public void setFolded(boolean folded) {
		this.folded = folded;
	}
	
}
