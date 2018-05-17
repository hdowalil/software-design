package lab03.excercise.solution.trainer;

public class UseSmartphone {

	public static void main(String[] args) {
		
		// this works
		Smartphone phone = new Smartphone();
		phone.setConnection(new Connection());
		phone.getConnection().get().setConnected(true);
		System.out.println(phone.speak("Hello?"));

		// this does not
		phone = new Smartphone();
		System.out.println(phone.speak("Hello?"));
	}

}
