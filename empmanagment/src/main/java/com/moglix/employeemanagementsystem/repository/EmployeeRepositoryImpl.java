package com.moglix.employeemanagementsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.moglix.employeemanagementsystem.dto.Employee;
import com.moglix.employeemanagementsystem.utils.DButils;

@Component
@Service
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	DButils dbutils;

	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into Employee(empID,empFirstName,empLastNAme,empSalary,empAddress,empPan,empAadhar)"
				+ " values(?,?,?,?,?,?,?)";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmpID());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setDouble(4, employee.getEmpSalary());
			preparedStatement.setString(5, employee.getEmpAddress());
			preparedStatement.setString(6, employee.getEmpPan());
			preparedStatement.setString(7, employee.getEmpAadhar());

			//preparedStatement.executeUpdate();
			// execute : DDL : bolean
			// executeUpdate : DML : int : no of affected rows
			// executeQuery : DQL : ResultSet : will hold records & will help us to
			// travaerse the records.

			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				return "Table updated";
			} else {
				return "update failed";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			dbutils.closeConnection(connection);
		}
		return null;

	}

	public String updateEmployee(String id, Employee employee) {
		
		Connection connection = this.dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update Employee set empFirstName = ? "
				             + ",empLastName = ? ,empSalary = ?"
				                   + " ,empAddress = ? where empID =?"; 
		try {
			preparedStatement = connection.prepareStatement(sql);
            
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				return "Employee Updated";
			} else {
				return "Table updation Failed";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			dbutils.closeConnection(connection);
		}
		return null;

	}

	public Employee getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteEmployeeById(String id){
		
		Connection connection = this.dbutils.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "Delete from Employee where empID =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
            
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				return "Table Be Like: deleted empID";
			} else {
				return "Table content delete failed";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			dbutils.closeConnection(connection);
		}
		return null;


			
			
		
	}

	public void deleteAllEmployees() {
		
		Connection connection = this.dbutils.getConnection();
		String sql = "Delete TABLE Emplyoee;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		if (preparedStatement.executeUpdate() > 0)
		{System.out.println("Table Be Like : khtam tata bye deleted");}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbutils.closeConnection(connection);
		}



	}

}

