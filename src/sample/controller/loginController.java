package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.*;

public class loginController {
    @FXML
    TextField textField1, textField2;

    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void switchToRegister(ActionEvent event) throws IOException{
        Parent root = load(getClass().getResource("../view/register.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../css/login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHome(ActionEvent event) throws IOException{
        Parent root = load(getClass().getResource("../view/home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../css/home.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTextField() throws IOException{
        textField1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                textField2.requestFocus();
            }
        });
    }
}