import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import maailmanluontisovellus.domain.Settlement;

public class SettlementTest {
    Settlement settle;
    
    @Before
    public void setUp() {
        this.settle = new Settlement("a", 0);
    }
    
    @Test
    public void getId() {
        assertTrue(settle.getId() == 0);
    }
    
    @Test
    public void setId() {
        settle.setId(1);
        assertTrue(settle.getId() == 1);
    }
    
    @Test
    public void getDescrip() {
        assertTrue(settle.getDescrip().equals(" "));
    }
    
    @Test
    public void getPopulation() {
        assertTrue(settle.getPopulation().equals(" "));
    }
    
    @Test
    public void getGovern() {
        assertTrue(settle.getGovern().equals(" "));
    }
    
    @Test
    public void getGeography() {
        assertTrue(settle.getGeography().equals(" "));
    }
    
    @Test
    public void getCulture() {
        assertTrue(settle.getCulture().equals(" "));
    }
    
    @Test
    public void compareTo() {
        assertTrue(settle.compareTo(new Settlement("b", 1)) < 0);
    }
}
