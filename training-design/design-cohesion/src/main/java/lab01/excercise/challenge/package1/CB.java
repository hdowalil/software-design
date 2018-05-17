package lab01.excercise.challenge.package1;

public class CB {

	public static void doSomething() {
		System.out.println(CB.class.getName());
		CD.doSomething();
		CE.doSomething();
	}

}
