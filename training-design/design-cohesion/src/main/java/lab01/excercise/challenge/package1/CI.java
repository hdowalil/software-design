package lab01.excercise.challenge.package1;

public class CI {

	public static void doSomething() {
		System.out.println(CI.class.getName());
		CJ.doSomething();
		CK.doSomething();
	}

}
