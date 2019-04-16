/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.ui;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import maailmanluontisovellus.domain.*;

/**
 *
 * @author halauri
 */
public class UserInterface {
    private Logic logic;

    public UserInterface(Logic logic) {
        this.logic = logic;
    }
    
    public void start(Stage stage) {
        //shortcut for faster manual testing
        logic.addNewUser("testi", "testi");
        //app starts from login view
        loginScene(stage);
    }
    
    //closes the app
    public void stop() {
        Platform.exit();
    }
    
    // SCENE GENERATION METHODS
    
    //LOGIN SCENE
    public void loginScene(Stage stage) {
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
            String name = nameField.getText();
            String password = passField.getText();
            if (logic.login(name, password)) {
                mainPage(stage);
            } else {
                error.setText("Incorrect username or password");
            }
        });
        
        //login view -> create new user view
        goToCreateAccount.setOnAction((event) -> {
            createAccount(stage);
        });
        
        stage.setScene(loginScene);
        stage.show();
        
    }
    
    //CREATE NEW ACCOUNT SCENE
    public void createAccount(Stage stage) {
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
            loginScene(stage);
        });
        
        //creating new user
        createButton.setOnAction((event) -> {
            String name = newNameField.getText();
            String password = newPassField.getText();
            if (logic.addNewUser(name, password)) {
                loginScene(stage);
            } else {
                creationError.setText("A field left empty or a taken username");
            }
        });
        
        stage.setScene(createScene);
        stage.show();
    }
    
    //MAIN PAGE SCENE
    public void mainPage(Stage stage) {
        
        GridPane mainPage = new GridPane();
        
        Label welcomeText = new Label("Welcome " + logic.currentUser().getName());
        Button charCreation = new Button(" New character ");
        Button settleCreation = new Button(" New settlement ");
        Button charCatalogueButton = new Button("Your characters");
        Button settleCatalogueButton = new Button("Your settlements");
        Button logout = new Button("Logout");
        
        mainPage.add(welcomeText, 2, 1);
        mainPage.add(charCreation, 1, 3);
        mainPage.add(settleCreation, 3, 3);
        mainPage.add(charCatalogueButton, 1, 5);
        mainPage.add(settleCatalogueButton, 3, 5);
        mainPage.add(logout, 2, 6);
        
        //log out
        logout.setOnAction((event) -> {
            logic.logout();
            loginScene(stage);
        });
        
         //main page -> character creation page
        charCreation.setOnAction((e) -> {
            createCharaScene(stage);
        });
        
        
        //main page -> character catalogue page
        charCatalogueButton.setOnAction((e)-> {
            charaCatalogueScene(stage);
        });
        
        //main page -> settlement creation page
        settleCreation.setOnAction((e) -> {
            createSettleScene(stage);
        });
       
        //main page -> settlement catalogue page
        settleCatalogueButton.setOnAction((e)-> {
            settleCatalogueScene(stage);
        });
        
        Scene mainPageScene = new Scene(mainPage);
        stage.setScene(mainPageScene);
        stage.show();
    }
    
    //CREATE NEW CHARACTER SCENE
    public void createCharaScene(Stage stage) {
        
        GridPane createChar = new GridPane();
        
        Label enterCharNameLabel = new Label("Name:");
        TextField enterCharName = new TextField();
        Label appearLabel = new Label("Appearance: ");
        TextField appearanceField = new TextField();
        Label personLabel = new Label("Personality: ");
        TextField personalityField = new TextField();
        Label goalLabel = new Label("Goal: ");
        TextField goalField = new TextField();
        Label abilityLabel = new Label("Ability: ");
        TextField abilityField = new TextField();
        Label weaknessLabel = new Label("Weakness: ");
        TextField weaknessField = new TextField();
        Label errorText = new Label("");
        Button confirmCreateChar = new Button("Save");
        Button exitCharMake = new Button("Return");
        
        int x = 2;
        int y = 7;
        
        createChar.add(enterCharNameLabel, 1, 1);
        createChar.add(enterCharName, 2, 1);
        createChar.add(appearLabel, 1, 2);
        createChar.add(appearanceField, 2, 2);
        createChar.add(personLabel, 1, 3);
        createChar.add(personalityField, 2, 3);
        createChar.add(goalLabel, 1, 4);
        createChar.add(goalField, 2, 4);
        createChar.add(abilityLabel, 1, 5);
        createChar.add(abilityField, 2, 5);
        createChar.add(weaknessLabel, 1, 6);
        createChar.add(weaknessField, 2, 6);
        createChar.add(errorText, x, y);
        createChar.add(confirmCreateChar, x, y+1);
        createChar.add(exitCharMake, x+1, y+2);
        
        Scene charaCreateScene = new Scene(createChar);
        
        //return to main page
        exitCharMake.setOnAction((e)-> {
            mainPage(stage);
        });
        
         
        //save changes and create new character
        confirmCreateChar.setOnAction((e) -> {
            String name = enterCharName.getText();
            String appearance = appearanceField.getText();
            String personality = personalityField.getText();
            String goal = goalField.getText();
            String ability = abilityField.getText();
            String weakness = weaknessField.getText();
            if (logic.newChara(name)) {
                logic.modifyChara(name, appearance, personality, goal, ability, weakness);
                mainPage(stage);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        stage.setScene(charaCreateScene);
        stage.show();
    }
    
    //CREATE NEW SETTLEMENT SCENE
    public void createSettleScene(Stage stage) {
        
        GridPane createSettle = new GridPane();
        
        Label enterSettleNameLabel = new Label("Name:");
        TextField enterSettleName = new TextField();
        Label descripLabel = new Label("Description: ");
        TextField descrip = new TextField();
        Label populLabel = new Label("Population: ");
        TextField popul = new TextField();
        Label governLabel = new Label("Government: ");
        TextField govern = new TextField();
        Label cultureLabel = new Label("Culture: ");
        TextField cultur = new TextField();
        Label geoLabel = new Label("Geography: ");
        TextField geo = new TextField();
        Label errorText = new Label("");
        Button confirmCreateSettle = new Button("Save");
        Button exitSettleMake = new Button("Return");
        
        createSettle.add(enterSettleNameLabel, 1, 1);
        createSettle.add(enterSettleName, 2, 1);
        createSettle.add(descripLabel, 1, 2);
        createSettle.add(descrip, 2, 2);
        createSettle.add(populLabel, 1, 3);
        createSettle.add(popul, 2, 3);
        createSettle.add(governLabel, 1, 4);
        createSettle.add(govern, 2, 4);
        createSettle.add(cultureLabel, 1, 5);
        createSettle.add(cultur, 2, 5);
        createSettle.add(geoLabel, 1, 6);
        createSettle.add(geo, 2, 6);
        createSettle.add(errorText, 2, 7);
        createSettle.add(confirmCreateSettle, 2, 8);
        createSettle.add(exitSettleMake, 2, 9);
        
        Scene settleCreateScene = new Scene(createSettle);
        
        //return to main page
        exitSettleMake.setOnAction((e)-> {
            mainPage(stage);
        });
        
         
        //save changes and create new character
        confirmCreateSettle.setOnAction((e) -> {
            String name = enterSettleName.getText();
            String description = descrip.getText();
            String population = popul.getText();
            String government = govern.getText();
            String culture = cultur.getText();
            String geography = geo.getText();
            if (logic.newSettle(name)) {
                logic.modifySettle(name, description, population, government, culture, geography);
                mainPage(stage);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        stage.setScene(settleCreateScene);
        stage.show();
        
    }
    
    //CHARACTER CATALOGUE SCENE
    public void charaCatalogueScene(Stage stage) {
        
        GridPane charCatalogueView = new GridPane();
        Label charCatalogueTitle = new Label(logic.currentUser().getName() + "'s characters");
        VBox charListBox = new VBox();
        for (int i = 0; i < logic.currentUser().getCharas().size(); i++) {
            String charName = logic.currentUser().getCharas().get(i).getName();
            Button chara = new Button(charName);
            charListBox.getChildren().add(chara);
            
            //character catalogue page -> character's own page
            chara.setOnAction((e)-> {
                characterPage(stage, charName);
            });
        }
        Button returnFromCharCa = new Button("Return");
        
        charCatalogueView.add(charCatalogueTitle, 1, 1);
        charCatalogueView.add(charListBox, 2, 2);
        charCatalogueView.add(returnFromCharCa, 1, 4);
        
        Scene charaCatalogueScene = new Scene(charCatalogueView);
        
        //character catalogue page -> main page
        returnFromCharCa.setOnAction((e)-> {
            mainPage(stage);
        });
        
        stage.setScene(charaCatalogueScene);
        stage.show();
    }
    
    //SETTLEMENT CATALOGUE SCENE
    public void settleCatalogueScene(Stage stage) {
        
        GridPane settleCatalogueView = new GridPane();
        Label settleCatalogueTitle = new Label(logic.currentUser().getName() + "'s settlements");
        VBox settleListBox = new VBox();
        for (int i = 0; i < logic.currentUser().getSettles().size(); i++) {
            String settleName = logic.currentUser().getSettles().get(i).getName();
            Button settle = new Button(settleName);
            settleListBox.getChildren().add(settle);
            
            //settlement catalogue page -> settlement's own page
            settle.setOnAction((e)-> {
               settlementPage(stage, settleName); 
            });
        }
        Button returnFromSettCa = new Button("Return");
        
        settleCatalogueView.add(settleCatalogueTitle, 1, 1);
        settleCatalogueView.add(settleListBox, 2, 2);
        settleCatalogueView.add(returnFromSettCa, 1, 4);
        
        Scene settleCatalogueScene = new Scene(settleCatalogueView);
        
        //character catalogue page -> main page
        returnFromSettCa.setOnAction((e)-> {
            mainPage(stage);
        });
        
        stage.setScene(settleCatalogueScene);
        stage.show();

    }
    
    //VIEW CHARACTER SCENE
    public void characterPage(Stage stage, String name) {
        GridPane charaPage = new GridPane();
        
        maailmanluontisovellus.domain.Character chara = logic.currentUser().findChara(name);
        
        Label charNameLabel = new Label("Name: ");
        Label charName = new Label(chara.getName());
        Label appearLabel = new Label("Appearance: ");
        Label appear = new Label(chara.getAppearance());
        Label personLabel = new Label("Personality: ");
        Label person = new Label(chara.getPersonality());
        Label goalLabel = new Label("Goal: ");
        Label charaGoal = new Label(chara.getGoal());
        Label abilityLabel = new Label("Ability: ");
        Label charaAbility = new Label(chara.getAbility());
        Label weaknessLabel = new Label("Weakness: ");
        Label charaWeakness = new Label(chara.getWeakness());
        Label errorText = new Label("");
        Label fillLabel = new Label("");
        Button exit = new Button("Return");
        
        int x = 2;
        int y = 7;
        
        charaPage.add(charNameLabel, 1, 1);
        charaPage.add(charName, 2, 1);
        charaPage.add(appearLabel, 1, 2);
        charaPage.add(appear, 2, 2);
        charaPage.add(personLabel, 1, 3);
        charaPage.add(person, 2, 3);
        charaPage.add(goalLabel, 1, 4);
        charaPage.add(charaGoal, 2, 4);
        charaPage.add(abilityLabel, 1, 5);
        charaPage.add(charaAbility, 2, 5);
        charaPage.add(weaknessLabel, 1, 6);
        charaPage.add(charaWeakness, 2, 6);
        charaPage.add(errorText, x, y);
        charaPage.add(fillLabel, x, y+1);
        charaPage.add(exit, x, y+2);
        
        Scene charaPageScene = new Scene(charaPage);
        
        //return to character catalogue
        exit.setOnAction((e)-> {
            charaCatalogueScene(stage);
        });
        
        
        stage.setScene(charaPageScene);
        stage.show();
    }
    
    public void settlementPage(Stage stage, String name) {
        GridPane settlePage = new GridPane();
        
        Settlement settle = logic.currentUser().findSettle(name);
        
        Label settleNameLabel = new Label("Name: ");
        Label settleName = new Label(settle.getName());
        Label descripLabel = new Label("Description: ");
        Label descrip = new Label(settle.getDescrip());
        Label populLabel = new Label("Population: ");
        Label popul = new Label(settle.getPopulation());
        Label governLabel = new Label("Government: ");
        Label govern = new Label(settle.getGovern());
        Label cultureLabel = new Label("Culture: ");
        Label cultur = new Label(settle.getCulture());
        Label geoLabel = new Label("Geography: ");
        Label geo = new Label(settle.getGeography());
        Label errorText = new Label("");
        Label fillLabel = new Label("");
        Button exit = new Button("Return");
        
        settlePage.add(settleNameLabel, 1, 1);
        settlePage.add(settleName, 2, 1);
        settlePage.add(descripLabel, 1, 2);
        settlePage.add(descrip, 2, 2);
        settlePage.add(populLabel, 1, 3);
        settlePage.add(popul, 2, 3);
        settlePage.add(governLabel, 1, 4);
        settlePage.add(govern, 2, 4);
        settlePage.add(cultureLabel, 1, 5);
        settlePage.add(cultur, 2, 5);
        settlePage.add(geoLabel, 1, 6);
        settlePage.add(geo, 2, 6);
        settlePage.add(errorText, 2, 7);
        settlePage.add(fillLabel, 2, 8);
        settlePage.add(exit, 2, 9);
        
        Scene settlePageScene = new Scene(settlePage);
        
        //return to character catalogue
        exit.setOnAction((e)-> {
            settleCatalogueScene(stage);
        });
        
        
        stage.setScene(settlePageScene);
        stage.show();
    }
    
}
