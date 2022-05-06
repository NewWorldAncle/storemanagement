package controll;

import java.io.IOException;

import dao.UsersDao;
import dto.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsersControl {

    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPw;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnJoin;

    @FXML
    void join(ActionEvent event) {	//회원가입 창 팝업
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/joins.fxml"));
    	try {
			Parent root = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Store Management Ver1.0");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
	@FXML
    void login(ActionEvent event) {		//select질의 활용
    	Users user = new Users();
    	UsersDao dao = new UsersDao();
	    	try {
				dao.login(user.getId(), user.getPw());
			
				//로그인 안내창
				System.out.println("로그인 성공.");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Store Management Ver1.0");
				alert.setHeaderText("로그인 결과");
				alert.setContentText("로그인 성공하였습니다 :)");
				alert.showAndWait();
					
				//새 창 전환
				Parent root = FXMLLoader.load(getClass().getResource("../fxml/home.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage)btnLogin.getScene().getWindow(); // 현재 윈도우 가져오기
				primaryStage.setTitle("Store Management Ver1.0");
				primaryStage.hide();	//전환 애니메이션
				primaryStage.setScene(scene);
				primaryStage.show();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
    	 
    }
}
