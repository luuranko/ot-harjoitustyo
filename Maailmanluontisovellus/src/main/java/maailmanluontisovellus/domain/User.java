/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author halauri
 */
public class User {
    private int id;
    private String name;
    private String password;
    private ArrayList<Character> charas;
    private ArrayList<Settlement> settles;
    private HashMap<String, Integer> charaIdFinder;
    private HashMap<String, Integer> settleIdFinder;
    
    public User(String name, String password, int id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.charas = new ArrayList<>();
        this.settles = new ArrayList<>();
        this.charaIdFinder = new HashMap<>();
        this.settleIdFinder = new HashMap<>();
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
    
    /**
     * Adds a new character to the user's character list
     * if there is no other character by that name yet.
     * @param name  The name of the character submitted by the user
     * @return Returns the boolean on if character creation was successful
     */
    public boolean addChara(String name) {
        boolean okay = true;
        for (int i = 0; i < charas.size(); i++) {
            if (charas.get(i).getName().equals(name)) {
                okay = false;
            }
        }
        if (okay)  {
            int id = charas.size();
            this.charas.add(new Character(name, id));
            this.charaIdFinder.put(name, id);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Adds a new settlement to the user's settlement list
     * if there is no other settlement by that name yet.
     * @param name  The name of the settlement submitted by the user
     * @return Returns the boolean on if settlement creation was successful
     */
    public boolean addSettle(String name) {
        boolean okay = true;
        for (int i = 0; i < settles.size(); i++) {
            if (settles.get(i).getName().equals(name)) {
                okay = false;
            }
        }
        if (okay)  {
            int id = settles.size();
            this.settles.add(new Settlement(name, id));
            this.settleIdFinder.put(name, id);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns the Character with the same name as in the parameter
     * @param name  The name of the character
     * @return Character
     */
    public Character findChara(String name) {
        if (!charaIdFinder.containsKey(name)) {
            return null;
        }
        int id = charaIdFinder.get(name);
        return charas.get(id);
    }
    
    /**
     * Returns the Settlement with the same name as in the parameter
     * @param name  The name of the settlement
     * @return Settlement
     */
    public Settlement findSettle(String name) {
        if (!settleIdFinder.containsKey(name)) {
            return null;
        }
        int id = settleIdFinder.get(name);
        return settles.get(id);
    }
    
    /**
     * Updates the character's name change in the finder
     * that is used for finding Characters by name.
     * @param oldName   The previous name of the character
     * @param newName   The new name for the character
     */
    public void replaceCharaName(String oldName, String newName) {
        int i = charaIdFinder.get(oldName);
        charaIdFinder.remove(oldName);
        charaIdFinder.put(newName, i);
    }
    
    /**
     * Updates the settlement's name change in the finder
     * that is used for finding Settlements by name.
     * @param oldName   The settlement's previous name
     * @param newName   The new name for the settlement
     */
    public void replaceSettleName(String oldName, String newName) {
        int i = settleIdFinder.get(oldName);
        settleIdFinder.remove(oldName);
        settleIdFinder.put(newName, i);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    
    
    
}
