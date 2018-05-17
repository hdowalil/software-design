/**
 * This package contains all the classes necessary to solve a unblockme-game!<br>
 * This is hiding stuff, that are not needed for solution outside of this package.<br>
 * For usage of this package focus on this main classes:
 * <ul>
 * <li>Construct a {@link solution.trainer.Board} with {@link solution.trainer.Block} that you want to solve</li>
 * <li>Then use {@link solution.trainer.MySolver} to find a solution. This will return a list of {@link solution.trainer.Move}</li>
 * <li>There is also a String API {@link solution.trainer.MySolver#solveBoard(String)} according to the Strings described in {@link solution.your.Solver}</li>
 * </ul>
 * If you want to give it a try, run {@link solution.trainer.MySolver#main(String[])}  
 */
package solution.trainer;
