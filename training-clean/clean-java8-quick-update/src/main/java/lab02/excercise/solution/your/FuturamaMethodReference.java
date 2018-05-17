package lab02.excercise.solution.your;

import java.util.function.Consumer;

public class FuturamaMethodReference {
	
	private final static String[] futuramaCharacters = { "Philip J. Fry", "Bender", "Leela", "Dr. Zoidberg", "Amy Wong", "Professor Farnsworth" };
	
	public void doSomethingWithFuturamaCharacterNames(Consumer<String> consumer) {
		
		for (String f : futuramaCharacters) {
			consumer.accept(f);
		}
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		FuturamaMethodReference futurama = new FuturamaMethodReference();
		
		// do the same, just without an explicit consumer
		// futurama.doSomethingWithFuturamaCharacterNames(???);
		
	}
}
