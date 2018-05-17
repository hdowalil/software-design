package solution.trainer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * The main class of the playing board, will bear all the blocks and provide an API for creation ({@link BoardBuilder}) and usage
 */
@Immutable
public final class Board implements Cloneable {
	
	private final static Coordinate SOLVED_RED_POSITION = new Coordinate(4, 3); 
	
	private List<Block> blocks;
	
	private Board(@Nonnull List<Block> blocks) {
		this.blocks = blocks;
	}

	public static class BoardBuilder {
		
		List<Block> blocks2Add = null;
		
		public BoardBuilder() {
			this(true);
		}

		private BoardBuilder(boolean addRed) {
			super();
			blocks2Add = new ArrayList<>();
			if (addRed) {
				blocks2Add.add(Block.createRedBlock());
			}
		}

		public BoardBuilder addBlock(Block newBlock) {
			blocks2Add.add(newBlock);
			return this;
		}
		
		public Board build() {
			List<Block> blocks = new ArrayList<>();
			blocks.addAll(blocks2Add);
			Board result = new Board(blocks);
			// Maybe later:
			// assert result.invariant();
			return result;
		}
	}
	
	public static Board fromString(@Nonnull String input) {
		
		Objects.requireNonNull(input);
		
		BoardBuilder builder = new BoardBuilder(false);
		Block.blocksFromString(input).stream().forEach(b -> builder.addBlock(b));;
		return builder.build();
	}
	
	/**
	 * Every board situation will be represented by the same unique String,
	 * which is the reason why we sort the blocks before converting them toString,
	 * by its root coordinate<br>
	 * By sorting we achieve that the same boards with blocks in different order in collection
	 * will be represented by the same string result of this method!
	 */
	@Override
	public String toString() {
		Collections.sort(this.blocks);
		return Block.blocksToString(this.blocks);
	}
	
	public Optional<Block> findBlock(@Nonnegative int posX, @Nonnegative int posY) {
		
		Coordinate pos = new Coordinate(posX, posY);
		
		return blocks.stream().filter(b -> b.getPos().equals(pos)).findFirst();
	}
	
	/**
	 * The board is solved, when the red block sees the exit.
	 * 
	 * @return true if the board is solved, and the red block can see the exit directly ahead!
	 */
	public boolean isSovled() {
		return blocks.stream().
				filter(Block::isRed).
				filter(b -> b.getPos().
						equals(SOLVED_RED_POSITION)).
				findAny().
				isPresent();
	}
	
	List<Move> findPossibleMoves() {
		
		List<Move> result = new ArrayList<>();
		
		for (Block block : blocks) {
			
			if (isValidMove(block, Direction.FORWARD)) {
				result.add(new Move(block.getPos(),Direction.FORWARD));
			}
			
			if (isValidMove(block, Direction.BACKWARD)) {
				result.add(new Move(block.getPos(),Direction.BACKWARD));
			}
		}
		
		return result;
	}
	
	/*
	 * get all coordinates, that are covered on the board, 
	 * except the coordinates covered by the parameter block-2-exlcude.
	 * if that is null, you will get ALL covered coordinates
	 */
	private UniqueCoordinates getAllCoveredCoordinatesExcept(@Nullable Block block2Exclude) {
		
		final UniqueCoordinates result = new UniqueCoordinates();
		
		for (Block block : blocks) {
			if (block != block2Exclude) {
				block.getCoveredCoordinates().
					getUniqueCoordinates().
					stream().
					forEach(c -> result.addOnlyWhenNotIncluded(c));
			}
		}
		
		return result;
	}
	
	private UniqueCoordinates getAllCoveredCoordinates() {
		return getAllCoveredCoordinatesExcept(null);
	}
	
	public boolean isValidMove(Block block, Direction dir) {
		
		if (!block.isMoveWithinRange(dir)) {
			// out of the boards coordinates
			return false;
		}
		
		UniqueCoordinates allCoveredCoordinates = getAllCoveredCoordinatesExcept(block);
		
		Block movedBlock = block.clone();
		movedBlock.move(dir);
		
		UniqueCoordinates movedBlocksCoveredCoordinates = movedBlock.getCoveredCoordinates();
		
		// will return false, if the move collides with another block
		return !allCoveredCoordinates.isAtLeastOneCoordinateAlreadyIncluded(movedBlocksCoveredCoordinates.getUniqueCoordinates());
	}
	
	public void move (Move move) {
		
		Block block2Move = findBlock(move.getPos().getPosX(),move.getPos().getPosY()).orElseThrow(IllegalArgumentException::new);
		
		if (!isValidMove(block2Move, move.getDirection())) {
			throw new IllegalArgumentException("This is not a valid move!");
		}
		
		block2Move.move(move.getDirection());
	}
	
	@Override
	public Board clone() {
		BoardBuilder builder = new BoardBuilder(false);
		blocks.stream().forEach(b -> builder.addBlock(b.clone()));
		return builder.build();
	}
	
	private String convertBordXLineToString(UniqueCoordinates coords, int y) {
		StringBuffer result = new StringBuffer();
		for (int x=0; x<6; x++) {
			Coordinate coord2Check = new Coordinate(x, y);
			if (coords.isCoordinateAlreadyIncluded(coord2Check)) {
				result.append("X");
			} else {
				result.append("-");
			}
		}
		return result.toString();
	}
	
	public void print (PrintStream out) {
		
		UniqueCoordinates coords = getAllCoveredCoordinates();
		for (int y=5; y>=0; y--) {
			out.println(convertBordXLineToString(coords, y));
		}
	}
}
