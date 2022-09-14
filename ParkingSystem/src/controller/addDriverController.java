package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.Driver;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addDriverController implements Initializable {
    public JFXTextField dn;
    public JFXTextField nic;
    public JFXTextField dln;
    public JFXTextField address;
    public JFXTextField contact;
    public JFXButton addDriverButton;

    public void openNIC(ActionEvent actionEvent) {
        nic.requestFocus();
    }

    public void openDLN(ActionEvent actionEvent) {
        dln.requestFocus();
    }

    public void openAddress(ActionEvent actionEvent) {
        address.requestFocus();
    }

    public void openContact(ActionEvent actionEvent) {
        contact.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public static ArrayList<Driver> driverArrayList=new ArrayList();

    public void addDriver(ActionEvent actionEvent) {
        Driver d1=new Driver(dn.getText(),nic.getText(),dln.getText(),address.getText(),contact.getText());
        driverArrayList.add(d1);

        dn.clear();
        nic.clear();
        dln.clear();
        address.clear();
        contact.clear();
    }
}
