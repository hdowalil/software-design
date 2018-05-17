package lab04.sample.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab04.excercise.common.Food;

public class Assortment {

	private List<Food> inventory;

	public Assortment() {
		super();
		inventory = new ArrayList<Food>();
	}
	
	public Assortment addFood(Food newFood) {
		inventory.add(newFood);
		return this;
	}
	
	public long countDifferentOrganicFood() {
		
		Set<String> result = new HashSet<String>(); 
		
		for (Food food : inventory) {
			if (food.isOrganic()) {
				result.add(food.getName());
			}
		}
		
		return result.size();
	}
	
	public static void main(String[] args) {
		
		Assortment assortment = new Assortment();
		
		assortment.
			addFood(new Food(true,"Orange")).
			addFood(new Food(false,"Orange")).
			addFood(new Food(true,"Apple")).
			addFood(new Food(true,"Apple")).
			addFood(new Food(false,"Banana")).
			addFood(new Food(false,"Banana")).
			addFood(new Food(false,"Strawberry"));
		
		System.out.println("Should be 2 (Orange and Apple): " + Long.toString(assortment.countDifferentOrganicFood()));
	}
	
}
