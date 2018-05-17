package lab01.sample.common;

import java.util.Date;

public class Message {
	
	private String someText;
	private long someValue;
	private Date someDate;
	
	public Message() {
		super();
	}
	
	public Message(String someText, long someValue, Date someDate) {
		super();
		this.someText = someText;
		this.someValue = someValue;
		this.someDate = someDate;
	}

	public String getSomeText() {
		return someText;
	}
	public void setSomeText(String someText) {
		this.someText = someText;
	}
	public long getSomeValue() {
		return someValue;
	}
	public void setSomeValue(long someValue) {
		this.someValue = someValue;
	}
	public Date getSomeDate() {
		return someDate;
	}
	public void setSomeDate(Date someDate) {
		this.someDate = someDate;
	}

}
