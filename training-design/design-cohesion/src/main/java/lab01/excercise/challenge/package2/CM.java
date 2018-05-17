package lab01.excercise.challenge.package2;

public class CM {

	public static void doSomething() {
		System.out.println(CM.class.getName());
		CN.doSomething();
		CO.doSomething();
		CP.doSomething();
	}
	
}
