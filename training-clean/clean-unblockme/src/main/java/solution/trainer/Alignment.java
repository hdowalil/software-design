package solution.trainer;

public enum Alignment {

	HORIZONTAL,
	VERTICAL;
	
    public static Alignment fromString(String input) {
        return "V".equals(input) ? VERTICAL : HORIZONTAL;
    }

    public String toString() {
        return this.name().substring(0,1);
    }
}
