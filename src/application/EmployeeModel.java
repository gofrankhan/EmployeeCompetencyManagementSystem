package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeModel {
	
	Connection conn;
	
	public EmployeeModel(){
		conn = DBConnector.connect();
	}
	
	public String checkAllData(Employee emp){
		if(emp.getFull_name().isEmpty())
			return "Full name is empty.";
		if(emp.getEmp_id().isEmpty())
			return "Employee Id is empty.";
		if(emp.getDepartment()== null)
			return "Department is empty.";
		if(emp.getDesignation() == null)
			return "Designation is empty.";
		if(emp.getEmail().isEmpty())
			return "Email is empty.";
		if(emp.getAddress().isEmpty())
			return "Address is empty.";
		if(emp.getPhone_no().isEmpty())
			return "Phone No is empty.";
		if(emp.getPhone_no().length() != 11)
			return "Phone No must me 11 digits!";
		Pattern p = Pattern.compile("[0]{1}[0-9]{10}");
		Matcher m = p.matcher(emp.getPhone_no());
		if(!m.find())
			return "Invalid Phone No.";
		
		Pattern email_pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher email_matcher = email_pattern.matcher(emp.getEmail());
		if(!email_matcher.matches()){
			return "Invalid Email Address!";
		}
		
		return "success";
	}
	
	public boolean insertEmployee(Employee emp) throws SQLException{
		PreparedStatement preparestatement = null;
		
		String query = "INSERT INTO 'employee'('employee_id', 'full_name', 'department', 'designation'"
				+ ", 'experience', 'email', 'phone_no', 'address', 'gender') VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, emp.getEmp_id());
			preparestatement.setString(2, emp.getFull_name());
			preparestatement.setString(3, emp.getDepartment());
			preparestatement.setString(4, emp.getDesignation());
			preparestatement.setInt(5, emp.getExperience());
			preparestatement.setString(6, emp.getEmail());
			preparestatement.setString(7, emp.getPhone_no());
			preparestatement.setString(8, emp.getAddress());
			preparestatement.setString(9, emp.getGender());
			int result = preparestatement.executeUpdate();
			System.out.println(result);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			preparestatement.close();
		}
	}
	
	public ObservableList<Employee> getEmployees() throws SQLException{
		PreparedStatement preparestatement = null;
		ResultSet resultSet = null;
		ObservableList<Employee> list = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM employee";
		try {
			preparestatement = conn.prepareStatement(query);
			resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				Employee model = new Employee(resultSet.getString("full_name"), resultSet.getString("employee_id"),
						resultSet.getString("department"), resultSet.getString("designation"), resultSet.getInt("experience"),
						resultSet.getString("phone_no"),resultSet.getString("email"), resultSet.getString("address"),
						resultSet.getString("gender"));
				list.add(model);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}finally{
			preparestatement.close();
		}
	}
	
	public Employee getEmployee(String id) throws SQLException{
		PreparedStatement preparestatement = null;
		ResultSet resultSet = null;
		Employee model = null;
		String query = "SELECT * FROM employee where employee_id=?";
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, id);
			resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				 model = new Employee(resultSet.getString("full_name"), resultSet.getString("employee_id"),
						resultSet.getString("department"), resultSet.getString("designation"), resultSet.getInt("experience"),
						resultSet.getString("phone_no"),resultSet.getString("email"), resultSet.getString("address"),
						resultSet.getString("gender"));
				break;
			}
			return model;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			preparestatement.close();
		}
	}
}
