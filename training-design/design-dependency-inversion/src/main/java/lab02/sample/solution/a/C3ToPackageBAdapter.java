package lab02.sample.solution.a;

import javax.inject.Inject;

import lab02.sample.solution.b.WhatC4Needs;

public class C3ToPackageBAdapter implements WhatC4Needs {
	
	@Inject
	C3 c3;

	@Override
	public void whatC4Needs() {
		c3.do3();
	}
	
}
