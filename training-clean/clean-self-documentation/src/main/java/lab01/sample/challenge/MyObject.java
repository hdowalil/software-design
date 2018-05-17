package lab01.sample.challenge;

public class MyObject {
	
	private long value;
	private boolean related;
	private int percentage;
	private int years;
	private boolean ext;
	
	public MyObject(boolean related, int percentage, int years, boolean ext) {
		
		super();
		
		this.related = related;
		this.percentage = percentage;
		this.years = years;
		this.ext = ext;
		
		if ((percentage >= 50 && years > 2 && !ext) || related) {
			value = 2000;
		} else {
			value = 1000;
		}
		
	}

	public long getValue() {
		return value;
	}

	public boolean isRelated() {
		return related;
	}

	public int getPercentage() {
		return percentage;
	}

	public int getYears() {
		return years;
	}

	public boolean isExt() {
		return ext;
	}
	
	
}
