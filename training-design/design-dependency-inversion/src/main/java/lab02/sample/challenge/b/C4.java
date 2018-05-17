package lab02.sample.challenge.b;

import javax.inject.Inject;

import lab02.sample.challenge.a.C3;

public class C4 {

	@Inject
	C3 c3;
	@Inject
	C5 c5;
	@Inject
	C6 c6;
	@Inject
	C7 c7;
	
	public void do4() {
		c3.do3();
		System.out.println("4");
		c5.do5();
		c6.do6();
		c7.do7();
	}

}
