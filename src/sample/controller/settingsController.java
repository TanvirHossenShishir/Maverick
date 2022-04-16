package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class settingsController implements Initializable {
    @FXML
    private Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void darkToLight() {
        System.out.println("clicked");
        //System.out.println(button.getStyleClass());
        button.getScene().getRoot().getStylesheets().remove(getClass().getResource("../css/style.css").toString());
        //button.getScene().getRoot().getStylesheets().add(getClass().getResource("../css/style1.css").toString());
    }
}
