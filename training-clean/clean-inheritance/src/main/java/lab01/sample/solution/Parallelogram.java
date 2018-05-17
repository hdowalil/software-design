package lab01.sample.solution;

public final class Parallelogram extends FourSidedFigure {
	
	private int a;
	private int b;
	private int ha;

	public Parallelogram(int a, int b, int ha) {
		super();
		this.a = a;
		this.b = b;
		this.ha = ha;
	}

	@Override
	public int area() {
		return super.calculateAreaOfRectangularFourSidedFigure(a,ha);
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getHa() {
		return ha;
	}

	
	

}
