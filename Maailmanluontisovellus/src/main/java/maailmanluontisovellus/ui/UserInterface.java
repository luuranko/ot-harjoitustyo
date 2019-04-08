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
import javafx.scene.layout.GridPane;
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
        
       
        //LOGIN VIEW
        
        VBox login = new VBox();
        
        Label enterName = new Label("Enter username");
        TextField nameField = new TextField();
        Label enterPass = new Label("Enter password");
        TextField passField = new TextField();
        Button loginButton = new Button("login");
        Label error = new Label("");
        Label guideNew = new Label("Or create new account:");
        Button goToCreateAccount = new Button("Create new account");
        Button loginExit = new Button("Exit");
        
        login.getChildren().addAll(enterName, nameField, enterPass, passField, loginButton, error, guideNew, goToCreateAccount, loginExit);
        login.setPadding(new Insets(10, 10, 10, 10));
        
        loginExit.setOnAction((event) -> {
            stop();
        });
        
        
        
        Scene loginScene = new Scene(login);
        
        //CREATE NEW ACCOUNT VIEW
        
        VBox createNew = new VBox();
        
        Label enterNewName = new Label("Enter your username");
        TextField newNameField = new TextField();
        Label enterNewPass = new Label("Enter the password");
        TextField newPassField = new TextField();
        Button createButton = new Button("create account");
        Label creationError = new Label("");
        Button createExit = new Button("Exit");
        
        createNew.getChildren().addAll(enterNewName, newNameField, enterNewPass, newPassField, createButton, creationError, createExit);
        
        createExit.setOnAction((event) -> {
            stop();
        });
        
        createButton.setOnAction((event) -> {
            boolean okay = true;
            for (int i =0; i < users.size(); i++){
                if (users.get(i).getName().equals(newNameField.getText())){
                    okay = false;
                } 
            }
            if (newNameField.getText().isEmpty()) {
                okay = false;
            }
            if (okay) {
                creationError.setText("Pick another username");
            } else {
                User newUser = new User(newNameField.getText(), newPassField.getText());
                users.add(newUser);
                stage.setScene(loginScene);
            }
        });
        
        Scene createScene = new Scene(createNew);
        
        goToCreateAccount.setOnAction((event) -> {
            stage.setScene(createScene);
        });
        
        //MAIN PAGE VIEW
        
        VBox mainPage = new VBox();
        
        Label welcomeText = new Label("Welcome");
        Button charCreation = new Button("Create a new character");
        Button mainExit = new Button("Exit");
        
        mainPage.getChildren().addAll(welcomeText, charCreation, mainExit);
        
        mainExit.setOnAction((event) -> {
            stop();
        });
        
        
        
        Scene mainPageScene = new Scene(mainPage);
        
        // CREATE NEW CHARACTER VIEW
        
        GridPane createChar = new GridPane();
        
        Button exitCharMake = new Button("exit");
        
        createChar.add(exitCharMake, 1, 1);
        
        Scene charaCreateScene = new Scene(createChar);
        
        charCreation.setOnAction((e) -> {
            stage.setScene(charaCreateScene);
        });
        
        //login -> main page
        loginButton.setOnAction((event) -> {
           User comparable = new User(nameField.getText(), passField.getText());
           if (users.contains(comparable)) {
               welcomeText.setText(comparable.getName());
               stage.setScene(mainPageScene);
           } else {
               error.setText("Wrong username or password");
           }
        });
        
        
       
        
        stage.setScene(loginScene);
        stage.show();
    }
    
    public void stop() {
        Platform.exit();
    }
}
