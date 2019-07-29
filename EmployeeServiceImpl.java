
package com.journaldev.jaxrs.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//imports rest service operations that have been made available by using dependency
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.Response;
//Setting the path to access
@Path("/Employe")
//used to mention that the output and input 
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Integer,Employee> Employees = new HashMap<Integer,Employee>();
	

	//fetches a employee by using id
	@Override
	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		return Employees.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee p = new Employee();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	//fetches all employee
	@Override
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		Set<Integer> ids = Employees.keySet();
		Employee[] e = new Employee[ids.size()];
		int i=0;
		for(Integer id : ids){
			e[i] = Employees.get(id);
			i++;
		}
		return e;
	}
	
	//adds a new employee
		@Override
		@POST
	    @Path("/add")
		public Response addEmployee(Employee s) {
			Response response = new Response();
			if(Employees.get(s.getId()) != null){
				response.setStatus(false);
				response.setMessage("Employee Exists");
				return response;
			}
			Employees.put(s.getId(), s);
			response.setStatus(true);
			response.setMessage("Employee created successfully");
			return response;
		}
	//modifies a employee name
	@Override
	@PUT
    @Path("/modifyName")
	public Response modifyEmployeeName(Employee s) {
		Response response = new Response();
		if(Employees.get(s.getId()) == null){
			response.setStatus(false);
			response.setMessage("Employee Does not Exists");
			return response;
		}
		Employee e=Employees.get(s.getId());
		e.setName(s.getName());
		response.setStatus(true);
		response.setMessage("Employee modified successfully");
		return response;
	}
	//deletes a employee by using id
		@Override
		@DELETE
	    @Path("/{id}/delete")
		public Response deleteEmployee(@PathParam("id") int id) {
			Response response = new Response();
			if(Employees.get(id) == null){
				response.setStatus(false);
				response.setMessage("Employee Doesn't Exists");
				return response;
			}
			Employees.remove(id);
			response.setStatus(true);
			response.setMessage("Employee deleted successfully");
			return response;
		}

	

}
