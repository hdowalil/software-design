package lab01.excercise.challenge;

/**
 * The events, that every on off machine has
 * <br>
 * All implementing concrete states (and the context if you like) must implement
 */
public interface OnOffState {

	public void switchOn();
	public void switchOff();
	
}
