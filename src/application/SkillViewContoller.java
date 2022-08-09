package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SkillViewContoller implements Initializable{

	@FXML
	private TableView<EmployeeSkill> tableView;
	@FXML
	private TableColumn<EmployeeSkill, String> col_sl;
	@FXML
	private TableColumn<EmployeeSkill, String> col_id;
	@FXML
	private TableColumn<EmployeeSkill, String> col_full_name;
	@FXML
	private TableColumn<EmployeeSkill, String> col_dept;
	@FXML
	private TableColumn<EmployeeSkill, String> col_design;
	@FXML
	private TableColumn<EmployeeSkill, String> col_email;
	@FXML
	private TableColumn<EmployeeSkill, Integer> col_duration;
	@FXML
	private TableColumn<EmployeeSkill, String> col_skill_name;
	@FXML
	private TableColumn<EmployeeSkill, String> col_level;
	@FXML
	private TableColumn<EmployeeSkill, String> col_type;
	
	TechnicalSkillModel skill_model;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
		skill_model = new TechnicalSkillModel();
		col_id.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("emp_id"));
		col_full_name.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("full_name"));
		col_dept.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("department"));
		col_design.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("designation"));
		col_duration.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, Integer>("duration"));
		col_email.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("email"));
		col_skill_name.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("skill_name"));
		col_level.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("level"));
		col_type.setCellValueFactory(new PropertyValueFactory<EmployeeSkill, String>("type"));
		try {
			tableView.setItems(skill_model.getEmployeeSkills());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
