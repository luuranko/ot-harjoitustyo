/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanluontisovellus.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author halauri
 */
public class User {
    private String name;
    private String password;
    private ArrayList<Character> charas;
    private ArrayList<Settlement> settles;
    
    public User(String name, String password) {
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

    public ArrayList<Character> getCharas() {
        return charas;
    }

    public ArrayList<Settlement> getSettles() {
        return settles;
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
