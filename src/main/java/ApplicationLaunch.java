/**
 * Created by XTR100 on 11/11/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationLaunch extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
        Pane root = (Pane) loader.load();
        primaryStage.setTitle("BeJam Lottery");
        primaryStage.setScene(new Scene(root,1024,600));
        primaryStage.show();
    }
}
