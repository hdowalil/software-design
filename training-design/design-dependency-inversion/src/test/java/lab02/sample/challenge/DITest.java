package lab02.sample.challenge;

import org.junit.jupiter.api.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lab02.sample.challenge.a.C1;

public class DITest {
	
	@Test
	public void runC1() {
		
		Injector injector = Guice.createInjector(new Module());
	    C1 c1 = injector.getInstance(C1.class);
	    
	    c1.do1();
	    
	}
	

}
