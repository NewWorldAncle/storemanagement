package controll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class HomeControl implements Initializable{

    @FXML
    private BorderPane bp;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnMembership;
    @FXML
    private Button btnManagement;
    @FXML
    private AnchorPane ap;

    
    @FXML
    void home(ActionEvent event) {
    	bp.setCenter(ap);
    }

    @FXML
    void management(ActionEvent event) {
    	loadPage("management");
    }

    @FXML
    void membership(ActionEvent event) {
    	loadPage("membership");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadPage(String page) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/"+page+".fxml"));
			bp.setCenter(root);
		} catch (IOException e) {
			Logger.getLogger(HomeControl.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
