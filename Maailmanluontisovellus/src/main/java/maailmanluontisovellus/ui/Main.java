/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.ui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import maailmanluontisovellus.domain.Logic;
import maailmanluontisovellus.ui.UserInterface;

/**
 *
 * @author halauri
 */
public class Main extends Application{
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
    public void start(Stage stage){
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setTitle("Maailmanluonti");
        ui.start(stage);
        
        
        
    }
}
