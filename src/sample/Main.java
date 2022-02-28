package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        //Image icon = new Image("../image/logo3.png");
        //stage.getIcons().add(icon);
        stage.setTitle("MAVERICK");
        Scene scene = new Scene(root);

        String css = this.getClass().getResource("css/login.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        //stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
