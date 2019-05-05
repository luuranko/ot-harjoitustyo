import maailmanluontisovellus.domain.Character;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    maailmanluontisovellus.domain.Character chara;
    
    @Before
    public void setUp() {
        this.chara = new maailmanluontisovellus.domain.Character("a", 0);
    }
    
    @Test
    public void getId() {
        assertTrue(chara.getId() == 0);
    }
    
    @Test
    public void setId() {
        chara.setId(1);
        assertTrue(chara.getId() == 1);
    }
    
    @Test
    public void getAppearance() {
        assertTrue(chara.getAppearance().equals(" "));
    }
    
    @Test
    public void getPersonality() {
        assertTrue(chara.getPersonality().equals(" "));
    }
    
    @Test
    public void getWeakness() {
        assertTrue(chara.getWeakness().equals(" "));
    }
    
    @Test
    public void getGoal() {
        assertTrue(chara.getGoal().equals(" "));
    }
    
    @Test
    public void compareTo() {
        assertTrue(chara.compareTo(new Character("b", 1)) < 0);
    }
}
