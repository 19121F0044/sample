package com.kumaran.service;

import com.kumaran.model.Employee;
import java.util.*;

public interface EmployeeService 
{
	public void save(Employee employee);
	public List<Employee> getAll();

}
