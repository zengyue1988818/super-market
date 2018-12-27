package com.soft1841.sm;

/**
 * @author zengyue
 * 2018.12.24
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AdminMainAPP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("五行后台系统");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/admin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setMaximized(true);
        scene.getStylesheets().add(AdminMainAPP.class.getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
