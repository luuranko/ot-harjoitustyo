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
        //shortcut user account for faster manual testing
        this.currentUser = new User("testi", "testi", 0);
        this.userlist.add(currentUser);
    }
    
    public User currentUser() {
        return currentUser;
    }
    
    public boolean addNewUser(String name, String password) {
        boolean okay = true;
        for (int i =0; i < userlist.size(); i++){
            if (userlist.get(i).getName().equals(name)){
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
        for (int i =0; i < userlist.size(); i++){
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
    
    
}
