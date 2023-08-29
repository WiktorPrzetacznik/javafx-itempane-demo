package itempanedemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ItemPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Main.fxml")));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Demo");
        primaryStage.show();
    }

}