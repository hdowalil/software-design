package lab04.excercise.solution.your;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
		
		// TODO do this with a stream
		return null;
	}
	
	public Collection<Food> getAllOrganicFoods() {
		
		// TODO do this with a stream
		return null;
	}
	
	public Map<Boolean, Long> getNumberOf () {
		
		// TODO do this with a stream, use Collectors.groupingBy and .counting
		return null;
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
	}
	
}
