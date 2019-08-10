package com.accolite.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dao.EmployeDao;
import com.accolite.model.Employee;

import lombok.Value;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Value("${a}")
	private int a;
	@Autowired
   private EmployeDao dao;
	
	@PropertyMapping("/add")
     public String AddEmployee(ArrayList <Employee> list1)
    {
	    dao.saveAll(list1);
	    return "employees added"+list1.size();
    }
      
	@GetMapping("/get")
      public ArrayList<Employee> getEmployee()
      {
    	  return (ArrayList<Employee>) dao.findAll();
      }

}
