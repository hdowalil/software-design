package lab02.excercise.solution.trainer;

import java.io.PrintStream;

public class Triangle implements Shape {
	
	@Override
	public String getName() {
		return "Triangle";
	}

	@Override
	public String getDescription() {
		return "A triangle is a polygon with three edges and three vertices.";
	}

	public void draw(PrintStream out) {
		out.println(" /\\");
		out.println("/__\\");
	}

}
