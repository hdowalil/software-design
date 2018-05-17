package lab02.sample.solution.b;

import javax.inject.Inject;

public class C4 {

	@Inject
	WhatC4Needs whatINeed;
	@Inject
	C5 c5;
	@Inject
	C6 c6;
	@Inject
	C7 c7;
	
	public void do4() {
		whatINeed.whatC4Needs();
		System.out.println("Solution-4");
		c5.do5();
		c6.do6();
		c7.do7();
	}

}
