package lab01.sample.solution;

public final class Rectangle extends FourSidedFigure {
	
	int width;
	int height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int area() {
		return super.calculateAreaOfRectangularFourSidedFigure(width, height);
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}
