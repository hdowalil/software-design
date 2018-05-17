package solution.trainer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * A Move is represented by the coordinate of the block (left bottom end), and the {@link Direction} it should be moved.<br>
 * Invoking {@link Move#toString} will bring up this format: 0#3,F
 */
@Immutable
public final class Move implements Cloneable {
	
	private Coordinate pos;
	private Direction direction;

	/**
	 * @param pos     The Blocks root coordinate (most bottom left) that should be moved on the board
	 * @param forward true if you want to move up or right (depending on block direction), or false otherwise
	 */
	Move(@Nonnull Coordinate pos, @Nonnull Direction direction) {
		super();
		
		Objects.requireNonNull(pos);
		Objects.requireNonNull(direction);
		
		this.pos = pos;
		this.direction = direction;
	}

	public Move(int x, int y, @Nonnull Direction direction) {
		this(new Coordinate(x, y),direction);
	}
	
	/**
	 * Will parse this format: 0#3,F
	 */
	static Move fromString(@Nonnull String input) {
		
		Objects.requireNonNull(input);
		
		String[] values = input.split("\\,");
		return new Move(
				Coordinate.fromString(values[0]),
				Direction.fromString(values[1]));
	}
	
	public static String movesToString(@Nonnull Collection<Move> moves) {
		
		Objects.requireNonNull(moves);
		
		return moves.stream().map(m -> m.toString()).collect(Collectors.joining(" "));
	}
	
	public static List<Move> movesFromString(@Nonnull String input) {
		
		Objects.requireNonNull(input);
		
		String[] moves = input.split("\\ ");
		return Arrays.stream(moves).map(Move::fromString).collect(Collectors.toList());
	}
	
	/**
	 * The String will look sthg like this: 0#3,F
	 */
	@Override
	public String toString() {
		return String.format("%s,%s",this.pos.toString(),direction.toString());
	}
	
	@Override
	public Move clone() {
		return new Move(this.pos.clone(),this.direction);
	}
	
	public Coordinate getPos() {
		return pos;
	}

	public Direction getDirection() {
		return direction;
	}
	
}
