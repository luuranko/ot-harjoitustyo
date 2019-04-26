
package maailmanluontisovellus.ui;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import maailmanluontisovellus.domain.*;


public class UserInterface {
    private Logic logic;

    public UserInterface(Logic logic) {
        this.logic = logic;
    }
    
    public void start(Stage stage) {
        //shortcut for faster manual testing
        //logic.addNewUser("testi", "testi");
        
        //app starts from login view
        loginScene(stage);
    }
    
    //closes the app
    public void stop() {
        Platform.exit();
    }
    
    // SCENE GENERATION METHODS
    
    /**
     * LOGIN SCENE: 
     * where the user can enter their username and password to log in
     * or move to the scene for creating a new account
     * @param stage The stage used by the app
     */
    public void loginScene(Stage stage) {
        GridPane loginView = new GridPane();
        
        Label enterName = new Label("Enter username:    ");
        TextField nameField = new TextField();
        Label enterPass = new Label("Enter password:    ");
        TextField passField = new TextField();
        Label filler = new Label("");
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #FFFFFF;");
        Label error = new Label("");
        Label guideNew = new Label("Or create new account:");
        Button goToCreateAccount = new Button("Create new account");
        goToCreateAccount.setStyle("-fx-background-color: #FFFFFF;");
        Button loginExit = new Button("Exit");
        loginExit.setStyle("-fx-background-color: #FFFFFF;");
        
        loginView.add(enterName, 1, 1);
        loginView.add(nameField, 2, 1);
        loginView.add(enterPass, 1, 2);
        loginView.add(passField, 2, 2);
        loginView.add(filler, 2, 3);
        loginView.add(loginButton, 2, 4);
        loginView.add(error, 2, 5);
        loginView.add(guideNew, 2, 6);
        loginView.add(goToCreateAccount, 2, 7);
        loginView.add(loginExit, 3, 8);
        
        loginView.setPadding(new Insets(20, 20, 20, 20));
        loginView.setStyle("-fx-background-color: #FFCFAF;");

        Scene loginScene = new Scene(loginView, Color.ANTIQUEWHITE);
        
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
    
    /**
     * CREATE NEW ACCOUNT SCENE: 
     * where the user can enter the username and password for their new account
     * @param stage The stage used by the app
     */
    public void createAccount(Stage stage) {
        VBox createNew = new VBox();
        
        Label enterNewName = new Label("Enter your username");
        TextField newNameField = new TextField();
        Label enterNewPass = new Label("Enter the password");
        TextField newPassField = new TextField();
        Button createButton = new Button("create account");
        createButton.setStyle("-fx-background-color: #FFFFFF;");
        Label creationError = new Label("");
        Button createReturn = new Button("Exit");
        createReturn.setStyle("-fx-background-color: #FFFFFF;");
        
        createNew.getChildren().addAll(enterNewName, newNameField, enterNewPass, newPassField, createButton, creationError, createReturn);
        createNew.setPadding(new Insets(20, 20, 20, 20));
        createNew.setStyle("-fx-background-color: #FFCFAF;");
        
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
    
    /**
     * MAIN PAGE SCENE: 
     * from where the user can access their character and settlement catalogues
     * and character or settlement creation pages.
     * @param stage The stage used by the app
     */
    public void mainPage(Stage stage) {
        
        GridPane mainPage = new GridPane();
        
        Label welcomeText = new Label("Welcome " + logic.currentUser().getName());
        Button charCreation = new Button(" New character ");
        charCreation.setStyle("-fx-background-color: #FFFFFF;");
        Button settleCreation = new Button(" New settlement ");
        settleCreation.setStyle("-fx-background-color: #FFFFFF;");
        Button charCatalogueButton = new Button("Your characters");
        charCatalogueButton.setStyle("-fx-background-color: #FFFFFF;");
        Button settleCatalogueButton = new Button("Your settlements");
        settleCatalogueButton.setStyle("-fx-background-color: #FFFFFF;");
        Button logout = new Button("Logout");
        logout.setStyle("-fx-background-color: #FFFFFF;");
        
        mainPage.add(welcomeText, 2, 1);
        mainPage.add(charCreation, 1, 3);
        mainPage.add(settleCreation, 3, 3);
        mainPage.add(charCatalogueButton, 1, 5);
        mainPage.add(settleCatalogueButton, 3, 5);
        mainPage.add(logout, 2, 6);
        
        mainPage.setPadding(new Insets(20, 20, 20, 20));
        mainPage.setStyle("-fx-background-color: #FFCFAF;");
        
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
    
    /**
     * CHARACTER CREATION SCENE: 
     * where the user can enter the name and other details for a new character
     * @param stage The stage used by the app
     */
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
        Button confirm = new Button("Save");
        confirm.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
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
        createChar.add(confirm, x, y+1);
        createChar.add(exit, x+1, y+2);
        
        createChar.setPadding(new Insets(20, 20, 20, 20));
        createChar.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene charaCreateScene = new Scene(createChar);
        
        //return to main page
        exit.setOnAction((e)-> {
            mainPage(stage);
        });
        
         
        //save changes and create new character
        confirm.setOnAction((e) -> {
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
    
    /**
     * SETTLEMENT CREATION SCENE: 
     * where the user can enter the name and other details for a new settlement.
     * @param stage The stage used by the app
     */
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
        Button confirm = new Button("Save");
        confirm.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
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
        createSettle.add(confirm, 2, 8);
        createSettle.add(exit, 2, 9);
        
        createSettle.setPadding(new Insets(20, 20, 20, 20));
        createSettle.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene settleCreateScene = new Scene(createSettle);
        
        //return to main page
        exit.setOnAction((e)-> {
            mainPage(stage);
        });
        
         
        //save changes and create new settlement
        confirm.setOnAction((e) -> {
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
    
    /**
     * CHARACTER CATALOGUE SCENE: 
     * where the user can view a list of characters they have created
     * and access their character pages.
     * @param stage The stage used by the app
     */
    public void charaCatalogueScene(Stage stage) {
        
        GridPane charCatalogueView = new GridPane();
        Label charCatalogueTitle = new Label(logic.currentUser().getName() + "'s characters");
        VBox charListBox = new VBox();
        for (int i = 0; i < logic.currentUser().getCharas().size(); i++) {
            String charName = logic.currentUser().getCharas().get(i).getName();
            Button chara = new Button(charName);
            chara.setStyle("-fx-background-color: #FFFFFF;");
            charListBox.getChildren().add(chara);
            
            //character catalogue page -> character's own page
            chara.setOnAction((e)-> {
                characterPage(stage, charName);
            });
        }
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
        charCatalogueView.add(charCatalogueTitle, 1, 1);
        charCatalogueView.add(charListBox, 2, 2);
        charCatalogueView.add(exit, 1, 4);
        
        charCatalogueView.setPadding(new Insets(20, 20, 20, 20));
        charCatalogueView.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene charaCatalogueScene = new Scene(charCatalogueView);
        
        //character catalogue page -> main page
        exit.setOnAction((e)-> {
            mainPage(stage);
        });
        
        stage.setScene(charaCatalogueScene);
        stage.show();
    }
    
    /**
     * SETTELEMENT CATALOGUE SCENE: 
     * where the user can view a list of settlements they have created
     * and access their settlement pages.
     * @param stage The stage used by the app
     */
    public void settleCatalogueScene(Stage stage) {
        
        GridPane settleCatalogueView = new GridPane();
        Label settleCatalogueTitle = new Label(logic.currentUser().getName() + "'s settlements");
        VBox settleListBox = new VBox();
        for (int i = 0; i < logic.currentUser().getSettles().size(); i++) {
            String settleName = logic.currentUser().getSettles().get(i).getName();
            Button settle = new Button(settleName);
            settle.setStyle("-fx-background-color: #FFFFFF;");
            settleListBox.getChildren().add(settle);
            
            //settlement catalogue page -> settlement's own page
            settle.setOnAction((e)-> {
               settlementPage(stage, settleName); 
            });
        }
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
        settleCatalogueView.add(settleCatalogueTitle, 1, 1);
        settleCatalogueView.add(settleListBox, 2, 2);
        settleCatalogueView.add(exit, 1, 4);
        
        settleCatalogueView.setPadding(new Insets(20, 20, 20, 20));
        settleCatalogueView.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene settleCatalogueScene = new Scene(settleCatalogueView);
        
        //settlement catalogue page -> main page
        exit.setOnAction((e)-> {
            mainPage(stage);
        });
        
        stage.setScene(settleCatalogueScene);
        stage.show();

    }
    
    /**
     * CHARACTER PAGE SCENE: 
     * where the chosen character's info is shown
     * and where the user can access the modifying page for that character.
     * @param stage The stage used by the app
     * @param name The name of the character shown
     */
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
        Button modify = new Button("Modify");
        modify.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
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
        charaPage.add(modify, x, y+2);
        charaPage.add(exit, x+1, y+2);
        
        charaPage.setPadding(new Insets(20, 20, 20, 20));
        charaPage.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene charaPageScene = new Scene(charaPage);
        
        //return to character catalogue
        exit.setOnAction((e)-> {
            charaCatalogueScene(stage);
        });
        
        //go to modifying page
        modify.setOnAction((e)-> {
            modifyCharaPage(stage, name);
        });
        
        stage.setScene(charaPageScene);
        stage.show();
    }
    
    /**
     * SETTELEMENT PAGE SCENE: 
     * where the chosen settlement's info is shown
     * and where the user can access the modifying page for that settlement.
     * @param stage The stage used by the app
     * @param name The name of the settlement shown
     */
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
        Button modify = new Button("Modify");
        modify.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
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
        settlePage.add(modify, 2, 9);
        settlePage.add(exit, 3, 9);
        
        settlePage.setPadding(new Insets(20, 20, 20, 20));
        settlePage.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene settlePageScene = new Scene(settlePage);
        
        //return to character catalogue
        exit.setOnAction((e)-> {
            settleCatalogueScene(stage);
        });
        
        //go to modifying page
        modify.setOnAction((e)-> {
            modifySettlePage(stage, name);
        });
        
        stage.setScene(settlePageScene);
        stage.show();
    }
    
    /**
     * CHARACTER MODIFYING SCENE: 
     * where the user can enter and save changes to the character's info.
     * @param stage The stage used by the app
     * @param name The name of the character
     */
    public void modifyCharaPage(Stage stage, String name) {
        
        maailmanluontisovellus.domain.Character chara = logic.currentUser().findChara(name);
        
        GridPane pane = new GridPane();
        
        Label enterCharNameLabel = new Label("Name:");
        TextField enterCharName = new TextField(chara.getName());
        Label appearLabel = new Label("Appearance: ");
        TextField appearanceField = new TextField(chara.getAppearance());
        Label personLabel = new Label("Personality: ");
        TextField personalityField = new TextField(chara.getPersonality());
        Label goalLabel = new Label("Goal: ");
        TextField goalField = new TextField(chara.getGoal());
        Label abilityLabel = new Label("Ability: ");
        TextField abilityField = new TextField(chara.getAbility());
        Label weaknessLabel = new Label("Weakness: ");
        TextField weaknessField = new TextField(chara.getWeakness());
        Label errorText = new Label("");
        Button confirm = new Button("Save");
        confirm.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
        int x = 2;
        int y = 7;
        
        pane.add(enterCharNameLabel, 1, 1);
        pane.add(enterCharName, 2, 1);
        pane.add(appearLabel, 1, 2);
        pane.add(appearanceField, 2, 2);
        pane.add(personLabel, 1, 3);
        pane.add(personalityField, 2, 3);
        pane.add(goalLabel, 1, 4);
        pane.add(goalField, 2, 4);
        pane.add(abilityLabel, 1, 5);
        pane.add(abilityField, 2, 5);
        pane.add(weaknessLabel, 1, 6);
        pane.add(weaknessField, 2, 6);
        pane.add(errorText, x, y);
        pane.add(confirm, x, y+1);
        pane.add(exit, x+1, y+2);
        
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene scene = new Scene(pane);
        
        //return without saving
        exit.setOnAction((e)-> {
            characterPage(stage, name);
        });
        
         
        //save changes
        confirm.setOnAction((e) -> {
            String charaName = enterCharName.getText();
            String appearance = appearanceField.getText();
            String personality = personalityField.getText();
            String goal = goalField.getText();
            String ability = abilityField.getText();
            String weakness = weaknessField.getText();
            if (logic.modifyCharaName(name, charaName)) {
                logic.modifyChara(charaName, appearance, personality, goal, ability, weakness);
                characterPage(stage, charaName);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * SETTLEMENT MODIFYING SCENE: 
     * where the user can enter and save changes to the settlement's info.
     * @param stage The stage used by the app
     * @param name The name of the settlement
     */
    public void modifySettlePage(Stage stage, String name) {
        Settlement settle = logic.currentUser().findSettle(name);
        
        GridPane pane = new GridPane();
        
        Label enterSettleNameLabel = new Label("Name:");
        TextField enterSettleName = new TextField(settle.getName());
        Label descripLabel = new Label("Description: ");
        TextField descrip = new TextField(settle.getDescrip());
        Label populLabel = new Label("Population: ");
        TextField popul = new TextField(settle.getPopulation());
        Label governLabel = new Label("Government: ");
        TextField govern = new TextField(settle.getGovern());
        Label cultureLabel = new Label("Culture: ");
        TextField cultur = new TextField(settle.getCulture());
        Label geoLabel = new Label("Geography: ");
        TextField geo = new TextField(settle.getGeography());
        Label errorText = new Label("");
        Button confirm = new Button("Save");
        confirm.setStyle("-fx-background-color: #FFFFFF;");
        Button exit = new Button("Return");
        exit.setStyle("-fx-background-color: #FFFFFF;");
        
        pane.add(enterSettleNameLabel, 1, 1);
        pane.add(enterSettleName, 2, 1);
        pane.add(descripLabel, 1, 2);
        pane.add(descrip, 2, 2);
        pane.add(populLabel, 1, 3);
        pane.add(popul, 2, 3);
        pane.add(governLabel, 1, 4);
        pane.add(govern, 2, 4);
        pane.add(cultureLabel, 1, 5);
        pane.add(cultur, 2, 5);
        pane.add(geoLabel, 1, 6);
        pane.add(geo, 2, 6);
        pane.add(errorText, 2, 7);
        pane.add(confirm, 2, 8);
        pane.add(exit, 2, 9);
        
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setStyle("-fx-background-color: #FFCFAF;");
        
        Scene settleCreateScene = new Scene(pane);
        
        //return without saving
        exit.setOnAction((e)-> {
            this.settlementPage(stage, name);
        });
        
         
        //save changes and return
        confirm.setOnAction((e) -> {
            String settleName = enterSettleName.getText();
            String description = descrip.getText();
            String population = popul.getText();
            String government = govern.getText();
            String culture = cultur.getText();
            String geography = geo.getText();
            if (logic.modifySettleName(name, settleName)) {
                logic.modifySettle(settleName, description, population, government, culture, geography);
                mainPage(stage);
            } else {
                errorText.setText("Taken or empty character name");
            }
            
        });
        
        stage.setScene(settleCreateScene);
        stage.show();
    }
    
}
