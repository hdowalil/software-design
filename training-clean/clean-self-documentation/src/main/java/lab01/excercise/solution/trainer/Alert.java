package lab01.excercise.solution.trainer;

import java.util.Arrays;
import java.util.Objects;

public enum Alert {
	
	/**
	 * everything is just fine
	 */
	GREEN(0),
	
	/**
	 * do something about the problem!
	 */
	YELLOW(1),
	
	/**
	 * use escape pods, if there are any, immediately
	 */
	RED(2);
	
	private final int severity;
	
	private Alert(int severity) {
		this.severity = severity;
	}
	
	public int severity() {
		return this.severity;
	}
	
	public static Alert getMaximumSeverity(Alert...alerts) {
		
		Objects.requireNonNull(alerts);
		
		return Arrays.stream(alerts).max((v1,v2) -> Integer.compare(v1.severity(), v2.severity())).get();
	}

}
