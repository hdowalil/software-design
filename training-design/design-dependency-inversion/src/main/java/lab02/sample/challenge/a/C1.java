package lab02.sample.challenge.a;

import javax.inject.Inject;

import lab02.sample.challenge.b.C5;

public class C1 {
	
	@Inject
	C2 c2;
	@Inject
	C3 c3;
	@Inject
	C5 c5;
	
	public void do1() {
		
		System.out.println("1");
		c2.do2();
		c3.do3();
		c5.do5();
	}

}
