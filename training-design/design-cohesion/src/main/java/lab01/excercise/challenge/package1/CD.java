package lab01.excercise.challenge.package1;

import lab01.excercise.challenge.package2.CL;

public class CD {

	public static void doSomething() {
		System.out.println(CD.class.getName());
		CL.doSomething();
		CF.doSomething();
	}

}
