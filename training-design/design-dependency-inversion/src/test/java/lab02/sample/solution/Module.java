package lab02.sample.solution;

import com.google.inject.AbstractModule;

import lab02.sample.solution.a.C3ToPackageBAdapter;
import lab02.sample.solution.b.WhatC4Needs;

public class Module extends AbstractModule {

	  @Override 
	  protected void configure() {

	     /*
	      * This tells Guice that whenever it sees a dependency on WhatC4Needs,
	      * it should satisfy the dependency using a C3ToPackageBAdapter.
	      */
	    bind(WhatC4Needs.class).to(C3ToPackageBAdapter.class);

	  }}
