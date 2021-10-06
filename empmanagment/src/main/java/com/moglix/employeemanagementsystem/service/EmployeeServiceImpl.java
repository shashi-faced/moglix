package com.moglix.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.repository.EmployeeRepository;
//@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository; 
	
//	private  EmployeeServiceImpl() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	private static EmployeeService employeeService;
//	
//	public static EmployeeService getInstance() {
//		if(employeeService==null) {
//			employeeService=new EmployeeServiceImpl();
//			return employeeService;
//			}
//		else {
//			return employeeService;
//		}
//	}

	
	public String addEmployee(Employee employee) {
		// service is consuming dao method
				return employeeRepository.addEmployee(employee);
	}

	
	public String updateEmployee(String id, Employee employee) {
		return employeeRepository.updateEmployee(id, employee);
	}

	
	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
		
	}

	
	public List<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}

	
	public String deleteEmployeeById(String id) {
		return employeeRepository.deleteEmployeeById(id);
	}

	
	public void deleteAllEmployees() {
		employeeRepository.deleteAllEmployees();

	}

}
