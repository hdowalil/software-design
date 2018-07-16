package lab02.excercise.solution.trainer;

import java.io.PrintStream;

public class Circle implements Shape {

	@Override
	public String getName() {
		return "Circle";
	}

	@Override
	public String getDescription() {
		return "A circle is the set of all points in a plane that are at a given distance from a given point, the centre.";
	}

	@Override
	public void draw(PrintStream out) {
        out.println(" ___");
        out.println("/   \\");
        out.println("\\___/");
	}
	
}
