package com.moglix.employeemanagementsystem;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.moglix.employeemanagementsystem.config.config;
import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.service.EmployeeService;

public class Main1 {
//@Autowired						
//EmployeeService employeeService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext();
		
		
		AnnotationConfigApplicationContext  aplicationContext = new AnnotationConfigApplicationContext(config.class);
        
		DataSource dataSource = aplicationContext.getBean(DataSource.class);
        
		System.out.println(dataSource!= null);
		
        
		EmployeeService employeeService = aplicationContext.getBean(EmployeeService.class);
		String result = employeeService
				.addEmployee(new Employee("206", "Shashi", "kumar", 0.0f, "adalpura", "AUPwap", "Aadhar"));
		System.out.println(result);
		System.out.println("result true hai --> Aadhar");
		
	}

}
