package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.InParking;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class inParkingTableController implements Initializable {
    public AnchorPane onParkingTable;
    public TableView<InParking> parkingVehicleTable;
    public TableColumn vNumber;
    public TableColumn vType;
    public TableColumn pSlot;
    public TableColumn pTime;
    public static ArrayList<InParking> inParkingList =new ArrayList<>();
    @Override
    public  void initialize(URL location, ResourceBundle resources) {
        ObservableList<InParking> obsInParking= FXCollections.observableArrayList(inParkingList);
        vNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        vType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        pSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        pTime.setCellValueFactory(new PropertyValueFactory("parkedTime"));
        parkingVehicleTable.setItems(obsInParking);
    }
}
