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
    private Logic logic;
    
    private ArrayList<User> users;
    
    private User currentUser;
    
    
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
        
        //exit app
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
        createNew.setPadding(new Insets(10, 10, 10, 10));
        
        //exit app
        createExit.setOnAction((event) -> {
            stop();
        });
        
        //creating new user
        createButton.setOnAction((event) -> {
            boolean usernameOkay = true;
            boolean passwordOkay = true;
            for (int i =0; i < users.size(); i++){
                if (users.get(i).getName().equals(newNameField.getText())){
                    usernameOkay = false;
                } 
            }
            if (newNameField.getText().isEmpty()) {
                usernameOkay = false;
            }
            if (newPassField.getText().isEmpty()) {
                passwordOkay = false;
            }
            if (usernameOkay == false) {
                creationError.setText("Pick another username");
            } else if (passwordOkay == false) {
                creationError.setText("Don't leave password empty");
            } else {
                User newUser = new User(newNameField.getText(), newPassField.getText());
                users.add(newUser);
                stage.setScene(loginScene);
            }
        });
        
        Scene createScene = new Scene(createNew);
        
        //login view -> create new user view
        goToCreateAccount.setOnAction((event) -> {
            stage.setScene(createScene);
        });
        
        //MAIN PAGE VIEW
        
        GridPane mainPage = new GridPane();
        
        Label welcomeText = new Label("Welcome");
        Button charCreation = new Button("Create a new character");
        Button settleCreation = new Button("Create a new settlement");
        Button charCatalogue = new Button("     Your characters     ");
        Button settleCatalogue = new Button("     Your settlements     ");
        Button mainExit = new Button("Exit");
        
        mainPage.add(welcomeText, 2, 1);
        mainPage.add(charCreation, 1, 3);
        mainPage.add(settleCreation, 3, 3);
        mainPage.add(charCatalogue, 1, 5);
        mainPage.add(settleCatalogue, 3, 5);
        mainPage.add(mainExit, 2, 6);
        
        //exit app
        mainExit.setOnAction((event) -> {
            stop();
        });
        
        
        
        Scene mainPageScene = new Scene(mainPage);
        
        // CREATE NEW CHARACTER VIEW
        
        GridPane createChar = new GridPane();
        
        Label enterCharNameLabel = new Label("Name:");
        TextField enterCharName = new TextField();
        Label errorText = new Label("");
        Button confirmCreateChar = new Button("Save");
        Button exitCharMake = new Button("Return");
        
        createChar.add(enterCharNameLabel, 1, 1);
        createChar.add(enterCharName, 2, 1);
        createChar.add(errorText, 2, 2);
        createChar.add(confirmCreateChar, 2, 3);
        createChar.add(exitCharMake, 3, 4);
        
        Scene charaCreateScene = new Scene(createChar);
        
        //save changes and create new character
        confirmCreateChar.setOnAction((e) -> {
            if (currentUser.addChara(enterCharName.getText()) && !enterCharName.getText().isEmpty()) {
                enterCharName.setText("");
                stage.setScene(mainPageScene);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        //return to main page
        exitCharMake.setOnAction((e)-> {
            stage.setScene(mainPageScene);
        });
        
        //main page -> character creation page
        charCreation.setOnAction((e) -> {
            stage.setScene(charaCreateScene);
        });
        
        //login -> main page
        loginButton.setOnAction((event) -> {
           User comparable = new User(nameField.getText(), passField.getText());
           if (users.contains(comparable)) {
               setCurrentUser(nameField.getText());
               welcomeText.setText(currentUser.getName());
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
    
    public void setCurrentUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                this.currentUser = users.get(i);
            }
        }
        
    }
}
