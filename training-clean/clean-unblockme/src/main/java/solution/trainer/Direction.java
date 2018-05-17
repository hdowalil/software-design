package solution.trainer;

public enum Direction {

	/**
	 * Forward means:
	 * <ul>
	 * <li>right in case of a {@link Alignment#HORIZONTAL} alignment</li>
	 * <li>up in case of a {@link Alignment#VERTICAL} alignment</li>
	 * </ul>
	 */
	FORWARD,
	
	/**
	 * Backward means:
	 * <ul>
	 * <li>left in case of a {@link Alignment#HORIZONTAL} alignment</li>
	 * <li>down in case of a {@link Alignment#VERTICAL} alignment</li>
	 * </ul>
	 */
	BACKWARD;
	
    public static Direction fromString(String input) {
        return "F".equals(input) ? Direction.FORWARD : Direction.BACKWARD;
    }

    public String toString() {
        return this.name().substring(0,1);
    }
}
