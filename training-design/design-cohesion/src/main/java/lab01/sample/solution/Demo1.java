package lab01.sample.solution;

public class Demo1 {

	private int var1;
	
	public void setVar1(int var1) {
		this.var1 = var1;
	}

	public int methodA() {
		return var1*2;
	}
	
	public int methodB() {
		return methodA()*3;
	}
	
}

