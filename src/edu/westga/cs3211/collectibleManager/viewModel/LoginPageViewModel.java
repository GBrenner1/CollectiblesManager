package edu.westga.cs3211.collectibleManager.viewModel;

import java.io.IOException;
import java.sql.SQLException;

import edu.westga.cs3211.collectibleManager.model.CollectionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * the viewmodel for the login page
 */
public class LoginPageViewModel {

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;
    
    @FXML
    private Text errorMessageText;

    @FXML
    private Button loginButton;

    public void checkUserPassMatch(ActionEvent event) throws IOException , SQLException {
    	if (CollectionManager.authorize(this.userNameTextField.getText(), this.passwordTextField.getText())) {
    		this.changeView(event);
    	} else {
    		this.errorMessageText.setVisible(true);
    	}
    }
    
    private void changeView(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("../view/CollectionViewPage.fxml"));
    	Scene scene = new Scene(parent);
    	
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    	
    	stage.show();
    }
}