/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import maailmanluontisovellus.domain.Logic;

/**
 *
 * @author halauri
 */
public class Main extends Application {
    UserInterface ui;
    Logic logic;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
        logic = new Logic();
        ui = new UserInterface(logic);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setHeight(400);
        stage.setWidth(750);
        stage.setTitle("Maailmanluonti");
        ui.start(stage);
        
        
        
    }
}
