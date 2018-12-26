package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 前台主程序，zengyue
 * 2018.12.26
 */
public class QLoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("超市前台收银系统");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/qlogin.fxml"));
        primaryStage.getIcons().add(new Image("/img/back.png"));
        Scene scene = new Scene(root,700,500);
        scene.getStylesheets().add("/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public  static void main(String[] args){
        launch(args);
    }
}
