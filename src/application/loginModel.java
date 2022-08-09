package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loginModel {
	
	Connection conn;
	
	public loginModel(){
		conn = DBConnector.connect();
	}
	
	public boolean isCorrect(String username, String password) throws SQLException{
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		String query = "select * from login where username = ? and password = ?";
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, username);
			preparestatement.setString(2, password);
			resultset = preparestatement.executeQuery();
			if(resultset.next())
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			preparestatement.close();
			resultset.close();
		}
	}
	
	public String validateInput(String username, String password, String confirm_password){
		if(username.isEmpty())
			return "Username is Empty";
		if(password.isEmpty())
			return "Passward is Empty";
		System.out.println(password);
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		Pattern password_pattern = Pattern.compile(regex);
		Matcher password_matcher = password_pattern.matcher(password);
		if(!password_matcher.matches()){
			return "Password must be alpha-numeric, contains sepcial character and atleast 8 character";
		}
		if(confirm_password.isEmpty())
			return "Confirm Password is Empty";
		if(!password.equals(confirm_password))
			return "Confirm Password did not matched";
		return "success";
	}
	
	public boolean submitData(String username, String password) throws SQLException{
		PreparedStatement preparestatement = null;
		
		String query = "INSERT INTO 'login'('username', 'password') VALUES(?,?)";
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, username);
			preparestatement.setString(2, password);
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

}
