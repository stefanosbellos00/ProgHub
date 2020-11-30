package phproject;

import java.util.ArrayList;

import phproject.Employee.Status;

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
	
	public void updateList(ArrayList<Employee> newList) {
		this.companyEmployees = newList;
	}
	
	public void addEmployee(Employee employee) {
		this.companyEmployees.add(employee);
	}
	// Adds employee object to the selected list
	public void addToList(Employee employee, ArrayList<Employee> list) {
		list.add(employee);
	}
	//Methods to get list of employees with a certain case status
	//searches through the list of employees and returns a list containing only those with the status SUSPECT
	public ArrayList<Employee> suspectList() {
		ArrayList<Employee> suspectList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.SUSPECT) {
				this.addToList(searchList.get(i), suspectList);
			}
		}
		return suspectList;
	}
	//searches through the list of employees and returns a list containing only those with the status POSITIVE
	public ArrayList<Employee> positiveList() {
		ArrayList<Employee> positiveList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.POSITIVE) {
				this.addToList(searchList.get(i), positiveList);
			}
		}
		return positiveList;
	}
	//searches through the list of employees and returns a list containing only those with the status NEGATIVE
	public ArrayList<Employee> negativeList() {
		ArrayList<Employee> negativeList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.NEGATIVE) {
				this.addToList(searchList.get(i), negativeList);
			}
		}
		return negativeList;
	}
	/*searches through the list of employees and returns a list containing only those with the status 
	RETEST_READY */
	public ArrayList<Employee> retestReadyList() {
		ArrayList<Employee> retestReadyList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.RETEST_READY) {
				this.addToList(searchList.get(i), retestReadyList);
			}
		}
		return retestReadyList;
	}
	
	/*searches through the list of employees and returns a list containing all pending tests
	 * (Suspect and Retest_Ready cases) */
	
	public ArrayList<Employee> pendingTestsList() {
		ArrayList<Employee> pendingTestList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.RETEST_READY || searchList.get(i).getCaseStatus() == Status.SUSPECT) {
				this.addToList(searchList.get(i), pendingTestList);
			}
		}
		return pendingTestList;
	}
	
	/*searches through the list of employees and returns a list containing all inactive employees
	 * (Suspect,Retest_Ready cases, and Positive cases ) */
	
	public ArrayList<Employee> inactiveList() {
		ArrayList<Employee> inactiveList = new ArrayList<Employee>();
		ArrayList<Employee> searchList = this.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getCaseStatus() == Status.RETEST_READY || searchList.get(i).getCaseStatus() == Status.SUSPECT || 
				searchList.get(i).getCaseStatus() == Status.POSITIVE) {
				this.addToList(searchList.get(i), inactiveList);
			}
		}
		return inactiveList;
	}
	//should be launched at program start, checks the positives and updates status accordingly
	
	public void updateStatus() {
		for (int i=0; i < this.companyEmployees.size(); i++) {
			companyEmployees.get(i).checkRetestReady();
		}
	}
}
