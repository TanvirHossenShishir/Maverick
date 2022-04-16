package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class questionController implements Initializable {
    @FXML
    private Label title;
    @FXML
    private HBox questionSummary;

    public void setTitle(String quesTitle) {
        title.setText(quesTitle);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questionSummary.setOnMouseClicked(e->{
            sidebarController q=sidebarController.getInstance();
            q.loadAns();
        });
    }
}
