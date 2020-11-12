package phproject;

import java.util.ArrayList;

public class Company {
	// Fields
	private String companyId;
	private String companyName;
	private ArrayList<Employee> companyEmployees;
	// Constructor
	public Company(String companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyEmployees = new ArrayList<Employee>();
	}
	// Getters and Setters
	public String getCompanyId() {
		return companyId;
	}
		
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
		
	public String getCompanyName() {
		return companyName;
	}
		
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
		
	public ArrayList<Employee> getCompanyEmployees() {
		return companyEmployees;
	}
		
	public void addEmployee(Employee employee) {
		this.companyEmployees.add(employee);
	}
	
}
