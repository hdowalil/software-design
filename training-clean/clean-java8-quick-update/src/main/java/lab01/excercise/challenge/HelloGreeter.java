package lab01.excercise.challenge;

import java.io.PrintStream;

import lab01.excercise.common.Greeting;

public class HelloGreeter {

	public static void main(String[] args) {

		Greeting greeting = new Greeting() {
			
			@Override
			public void sayHello(String name, PrintStream output) {
				output.println("Hello " + name + "!");
			}
		};
		
		greeting.sayHello("Charlie", System.out);
		
	}
	
}
