package lab04.sample.solution;

import java.util.ArrayList;
import java.util.List;

import lab04.excercise.common.Food;

public class AssortmentStream {

	private List<Food> inventory;

	public AssortmentStream() {
		super();
		inventory = new ArrayList<Food>();
	}
	
	public AssortmentStream addFood(Food newFood) {
		inventory.add(newFood);
		return this;
	}
	
	public long countDifferentOrganicFood() {
		
		return inventory.stream().filter(Food::isOrganic).map(Food::getName).distinct().count();
	}
	
	public static void main(String[] args) {
		
		AssortmentStream assortment = new AssortmentStream();
		
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
