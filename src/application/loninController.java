package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loninController implements Initializable {
	@FXML
	private Label lbl_status;
	
	@FXML
	private Button btn_login;
	
	@FXML
	private TextField input_username;
	
	@FXML
	private PasswordField input_password;
	
	@FXML
	private TextField username;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private PasswordField confirm_password;
	
	@FXML
	private Button btn_add;
	
	@FXML
	private Button btn_cancel;
	
	loginModel model;
	MainController mainC;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		model = new loginModel();
		mainC = new MainController();
	}
	
	public void login(ActionEvent event) throws IOException, SQLException{
		if(model.isCorrect(input_username.getText(), input_password.getText())){
			lbl_status.setText("Success");
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Employee Competency");
			primaryStage.show();
			((Node)event.getSource()).getScene().getWindow().hide();
		}else lbl_status.setText("Failed");
	}
	
	@FXML
	public void add_user(ActionEvent event) throws SQLException{
		String result = model.validateInput(username.getText(), password.getText(), confirm_password.getText());
		if(result.equals("success")){
			if(model.submitData(username.getText(), password.getText())){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Data Inserted Successfully!");
				alert.show();
				clearFields();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Data Insertion Failed!");
				alert.show();
				clearFields();
			}
		}else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("No empty field allowed, and confirm password must match with password");
			alert.setHeaderText(result);
			alert.show();
			clearFields();
		}
	}
	
	@FXML
	public void cancel_user(ActionEvent event){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Are you sure?");
		alert.setContentText("Press OK to reset input fields ");
		alert.showAndWait().ifPresent((btnType) -> {
			  if (btnType == ButtonType.OK) {
				  clearFields();
			  } else if (btnType == ButtonType.CANCEL) {
			    
			  }
		});
	}
	
	public void clearFields(){
		username.clear();
		password.clear();
		confirm_password.clear();
	}
	
}
