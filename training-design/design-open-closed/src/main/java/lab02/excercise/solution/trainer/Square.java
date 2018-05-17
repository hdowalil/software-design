package lab02.excercise.solution.trainer;

import java.io.PrintStream;

public class Square implements Shape {

	@Override
	public String getName() {
		return "Square";
	}

	@Override
	public String getDescription() {
		return "A square is a regular quadrilateral, which means that it has four equal sides and four equal angles (90-degree angles).";
	}

	@Override
	public void draw(PrintStream out) {
		out.println(" ___");
		out.println("|   |");
		out.println("|___|");
	}

}
