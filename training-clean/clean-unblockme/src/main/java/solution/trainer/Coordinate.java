package solution.trainer;

import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.Immutable;

@Immutable
class Coordinate implements Cloneable, Comparable<Coordinate> {
	
	private final static int BOARD_WIDTH = 6;
	private final static int BOARD_HEIGHT = 6;
	
	int posX;
	int posY;
	
	Coordinate(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		if (!invariant()) {
			throw new IllegalArgumentException("must be within 0,0 and 5,5");
		}
	}

	static boolean isValidCoordinate(int x, int y) {
		boolean posXOk = (x >= 0 && x < BOARD_WIDTH);
		boolean posYOk = (y >= 0 && y < BOARD_HEIGHT);
		return posXOk && posYOk;
	}
	
	boolean invariant() {
		return Coordinate.isValidCoordinate(this.posX, this.posY);
	}
	
	@Override
	public Coordinate clone() {
		return new Coordinate(this.posX, this.posY);
	}
	
	@Override
	public String toString() {
		return String.format("%d#%d",this.posX,this.posY);
	}
	
	static Coordinate fromString(String input) {
		String[] values = input.split("\\#");
		return new Coordinate(
				Integer.parseInt(values[0]),
				Integer.parseInt(values[1]));
	}
	
	boolean isMoveWithinRange(int deltaX, int deltaY) {
		return Coordinate.isValidCoordinate(posX+deltaX, posY+deltaY);
	}
	
	@CheckReturnValue
	Coordinate move(int deltaX, int deltaY) {
		return new Coordinate(posX+deltaX, posY+deltaY);
	}
	
	int getPosX() {
		return posX;
	}

	int getPosY() {
		return posY;
	}

	private int getSortKey() {
		return this.posY*10000+posX;
	}
	
	/**
	 * We implement comparable to make it possible for the board, to bring its blocks into some sort of order
	 */
	@Override
	public int compareTo(Coordinate arg0) {
		return Integer.compare(this.getSortKey(), arg0.getSortKey());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + posX;
		result = prime * result + posY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

}
