import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import maailmanluontisovellus.domain.*;

public class LogicTest {
    Logic logic;
    
    @Before
    public void setUp() {
        this.logic = new Logic();
    }
    
    @Test
    public void getRangen() {
        assertTrue(logic.getRangen() != null);
    }
    
    @Test
    public void getUserlist() {
        assertTrue(logic.getUserlist().isEmpty());
    }
    
    @Test
    public void setUserlist() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("a", "a", 0));
        logic.setUserlist(list);
        assertTrue(logic.getUserlist().size() == 1);
    }
    
    @Test
    public void currentUser1() {
        assertTrue(logic.currentUser() == null);
    }
    
    @Test
    public void addNewUser1() {
        logic.addNewUser("a", "a");
        assertTrue(logic.getUserlist().size() == 1);
    }
    
    @Test
    public void addNewUser2() {
        logic.addNewUser("a", "a");
        assertTrue(logic.addNewUser("a", "b") == false);
    }
    
    @Test
    public void addNewUser3() {
        assertTrue(logic.addNewUser("", "a") == false);
    }
    
    @Test
    public void addNewUser4() {
        assertTrue(logic.addNewUser("a", "") == false);
    }
    
    @Test
    public void addNewUser5() {
        assertTrue(logic.addNewUser("a;", "a") == false);
    }
    
    @Test
    public void addNewUser6() {
        assertTrue(logic.addNewUser("a", ";a") == false);
    }
    
    @Test
    public void addNewUser7() {
        logic.addNewUser("a", "a");
        logic.addNewUser("a", "b");
        assertTrue(logic.addNewUser("a", "b") == false);
    }
    
    @Test
    public void addNewUser8() {
        assertTrue(logic.addNewUser("aaaaaaaaaaaaaaaaaaaaa", "a") == false);
    }
    
    @Test
    public void addNewUser9() {
        assertTrue(logic.addNewUser("a", "aaaaaaaaaaaaaaaaaaaaa") == false);
    }
    
    @Test
    public void login1() {
        logic.addNewUser("a", "a");
        assertTrue(logic.login("a", "a"));
    }
    
    @Test
    public void currentUser2() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.currentUser().getName().equals("a"));
    }
    
    @Test
    public void login2() {
        logic.addNewUser("a", "a");
        assertTrue(logic.login("a", "b") == false);
    }
    
    @Test
    public void login3() {
        logic.addNewUser("a", "a");
        assertTrue(logic.login("b", "a") == false);
    }
    
    @Test
    public void logout() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.logout();
        assertTrue(logic.currentUser() == null);
    }
    
    @Test
    public void newChara1() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        assertTrue(logic.currentUser().getCharas().size() == 1);
    }
    
    @Test
    public void newChara2() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newChara("") == null);
    }
    
    @Test
    public void newChara3() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newChara("a;") == null);
    }
    
    @Test
    public void newChara4() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newChara("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").getName().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void newSettle1() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        assertTrue(logic.currentUser().getSettles().size() == 1);
    }
    
    @Test
    public void newSettle2() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newSettle("") == null);
    }
    
    @Test
    public void newSettle3() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newSettle("a;") == null);
    }
    
    @Test
    public void newSettle4() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        assertTrue(logic.newSettle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").getName().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void modifyCharaName1() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        assertTrue(logic.modifyCharaName("a", "b"));
    }
    
    @Test
    public void modifyCharaName2() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        assertTrue(logic.modifyCharaName("a", "a"));
    }
    
    @Test
    public void modifyCharaName3() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        logic.modifyCharaName("a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(logic.currentUser().findChara("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") != null);
    }
    
    @Test
    public void modifyCharaName4() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        assertTrue(logic.modifyCharaName("a", "a;") == false);
    }
    
    @Test
    public void modifyCharaName5() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        assertTrue(logic.modifyCharaName("b", "c") == false);
    }
    
    @Test
    public void modifyCharaName6() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newChara("a");
        logic.newChara("b");
        assertTrue(logic.modifyCharaName("b", "a") == false);
    }
    
    @Test
    public void modifySettleName1() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        assertTrue(logic.modifySettleName("a", "b"));
    }
    
    @Test
    public void modifySettleName2() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        assertTrue(logic.modifySettleName("a", "a"));
    }
    
    @Test
    public void modifySettleName3() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        logic.modifySettleName("a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(logic.currentUser().findSettle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") != null);
    }
    
    @Test
    public void modifySettleName4() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        assertTrue(logic.modifySettleName("a", "a;") == false);
    }
    
    @Test
    public void modifySettleName5() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        assertTrue(logic.modifySettleName("b", "c") == false);
    }
    
    @Test
    public void modifySettleName6() {
        logic.addNewUser("a", "a");
        logic.login("a", "a");
        logic.newSettle("a");
        logic.newSettle("b");
        assertTrue(logic.modifySettleName("b", "a") == false);
    }
    
    @Test
    public void modifyChara1() {
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("a", 0);
        logic.modifyChara(chara, "", "", "", "", "");
        assertTrue(chara.getAbility().equals(" "));
    }
    
    @Test
    public void modifyChara2() {
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("a", 0);
        logic.modifyChara(chara, "a", "a", "a", "a", "a");
        assertTrue(chara.getAbility().equals("a"));
    }
    
    @Test
    public void modifyChara3() {
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("a", 0);
        logic.modifyChara(chara, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(chara.getAbility().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void modifySettle1() {
        Settlement settle = new Settlement("a", 0);
        logic.modifySettle(settle, "", "", "", "", "");
        assertTrue(settle.getCulture().equals(" "));
    }
    
    @Test
    public void modifySettle2() {
        Settlement settle = new Settlement("a", 0);
        logic.modifySettle(settle, "a", "a", "a", "a", "a");
        assertTrue(settle.getCulture().equals("a"));
    }
    
    @Test
    public void modifySettle3() {
        Settlement settle = new Settlement("a", 0);
        logic.modifySettle(settle, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertTrue(settle.getCulture().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
