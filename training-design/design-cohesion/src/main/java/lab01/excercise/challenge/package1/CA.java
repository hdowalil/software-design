package lab01.excercise.challenge.package1;

public class CA {

	public static void doSomething() {
		System.out.println(CA.class.getName());
		CB.doSomething();
		CC.doSomething();
	}

}
