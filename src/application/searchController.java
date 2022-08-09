package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class searchController {
	
	@FXML
	private TextField text_search;
	
	@FXML
	private Button btn_search;
	
	@FXML
	private Label lbl_emp_id;
	
	@FXML
	private Label lbl_emp_name;
	
	@FXML
	private Label lbl_emp_dept;
	
	@FXML
	private Label lbl_emp_design;
	
	@FXML
	private Label lbl_emp_email;
	
	@FXML
	private Label lbl_emp_phone;
	
	@FXML
	private TableView<Skill> tbl_tech_view;
	
	@FXML
	private TableView<Skill> tbl_non_tech_view;
	
	@FXML
	private TableColumn<Skill, String> col_tech_name;
	
	@FXML
	private TableColumn<Skill, String> col_tech_level;
	
	@FXML
	private TableColumn<Skill, String> col_tech_type;
	
	@FXML
	private TableColumn<Skill, Integer> col_tech_duration;
	
	@FXML
	private TableColumn<Skill, String> col_non_tech_name;
	
	@FXML
	private TableColumn<Skill, String> col_non_tech_level;
	
	@FXML
	private TableColumn<Skill, String> col_non_tech_type;
	
	@FXML
	private TableColumn<Skill, Integer> col_non_tech_duration;
	
	EmployeeModel empModel;
	TechnicalSkillModel skill_model;
	
	@FXML
	public void searchEmployee() throws SQLException{
		empModel = new EmployeeModel();
		String id = text_search.getText();
		lbl_emp_id.setText(id);
		Employee emp = empModel.getEmployee(id);
		if(emp != null){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Successfully Found!");
			alert.show();
			lbl_emp_name.setText(emp.getFull_name());
			lbl_emp_id.setText(emp.getEmp_id());
			lbl_emp_dept.setText(emp.getDepartment());
			lbl_emp_design.setText(emp.getDesignation());
			lbl_emp_email.setText(emp.getEmail());
			lbl_emp_phone.setText(emp.getPhone_no());
			
			skill_model = new TechnicalSkillModel();
			
			col_tech_name.setCellValueFactory(new PropertyValueFactory<Skill, String>("skill_name"));
			col_tech_level.setCellValueFactory(new PropertyValueFactory<Skill, String>("level"));
			col_tech_type.setCellValueFactory(new PropertyValueFactory<Skill, String>("type"));
			col_tech_duration.setCellValueFactory(new PropertyValueFactory<Skill, Integer>("duration"));
			try {
				tbl_tech_view.setItems(skill_model.getEmployeesSkills(id, "Technical"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			col_non_tech_name.setCellValueFactory(new PropertyValueFactory<Skill, String>("skill_name"));
			col_non_tech_level.setCellValueFactory(new PropertyValueFactory<Skill, String>("level"));
			col_non_tech_type.setCellValueFactory(new PropertyValueFactory<Skill, String>("type"));
			col_non_tech_duration.setCellValueFactory(new PropertyValueFactory<Skill, Integer>("duration"));
			try {
				tbl_non_tech_view.setItems(skill_model.getEmployeesSkills(id, "Non-Technical"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Employee Id not found!");
			alert.show();
			text_search.clear();
			lbl_emp_name.setText("");
			lbl_emp_id.setText("");
			lbl_emp_dept.setText("");
			lbl_emp_design.setText("");
			lbl_emp_email.setText("");
			lbl_emp_phone.setText("");
			tbl_tech_view.getItems().clear();
			tbl_non_tech_view.getItems().clear();
		}
		
	}
	

}
