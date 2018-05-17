package lab04.excercise.solution.trainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lab04.excercise.common.Food;

public class SupermarketStream {

	private List<Food> inventory;

	public SupermarketStream() {
		super();
		inventory = new ArrayList<Food>();
	}
	
	public SupermarketStream addFood(Food newFood) {
		inventory.add(newFood);
		return this;
	}
	
	public Food getCheapestOrganicFood() {
		
		return inventory.
				stream().
				filter(Food::isOrganic).
				sorted(Comparator.comparing(Food::getPrice)).
				findFirst().get();
	}
	
	public Collection<Food> getAllOrganicFoods() {
		
		return inventory.
				stream().
				filter(Food::isOrganic).
				collect(Collectors.toList());
	}
	
	public Map<Boolean, Long> getNumberOf () {
		
		return inventory.
				stream().
				collect(
                        Collectors.groupingBy(
                                Food::isOrganic, Collectors.counting())
                        );
	}
	
	public static void main(String[] args) {
		
		SupermarketStream market = new SupermarketStream();
		
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
