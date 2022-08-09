package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeViewController implements Initializable{

	@FXML
	private TableView<Employee> tableView;
	@FXML
	private TableColumn<Employee, String> col_sl;
	@FXML
	private TableColumn<Employee, String> col_id;
	@FXML
	private TableColumn<Employee, String> col_full_name;
	@FXML
	private TableColumn<Employee, String> col_dept;
	@FXML
	private TableColumn<Employee, String> col_design;
	@FXML
	private TableColumn<Employee, Integer> col_experience;
	@FXML
	private TableColumn<Employee, String> col_email;
	@FXML
	private TableColumn<Employee, String> col_phone;
	@FXML
	private TableColumn<Employee, String> col_address;
	
	EmployeeModel emp_model;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		emp_model = new EmployeeModel();
		col_id.setCellValueFactory(new PropertyValueFactory<Employee, String>("emp_id"));
		col_full_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("full_name"));
		col_dept.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));
		col_design.setCellValueFactory(new PropertyValueFactory<Employee, String>("designation"));
		col_experience.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("experience"));
		col_email.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		col_phone.setCellValueFactory(new PropertyValueFactory<Employee, String>("phone_no"));
		col_address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
		try {
			tableView.setItems(emp_model.getEmployees());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
