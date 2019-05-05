package maailmanluontisovellus.domain;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String password;
    private ArrayList<Character> charas;
    private ArrayList<Settlement> settles;
    
    public User(String name, String password, int id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.charas = new ArrayList<>();
        this.settles = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }
    
    public int getId() {
        return id;
    }

    public ArrayList<Character> getCharas() {
        return charas;
    }

    public ArrayList<Settlement> getSettles() {
        return settles;
    }
    
    public void setCharas(ArrayList charalist) {
        if (charalist == null) {
            charalist = new ArrayList<>();
        }
        this.charas = charalist;
    }
    
    public void setSettles(ArrayList settlelist) {
        if (settlelist == null) {
            settlelist = new ArrayList<>();
        }
        this.settles = settlelist;
    }
    
    /**
     * Adds a new character to the user's character list
     * if there is no other character by that name yet.
     * @param name  The name of the character submitted by the user
     * @return Returns the created Character, or null if not successful
     */
    public Character addChara(String name) {
        boolean okay = true;
        for (int i = 0; i < charas.size(); i++) {
            if (charas.get(i).getName().equals(name)) {
                okay = false;
            }
        }
        if (okay)  {
            int id = charas.size();
            Character chara = new Character(name, id);
            this.charas.add(chara);
            return chara;
        } else {
            return null;
        }
    }
    
    /**
     * Adds a new settlement to the user's settlement list
     * if there is no other settlement by that name yet.
     * @param name  The name of the settlement submitted by the user
     * @return Returns the created Settlement, or null if not successful
     */
    public Settlement addSettle(String name) {
        boolean okay = true;
        for (int i = 0; i < settles.size(); i++) {
            if (settles.get(i).getName().equals(name)) {
                okay = false;
            }
        }
        if (okay)  {
            int id = settles.size();
            Settlement settle = new Settlement(name, id);
            this.settles.add(settle);
            return settle;
        } else {
            return null;
        }
    }
    
    /**
     * Returns the Character with the same name as in the parameter
     * @param name  The name of the character
     * @return Character
     */
    public Character findChara(String name) {
        for (Character chara : charas) {
            if (chara.getName().equals(name)) {
                return chara;
            }
        }
        return null;
    }
    
    /**
     * Returns the Settlement with the same name as in the parameter
     * @param name  The name of the settlement
     * @return Settlement
     */
    public Settlement findSettle(String name) {
        for (Settlement settle: settles) {
            if (settle.getName().equals(name)) {
                return settle;
            }
        }
        return null;
    } 
}
