package phproject;

import java.util.Date;

public class Test {
	// Fields
	private String testId;
	private Date testDate;
	private boolean isPositive;
	// Constructor
	public Test(String testId, Date testDate, boolean isPositive) {
		this.testId = testId;
		this.testDate = testDate;
		this.isPositive = isPositive;
	}
	// Getters and Setters
	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public boolean isPositive() {
		return isPositive;
	}

	public void setIsPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}
	
}
