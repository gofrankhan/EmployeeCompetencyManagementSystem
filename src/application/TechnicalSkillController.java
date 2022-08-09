package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TechnicalSkillController implements Initializable{
	
	@FXML
	private TextField employee_id;
	@FXML
	private TextField full_name;
	@FXML
	private TextField department;
	@FXML
	private TextField designation;
	@FXML
	private TextField email;
	@FXML
	private ComboBox<String> skill_name;
	@FXML
	private ComboBox<String> skill_level;
	@FXML
	private ComboBox<String> skill_type;
	@FXML
	private CheckBox tech_skill;
	@FXML
	private CheckBox non_tech_skill;
	@FXML
	private Spinner<Integer> duration;
	@FXML
	private TableView<Skill> tableView;
	@FXML
	private TableColumn<Skill, String> col_skill_name;
	@FXML
	private TableColumn<Skill, String> col_level;
	@FXML
	private TableColumn<Skill, String> col_type;
	@FXML
	private TableColumn<Skill, String> col_duration;
	@FXML
	private Button search;
	@FXML
	private Button add;
	@FXML
	private Button save;
	
	private String id;
	
	ObservableList<String> skill_name_list = FXCollections.observableArrayList("C/C++", "Java", "Python",
			"PHP", "HTML", "SQA", "Android", "IOS");
	
	ObservableList<String> non_tech_list = FXCollections.observableArrayList("Leadership", "Management",
			"Accounting", "Customer Relationship", "Banking");
	
	ObservableList<String> skill_level_list = FXCollections.observableArrayList("Beginer",
			"Advance", "Professional", "Expart");
	
	ObservableList<String> skill_type_list = FXCollections.observableArrayList("Project",
			"Course", "Training");

	TechnicalSkillModel techModel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(tech_skill.isSelected()){
			skill_name.setItems(skill_name_list);
			non_tech_skill.setSelected(false);
		}
		else if(non_tech_skill.isSelected()){
			skill_name.setItems(non_tech_list);
			tech_skill.setSelected(false);
		}
		skill_level.setItems(skill_level_list);
		skill_type.setItems(skill_type_list);
		duration.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
		techModel = new TechnicalSkillModel();
	}
	
	@FXML
	public void add_skill(){
		Skill skill = new Skill(skill_name.getValue(), skill_level.getValue(),skill_type.getValue(), duration.getValue());
		if(tech_skill.isSelected())
			skill.setCategory("Technical");
		else if(non_tech_skill.isSelected())
			skill.setCategory("Non-Technical");
		String result = techModel.checkSkillValues(skill);
		if(result.equals("success")){
			techModel.append_skill(skill);
			add_list();
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Please check all field carefully!");
			alert.setHeaderText(result);
			alert.show();
		}
	}
	
	public void add_list(){
		col_skill_name.setCellValueFactory(new PropertyValueFactory<Skill, String>("skill_name"));
		col_level.setCellValueFactory(new PropertyValueFactory<Skill, String>("skill_level"));
		col_type.setCellValueFactory(new PropertyValueFactory<Skill, String>("skill_type"));
		col_duration.setCellValueFactory(new PropertyValueFactory<Skill, String>("duration"));
		tableView.setItems(techModel.list);
		}
	
	@FXML
	public void search() throws SQLException{
		id = employee_id.getText();
		ResultSet resultset = techModel.getEmployee(id);
		if(!resultset.next()){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("No Employee found!");
			alert.show();
			employee_id.clear();
		}else{
			employee_id.setText(resultset.getString("employee_id"));
			full_name.setText(resultset.getString("full_name"));
			department.setText(resultset.getString("department"));
			designation.setText(resultset.getString("designation"));
			email.setText(resultset.getString("email"));
		}
	}
	
	@FXML
	public void select_tech_skill(){
		if(tech_skill.isSelected()){
			skill_name.setItems(skill_name_list);
			non_tech_skill.setSelected(false);
		}
	}
	
	@FXML
	public void select_non_tech_skill(){
		if(non_tech_skill.isSelected()){
			skill_name.setItems(non_tech_list);
			tech_skill.setSelected(false);
		}
	}
	
	@FXML
	public void insert_skill() throws SQLException{
		if(techModel.insertSkills(id)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Data Inserted Successfully!");
			alert.show();
			clearFields();
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Data Insertion Failed!");
			alert.show();
		}
	}


	private void clearFields() {
		// TODO Auto-generated method stub
		employee_id.clear();
		full_name.clear();
		department.clear();
		designation.clear();
		email.clear();
		tableView.getItems().clear();
	}
}
