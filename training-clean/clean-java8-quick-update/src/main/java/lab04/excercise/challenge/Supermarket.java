package lab04.excercise.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab04.excercise.common.Food;

public class Supermarket {

	private List<Food> inventory;

	public Supermarket() {
		super();
		inventory = new ArrayList<Food>();
	}
	
	public Supermarket addFood(Food newFood) {
		inventory.add(newFood);
		return this;
	}
	
	public Food getCheapestOrganicFood() {
		
		Food cheapestFood = null;
		
		for (Food food : inventory) {
			if (food.isOrganic()) {
				if (cheapestFood == null || food.getPrice() < cheapestFood.getPrice()) {
					cheapestFood = food;
				}
			}
		}
		
		return cheapestFood;
	}
	
	public Collection<Food> getAllOrganicFoods() {
		
		List<Food> result = new ArrayList<Food>(); 
		
		for (Food food : inventory) {
			if (food.isOrganic()) {
				result.add(food);
			}
		}
		
		return result;
	}
	
	public Map<Boolean, Long> getNumberOf () {
		
		Map<Boolean, Long> result = new HashMap<>();
		
		result.put(Boolean.FALSE, 0L);
		result.put(Boolean.TRUE, 0L);
		
		for (Food food : inventory) {
			result.put(food.isOrganic(), result.get(food.isOrganic())+1L);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Supermarket market = new Supermarket();
		
		market.
			addFood(new Food(true,"Orange",4.5d)).
			addFood(new Food(false,"Orange",3.2d)).
			addFood(new Food(true,"Apple",4.2d)).
			addFood(new Food(true,"Apple",4.0d)).
			addFood(new Food(false,"Banana",2.8d)).
			addFood(new Food(false,"Banana",2.6d)).
			addFood(new Food(false,"Strawberry",1.8d));
		
		Food cheapestOrganic = market.getCheapestOrganicFood();
		System.out.println("Should be an apple for 4: " + cheapestOrganic.getName() + " for " + Double.toString(cheapestOrganic.getPrice()));
		
		System.out.println("All organic foods: " + market.getAllOrganicFoods().toString());
	
		System.out.println("Number Of, Grouped By: " + market.getNumberOf().toString());
	}
	
}
