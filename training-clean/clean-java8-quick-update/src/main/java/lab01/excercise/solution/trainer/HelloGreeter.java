package lab01.excercise.solution.trainer;

import lab01.excercise.common.Greeting;

public class HelloGreeter {

	public static void main(String[] args) {

		Greeting greeting = (name, output) -> output.println("Hello " + name + "!"); 
		
		greeting.sayHello("Charlie", System.out);
		
	}
	
}
