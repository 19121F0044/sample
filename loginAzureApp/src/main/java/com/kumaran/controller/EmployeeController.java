package com.kumaran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kumaran.model.Employee;
import com.kumaran.model.Login;
import com.kumaran.service.EmployeeService;
import java.util.*;


@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	
	@RequestMapping("/register")
	public String register(Model model, Employee employee)
	{
		model.addAttribute("emp", employee);
		return "RegisterPage";
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		
		
			//System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getUsername()+" "+employee.getPassword());
		
		es.save(employee);
		return "index";
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(Model model, Login login)
	{
		model.addAttribute("login", login);
		return "LoginPage";
	}
	
	@GetMapping("/loginCheck")
	public String loginCheck(@ModelAttribute("login") Login login)
	{
		//System.out.println(login.getUsername()+" "+login.getPassword());
		List<Employee> emp=es.getAll();
		for(Employee e:emp)
		{
			if(login.getUsername().equals(e.getUsername()) && login.getPassword().equals(e.getPassword()))
			{
				System.out.println(login.getUsername() +" "+e.getUsername());
				System.out.println("Executed success");
				return "welcome";
			}
			/*else
			{
				System.out.println("executed else");
				System.out.println(login.getUsername() +" "+e.getUsername());
				return "LoginPage";
			}*/
		}
		System.out.println("Executed overall");
		return "LoginPage";
		
	}
	
	

}
