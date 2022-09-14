package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addVehicleController implements Initializable {
    public JFXTextField vn;
    public JFXTextField mw;
    public JFXTextField np;
    public JFXTextField vt;
    public JFXComboBox cmbVehicleType;

    public void openVT(ActionEvent actionEvent) {
        cmbVehicleType.requestFocus();
    }

    public void openNP(ActionEvent actionEvent) {
        np.requestFocus();
    }

    public void openMW(ActionEvent actionEvent) {
        mw.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> vehicleType = FXCollections.observableArrayList("Van", "Bus", "Cargo Lorry");
        cmbVehicleType.setItems(vehicleType);
    }

    public static ArrayList<Vehicle> vehicleArrayList = new ArrayList();

    public void addVehicleDetails(ActionEvent actionEvent) {
        String vT = (String) cmbVehicleType.getSelectionModel().getSelectedItem();
        Vehicle v1 = null;
        if (vT.equalsIgnoreCase("van")) {
            v1 = new Van(vn.getText(), vT, Integer.parseInt(mw.getText()), Integer.parseInt(np.getText()), null);
        }
        if (vT.equalsIgnoreCase("cargo lorry")) {
            v1 = new CargoLorry(vn.getText(), vT, Integer.parseInt(mw.getText()), Integer.parseInt(np.getText()), null);
        }
        if (vT.equalsIgnoreCase("bus")) {
            v1 = new Bus(vn.getText(), vT, Integer.parseInt(mw.getText()), Integer.parseInt(np.getText()), null);
        }
        vehicleArrayList.add(v1);

        vn.clear();
        mw.clear();
        np.clear();
        cmbVehicleType.getSelectionModel().clearSelection();
    }

    public void addVehicleWithEnter(ActionEvent actionEvent) {

    }
}