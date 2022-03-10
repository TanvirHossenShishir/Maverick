package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class forumController implements Initializable {
    @FXML
    private ComboBox comboBox;
    @FXML
    private ContextMenu contextMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Most Recent", "Most Popular", "Unanswered");
        comboBox.getSelectionModel().select("Most Recent");

    }
}
