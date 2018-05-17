package lab02.excercise.challenge.p1;

import lab02.excercise.challenge.p2.Class2;

public class Class1 {
	
	public static void method1A() {
		System.out.println("Logic of Method 1A");
		method1B();
		Class2.method2B();
	}

	public static void method1B() {
		System.out.println("Logic of Method 1B");
	}

}
