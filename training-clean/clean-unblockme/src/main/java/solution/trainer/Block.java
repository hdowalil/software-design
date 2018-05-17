package solution.trainer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * A class instance will represent one of the stones on the {@link Board}<br>
 * Being "red" {@link Block#isRed()} means, that this is the players stone, that needs to find the exit.<br> 
 * A block can be {@link Alignment#HORIZONTAL} or {@link Alignment#VERTICAL} aligned, and has a lenght of 2 or 3 fields.<br>
 * Blocks cannot overlap on a board, which is checked by the {@link Board}.
 */
public final class Block implements Cloneable, Comparable<Block> {
	
	private static final int RED_POS_X = 0;
	private static final int RED_POS_Y = 3;
	private static final Alignment RED_ALIGNMENT = Alignment.HORIZONTAL;
	private static final int RED_LENGTH = 2;
	
	private boolean red;
	private Coordinate pos;
	private Alignment alignment;
	private int length;
	
	private Block(boolean red, @Nonnull Coordinate pos, @Nonnull Alignment alignment, int length) {
		super();
		
		Objects.requireNonNull(pos);
		Objects.requireNonNull(alignment);
		
		this.red = red;
		this.pos = pos;
		this.alignment = alignment;
		this.length = length;
		
		assert invariants();
	}

	public Block(@Nonnegative int x, @Nonnegative int y, @Nonnull Alignment alignment, int length) {
		this(false,new Coordinate(x,y),alignment,length);
	}

	public boolean invariants() {
		boolean lengthOk = (this.length >=2 && this.length <=3);
		return (lengthOk && invariantPositionOk());
	}
	
	private boolean invariantPositionOk() {
		boolean atLeastOneCoordinateNotOk = getCoveredCoordinates().getUniqueCoordinates().stream().
				filter(c -> !c.invariant()).
				findAny().
				isPresent();
		return !atLeastOneCoordinateNotOk;
	}
	
	static Block createRedBlock() {
		return new Block(true,new Coordinate(RED_POS_X, RED_POS_Y),RED_ALIGNMENT,RED_LENGTH);
	}

	/**
	 * this will use the root coordinate for sorting, as this should be unique in a board list
	 */
	@Override
	public int compareTo(@Nonnull Block arg0) {
		return this.pos.compareTo(arg0.pos);
	}

	@Override
	public Block clone() {
		return new Block(this.red,this.pos.clone(),this.alignment,this.length);
	}
	
	private static boolean redFromString(CharSequence input) {
		return "R".equals(input);
	}
	
	private String redToString() {
		return red ? "R" : "N";
	} 
	
	static Block fromString(@Nonnull String input) {
		String[] values = input.split("\\,");
		Coordinate coord = Coordinate.fromString(values[1]);
		return new Block(
				redFromString(values[0]),
				coord,
				Alignment.fromString(values[2]),
				Integer.parseInt(values[3]));
	}
	
	static String blocksToString(@Nonnull Collection<Block> blocks) {
		return blocks.stream().map(b -> b.toString()).collect(Collectors.joining(" "));
	}
	
	static List<Block> blocksFromString(@Nonnull String input) {
		String[] blocks = input.split("\\ ");
		return Arrays.stream(blocks).map(Block::fromString).collect(Collectors.toList());
	}
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%d",
				this.redToString(),
				this.pos.toString(),
				this.alignment.toString(),
				this.length);
	}
	
	/**
	 * this Block has an alignment in which it is pointing and a length,
	 * which means that it covers more fields on the board than just it´s origin.
	 * <br>
	 * this method will return all the coordinates covered by this block
	 * 
	 * @return the list of the covered coordinates
	 */
	UniqueCoordinates getCoveredCoordinates() {
		UniqueCoordinates result = new UniqueCoordinates();
		
		result.addOnlyWhenNotIncluded(this.pos.clone());
		for (int i=1; i<this.length; i++) {
			if (Alignment.VERTICAL.equals(this.alignment)) {
				result.addOnlyWhenNotIncluded(new Coordinate(this.pos.getPosX(), this.pos.getPosY()+i));
			} else {
				result.addOnlyWhenNotIncluded(new Coordinate(this.pos.getPosX()+i, this.pos.getPosY()));
			}
		}
		
		return result;
	}
	
	/**
	 * That a move is possible, 
	 * all of the moved coordinates of a block have to be in range of the board after the move
	 * 
	 * @param forward
	 * @return
	 */
	boolean isMoveWithinRange(@Nonnull Direction dir) {
		Collection<Coordinate> allCoordinates = getCoveredCoordinates().getUniqueCoordinates();
		
		for (Coordinate coord : allCoordinates) {
			
			if (dir.equals(Direction.FORWARD)) {

				// FORWARD:
				if (Alignment.VERTICAL.equals(this.alignment)) {
					if (!coord.isMoveWithinRange(0, 1)) {
						return false;
					}
				} else {
					if (!coord.isMoveWithinRange(1, 0)) {
						return false;
					}
				}
				
			} else {
				
				// BACKWARD:
				if (Alignment.VERTICAL.equals(this.alignment)) {
					if (!coord.isMoveWithinRange(0, -1)) {
						return false;
					}
				} else {
					if (!coord.isMoveWithinRange(-1, 0)) {
						return false;
					}
				}
				
			}
		}
		
		return true;
	}
	
	void move(@Nonnull Direction dir) {
		if (dir.equals(Direction.FORWARD)) {
			moveForward();
		} else {
			moveBackward();
		}
	}
	
	private void moveForward() {
		
		if (Alignment.VERTICAL.equals(this.alignment)) {
			this.pos = this.pos.move(0,1);
		} else {
			this.pos = this.pos.move(1,0);
		}
		
		assert invariants();
	}
	
	private void moveBackward() {
		
		if (Alignment.VERTICAL.equals(this.alignment)) {
			this.pos = this.pos.move(0,-1);
		} else {
			this.pos = this.pos.move(-1,0);
		}
		
		assert invariants();
	}

	Coordinate getPos() {
		return this.pos;
	}
	
	public boolean isRed() {
		return red;
	}

	public int getPosX() {
		return pos.getPosX();
	}
	
	public int getPosY() {
		return pos.getPosY();
	}
	
	public Alignment getAlignment() {
		return alignment;
	}

	public int getLength() {
		return length;
	}

}
