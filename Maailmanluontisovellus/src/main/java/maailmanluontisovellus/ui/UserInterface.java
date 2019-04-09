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
import maailmanluontisovellus.domain.*;

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
        //these are here for faster manual testing
        this.currentUser = new User("test", "test");
        this.users.add(currentUser);
    }
    
    public void setLogic(Logic logic) {
        this.logic = logic;
    }
    
    
    
    public void start(Stage stage) {
        //MAIN PAGE SCENE
        
        GridPane mainPage = new GridPane();
        
        Label welcomeText = new Label("Welcome " + this.currentUser.getName());
        Button charCreation = new Button(" New character ");
        Button settleCreation = new Button(" New settlement ");
        Button charCatalogueButton = new Button("Your characters");
        Button settleCatalogueButton = new Button("Your settlements");
        Button mainExit = new Button("Exit");
        
        mainPage.add(welcomeText, 2, 1);
        mainPage.add(charCreation, 1, 3);
        mainPage.add(settleCreation, 3, 3);
        mainPage.add(charCatalogueButton, 1, 5);
        mainPage.add(settleCatalogueButton, 3, 5);
        mainPage.add(mainExit, 2, 6);
        
        //exit app
        mainExit.setOnAction((event) -> {
            stop();
        });
        
        Scene mainPageScene = new Scene(mainPage);
        
        //CREATE NEW ACCOUNT SCENE
        
        VBox createNew = new VBox();
        
        Label enterNewName = new Label("Enter your username");
        TextField newNameField = new TextField();
        Label enterNewPass = new Label("Enter the password");
        TextField newPassField = new TextField();
        Button createButton = new Button("create account");
        Label creationError = new Label("");
        Button createReturn = new Button("Exit");
        
        createNew.getChildren().addAll(enterNewName, newNameField, enterNewPass, newPassField, createButton, creationError, createReturn);
        createNew.setPadding(new Insets(10, 10, 10, 10));
        
        Scene createScene = new Scene(createNew);
        
        //return to login scene
        createReturn.setOnAction((event) -> {
            stage.setScene(loginScene(stage, mainPageScene, createScene));
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
                stage.setScene(loginScene(stage, mainPageScene, createScene));
            }
        });
        
        
        //main page -> character creation page
        charCreation.setOnAction((e) -> {
            stage.setScene(createCharaScene(stage, mainPageScene));
        });
        
        
        //main page -> character catalogue page
        charCatalogueButton.setOnAction((e)-> {
            stage.setScene(charaCatalogueScene(stage, mainPageScene));
        });
        
        //main page -> settlement creation page
        settleCreation.setOnAction((e) -> {
            stage.setScene(createSettleScene(stage, mainPageScene));
        });
       
        //main page -> settlement catalogue page
        settleCatalogueButton.setOnAction((e)-> {
            stage.setScene(settleCatalogueScene(stage, mainPageScene));
        });
        
        stage.setScene(this.loginScene(stage, mainPageScene, createScene));
        stage.show();
    }
    
    //closes the app
    public void stop() {
        Platform.exit();
    }
    
    //sets the current user on app during login
    public void setCurrentUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                this.currentUser = users.get(i);
            }
        }
        
    }
    
    // SCENE GENERATION METHODS
    
    //LOGIN SCENE
    public Scene loginScene(Stage stage, Scene main, Scene create) {
        GridPane loginView = new GridPane();
        
        Label enterName = new Label("Enter username");
        TextField nameField = new TextField();
        Label enterPass = new Label("Enter password");
        TextField passField = new TextField();
        Button loginButton = new Button("login");
        Label error = new Label("");
        Label guideNew = new Label("Or create new account:");
        Button goToCreateAccount = new Button("Create new account");
        Button loginExit = new Button("Exit");
        
        loginView.add(enterName, 1, 1);
        loginView.add(nameField, 2, 1);
        loginView.add(enterPass, 1, 2);
        loginView.add(passField, 2, 2);
        loginView.add(loginButton, 2, 3);
        loginView.add(error, 2, 4);
        loginView.add(guideNew, 2, 5);
        loginView.add(goToCreateAccount, 2, 6);
        loginView.add(loginExit, 3, 7);
        
        Scene loginScene = new Scene(loginView);
        
        //exit app
        loginExit.setOnAction((event) -> {
            stop();
        });
        
        //login -> main page
        loginButton.setOnAction((event) -> {
           User comparable = new User(nameField.getText(), passField.getText());
           if (users.contains(comparable)) {
               setCurrentUser(nameField.getText());
               stage.setScene(main);
           } else {
               error.setText("Wrong username or password");
           }
        });
        
        //login view -> create new user view
        goToCreateAccount.setOnAction((event) -> {
            stage.setScene(create);
        });
        
        return loginScene;
    }
    
    //CREATE NEW CHARACTER SCENE
    public Scene createCharaScene(Stage stage, Scene main) {
        
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
        
        //return to main page
        exitCharMake.setOnAction((e)-> {
            stage.setScene(main);
        });
        
         
        //save changes and create new character
        confirmCreateChar.setOnAction((e) -> {
            boolean creationSuccess = false;
            if (enterCharName.getText().isEmpty() == false) {
                creationSuccess = this.currentUser.addChara(enterCharName.getText());
            }
            if (creationSuccess) {
                enterCharName.setText("");
                stage.setScene(main);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        
        return charaCreateScene;
    }
    
    //CHARACTER CATALOGUE SCENE
    public Scene charaCatalogueScene(Stage stage, Scene main) {
        
        GridPane charCatalogueView = new GridPane();
        Label charCatalogueTitle = new Label(currentUser.getName() + "'s characters");
        VBox charListBox = new VBox();
        for (int i = 0; i < currentUser.getCharas().size(); i++) {
            String charName = currentUser.getCharas().get(i).getName();
            charListBox.getChildren().add(new Button(charName));
        }
        Button returnFromCharCa = new Button("Return");
        
        charCatalogueView.add(charCatalogueTitle, 1, 1);
        charCatalogueView.add(charListBox, 2, 2);
        charCatalogueView.add(returnFromCharCa, 1, 4);
        
        Scene charaCatalogueScene = new Scene(charCatalogueView);
        
        //character catalogue page -> main page
        returnFromCharCa.setOnAction((e)-> {
            stage.setScene(main);
        });
        
        return charaCatalogueScene;
    }
    
    //CREATE NEW SETTLEMENT SCENE
    public Scene createSettleScene(Stage stage, Scene main) {
        
        GridPane createSettle = new GridPane();
        
        Label enterSettleNameLabel = new Label("Name:");
        TextField enterSettleName = new TextField();
        Label errorText = new Label("");
        Button confirmCreateSettle = new Button("Save");
        Button exitSettleMake = new Button("Return");
        
        createSettle.add(enterSettleNameLabel, 1, 1);
        createSettle.add(enterSettleName, 2, 1);
        createSettle.add(errorText, 2, 2);
        createSettle.add(confirmCreateSettle, 2, 3);
        createSettle.add(exitSettleMake, 3, 4);
        
        Scene settleCreateScene = new Scene(createSettle);
        
        //return to main page
        exitSettleMake.setOnAction((e)-> {
            stage.setScene(main);
        });
        
         
        //save changes and create new character
        confirmCreateSettle.setOnAction((e) -> {
            boolean creationSuccess = false;
            if (enterSettleName.getText().isEmpty() == false) {
                creationSuccess = this.currentUser.addSettle(enterSettleName.getText());
            }
            if (creationSuccess) {
                enterSettleName.setText("");
                stage.setScene(main);
            } else {
                errorText.setText("Taken or empty settlement name");
            }
            
        });
        
        return settleCreateScene;
        
    }
    
    
    //CHARACTER CATALOGUE SCENE
    public Scene settleCatalogueScene(Stage stage, Scene main) {
        
        GridPane settleCatalogueView = new GridPane();
        Label settleCatalogueTitle = new Label(currentUser.getName() + "'s settlements");
        VBox settleListBox = new VBox();
        for (int i = 0; i < currentUser.getSettles().size(); i++) {
            String settleName = currentUser.getSettles().get(i).getName();
            settleListBox.getChildren().add(new Button(settleName));
        }
        Button returnFromSettCa = new Button("Return");
        
        settleCatalogueView.add(settleCatalogueTitle, 1, 1);
        settleCatalogueView.add(settleListBox, 2, 2);
        settleCatalogueView.add(returnFromSettCa, 1, 4);
        
        Scene settleCatalogueScene = new Scene(settleCatalogueView);
        
        //character catalogue page -> main page
        returnFromSettCa.setOnAction((e)-> {
            stage.setScene(main);
        });
        
        return settleCatalogueScene;
    }
    
}
