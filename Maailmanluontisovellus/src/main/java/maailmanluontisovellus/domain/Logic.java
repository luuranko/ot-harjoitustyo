
package maailmanluontisovellus.domain;

import java.util.ArrayList;


public class Logic {
    private ArrayList<User> userlist;
    private User currentUser;
    
    public Logic() {
        this.userlist = new ArrayList<>();
    }
    
    /**
     * Returns the user that is currently logged in
     * @return Logged-in user
     */
    public User currentUser() {
        return currentUser;
    }
    
    /**
     * Adds a new user to the list
     * if there is no user with the same username yet
     * and if neither the username nor the password are empty.
     * @param name  Username submitted by the user
     * @param password  Password submitted by the user
     * @return Returns the boolean on if creating a new user succeeded
     */
    public boolean addNewUser(String name, String password) {
        boolean okay = true;
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getName().equals(name)) {
                okay = false;
            } 
        }
         if (name.isEmpty() || password.isEmpty()) {
            okay = false;
        }
        if (okay) {
            userlist.add(new User(name, password, userlist.size()));
        } 
        return okay;
    }
    
    /**
     * Logs the user in if a user by that name exists
     * and the password is correct.
     * @param name  Username submitted by the user
     * @param password  Password submitted by the user
     * @return Returns the boolean on if login succeeded
     */
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
    
    /**
     * Logs the user out by resetting the current user.
     */
    public void logout() {
        currentUser = null;
    }
    
    /**
     * Creates a new character for the logged-in user.
     * @param name  The name for the character submitted by the user
     * @return Returns the boolean on if creating the character succeeded
     */
    public boolean newChara(String name) {
        if (name.isEmpty()) {
            return false;
        } else {
            boolean success = currentUser.addChara(name);
            return success;
        }   
    }
    
    /**
     * Creates a new settlement for the logged-in user.
     * @param name  The name for the settlement submitted by the user
     * @return Returns the boolean on if creating the settlement succeeded
     */
    public boolean newSettle(String name) {
        if (name.isEmpty()) {
            return false;
        } else {
            boolean success = currentUser.addSettle(name);
            return success;
        }   
    }
    
    /**
     * Changes the character's name to another in the data.
     * @param oldName   The character's previous name
     * @param newName   The new name for the character
     * @return Returns the boolean on if replacing the name succeeded
     */
    public boolean modifyCharaName(String oldName, String newName) {
        if (currentUser.findChara(newName) == null && currentUser.findChara(oldName) != null) {
            currentUser.findChara(oldName).setName(newName);
            currentUser.replaceCharaName(oldName, newName);
            return true;
        } else if (oldName.equals(newName)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Changes the settlement's name to another in the data.
     * @param oldName   The settlement's previous name
     * @param newName   The new name for the settlement
     * @return Returns the boolean on if replacing the name succeeded
     */
    public boolean modifySettleName(String oldName, String newName) {
        if (currentUser.findSettle(newName) == null && currentUser.findSettle(oldName) != null) {
            currentUser.findSettle(oldName).setName(newName);
            currentUser.replaceSettleName(oldName, newName);
            return true;
        } else if (oldName.equals(newName)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Changes the saved info for the character except for its name.
     * @param characterName The name of the character to be modified
     * @param appearance    The character's appearance submitted by the user
     * @param personality   The character's personality submitted by the user
     * @param goal  The character's goal submitted by the user
     * @param ability   The character's ability submitted by the user
     * @param weakness  The character's weakness submitted by the user
     */
    public void modifyChara(String characterName, String appearance, String personality, String goal, String ability, String weakness) {
        currentUser.findChara(characterName).setAppearance(appearance);
        currentUser.findChara(characterName).setPersonality(personality);
        currentUser.findChara(characterName).setGoal(goal);
        currentUser.findChara(characterName).setAbility(ability);
        currentUser.findChara(characterName).setWeakness(weakness);
    }
    
    /**
     * Changes the saved info for the settlement except for its name.
     * @param settleName    The name of the settlement to be modified
     * @param description   The description submitted by the user
     * @param population    The population submitted by the user
     * @param government    The government submitted by the user
     * @param culture   The culture submitted by the user
     * @param geography The geography submitted by the user
     */
    public void modifySettle(String settleName, String description, String population, String government, String culture, String geography) {
        currentUser.findSettle(settleName).setDescrip(description);
        currentUser.findSettle(settleName).setPopulation(population);
        currentUser.findSettle(settleName).setGovern(government);
        currentUser.findSettle(settleName).setCulture(culture);
        currentUser.findSettle(settleName).setGeography(geography);
    }
    
    
}
