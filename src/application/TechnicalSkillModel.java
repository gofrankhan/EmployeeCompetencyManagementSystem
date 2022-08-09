package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;

public class TechnicalSkillModel {
	
	Connection conn;
	
	public TechnicalSkillModel(){
		conn = DBConnector.connect();
	}
	
	public String checkSkillValues(Skill skill){
		if(skill.getSkill_name() == null)
			return "Skill name is null";
		if(skill.getLevel() == null)
			return "Skill level is null";
		if(skill.getType() == null)
			return "Skill type is null";
		return "success";
	}
	
	ObservableList<Skill> list = FXCollections.observableArrayList();
	
	public void append_skill(Skill skill){
		list.add(skill);
	}
	
	public ResultSet getEmployee(String id) throws SQLException{
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		
		String query = "SELECT * FROM employee WHERE employee_id = ?";
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, id);
			resultset = preparestatement.executeQuery();
			return resultset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean insertSkills(String id) throws SQLException{
		PreparedStatement preparestatement = null;
		
		String query = "INSERT INTO 'skill'('employee_id', 'category', 'skill_name', 'level'"
				+ ", 'type', 'duration') VALUES(?,?,?,?,?,?)";
		try {
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				Skill skill = (Skill) itr.next();
				preparestatement = conn.prepareStatement(query);
				preparestatement.setString(1, id);
				preparestatement.setString(2, skill.getCategory());
				preparestatement.setString(3, skill.getSkill_name());
				preparestatement.setString(4, skill.getLevel());
				preparestatement.setString(5, skill.getType());
				preparestatement.setInt(6, skill.getDuration());
				int result = preparestatement.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			preparestatement.close();
		}
	}
	
	public ObservableList<EmployeeSkill> getEmployeeSkills() throws SQLException{
		PreparedStatement preparestatement = null;
		PreparedStatement preparestatementEmp = null;
		ResultSet resultSetEmp = null;
		ResultSet resultSetSkill = null;
		ObservableList<EmployeeSkill> list = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM skill";
		try {
			preparestatement = conn.prepareStatement(query);
			resultSetSkill = preparestatement.executeQuery();
			while(resultSetSkill.next()){
				String id = resultSetSkill.getString("employee_id");
				String queryEmp = "SELECT * FROM employee WHERE employee_id = ?";
				preparestatementEmp = conn.prepareStatement(queryEmp);
				preparestatementEmp.setString(1, id);
				resultSetEmp = preparestatementEmp.executeQuery();
				EmployeeSkill model = new EmployeeSkill(resultSetEmp.getString("employee_id"), resultSetEmp.getString("full_name"),
				resultSetEmp.getString("department"), resultSetEmp.getString("designation"), resultSetEmp.getString("email"),
				resultSetSkill.getString("category"),resultSetSkill.getString("skill_name"),resultSetSkill.getString("level"), resultSetSkill.getString("type"),
				resultSetSkill.getInt("duration"));
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
	
	public ObservableList<Skill> getEmployeesSkills(String id, String category) throws SQLException{
		PreparedStatement preparestatement = null;
		ResultSet resultSetSkill = null;
		ObservableList<Skill> list = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM skill where employee_id=? and category=?";
		System.out.println(id);
		try {
			preparestatement = conn.prepareStatement(query);
			preparestatement.setString(1, id);
			preparestatement.setString(2, category);
			resultSetSkill = preparestatement.executeQuery();
			while(resultSetSkill.next()){
				Skill model = new Skill(resultSetSkill.getString("skill_name"),resultSetSkill.getString("level"), resultSetSkill.getString("type"),
				resultSetSkill.getInt("duration"));
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
}
