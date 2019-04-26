/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import maailmanluontisovellus.domain.*;
/**
 *
 * @author halauri
 */
public class MaailmanluontiTest {
    Logic logic;
    
    @Before
    public void setUp() {
        this.logic = new Logic();
    }
    
    @Test
    public void addNewUser1() {
        boolean correct = true;
        if (logic.addNewUser("", "hey")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void addNewUser2() {
        boolean correct = true;
        if (logic.addNewUser("hey", "")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void addNewUser3() {
        boolean correct = true;
        logic.addNewUser("hey", "hoy");
        if (logic.addNewUser("hey", "hay")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void addNewUser4() {
        boolean correct = true;
        if (logic.addNewUser("hey", "hoy") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void login1() {
        boolean correct = true;
        logic.addNewUser("hey", "hoy");
        if (logic.login("hey", "hoy") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void login2() {
        boolean correct = true;
        logic.addNewUser("hey", "hoy");
        if (logic.login("hey", "hey")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void login3() {
        boolean correct = true;
        logic.addNewUser("hey", "hoy");
        if (logic.login("hoy", "hoy")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void logout() {
        boolean correct = true;
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        logic.logout();
        if (logic.currentUser() != null) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void newChara1() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.newChara("")) {
            correct = false;
        }
        assertTrue(correct); 
    }
    
    @Test
    public void newChara2() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.newChara("Link") ==  false) {
            correct = false;
        }
        assertTrue(correct); 
    }
    
    @Test
    public void newSettle1() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.newSettle("")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void newSettle2() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.newSettle("Castle Town") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser1() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.currentUser().getName().equals("Link") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser2() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.currentUser().getPassword().equals("courage") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser3() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.currentUser().getId() != 0) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser4() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.currentUser().addChara("Lonk") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser5() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addChara("Lonk");
        if (logic.currentUser().addChara("Lonk")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser6() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        if (logic.currentUser().addSettle("Castle Town") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser7() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addSettle("Castle Town");
        if (logic.currentUser().addSettle("Castle Town")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser8() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addChara("Lonk");
        logic.currentUser().addChara("Lanky");
        if (logic.currentUser().findChara("Lanky").equals(new maailmanluontisovellus.domain.Character("Lanky", 0)) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser9() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addSettle("Lonk");
        logic.currentUser().addSettle("Lanky");
        if (logic.currentUser().findSettle("Lanky").equals(new Settlement("Lanky", 0)) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser10() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addChara("Lonk");
        logic.currentUser().addChara("Lanky");
        if (logic.currentUser().getCharas().size() != 2) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void currentUser11() {
        logic.addNewUser("Link", "courage");
        logic.login("Link", "courage");
        boolean correct = true;
        logic.currentUser().addSettle("Lonk");
        logic.currentUser().addSettle("Lanky");
        if (logic.currentUser().getSettles().size() != 2) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void userEquals1() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(user) == false) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void userEquals2() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(null)) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void userEquals3() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(new Settlement("Hyrule", 99))) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void userEquals4() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(new User("Lonk", "courage", 1))) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void userEquals5() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(new User("Link", "power", 1))) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void userEquals6() {
        boolean correct = true;
        
        User user = new User("Link", "courage", 0);
        if (user.equals(new User("Link", "courage", 1)) == false) {
            correct = false;
        }
        
        assertTrue(correct);
    }
    
    @Test
    public void chara1() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        if (chara.getId() != 0) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara2() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setId(99);
        if (chara.getId() != 99) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara3() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setName("Lonk");
        if (chara.getName().equals("Lonk") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara4() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setAbility("brave");
        if (chara.getAbility().equals("brave") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara5() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setAppearance("small");
        if (chara.getAppearance().equals("small") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara6() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setPersonality("silent");
        if (chara.getPersonality().equals("silent") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara7() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setGoal("save world");
        if (chara.getGoal().equals("save world") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void chara8() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        chara.setWeakness("sleepy");
        if (chara.getWeakness().equals("sleepy") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle1() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setId(1);
        if (city.getId() != 1) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle2() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setName("Ruins");
        if (city.getName().equals("Ruins") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle3() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setDescrip("bustling");
        if (city.getDescrip().equals("bustling") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle4() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setPopulation("1000");
        if (city.getPopulation().equals("1000") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle5() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setGovern("monarchy");
        if (city.getGovern().equals("monarchy") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle6() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setCulture("cheery");
        if (city.getCulture().equals("cheery") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settle7() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        city.setGeography("plains");
        if (city.getGeography().equals("plains") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void charaEquals1() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        if (chara.equals(chara) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void charaEquals2() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        if (chara.equals(null)) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void charaEquals3() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        if (chara.equals(new Settlement("Link", 0))) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void charaEquals4() {
        boolean correct = true;
        maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character("Link", 0);
        if (chara.equals(new maailmanluontisovellus.domain.Character("Lonk", 0))) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settleEquals1() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        if (city.equals(city) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settleEquals2() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        if (city.equals(null)) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settleEquals3() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        if (city.equals("")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void settleEquals4() {
        boolean correct = true;
        Settlement city = new Settlement("Castle Town", 0);
        if (city.equals(new Settlement("Lake Town", 0))) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void replaceCharaName1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addChara("Link");
        logic.currentUser().findChara("Link").setAppearance("small");
        logic.currentUser().replaceCharaName("Link", "Lonk");
        if (logic.currentUser().findChara("Lonk").getAppearance().equals("small") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
     @Test
    public void replaceSettleName1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addSettle("Castle Town");
        logic.currentUser().findSettle("Castle Town").setDescrip("bustling");
        logic.currentUser().replaceSettleName("Castle Town", "Ruins");
        if (logic.currentUser().findSettle("Ruins").getDescrip().equals("bustling") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void findChara1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addChara("Link");
        if (logic.currentUser().findChara("Link").equals(new maailmanluontisovellus.domain.Character("Link", 1)) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void findChara2() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        if (logic.currentUser().findChara("Link") == null == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void findSettle1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addSettle("Castle Town");
        if (logic.currentUser().findSettle("Castle Town").equals(new Settlement("Castle Town", 1)) == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void findSettle2() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        if (logic.currentUser().findSettle("Castle Town") == null == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void modifyCharaName1() {
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addChara("Link");
        assertTrue(logic.modifyCharaName("Link", "Link"));
    }
    
    @Test
    public void modifyCharaName2() {
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addChara("Link");
        assertTrue(logic.modifyCharaName("Link", "Lonk"));
    }
    
    @Test
    public void modifyCharaName3() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        if (logic.modifyCharaName("x", "y")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void modifySettleName1() {
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addSettle("Castle Town");
        assertTrue(logic.modifySettleName("Castle Town", "Castle Town"));
    }
    
    @Test
    public void modifySettleName2() {
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addSettle("Castle Town");
        assertTrue(logic.modifySettleName("Castle Town", "Ruins"));
    }
    
    @Test
    public void modifySettleName3() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        if (logic.modifySettleName("x", "y")) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void modifyChara1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addChara("Link");
        logic.modifyChara("Link", "small", "quiet", "victory", "courage", "sleepy");
        if (logic.currentUser().findChara("Link").getName().equals("Link") == false || logic.currentUser().findChara("Link").getAbility().equals("courage") == false || logic.currentUser().findChara("Link").getAppearance().equals("small") == false || logic.currentUser().findChara("Link").getGoal().equals("victory") == false || logic.currentUser().findChara("Link").getPersonality().equals("quiet") == false || logic.currentUser().findChara("Link").getWeakness().equals("sleepy") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
    
    @Test
    public void modifySettle1() {
        boolean correct = true;
        logic.addNewUser("a", "b");
        logic.login("a", "b");
        logic.currentUser().addSettle("Town");
        logic.modifySettle("Town", "d", "p", "g", "c", "geo");
        if (logic.currentUser().findSettle("Town").getCulture().equals("c") == false || logic.currentUser().findSettle("Town").getDescrip().equals("d") == false || logic.currentUser().findSettle("Town").getGeography().equals("geo") == false || logic.currentUser().findSettle("Town").getGovern().equals("g") == false || logic.currentUser().findSettle("Town").getName().equals("Town") == false || logic.currentUser().findSettle("Town").getPopulation().equals("p") == false) {
            correct = false;
        }
        assertTrue(correct);
    }
}
