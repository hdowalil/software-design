package lab01.sample.challenge;

public class Demo {

	private int var1;
	private int var2;
	
	public void setVar1(int var1) {
		this.var1 = var1;
	}

	public void setVar2(int var2) {
		this.var2 = var2;
	}

	public int methodA() {
		return var1*2;
	}
	
	public int methodB() {
		return methodA()*3;
	}
	
	public int methodC() {
		return var2*4;
	}
	
}

