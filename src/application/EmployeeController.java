package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EmployeeController implements Initializable{
	
	@FXML
	private TextField full_name;
	
	@FXML
	private TextField emp_id;
	
	@FXML
	private Spinner<Integer> experience;
	
	@FXML
	private TextField phone_no;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextArea address;
	
	@FXML
	private ComboBox<String> cmb_dept;
	
	@FXML
	private ComboBox<String> cmb_design;
	
	@FXML
	private RadioButton male;
	
	@FXML
	private RadioButton female;
	
	@FXML
	private RadioButton others;
	
	@FXML
	private Button save;
	
	@FXML
	private Button btn_claer;
	
	@FXML
	private Button btn_cancel ;
	
	ObservableList<String> dept_list = FXCollections.observableArrayList("Web Developer",
			"IOS Developer", "Android Developer", "Software Testing", "Human Resource", "Finance");
	
	ObservableList<String> design_list = FXCollections.observableArrayList("Executive",
			"Engineer", "Manager", "Director", "Vice Precedent", "Staff");
	

	EmployeeModel empModel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cmb_dept.setItems(dept_list);
		cmb_design.setItems(design_list);
		experience.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1));
		
		empModel = new EmployeeModel();
	}
	
	@FXML
	public void saveData() throws SQLException{
		Employee my_employee = createEmployee();
		String result = empModel.checkAllData(my_employee);
		if(result.equals("success")){
			if(empModel.insertEmployee(my_employee)){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Data Inserted Successfully!");
				alert.show();
				clearFields();
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Data Insertion Failed!");
				alert.show();
			}
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Please check all field carefully!");
			alert.setHeaderText(result);
			alert.show();
		}
	}
	
	public Employee createEmployee(){
		Employee emp = new Employee();
		emp.setFull_name(full_name.getText());
		emp.setEmp_id(emp_id.getText());
		emp.setDepartment(cmb_dept.getValue());
		emp.setDesignation(cmb_design.getValue());
		emp.setExperience(experience.getValueFactory().getValue());
		emp.setEmail(email.getText());
		emp.setAddress(address.getText());
		emp.setPhone_no(phone_no.getText());
		String gender;
		if(male.isSelected()){
			gender = "Male";
		}else if(female.isSelected()){
			gender = "Female";
		}else{
			gender = "Others";
		}
		emp.setGender(gender);
		return emp;
	}
	
	@FXML
	public void clear(){
		clearFields();
	}
	
	@FXML
	public void cancel(){
		clearFields();
	}
	
	public void clearFields(){
		full_name.clear();
		emp_id.clear();
		cmb_dept.setValue("");
		cmb_design.setValue("");
		experience.getValueFactory().setValue(1);
		email.clear();
		phone_no.clear();
		address.clear();
	}
	
	

}
