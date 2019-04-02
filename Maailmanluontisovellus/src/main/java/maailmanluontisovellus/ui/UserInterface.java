/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.ui;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import maailmanluontisovellus.domain.Logic;
import maailmanluontisovellus.domain.User;

/**
 *
 * @author halauri
 */
public class UserInterface {
    Logic logic;
    
    ArrayList<User> users;
    public UserInterface() {
        this.users = new ArrayList<>();
    }
    
    public void setLogic(Logic logic) {
        this.logic = logic;
    }
    
    
    
    public void start(Stage stage) {
        
        
        VBox login = new VBox();
        
        Label enterName = new Label("Enter username");
        TextField nameField = new TextField();
        Label enterPass = new Label("Enter password");
        TextField passField = new TextField();
        Button loginButton = new Button("login");
        Label guideNew = new Label("Or create new account:");
        Button goToCreateAccount = new Button("Create new account");
        Button exit = new Button("Exit");
        
        login.getChildren().addAll(enterName, nameField, enterPass, passField, loginButton, guideNew, goToCreateAccount, exit);
        login.setPadding(new Insets(10, 10, 10, 10));
        
        Scene loginScene = new Scene(login);
        
        VBox createNew = new VBox();
        
        Label enterNewName = new Label("Enter your username");
        TextField newNameField = new TextField();
        Label enterNewPass = new Label("Enter the password");
        TextField newPassField = new TextField();
        Button createButton = new Button("create account");
        Button exit2 = new Button("Exit");
        
        createNew.getChildren().addAll(enterNewName, newNameField, enterNewPass, newPassField, createButton, exit2);
        
        Scene createScene = new Scene(createNew);
        
        VBox mainPage = new VBox();
        
        Label welcomeText = new Label("Welcome");
        Button exit3 = new Button("Exit");
        
        mainPage.getChildren().addAll(welcomeText, exit3);
        
        Scene mainPageScene = new Scene(mainPage);
        
        goToCreateAccount.setOnAction((event) -> {
            stage.setScene(createScene);
        });
        
        createButton.setOnAction((event) -> {
            User newUser = new User(newNameField.getText(), newPassField.getText());
            users.add(newUser);
            stage.setScene(loginScene);
        });
        
        loginButton.setOnAction((event) -> {
           User comparable = new User(nameField.getText(), passField.getText());
           if (users.contains(comparable)) {
               welcomeText.setText("Welcome " + comparable.getName());
               stage.setScene(mainPageScene);
           }
        });
        
        exit.setOnAction((event) -> {
            stop();
        });
        exit2.setOnAction((event) -> {
            stop();
        });
        exit3.setOnAction((event) -> {
            stop();
        });
        
        stage.setScene(loginScene);
        stage.show();
    }
    
    public void stop() {
        Platform.exit();
    }
}
