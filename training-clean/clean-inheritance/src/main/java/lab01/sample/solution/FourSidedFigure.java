package lab01.sample.solution;

public abstract class FourSidedFigure {
	
	public abstract int area();

	protected int calculateAreaOfRectangularFourSidedFigure(int width, int height) {
		return width*height;
	}
	
}
