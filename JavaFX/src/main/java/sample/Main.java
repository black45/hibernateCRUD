package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.BorderPaneBuilder;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        primaryStage.setTitle("School Manager");
        primaryStage.getIcons().add(new Image("/icon.png"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        }catch(Exception e){
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {

        launch(args);

    }
}
