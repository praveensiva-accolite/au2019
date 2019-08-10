package com.accolite.dao;

import org.springframework.data.repository.CrudRepository;

import com.accolite.model.Employee;

public interface EmployeDao extends CrudRepository<Employee, Integer>
{
     
}
