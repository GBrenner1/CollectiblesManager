package edu.westga.cs3211.collectibleManager.viewModel;
import java.io.IOException;
import java.sql.SQLException;

import edu.westga.cs3211.collectibleManager.model.Collectible;
import edu.westga.cs3211.collectibleManager.model.Collection;
import edu.westga.cs3211.collectibleManager.model.CollectionManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/*
 * the viewmodel for the Collection view page
 */
public class CollectionViewPageViewModel {

    @FXML
    private ListView<Collectible> collectionListView;

    @FXML
    private Button addCollectibleButton;

    public void initialize() throws SQLException {
    	if(this.collectionListView.getItems().size() != 0) {
    		this.collectionListView.getItems().clear();
    	}
    	
    	this.collectionListView.setItems(FXCollections.observableArrayList(CollectionManager.getCollection().getCollection()));
    }   
    
    public void changeView(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("../view/AddCollectiblePage.fxml"));
    	Scene scene = new Scene(parent);
    	
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.setScene(scene);
    	
    	stage.show();
    }
}