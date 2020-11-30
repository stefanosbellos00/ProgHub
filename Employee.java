package phproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.Calendar;

public class Employee {
	public enum Status {
		POSITIVE, NEGATIVE, SUSPECT, RETEST_READY
	}
	//sets currentDate
	Date currentDate = new Date();
	//Fields
	private String employeeId;
	private String employeeName;
	private int employeeAge;
	private Stack<Test> employeeTests;
	private String employeegender;
	private String department;
	private Status caseStatus;
	private ArrayList<Employee> contactEmployees;
	/*only used when in contact with a positive case outside of department
	 we assume that date of contact is current date for employees in the same department*/
	private Date dateOfContact;
	// Constructor
	public Employee(String employeeId, String employeeName, int employeeAge, String employeegender, String department, Status caseStatus) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.setDepartment(department);
		this.setEmployeegender(employeegender);
		this.employeeTests = new Stack<Test>();
		this.setCaseStatus(caseStatus);
		this.setDateOfContact(null);
	}
	// Getters and Setters
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public Status getCaseStatus() {
		return caseStatus;
	}
	
	public void setCaseStatus(Status caseStatus) {
		this.caseStatus = caseStatus;
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
	public String getEmployeegender() {
		return employeegender;
	}
	public void setEmployeegender(String employeegender) {
		this.employeegender = employeegender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public ArrayList<Employee> getContactList() {
		return contactEmployees;
	}
	public Date getDateOfContact() {
		return dateOfContact;
	}
	public void setDateOfContact(Date dateOfContact) {
		this.dateOfContact = dateOfContact;
	}
	// Contact list methods
	 //Adds to contact list everyone who was on the same department
	public void contactList (Company company) {
		String key = this.getDepartment();
		ArrayList<Employee> searchList = company.getCompanyEmployees();
		int size = searchList.size();
		for (int i = 0; i < size; i++) {
			if (searchList.get(i).getDepartment() == key) {
				searchList.get(i).setDateOfContact(currentDate);
				this.addToList(searchList.get(i), contactEmployees);
			}
		}
		
	}
	//Adds additional contacts
	public void addMoreContacts(Employee addContact, Date dateOfContact) {
		addContact.setDateOfContact(dateOfContact);
		contactEmployees.add(addContact);
	}
	
	// Adds employee to selected list
	public void addToList(Employee employee, ArrayList<Employee> list) {
		list.add(employee);
	}
	//checks if positive case has quarantined for more than 14 days and updates status accordingly
	public void checkRetestReady() {
		if (this.caseStatus == Status.POSITIVE) {
			Stack <Test> updateStatus = this.getEmployeeTests();
			Test mostRecent = updateStatus.pop();
			Date dateOfTest = mostRecent.getTestDate();
			Calendar c = Calendar.getInstance();
			c.setTime(dateOfTest);
			c.add(Calendar.DATE, 14);
	    	Date dateOfTestPlusFourteenDays = c.getTime();
			if (dateOfTestPlusFourteenDays.before(currentDate)) {
				this.setCaseStatus(Status.RETEST_READY);
			}
		}
	}
	
	
}
