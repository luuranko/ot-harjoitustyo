import maailmanluontisovellus.domain.RandomGenerator;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RandomGeneratorTest {
    RandomGenerator rangen;
    
    @Before
    public void setUp() {
        this.rangen = new RandomGenerator();
    }
    
    @Test
    public void appearance() {
        String random = rangen.appearance();
        assertTrue(random.matches("(.*) and (.*)"));
    }
    
    @Test
    public void personality() {
        String random = rangen.personality();
        assertTrue(random.matches("(.*) and (.*)"));
    }
    
    @Test
    public void goal() {
        String random = rangen.goal();
        assertTrue(random.length() > 3);
    }
    
    @Test
    public void ability() {
        String random = rangen.ability();
        assertTrue(random.matches("(.*) and (.*)"));
    }
    
    @Test
    public void weakness() {
        String random = rangen.weakness();
        assertTrue(random.length() > 4);
    }
    
    @Test
    public void description() {
        String random = rangen.description();
        assertTrue(random.length() > 6);
    }
    
    @Test
    public void population() {
        String random = rangen.population();
        assertTrue(random.length() > 3);
    }
    
    @Test
    public void government() {
        String random = rangen.government();
        assertTrue(random.length() > 3);
    }
    
    @Test
    public void culture() {
        String random = rangen.culture();
        assertTrue(random.length() > 3);
    }
    
    @Test
    public void geography() {
        String random = rangen.geography();
        assertTrue(random.length() > 3);
    }
}
