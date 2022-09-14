package controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.InParking;
import model.OnDelivery;
import model.Vehicle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;


public class parkingSystemController extends Vehicle {
    public JFXComboBox<String> vehicleID;
    public Label txtAnswer;
    public JFXComboBox<String> driverId;
    public Label time;
    public Label parkingSlot;
    public AnchorPane firstPage;
    public JFXButton btnOnDeliveryShift;
    public Label warning;
    public Label slotNumber;


    public void initialize() {
        ObservableList<String> obsVehicle = FXCollections.observableArrayList();
        for (Vehicle vehicle : addVehicleController.vehicleArrayList
        ) {
            obsVehicle.add(vehicle.getVehicleNumber());
        }
        vehicleID.setItems(obsVehicle);

        ObservableList<String> obsDriver = FXCollections.observableArrayList();
        for (Driver driver : addDriverController.driverArrayList
        ) {
            obsDriver.add(driver.getName());
        }
        driverId.setItems(obsDriver);

    }

    public void openSecondPage(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/LogInForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) firstPage.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void selectVehicle(ActionEvent actionEvent) {
        String vId = vehicleID.getSelectionModel().getSelectedItem();
        for (Vehicle vehicle : addVehicleController.vehicleArrayList
        ) {
            if (vehicle.getVehicleNumber().equalsIgnoreCase(vId)) {
                txtAnswer.setText(vehicle.getVehicleType());
            }
        }

    }

    public void parkVehicle(ActionEvent actionEvent) {
        boolean parked=false;
        String vN = vehicleID.getSelectionModel().getSelectedItem();
        String vT = txtAnswer.getText();
        String dN = driverId.getSelectionModel().getSelectedItem();

        for (InParking inParking:inParkingTableController.inParkingList
             ) {
            if(vN.equalsIgnoreCase(inParking.getVehicleNumber())){
                parked=true;
            }
        }
        if(!parked) {
            for (int i = 0; i < onDeliveryTableController.onDeliveries.size(); i++) {
                if (onDeliveryTableController.onDeliveries.get(i).getVehicleNumber().equalsIgnoreCase(vN)) {
                    onDeliveryTableController.onDeliveries.remove(i);
                }
            }
            for (Vehicle vehicle1 : addVehicleController.vehicleArrayList) {
                if (vN.equalsIgnoreCase(vehicle1.getVehicleNumber())) {
                    vehicle1.setDriverNic(null);
                    vehicle1.park(vN, vT);

                }
            }

            for (InParking inparking : inParkingTableController.inParkingList
            ) {
                if (vN.equalsIgnoreCase(inparking.getVehicleNumber())) {
                    DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
                            .appendValue(ChronoField.DAY_OF_MONTH, 2)
                            .appendLiteral("/")
                            .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                            .appendLiteral("/")
                            .appendValue(ChronoField.YEAR, 4)
                            .appendLiteral("   ")
                            .appendValue(ChronoField.HOUR_OF_AMPM, 2)
                            .appendLiteral(":")
                            .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                            .appendLiteral(" ")
                            .appendText(ChronoField.AMPM_OF_DAY);
                    DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();

                    time.setText(inparking.getParkedTime().format(dateTimeFormatter));
                    parkingSlot.setText("Your Parking Slot Number");
                    slotNumber.setText(String.valueOf(inparking.getParkingSlot()));
                }
            }

        }
    }


    public void onDeliveryShift(ActionEvent actionEvent) {
        boolean onDeliveryShift=false;
        String vN = vehicleID.getSelectionModel().getSelectedItem();
        String vT = txtAnswer.getText();
        String dN = driverId.getSelectionModel().getSelectedItem();
        String dNic=null;
        for (Driver driver:addDriverController.driverArrayList
             ) {
            if(driver.getName().equalsIgnoreCase(dN)){
                dNic=driver.getNic();
            }
        }
        for (Vehicle v1:addVehicleController.vehicleArrayList
             ) {
            if(v1.getDriverNic()!=null) {
                if (v1.getDriverNic().equalsIgnoreCase(dNic)) {
                    return;
                }
            }
        }
        for (OnDelivery onDelivery:onDeliveryTableController.onDeliveries
             ) {
            if(vN.equalsIgnoreCase(onDelivery.getVehicleNumber())){
                onDeliveryShift=true;
            }
        }

        if(!onDeliveryShift) {
            for (int i = 0; i < inParkingTableController.inParkingList.size(); i++) {
                if (inParkingTableController.inParkingList.get(i).getVehicleNumber().equalsIgnoreCase(vN)) {
                    inParkingTableController.inParkingList.remove(i);
                }
            }

            for (Vehicle vehicle2 : addVehicleController.vehicleArrayList) {
                if (vN.equalsIgnoreCase(vehicle2.getVehicleNumber())) {
                    vehicle2.setDriverNic(dNic);
                    vehicle2.leavePark(vN, vT);
                }
            }
            for (OnDelivery onDelivery : onDeliveryTableController.onDeliveries
            ) {
                if (vN.equalsIgnoreCase(onDelivery.getVehicleNumber())) {
                    DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
                            .appendValue(ChronoField.DAY_OF_MONTH, 2)
                            .appendLiteral("/")
                            .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                            .appendLiteral("/")
                            .appendValue(ChronoField.YEAR, 4)
                            .appendLiteral("   ")
                            .appendValue(ChronoField.HOUR_OF_AMPM, 2)
                            .appendLiteral(":")
                            .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                            .appendLiteral(" ")
                            .appendText(ChronoField.AMPM_OF_DAY);
                    DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();

                    time.setText(onDelivery.getLeftTime().format(dateTimeFormatter));

                    parkingSlot.setText(null);
                    slotNumber.setText(null);
                }
            }
        }
    }

}


