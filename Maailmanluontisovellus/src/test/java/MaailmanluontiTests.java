/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.stage.Stage;
import javafx.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import maailmanluontisovellus.ui.*;
import maailmanluontisovellus.domain.*;
/**
 *
 * @author halauri
 */
public class MaailmanluontiTests {
    UserInterface ui;
    
    @Before
    public void setUp() {
        //this.ui = new UserInterface();
    }
    
    @Test
    public void createAccountSuccess() {
        boolean correct = true;
        ui.start(new Stage());
        assertTrue(correct);
    }
}
