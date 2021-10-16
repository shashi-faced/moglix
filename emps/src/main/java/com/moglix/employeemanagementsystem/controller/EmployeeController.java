package com.moglix.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/api")

public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/hello") 
	public String sayHello() {
		return "hello shashi :) ";
		
	}
    @PostMapping("/add")// Api ko data dene ke liye--[ Json to Java Object by @requestBody
	public Employee addEmployee(@RequestBody Employee employee) {
    	return employeeService.addEmployee(employee);
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
    	return this.employeeService.getEmployeeById(id);
    	}
    
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id) {
		return this.employeeService.deleteEmployeeById(id);
    	
    }
    
    @DeleteMapping("employee/deleteAll")
    public String deleteAllEmployee() {
    	return this.employeeService.deleteAllEmployees();
    }
  @GetMapping("/employee/getAllEmployee")
  public List<Employee> getAllEmployee() {
	  return this.employeeService.getEmployees();
  }
}

