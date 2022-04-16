package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.fxml.FXMLLoader.load;

public class forumController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button menuButton, applyFilter, cancelFilter, askQuestion;
    @FXML
    private StackPane filterPane;
    @FXML
    private VBox questionArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("MOST RECENT", "MOST POPULAR", "UNANSWERED");
        comboBox.getSelectionModel().select("MOST RECENT");

        List<String> quesTitle = Arrays.asList("How can I remove a specific item from an array?",
                "What is your plan if nuclear war starts?",
                "Why is printing \"B\" dramatically slower than printing \"#\"?",
                "Why is printing \"B\" dramatically slower than printing \"#\"?",
                "sup3");
        for(int i=0; i<5; i++) {
            displayQuestion(quesTitle.get(i));
        }

        askQuestion.setOnAction(event -> addQuestionDialog());
    }

    public void addQuestionDialog(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/addQuestion.fxml"));
            DialogPane addQuesDialog = fxmlLoader.load();
            addQuestionController addQuesController = fxmlLoader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(addQuesDialog);
            dialog.setTitle("Ask Question");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(
                    new Image(this.getClass().getResource("../image/logo3.png").toString()));
            Optional<ButtonType> clickedbutton = dialog.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayQuestion(String quesTitle){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/question.fxml"));
            HBox hBox = fxmlLoader.load();
            questionController question = fxmlLoader.getController();
            question.setTitle(quesTitle);
            questionArea.getChildren().add(hBox);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
