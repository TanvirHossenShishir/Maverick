package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.serverClient.*;
import java.io.IOException;
import java.net.Socket;
public class Main extends Application {
    static public Client client;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("MAVERICK");
        Scene scene = new Scene(root);

        primaryStage.getIcons().add(new Image(
                getClass().getResourceAsStream( "image/logo3.png" )));
        //String css = this.getClass().getResource("css/login.css").toExternalForm();
        //scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost" ,1235);
        client = new Client(socket);
        launch(args);
    }
}
