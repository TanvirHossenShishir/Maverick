package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class questionDetailController implements Initializable {
    @FXML
    private VBox answerArea;
    @FXML
    private Label quesDescription;
    @FXML
    private Button home, addAnswer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        home.setOnMouseClicked(e->{
            sidebarController q = sidebarController.getInstance();
            q.loadUI("../view/forum");
        });
        quesDescription.setText("I have created an SPA. Refer to the following site. So, accessing the SPA and pressing the [SignIn] button will take you to the login screen. And if the authentication is successful, you will be redirected to SPA again.This is a common process. However, I would like to see the login page from the moment I access the SPA. In other words, we want to display the login page from the beginning without pressing the [SignIN] button and without firing the onclick event. In the sample, the following process is executed after the button is clicked.");

        List<String> quesTitle = Arrays.asList("How can I remove a specific item from an array?",
            "What is your plan if nuclear war starts?",
            "Why is printing \"B\" dramatically slower than printing \"#\"?",
            "Why is printing \"B\" dramatically slower than printing \"#\"?",
            "sup3");
        for(int i=0; i<5; i++) {
        //displayAnswer(quesTitle.get(i));
            displayAnswer();
        }
        addAnswer.setOnAction(event -> addAnswerDialog());

    }
    public void addAnswerDialog(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/addAnswer.fxml"));
            DialogPane addAnsDialog = fxmlLoader.load();
            addAnswerController addAnsController = fxmlLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(addAnsDialog);
            dialog.setTitle("Add Answer");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(
                    new Image(this.getClass().getResource("../image/logo3.png").toString()));
            Optional<ButtonType> clickedbutton = dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAnswer(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/answer.fxml"));
            HBox hBox = fxmlLoader.load();
            answerController answer = fxmlLoader.getController();
            //answer.setTitle(quesTitle);
            answerArea.getChildren().add(hBox);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
