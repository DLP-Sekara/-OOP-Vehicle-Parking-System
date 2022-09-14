package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.OnDelivery;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class onDeliveryTableController implements Initializable {
    public AnchorPane onDeliveryTablePage;
    public TableView<OnDelivery> onDeliveryTable;
    public TableColumn vNumber;
    public TableColumn vType;
    public TableColumn dName;
    public TableColumn lTime;
    public static ArrayList<OnDelivery> onDeliveries=new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<OnDelivery> obsOnDeliveries= FXCollections.observableArrayList(onDeliveries);
        vNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        vType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        dName.setCellValueFactory(new PropertyValueFactory("driverName"));
        lTime.setCellValueFactory(new PropertyValueFactory("leftTime"));
        onDeliveryTable.setItems(obsOnDeliveries);
    }
}
