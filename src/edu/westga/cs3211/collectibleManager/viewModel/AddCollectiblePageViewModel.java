package edu.westga.cs3211.collectibleManager.viewModel;

import java.io.IOException;
import java.sql.SQLException;

import edu.westga.cs3211.collectibleManager.model.Collectible;
import edu.westga.cs3211.collectibleManager.model.CollectionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCollectiblePageViewModel {

    @FXML
    private TextField collectibleNameTextBox;

    @FXML
    private TextField conditionTextBox;

    @FXML
    private Button addCollectibleButton;
    
    public void addCollectible(ActionEvent event) throws SQLException{
    	Collectible collectible = new Collectible(this.collectibleNameTextBox.getText(), this.conditionTextBox.getText());
    	CollectionManager.addCollectible(collectible);
    	try {
			this.changeView(event);
		} catch (IOException e) {
			
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
