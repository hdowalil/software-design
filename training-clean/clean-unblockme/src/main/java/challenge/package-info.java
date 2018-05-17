/**
 * Implement an Unblockme Solver to @see {@link solution.your.Solver}
 * <br> 
 * Short explanation of the game:
 * <br> 
 * A board is always 6x6 big, the coordiante origin is left/bottom where x=0 and y=0
 * <br>
 * The top right corner will be x=5 and y=5
 * <br>
 * blocks can have have a lenght of 2 or 3, they are vertical or horizontal
 * <br> 
 * Start Positions of Blocks are always representing their bottom left end
 * <br>
 * A vertical Bar can only move in vertical direction plus and minus 1, a horizontal Bar only horizontally
 * <br> 
 * A bar can only move within limits of game board
 * <br>
 * The red block will have a length of 2 and will always be at start position x=0, y=3
 * <br>
 * The exit will always be at x=6 and y=3, this is where the red bar should go!
 * <br>
 * As soon as the red bar is at x=4 and y=3 it can see the exit at it´s right end and the puzzle is solved
 * <br>
 * @see <a href="http://euri.ca/2013/solving-unblockme/index.html">Unblockme Game</a> 
 * <br>
 * or @see <a href="http://xpgameplus.com/games/unblockme/index.html">Play Unblockme</a> 
 *
 */
package challenge;
