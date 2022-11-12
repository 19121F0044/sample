package com.kumaran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumaran.model.Employee;
import com.kumaran.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService  {

	@Autowired
	EmployeeRepository er;

	@Override
	public void save(Employee employee) {
		er.save(employee);
		
	}

	@Override
	public List<Employee> getAll() {
		
		return er.findAll();
	}

	
	
	
	

	
}
