package lab02.excercise.challenge;

import java.util.function.Consumer;

public class Futurama {
	
	private final static String[] futuramaCharacters = { "Philip J. Fry", "Bender", "Leela", "Dr. Zoidberg", "Amy Wong", "Professor Farnsworth" };
	
	public void doSomethingWithFuturamaCharacterNames(Consumer<String> consumer) {
		
		for (String f : futuramaCharacters) {
			consumer.accept(f);
		}
	}

	public static void main(String[] args) {
		
		Futurama futurama = new Futurama();
		
		Consumer<String> writerToConsole = new Consumer<String>() {

			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		};
		
		futurama.doSomethingWithFuturamaCharacterNames(writerToConsole);
		
	}
}
