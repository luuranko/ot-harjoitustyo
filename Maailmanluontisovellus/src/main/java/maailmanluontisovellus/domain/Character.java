package maailmanluontisovellus.domain;

public class Character implements Comparable<Character> {
    private int id;
    private String name;
    private String appearance;
    private String personality;
    private String goal;
    private String ability;
    private String weakness;
    
    
    public Character(String name, int id) {
        this.name = name;
        this.id = id;
        appearance = " ";
        personality = " ";
        goal = " ";
        ability = " ";
        weakness = " ";
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        if (appearance.isEmpty()) {
            appearance = " ";
        }
        if (appearance.length() > 50) {
            String a = appearance.substring(0, 50);
            appearance = a;
        }
        this.appearance = appearance;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        if (personality.isEmpty()) {
            personality = " ";
        }
        if (personality.length() > 50) {
            String p = personality.substring(0, 50);
            personality = p;
        }
        this.personality = personality;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        if (goal.isEmpty()) {
            goal = " ";
        }
        if (goal.length() > 50) {
            String g = goal.substring(0, 50);
            goal = g;
        }
        this.goal = goal;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        if (ability.isEmpty()) {
            ability = " ";
        }
        if (ability.length() > 50) {
            String a = ability.substring(0, 50);
            ability = a;
        }
        this.ability = ability;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        if (weakness.isEmpty()) {
            weakness = " ";
        }
        if (weakness.length() > 50) {
            String w = weakness.substring(0, 50);
            weakness = w;
        }
        this.weakness = weakness;
    }
    
    /**
     * Calls the setters for all the features except name and id.
     * @param appearance
     * @param personality
     * @param goal
     * @param ability
     * @param weakness 
     */
    public void massModify(String appearance, String personality, String goal, String ability, String weakness) {
        setAppearance(appearance);
        setPersonality(personality);
        setGoal(goal);
        setAbility(ability);
        setWeakness(weakness);
    }

    @Override
    public int compareTo(Character c) {
        String own = this.name.toUpperCase();
        String other = c.getName().toUpperCase();
        return own.compareTo(other);
    }
    
    
}
