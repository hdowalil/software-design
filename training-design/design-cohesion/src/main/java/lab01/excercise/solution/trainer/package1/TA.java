package lab01.excercise.solution.trainer.package1;

public class TA {

	public static void doSomething() {
		System.out.println(TA.class.getName());
		TB.doSomething();
		TC.doSomething();
	}

}
