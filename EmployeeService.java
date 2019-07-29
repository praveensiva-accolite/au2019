package com.journaldev.jaxrs.service;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.Response;

//Interface to declare the employee services available
public interface EmployeeService {

	public Response addEmployee(Employee s);
	
	public Response modifyEmployeeName(Employee s);
	
	public Response deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public Employee[] getAllEmployees();

}
