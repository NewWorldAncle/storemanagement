package controll;

import java.sql.Date;
import java.sql.SQLException;

import dao.UsersDao;
import dto.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class JoinsControl {

    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPw;
    @FXML
    private DatePicker dpicBirthday;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnJoin;
    @FXML
    void join(ActionEvent event) {	//insert질의 활용
    	try {
			String id = txtId.getText();
			String pw = txtPw.getText();
			Date birthday = Date.valueOf(dpicBirthday.getValue());
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			
			Users vo = new Users();
			vo.setId(id);
			vo.setPw(pw);
			vo.setBirthday(birthday);
			vo.setPhone(phone);
			vo.setEmail(email);
			
			UsersDao dao = new UsersDao();
			dao.insert(vo);
			
			System.out.println("회원정보 등록 완료.");
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Home Ledger Ver1.0");
	    	alert.setHeaderText("회원가입 결과");
	    	alert.setContentText("회원가입에 성공하였습니다 :)");
	    	alert.showAndWait();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }

}
