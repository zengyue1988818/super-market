package com.soft1841.sm;

/**
 * 前台主界面App
 * @author zengyue
 * 2018.12.25
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CashierMainAPP extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("超市前台收银系统");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cashier.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setMaximized(true);
        scene.getStylesheets().add(CashierMainAPP.class.getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
