package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainController implements Initializable{
	
	@FXML
	private Button btn_addEmp;
	
	@FXML
	private Button btn_viewEmp;
	
	@FXML
	private Button btn_add_tech_skill;
	
	@FXML
	private Button btn_add_non_tech_skill;
	
	@FXML
	private Button btn_view_tech_skill;
	
	@FXML
	private Button btn_view_non_tech_skill;
	
	@FXML
	private Button btn_search;
	
	@FXML
	private Button btn_filter;
	
	@FXML
	private Button btn_settings;
	
	@FXML
	private Button btn_user;
	
	@FXML
	private ScrollPane scroll_pane;
	
	public void setScrollPane() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/add_employee.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void add_employee(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/add_employee.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void add_tech_skill(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/add_tech_skill.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void add_non_tech_skill(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/add_non_tech_skill.fxml"));
		scroll_pane.setContent(root);
	}
	

	@FXML
	public void view_tech_skill(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/view_tech_skill.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void view_non_tech_skill(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/view_non_tech_skill.fxml"));
		scroll_pane.setContent(root);
	}
	

	@FXML
	public void view_employee(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/view_employee.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void filter(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/filter.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void search(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/search.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void settings(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/settings.fxml"));
		scroll_pane.setContent(root);
	}
	
	@FXML
	public void user(MouseEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/application/user.fxml"));
		scroll_pane.setContent(root);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/add_employee.fxml"));
			scroll_pane.setContent(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
