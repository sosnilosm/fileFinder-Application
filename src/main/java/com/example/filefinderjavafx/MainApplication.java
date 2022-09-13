package com.example.filefinderjavafx;

import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField_Path = new TextField("Enter path!");
        textField_Path.setLayoutY(80);    // установка положения надписи по оси Y
        textField_Path.setLayoutX(80);   // установка положения надписи по оси X
        textField_Path.setMinWidth(130);
        textField_Path.setMaxWidth(130);

        TextField textField_str = new TextField("Enter str to find!");
        textField_str.setLayoutY(80);    // установка положения надписи по оси Y
        textField_str.setLayoutX(210);   // установка положения надписи по оси X
        textField_str.setMinWidth(130);
        textField_str.setMaxWidth(130);

        TextArea result = new TextArea("Search results:");
        result.setEditable(false);
        result.setLayoutX(85);     // установка положения надписи по оси Y
        result.setLayoutY(120);     // установка положения надписи по оси X

        Button enterBtn = new Button("Search");
        enterBtn.setLayoutX(340);   // установка положения надписи по оси X
        enterBtn.setLayoutY(80);    // установка положения надписи по оси Y
        enterBtn.setMinWidth(80);
        enterBtn.setMaxWidth(80);

        enterBtn.setOnAction(actionEvent -> result.setText("Search results:\n" + FileFinder.folderWorm(textField_Path.getText(), textField_str.getText())));

        Group group = new Group(textField_Path, textField_str, enterBtn, result);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("file-finder");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}