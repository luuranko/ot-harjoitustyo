import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import maailmanluontisovellus.domain.*;

public class UserTest {
    User user;
    
    @Before
    public void setUp() {
        this.user = new User("a", "a", 0);
    }
    
    @Test
    public void getName() {
        assertTrue(user.getName().equals("a"));
    }
    
    @Test
    public void getPassword() {
        assertTrue(user.getPassword().equals("a"));
    }
    
    @Test
    public void getId() {
        assertTrue(user.getId() == 0);
    }
    
    @Test
    public void getCharas1() {
        assertTrue(user.getCharas().isEmpty());
    }
    
    @Test
    public void getCharas2() {
        user.getCharas().add(new maailmanluontisovellus.domain.Character("a", 1));
        assertTrue(user.getCharas().size() == 1);
    }
    
    @Test
    public void getSettles1() {
        assertTrue(user.getSettles().isEmpty());
    }
    
    @Test
    public void getSettles2() {
        user.getSettles().add(new Settlement("a", 1));
        assertTrue(user.getSettles().size() == 1);
    }
    
    @Test
    public void setCharas1() {
        user.setCharas(null);
        assertTrue(user.getCharas().isEmpty());
    }
    
    @Test
    public void setCharas2() {
        ArrayList<maailmanluontisovellus.domain.Character> list = new ArrayList<>();
        list.add(new maailmanluontisovellus.domain.Character("a", 1));
        user.setCharas(list);
        assertTrue(user.getCharas().size() == 1);
    }
    
    @Test
    public void setSettles1() {
        user.setSettles(null);
        assertTrue(user.getSettles().isEmpty());
    }
    
    @Test
    public void setSettles2() {
        ArrayList<Settlement> list = new ArrayList<>();
        list.add(new Settlement("a", 1));
        user.setSettles(list);
        assertTrue(user.getSettles().size() == 1);
    }
    
    @Test
    public void addChara1() {
        user.addChara("a");
        assertTrue(user.getCharas().size() == 1);
    }
    
    @Test
    public void addChara2() {
        user.addChara("a");
        user.addChara("a");
        assertTrue(user.getCharas().size() == 1);
    }
    
    @Test
    public void addChara3() {
        user.addChara("a");
        assertTrue(user.addChara("a") == null);
    }
    
    @Test
    public void addSettle1() {
        user.addSettle("a");
        assertTrue(user.getSettles().size() == 1);
    }
    
    @Test
    public void addSettle2() {
        user.addSettle("a");
        user.addSettle("a");
        assertTrue(user.getSettles().size() == 1);
    }
    
    @Test
    public void addSettle3() {
        user.addSettle("a");
        assertTrue(user.addSettle("a") == null);
    }
    
    @Test
    public void findChara1() {
        user.addChara("a");
        assertTrue(user.findChara("a").getName().equals("a"));
    }
    
    @Test
    public void findChara2() {
        user.addChara("a");
        assertTrue(user.findChara("b") == null);
    }
    
    @Test
    public void findSettle1() {
        user.addSettle("a");
        assertTrue(user.findSettle("a").getName().equals("a"));
    }
    
    @Test
    public void findSettle2() {
        user.addSettle("a");
        assertTrue(user.findSettle("b") == null);
    }
}
