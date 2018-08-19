package eu.xthedoctah.updater.scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Loader extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/loader.fxml"));
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });
            primaryStage.setTitle("Whoniverse Launcher Updater");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 600, 300));
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
