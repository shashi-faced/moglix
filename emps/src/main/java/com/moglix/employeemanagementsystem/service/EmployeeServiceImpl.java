package com.moglix.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.repository.EmployeeRepository;
//@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository; 
	
	public Employee addEmployee(Employee employee) {
		// service is consuming dao method
		    Employee employee2 =  employeeRepository.save(employee);
		    
		    if(employee2!= null) {
		    	return employee2;
		    }
		    else {
		    	return null;
		    }
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		if(getEmployeeById(id)!= null) {
			return addEmployee(employee);
		}
		else {
			return null;
			}
	}

	@Override
	public Employee getEmployeeById(String id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		try{
			employeeRepository.deleteById(id);
		return "Sucess this id "+id+" Row deleted" ;
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Exception Occur";
		}
	}
	

	@Override
	public String deleteAllEmployees() {
		try {
			employeeRepository.deleteAll();
			return "Delete all Sucessful";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	
}
