package com.soft1841.sm.controller;

/**
 * 收银员信息控制器
 * @author zengyue
 * 2018.12.28
 */
import com.soft1841.sm.entity.Cashier;
import com.soft1841.sm.service.CashierService;
import com.soft1841.sm.until.ServiceFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class CashierController implements Initializable {
    @FXML
    private FlowPane cashierPane;
    private CashierService cashierService = ServiceFactory.getCashierServiceInstance();
    private List<Cashier> cashierList = new ArrayList<>();

    public CashierController() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cashierList = cashierService.getAllCashiers();
        showCashier(cashierList);
    }
    //读入布局文件
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cashier.fxml"));
    AnchorPane root = fxmlLoader.load();
    Scene scene = new Scene(root);


    //通过遍历循环cashierList集合，创建Hbox来显示每个收银员信息
    private void showCashier(List<Cashier> cashierList) {
        //移除之前的记录
        cashierPane.getChildren().clear();
        for (Cashier cashier : cashierList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(300,350);
            hBox.getStyleClass().add("box");
            hBox.setSpacing(30);
            //左边垂直布局放头像和身份
            VBox leftBox = new VBox();
            leftBox.setAlignment(Pos.TOP_CENTER);
            leftBox.setSpacing(30);
            ImageView imageView = new ImageView(new Image(cashier.getPicture()));
            imageView.setFitWidth(80);
            imageView.setFitHeight(120);
            Circle circle = new Circle();
            circle.setCenterX(40.0);
            circle.setCenterY(40.0);
            circle.setRadius(40.0);
            imageView.setClip(circle);
            //右边垂直布局放姓名、年龄、性别、部门
            VBox rightBox = new VBox();
            rightBox.setSpacing(10);
            Label nameLabel = new Label(cashier.getName());
            nameLabel.getStyleClass().add("font-title");
            Label ageLabel = new Label(cashier.getAge());
            Label sexLabel = new Label(cashier.getSexuality());
            Label numberLabel = new Label(cashier.getNumber());
            Label accountLabel = new Label(cashier.getAccount());
            Label passwordLabel = new Label(cashier.getPassword());
            Button delBtn = new Button("删除");
            delBtn.getStyleClass().add("grey-theme");
            //左右两个垂直布局加入水平布局
            hBox.getChildren().addAll(leftBox,rightBox);
            //水平布局加入大的内容容器
            cashierPane.getChildren().add(hBox);
            //删除按钮事件
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗？");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    long id = cashier.getId();
                    //删除这行记录
                    cashierService.deleteCashier(id);
                    //从流式面板移除当前这个人的布局
                    cashierPane.getChildren().remove(hBox);
                }
            });
            rightBox.getChildren().addAll(nameLabel,numberLabel,ageLabel,sexLabel,
                    accountLabel,passwordLabel,delBtn);
        }
    }

    //新增收银员方法
    public void insertCashier() {
        //创建一个Cashier对象
        Cashier cashier = new Cashier();
        //新建一个舞台
        Stage stage = new Stage();
        stage.setTitle("新增收银界面");
        //创建一个处置布局，用来放新增用户的各个组件
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10,10,10,10));
        Label infoLabel = new Label("请输入收银员信息");
        infoLabel.setPrefHeight(50);
        infoLabel.setPrefWidth(580);
        infoLabel.setAlignment(Pos.CENTER);
        //给文本添加样式
        infoLabel.getStyleClass().addAll("grey-theme");
        TextField nameField = new TextField();
        nameField.setPromptText("请输入姓名");
        //输入框无焦点
        nameField.setFocusTraversable(false);
        TextField pictureField = new TextField();
        pictureField.setPromptText("请输入头像地址");
        pictureField.setFocusTraversable(false);
        //性别，两个单选按钮为一个组，收银员单选按钮默认选中
        HBox roleBox = new HBox();
        roleBox.setSpacing(20);
        ToggleGroup group = new ToggleGroup();
        //学号输入框
        TextField numberField = new TextField();
        numberField.setPromptText("请输入学号");
        numberField.setFocusTraversable(false);
        //账号输入框
        TextField accountField = new TextField();
        accountField.setPromptText("请输入账号");
        accountField.setFocusTraversable(false);
        //密码输入框
        TextField passwordField = new TextField();
        passwordField.setPromptText("请输入密码");
        passwordField.setFocusTraversable(false);
        //新增按钮
        FlowPane flowPane = new FlowPane();
        Button addBtn = new Button("新增");
        addBtn.setPrefWidth(120);
        addBtn.getStyleClass().addAll("green-theme");
        flowPane.getChildren().add(addBtn);
        flowPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(infoLabel, nameField, pictureField,
                numberField,accountField, passwordField, flowPane);
        Scene scene = new Scene(vBox, 450, 380);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
        //点击新增按钮，将界面数据封装成一个Cashier对象，写入数据库
        addBtn.setOnAction(event -> {
            String nameString = nameField.getText().trim();
            String pictureString = pictureField.getText().trim();
            String numberString = numberField.getText().trim();
            String accountString = accountField.getText().trim();
            String passwordString = passwordField.getText().trim();
            cashier.setName(nameString);
            cashier.setPicture(pictureString);
            cashier.setNumber(numberString);
            cashier.setAccount(accountString);
            cashier.setPassword(passwordString);
            System.out.println(cashier.getName()  + cashier.getPicture());
            cashierService.insertCashier(cashier);
            stage.close();
            //重新读取一下数据显示
            cashierList = cashierService.getAllCashiers();
            showCashier(cashierList);
        });
    }
}