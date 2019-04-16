/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.domain;

import java.util.ArrayList;

/**
 *
 * @author halauri
 */
public class Logic {
    private ArrayList<User> userlist;
    private User currentUser;
    
    public Logic() {
        this.userlist = new ArrayList<>();
    }
    
    public User currentUser() {
        return currentUser;
    }
    
    public boolean addNewUser(String name, String password) {
        boolean okay = true;
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getName().equals(name)) {
                okay = false;
            } 
        }
        if (name.isEmpty()) {
            okay = false;
        }
        if (password.isEmpty()) {
            okay = false;
        }
        if (okay == false) {
            return false;
        } else {
            userlist.add(new User(name, password, userlist.size()));
            return true;
        }
    }
    
    public boolean login(String name, String password) {
        boolean okay = false;
        int loginId = 0;
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getName().equals(name) && userlist.get(i).getPassword().equals(password)) {
                okay = true;
                loginId = userlist.get(i).getId();
            }
        }
        if (okay) {
            currentUser = userlist.get(loginId);
            return true;
        } else {
            return false;
        }
    }
    
    public void logout() {
        currentUser = null;
    }
    
    public boolean newChara(String name) {
        if (name.isEmpty()) {
            return false;
        } else {
            boolean success = currentUser.addChara(name);
            return success;
        }   
    }
    
    public boolean newSettle(String name) {
        if (name.isEmpty()) {
            return false;
        } else {
            boolean success = currentUser.addSettle(name);
            return success;
        }   
    }
    
    public boolean modifyCharaName(String oldName, String newName) {
        if (currentUser.findChara(newName) == null && currentUser.findChara(oldName) != null) {
            currentUser.findChara(oldName).setName(newName);
            currentUser.replaceCharaName(oldName, newName);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean modifySettleName(String oldName, String newName) {
        if (currentUser.findSettle(newName) == null && currentUser.findSettle(oldName) != null) {
            currentUser.findSettle(oldName).setName(newName);
            currentUser.replaceSettleName(oldName, newName);
            return true;
        } else {
            return false;
        }
    }
    
    public void modifyChara(String characterName, String appearance, String personality, String goal, String ability, String weakness) {
        currentUser.findChara(characterName).setAppearance(appearance);
        currentUser.findChara(characterName).setPersonality(personality);
        currentUser.findChara(characterName).setGoal(goal);
        currentUser.findChara(characterName).setAbility(ability);
        currentUser.findChara(characterName).setWeakness(weakness);
    }
    
    public void modifySettle(String settleName, String description, String population, String government, String culture, String geography) {
        currentUser.findSettle(settleName).setDescrip(description);
        currentUser.findSettle(settleName).setPopulation(population);
        currentUser.findSettle(settleName).setGovern(government);
        currentUser.findSettle(settleName).setCulture(culture);
        currentUser.findSettle(settleName).setGeography(geography);
    }
    
    
}
