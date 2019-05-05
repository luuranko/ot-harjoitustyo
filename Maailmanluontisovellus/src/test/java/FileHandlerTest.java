import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import maailmanluontisovellus.domain.FileHandler;
import maailmanluontisovellus.domain.User;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FileHandlerTest {
    FileHandler handler;
    
    @Before
    public void setUp() throws IOException {
        this.handler = new FileHandler("a", "b", "c");
        FileWriter writer = new FileWriter(new File("a"));
        FileWriter writer2 = new FileWriter(new File("b"));
        FileWriter writer3 = new FileWriter(new File("c"));
    }
    
    @Test
    public void returnUsers() {
        assertTrue(handler.getUserlist().isEmpty());
    }
    
    @Test
    public void setUserlist() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("a", "a", 0));
        handler.setUserlist(list);
        assertTrue(handler.getUserlist().size() == 1);
    }
    
    @Test
    public void readingCreating() throws IOException {
        handler.init();
        assertTrue(handler.getUserlist().isEmpty());
    }
    
    @Test
    public void savingReading1() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("a", "a", 0));
        list.get(0).addChara("a");
        list.get(0).addChara("b");
        handler.setUserlist(list);
        handler.setCharalist(list.get(0), list.get(0).getCharas());
        handler.saveUsers();
        handler.saveCharas();
        handler.init();
        assertTrue(handler.getCharas(handler.getUserlist().get(0)).size() == 2);
    }
    
    @Test
    public void savingReading2() throws Exception {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("a", "a", 0));
        list.get(0).addChara("a");
        list.get(0).addChara("b");
        list.get(0).addSettle("a");
        list.get(0).addSettle("b");
        handler.setUserlist(list);
        handler.setCharalist(list.get(0), list.get(0).getCharas());
        handler.setSettlelist(list.get(0), list.get(0).getSettles());
        handler.saveUsers();
        handler.saveCharas();
        handler.saveSettles();
        handler.init();
        assertTrue(handler.getSettles(handler.getUserlist().get(0)).size() == 2);
    }
    
}
