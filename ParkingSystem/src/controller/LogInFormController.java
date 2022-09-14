package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInFormController {
    public Label loginFormWarning;
    public AnchorPane loginForm;
    public JFXTextField userName;
    public JFXPasswordField password;
    public JFXButton loginButton;
    public JFXButton loginButton1;
    public AnchorPane back;

    public void login(ActionEvent actionEvent) throws IOException {
        if(userName.getText().equalsIgnoreCase("lp") && password.getText().equalsIgnoreCase("lp")){
            URL resource = getClass().getResource("../view/managementAction.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginForm.getScene().getWindow();
            window.setScene(new Scene(load));

        }else{loginFormWarning.setText("* Enter valid info");}

    }

    public void goToPassword(ActionEvent actionEvent) {
        password.requestFocus();
    }

    public void loginWithEnter(ActionEvent actionEvent) throws IOException {
        if(userName.getText().equalsIgnoreCase("lp") && password.getText().equalsIgnoreCase("lp")){
            URL resource = getClass().getResource("../view/managementAction.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginForm.getScene().getWindow();
            window.setScene(new Scene(load));
        }else{loginFormWarning.setText("* Enter valid info");}
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/parkingSystem.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginForm.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void bckToHome(MouseEvent mouseEvent) {
    }
}
