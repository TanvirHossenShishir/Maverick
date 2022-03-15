package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.fxml.FXMLLoader.load;

public class forumController implements Initializable {
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button menuButton, applyFilter, cancelFilter;
    @FXML
    private StackPane filterPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Most Recent", "Most Popular", "Unanswered");
        comboBox.getSelectionModel().select("Most Recent");

    }

    public void filter(MouseEvent event){
        loadUI("../view/filter");
    }


    public void clearStackPane(){
        filterPane.getChildren().clear();
    }

    public void loadUI(String ui){
        Parent root = null;
        try {
            root = load(getClass().getResource(ui+".fxml"));
        } catch (IOException e) {
            Logger.getLogger(sidebarController.class.getName()).log(Level.SEVERE, null, e);
        }
        filterPane.getChildren().setAll(root);
    }
}
