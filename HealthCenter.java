package phproject;

import java.util.Date;
import java.util.Stack;

import phproject.Employee.Status;

import java.util.ArrayList;

public class HealthCenter {
	//Fields
	private String centerName;
	Date currentDate = new Date();
	//The company that the user has access to
	private Company loggedInCompany;
		
	//Constructor
	public HealthCenter (String name, Company loggedInCompany) {
		setCenterName(name);
		this.loggedInCompany = loggedInCompany;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	 //The testing method we use in each case, with the option to get a contact list
	//Test Id was set like this for testing purposes, ideally we'll have an id generator method
	 public void employeeTest(Employee employee, boolean isPositive, Date testDate) {
		Test newTest = new Test(employee.getEmployeeId()+"1", testDate, isPositive);
		employee.addTest(newTest);
		Status status = employee.getCaseStatus();
		ArrayList<Employee> contactList = employee.getContactList();
		ArrayList<Employee> updatedList = loggedInCompany.getCompanyEmployees();
		switch (status) {
		case NEGATIVE : 
			if (isPositive) {
				employee.setCaseStatus(Status.POSITIVE);
				employee.contactList(loggedInCompany);
				/* Here we'll have an option for additional contacts using the addContacts 
				 * method from the Employee class, for contacts with employees from other departments
				 */
				//Checks for every employee if he is in the contact list and updates their status
				for (int i = 0; i < updatedList.size(); i++) {
					Employee key = 	updatedList.get(i);
					for (int j = 0; j < contactList.size(); j++) {
						if (contactList.get(j) == key) {
							//Making sure we don't update positives back to suspect
							if (updatedList.get(i).getCaseStatus() == Status.NEGATIVE) {
									updatedList.get(i).setCaseStatus(Status.SUSPECT);
							}	
						}
					}
				}
				loggedInCompany.updateList(updatedList);
				} 
			break;
		case SUSPECT :
			if (isPositive) {
				employee.setCaseStatus(Status.POSITIVE);
				employee.contactList(loggedInCompany);
				/* Here we'll have an option for additional contacts using the addContacts 
				 * method from the Employee class, for contacts with employees from other departments
				 */
				//Checks for every employee if he is in the contact list and updates their status
				for (int i = 0; i < updatedList.size(); i++) {
					Employee key = 	updatedList.get(i);
					for (int j = 0; j < contactList.size(); j++) {
						if (contactList.get(j) == key) {
							/*Making sure we don't update positives back to suspect and person hasn't
							 already been tested after the day of contact with the positive*/
							Stack<Test> check = updatedList.get(i).getEmployeeTests();
							Test recentTest = (Test) check.pop();
							if (updatedList.get(i).getCaseStatus() == Status.NEGATIVE && 
									recentTest.getTestDate().before(updatedList.get(i).getDateOfContact()) ){
									updatedList.get(i).setCaseStatus(Status.SUSPECT);
							}	
						}
					}
				}
				loggedInCompany.updateList(updatedList);
			}else {
				// turning suspect back to negatives
				employee.setCaseStatus(Status.NEGATIVE);
				loggedInCompany.updateList(updatedList);
			}
			break;
		case RETEST_READY : 
			//We don't need contact list as they were in quarantine 
			if (isPositive) {
			employee.setCaseStatus(Status.POSITIVE);
			} else {employee.setCaseStatus(Status.NEGATIVE);
			loggedInCompany.updateList(updatedList);
			} break;
		case POSITIVE : 
			//Making sure we don't mess with the already positive cases
			break;
		}	
		}
	 public void multipleEmployeesTest(ArrayList<Employee> employees) {
			//For testing all employees in a certain list (i.e. suspect)
		 	//I'm not sure if original list gets updated
				for (int i =0; i<employees.size(); i++) {
					//For testing purposes, isPositive is set to true. Ideally we'll use the probability method
					boolean isPositive = true;
					this.employeeTest(employees.get(i), isPositive, currentDate);
			}
		}
	public void allEmployeesTest() {
	//We don't need a contact list since we test everyone
		ArrayList<Employee> updatedList = loggedInCompany.getCompanyEmployees();
		for (int i =0; i<updatedList.size(); i++) {
			//For testing purposes, isPositive is set to true. Ideally we'll use the probability method
			boolean isPositive = true;
			if (isPositive) {
				updatedList.get(i).setCaseStatus(Status.POSITIVE);
			} else {updatedList.get(i).setCaseStatus(Status.NEGATIVE);
			}
		}
		loggedInCompany.updateList(updatedList);
	}
}
