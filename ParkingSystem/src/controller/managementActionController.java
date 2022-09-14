package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class managementActionController {

    public JFXComboBox<String> managementOption;
    public AnchorPane secondPage;
    public AnchorPane context;

    public void initialize() {
        ObservableList<String> obsStatus = FXCollections.observableArrayList("In Parking", "On Delivery");
        managementOption.setItems(obsStatus);

    }

    public void back(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/parkingSystem.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) secondPage.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openInfoPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/infoPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) secondPage.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openTable(ActionEvent actionEvent) throws IOException {
        String table = managementOption.getSelectionModel().getSelectedItem();
        if (table.equalsIgnoreCase("In Parking")) {
            URL resource = getClass().getResource("../view/inParkingTable.fxml");
            Parent load = FXMLLoader.load(resource);
            context.getChildren().clear();
            context.getChildren().add(load);
        }
        if (table.equalsIgnoreCase("On Delivery")) {
            URL resource = getClass().getResource("../view/onDeliveryTable.fxml");
            Parent load = FXMLLoader.load(resource);
            context.getChildren().clear();
            context.getChildren().add(load);

        }
    }

    public void addDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/addDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addVehicle(ActionEvent actionEvent) throws IOException {


        URL resource = getClass().getResource("../view/addVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
