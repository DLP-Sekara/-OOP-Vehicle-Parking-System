package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class infoPageController {
    public AnchorPane infoPage;
    public JFXComboBox<String> infoPageOption;
    public AnchorPane context;

 public void back(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/managementAction.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) infoPage.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void allVehicleTable(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/allVehicles.fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }

    public void allDriverTable(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/allDrivers.fxml");
        Parent load = FXMLLoader.load(resource);
        context.getChildren().clear();
        context.getChildren().add(load);
    }
}
