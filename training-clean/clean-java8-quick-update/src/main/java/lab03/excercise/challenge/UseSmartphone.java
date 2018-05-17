package lab03.excercise.challenge;

public class UseSmartphone {

	public static void main(String[] args) {
		
		Smartphone phone = new Smartphone();
		// will throw exception
		phone.getConnection().speak("Hello?");

	}

}
