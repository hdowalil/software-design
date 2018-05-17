package lab01.excercise.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InsurancePolicy {
	
	private String policyNr;
	private long premium=0L;
	private List<Risk> risks;
	
	public InsurancePolicy() {
		super();
		risks = new ArrayList<>();
	}
	
	public boolean addRisks(Risk Risk) {
		return risks.add(Risk);
	}
	public boolean removeRisk(Risk Risk) {
		return risks.remove(Risk);
	}
	public Stream<Risk> riskStream() {
		return risks.stream();
	}
	
	public String getPolicyNr() {
		return policyNr;
	}
	public void setPolicyNr(String policyNr) {
		this.policyNr = policyNr;
	}
	public long getPremium() {
		return premium;
	}
	public void setPremium(long premium) {
		this.premium = premium;
	}
	

}
