package maailmanluontisovellus.ui;

import java.io.FileInputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.stage.Stage;
import maailmanluontisovellus.domain.FileHandler;
import maailmanluontisovellus.domain.FileLogic;
import maailmanluontisovellus.domain.Logic;


public class Main extends Application {
    UserInterface ui;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String userFile = properties.getProperty("userlist.txt");
        String charaFile = properties.getProperty("charalist.txt");
        String settleFile = properties.getProperty("settlelist.txt");
        FileHandler handler = new FileHandler(userFile, charaFile, settleFile);
        Logic logic = new Logic();
        FileLogic flogic = new FileLogic(logic, handler);
        ui = new UserInterface(logic, flogic);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setHeight(300);
        stage.setWidth(600);
        stage.setTitle("Maailmanluonti");
        ui.start(stage);
    }
}
