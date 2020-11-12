package phproject;

import java.util.Stack;

public class Employee {
	// Fields
	private String employeeId;
	private String employeeName;
	private int employeeAge;
	private Stack<Test> employeeTests;
	// Constructor
	public Employee(String employeeId, String employeeName, int employeeAge) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeTests = new Stack<Test>();
	}
	// Getters and Setters
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
		
	public String getEmployeeName() {
		return employeeName;
	}
		
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
		
	public int getEmployeeAge() {
		return employeeAge;
	}
		
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
		
	public Stack<Test> getEmployeeTests() {
		return employeeTests;
	}
		
	public void addTest(Test test) {
		employeeTests.push(test);
	}
	
}
