package lab01.sample.solution;

public final class Square extends FourSidedFigure {

	private int sideLength;

	public Square(int sideLength) {
		super();
		this.sideLength = sideLength;
	}
	
	@Override
	public int area() {
		return super.calculateAreaOfRectangularFourSidedFigure(sideLength, sideLength);
	}

	public int getSideLength() {
		return sideLength;
	}
	
}
