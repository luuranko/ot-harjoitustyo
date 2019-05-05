package maailmanluontisovellus.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class FileHandler {
    private String users;
    private String charas;
    private String settles;
    private ArrayList<User> userlist;
    private HashMap<User, ArrayList<Character>> charalist;
    private HashMap<User, ArrayList<Settlement>> settlelist;
    
    public FileHandler(String users, String charas, String settles) {
        this.users = users;
        this.charas = charas;
        this.settles = settles;
        this.userlist = new ArrayList<>();
        this.charalist = new HashMap<>();
        this.settlelist = new HashMap<>();
    }
    
    /**
     * Handles reading all the files during startup.
     * @throws IOException 
     */
    public void init() throws IOException {
        readUsers(users);
        readCharas(charas);
        readSettles(settles);
    }
    
    /**
     * Reads the User file and records its data or creates the file if it doesn't exist.
     * @param file
     * @throws IOException 
     */
    public void readUsers(String file) throws IOException {
        this.userlist = new ArrayList<>();
        this.users = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                if (parts.length > 0) {
                    User user = new User(parts[0], parts[1], Integer.parseInt(parts[2]));
                    userlist.add(user);
                    charalist.put(user, new ArrayList<>());
                    settlelist.put(user, new ArrayList<>());
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            FileWriter writer = new FileWriter(new File(file));
        }
    }
    
    /**
     * Reads the Character file and records its data or creates the file if it doesn't exist.
     * @param file
     * @throws IOException 
     */
    public void readCharas(String file) throws IOException {
        this.charalist = new HashMap<>();
        this.charas = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User user = userlist.stream().filter(u->u.getName().equals(parts[0])).findFirst().orElse(null);
                maailmanluontisovellus.domain.Character chara = new maailmanluontisovellus.domain.Character(parts[2], Integer.parseInt(parts[1]));
                chara.massModify(parts[3], parts[4], parts[5], parts[6], parts[7]);
                if (charalist.containsKey(user) == false) {
                    charalist.put(user, new ArrayList<>());
                }
                charalist.get(user).add(chara);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            FileWriter writer = new FileWriter(new File(file));
        }
    }
    
    /**
     * Reads the Settlement file and records its data or creates the file if it doesn't exist.
     * @param file
     * @throws IOException 
     */
    public void readSettles(String file) throws IOException {
        this.settlelist = new HashMap<>();
        this.settles = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User user = userlist.stream().filter(u->u.getName().equals(parts[0])).findFirst().orElse(null);
                Settlement settle = new Settlement(parts[2], Integer.parseInt(parts[1]));
                settle.massModify(parts[3], parts[4], parts[5], parts[6], parts[7]);
                if (settlelist.containsKey(user) == false) {
                    settlelist.put(user, new ArrayList<>());
                }
                settlelist.get(user).add(settle);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            FileWriter writer = new FileWriter(new File(file));
        }
    }
    
    public ArrayList<User> getUserlist() {
        return userlist;
    }
    
    /**
     * Sets the list of Users as the list in the parameter.
     * @param users 
     */
    public void setUserlist(ArrayList users) {
        this.userlist = users;
    }
    
    /**
     * Returns the specified User's Characters as an ArrayList.
     * @param user
     * @return 
     */
    public ArrayList<Character> getCharas(User user) {
        if (charalist.containsKey(user)) {
            return charalist.get(user);
        } else {
            return null;
        }
    }
    
    /**
     * Returns the specified User's Settlements as an ArrayList.
     * @param user
     * @return 
     */
    public ArrayList<Settlement> getSettles(User user) {
        if (settlelist.containsKey(user)) {
            return settlelist.get(user);
        } else {
            return null;
        }
    }
    
    /**
     * Writes the Users into the User file.
     * @throws Exception 
     */
    public void saveUsers() throws Exception {
        try (FileWriter writer = new FileWriter(new File(users))) {
            for (User user : userlist) {
                writer.write(user.getName() + ";" + user.getPassword() + ";" + user.getId() + "\n");
            }
        } 
    }
    
    /**
     * Writes the Characters into the Character file.
     * @throws Exception 
     */
    public void saveCharas() throws Exception {
        try (FileWriter writer = new FileWriter(new File(charas))) {
            for (User user: userlist) {
                if (charalist.get(user) != null) {
                    for (Character chara : charalist.get(user)) {
                        writer.write(user.getName() + ";" + chara.getId() + ";" + chara.getName() + ";" + chara.getAppearance() + ";" + chara.getPersonality() + ";" + chara.getGoal() + ";" + chara.getAbility() + ";" + chara.getWeakness() + "\n");
                    }
                }
            }
        } 
    }
    
    /**
     * Writes the Settlements into the Settlement file.
     * @throws Exception 
     */
    public void saveSettles() throws Exception {
        try (FileWriter writer = new FileWriter(new File(settles))) {
            for (User user: userlist) {
                if (settlelist.get(user) != null) {
                    for (Settlement settle : settlelist.get(user)) {
                        writer.write(user.getName() + ";" + settle.getId() + ";" + settle.getName() + ";" + settle.getDescrip() + ";" + settle.getPopulation() + ";" + settle.getGovern() + ";" + settle.getCulture() + ";" + settle.getGeography() + "\n");
                    }
                }
            }
        }
    } 
    
    /**
     * Sets the specified User's list of Characters as the list in the parameter.
     * @param user
     * @param list 
     */
    public void setCharalist(User user, ArrayList<Character> list) {
        charalist.put(user, list);
    }
    
    /**
     * Sets the specified User's list of Settlements as the list in the parameter.
     * @param user
     * @param list 
     */
    public void setSettlelist(User user, ArrayList<Settlement> list) {
        settlelist.put(user, list);
    }
    
}
