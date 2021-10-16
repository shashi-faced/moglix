package com.moglix.employeemanagementsystem.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity is a JPA annotation to make this object ready for storage in a JPA-based data store

@Entity   //(ORM Maping)  
@Table(name = "emplTable")

public class Employee implements Comparable<Employee>{
	
	@Id
	@Column(name = "employee_ID")   //existing column name change kar rha hai [ empID --> employee_ID ]
	private String empID;
	
	@Column(name = "empfirstName")
	private String empFirstName;
	
	@Column(name = "emplastName")
	private String empLastName;
	
//Isme column name change nahi  krna hai so Column use nahi Use kiya.	
	private double empSalary;
	
	private String empAddress;
	
	//
	private String empPan;
	
	private String empAadhar;
	
	
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empSalary=" + empSalary + ", empAddress=" + empAddress + ", empPan=" + empPan + ", empAadhar="
				+ empAadhar + "]";
	}


	
	public int hashCode() {
		return Objects.hash(empAadhar, empAddress, empFirstName, empID, empLastName, empPan, empSalary);
	}


	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empAadhar, other.empAadhar) && Objects.equals(empAddress, other.empAddress)
				&& Objects.equals(empFirstName, other.empFirstName) && Objects.equals(empID, other.empID)
				&& Objects.equals(empLastName, other.empLastName) && Objects.equals(empPan, other.empPan)
				&& Double.doubleToLongBits(empSalary) == Double.doubleToLongBits(other.empSalary);
	}

public Employee() {
	// TODO Auto-generated constructor stub
}
	
	
	
	public Employee(String empID, String empFirstName, String empLastName, double empSalary, String empAddress,
			String empPan, String empAadhar) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empSalary = empSalary;
		this.empAddress = empAddress;
		this.empPan = empPan;
		this.empAadhar = empAadhar;
		this.empAadhar = empAadhar;
	}


//	public Employee() {
//		// TODO Auto-generated constructor stub
//		System.out.println("inside the employee constructor");
//	}
	
	
	public String getEmpPan() {
		return empPan;
	}
	public void setEmpPan(String empPan) {
		this.empPan = empPan;
	}
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	public String getEmpAadhar() {
		return empAadhar;
	}


	public void setEmpAadhar(String empAadhar) {
		this.empAadhar = empAadhar;
	}
	
	public double calSalary() {
		double gsalary=getEmpSalary();
		double ta=(10*gsalary)/100;
		double da=(10*gsalary)/100;
		double hra=(10*gsalary)/100;
		double netsalary=hra+da+ta+gsalary;
		return netsalary;
		
	}


	
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empID.compareTo(o.empID);
	}
}
