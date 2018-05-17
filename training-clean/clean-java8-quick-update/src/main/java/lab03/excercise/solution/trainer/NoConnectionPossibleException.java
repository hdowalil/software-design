package lab03.excercise.solution.trainer;

public class NoConnectionPossibleException extends IllegalStateException {

	private static final long serialVersionUID = -2716602439938994455L;

	public NoConnectionPossibleException() {
		super("Phone cannot connect");
	}
	
	public static void throwIf (boolean shouldThrow) {
		if (shouldThrow) {
			throw new NoConnectionPossibleException();
		}
	}
	
}
