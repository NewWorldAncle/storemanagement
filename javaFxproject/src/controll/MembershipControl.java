package controll;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.MyTableView;
import dao.MembershipDao;
import dto.Membership;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MembershipControl implements Initializable{
    
	@FXML
    private BorderPane bp;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMem_num;
    @FXML
    private TextField txtMem_name;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtMem_address;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private DatePicker dipcMem_date;
    @FXML
    private TextField txtMem_phone;
    
    
    @FXML
    void delete(ActionEvent event) {
    	MembershipDao dao = new MembershipDao();
    	ObservableList<Membership> data;
    	try {
    		data = FXCollections.observableArrayList(dao.selectAll());
    		MyTableView tableView = new MyTableView(data,Membership.class);
    		bp.setCenter(tableView);
    		Membership member = (Membership) tableView.getSelectionModel().getSelectedItem();
    		
    		dao.delete(member.getMem_num());
    		tableView.getItems().remove(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void insert(ActionEvent event) {
    	try {
    		Membership vo = new Membership();
    		MembershipDao dao = new MembershipDao();
    		
    		String id = txtId.getText();
    		int mem_num = Integer.parseInt(txtMem_num.getText());
    		String mem_name = txtMem_name.getText();
    		Date mem_date = Date.valueOf(dipcMem_date.getValue());
    		String mem_phone = txtMem_phone.getText();
    		String mem_address = txtMem_address.getText();
    		vo.setId(id);
    		vo.setMem_num(mem_num);
    		vo.setMem_name(mem_name);
    		vo.setMem_date(mem_date);
    		vo.setMem_phone(mem_phone);
    		vo.setMem_address(mem_address);
    		
			dao.insert(vo);
			ObservableList<Membership> data;
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Membership.class);
			bp.setCenter(tableView);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void search(ActionEvent event) {
    	MembershipDao dao = new MembershipDao();
    	ObservableList<Membership> data;
    	try {
    		String key = txtMem_name.getText();
    		dao.select("'"+key+"'");
    		
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Membership.class);
			bp.setCenter(tableView);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void update(ActionEvent event) {
    	MembershipDao dao = new MembershipDao();
    	Membership vo = new Membership();
    	
    	String id = txtId.getText();
		int mem_num = Integer.parseInt(txtMem_num.getText());
		String mem_name = txtMem_name.getText();
		Date mem_date = Date.valueOf(dipcMem_date.getValue());
		String mem_phone = txtMem_phone.getText();
		String mem_address = txtMem_address.getText();
		vo.setId(id);
		vo.setMem_num(mem_num);
		vo.setMem_name(mem_name);
		vo.setMem_date(mem_date);
		vo.setMem_phone(mem_phone);
		vo.setMem_address(mem_address);
		try {
			dao.update(vo);
			ObservableList<Membership> data;
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Membership.class);
			bp.setCenter(tableView);
			
			int pos = (int) tableView.getSelectionModel().getSelectedItem();
			tableView.getItems().set(pos, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MembershipDao dao = new MembershipDao();
		
		ObservableList<Membership> data;
		try {
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Membership.class);
			bp.setCenter(tableView);
			tableView.setOnMouseClicked(
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Membership member = (Membership) tableView.getSelectionModel().getSelectedItem();
						txtId.setText(member.getId());
						txtMem_num.setText(""+member.getMem_num());
						txtMem_name.setText(member.getMem_name());
						txtMem_phone.setText(member.getMem_phone());
						txtMem_address.setText(member.getMem_address());
					}
				}
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
