package com.soft1841.sm;

/**
 * @author zengyue
 * 2018.12.24
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class AdminLoginApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("五行java商品管理登录界面");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/adminlogin.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,700,550);
        scene.getStylesheets().addAll ("/css/style.css");
        primaryStage.getIcons().add(new Image("/img/admin.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
