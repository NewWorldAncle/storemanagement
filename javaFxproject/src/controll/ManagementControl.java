package controll;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.MyTableView;
import dao.ManagementDao;
import dto.Management;
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

public class ManagementControl implements Initializable{

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMent_num;
    @FXML
    private TextField txtMent_goods;
    @FXML
    private Button btnSearch;
    @FXML
    private DatePicker dipcMent_date;
    @FXML
    private TextField txtMent_inven;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private BorderPane bp;

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void insert(ActionEvent event) {
		try {
			String id = txtId.getText();
			int ment_num = Integer.parseInt(txtMent_num.getText());
			String ment_goods = txtMent_goods.getText();
			Date ment_date = Date.valueOf(dipcMent_date.getValue());
			int ment_inven = Integer.parseInt(txtMent_inven.getText());
			
			Management vo = new Management();
			vo.setId(id);
			vo.setMent_num(ment_num);
			vo.setMent_goods(ment_goods);
			vo.setMent_date(ment_date);
			vo.setMent_inven(ment_inven);
			
			ManagementDao dao = new ManagementDao();
			dao.insert(vo);
			ObservableList<Management> data;
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Management.class);
			bp.setCenter(tableView);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
    	ManagementDao dao = new ManagementDao();
    	Management vo = new Management();
    	
    	String id = txtId.getText();
		int ment_num = Integer.parseInt(txtMent_num.getText());
		String ment_goods = txtMent_goods.getText();
		Date ment_date = Date.valueOf(dipcMent_date.getValue());
		int ment_inven = Integer.parseInt(txtMent_inven.getText());
		
		vo.setId(id);
		vo.setMent_num(ment_num);
		vo.setMent_goods(ment_goods);
		vo.setMent_date(ment_date);
		vo.setMent_inven(ment_inven);
		
		try {
			dao.update(vo);
			
			ObservableList<Management> data;
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Management.class);
			bp.setCenter(tableView);
			
			int pos = (int) tableView.getSelectionModel().getSelectedItem();
			tableView.getItems().set(pos, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ManagementDao dao = new ManagementDao();
		ObservableList<Management> data;
		try {
			data = FXCollections.observableArrayList(dao.selectAll());
			MyTableView tableView = new MyTableView(data,Management.class);
			bp.setCenter(tableView);
			tableView.setOnMouseClicked(
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Management manage = (Management) tableView.getSelectionModel().getSelectedItem();
						txtId.setText(manage.getId());
						txtMent_num.setText(""+manage.getMent_num());
						txtMent_goods.setText(manage.getMent_goods());
						txtMent_inven.setText(""+manage.getMent_inven());
					}
				}
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
