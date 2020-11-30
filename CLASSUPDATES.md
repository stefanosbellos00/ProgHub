# ProgHub
Updated and added methods to classes Employee, Company, and HealthCenter

EMPLOYEE CLASS UPDATES

-Added enum Status with values POSITIVE, NEGATIVE, SUSPECT, RETEST_READY as an Employee field
-Added Date dateOfContact field useful for checking if employee has been in contact with positive case before or after being tested
-Added Contact list methods
-Added method to check if positive case has been quarantined for 14 days and is ready to get retested

HEALTHCENTER CLASS UPDATES

-Added method to run tests and update status of all employees accordingly
-Added method to run tests on all employees and update the list accordingly
-Added method to run tests on a specific list of employees (not sure if it updates the list correctly)

COMPANY CLASS UPDATES

-Added methods to get list of employees with certain case status
-Added method to get list of employees that have pending tests
-Added method to get list of employees that are currently inactive due to the virus
-Added method to be called at the start of the program that checks the list of employees and updates the status of positive cases to RETEST_READY if 14 days have passed
