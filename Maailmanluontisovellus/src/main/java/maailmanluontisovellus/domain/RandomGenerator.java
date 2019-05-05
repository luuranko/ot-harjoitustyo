package maailmanluontisovellus.domain;

import java.util.Random;

public class RandomGenerator {
    private Random random;
    
    public RandomGenerator() {
        this.random = new Random();
    }
    
    /**
     * Generates a random appearance, e.g. "round and blue"
     * @return The generated appearance as a String
     */
    public String appearance() {

        String[] shapes = {
            "short", "petite", "muscular", "lanky", "fat", "round",
            "slim", "tall", "tiny", "huge", "fit", "thick", "skinny"
        };
        
        String[] colors = {
            "black", "blue", "purple", "red", "orange", "yellow",
            "green", "white", "grey", "brown", "golden", "silver",
            "teal", "pink"
        };

        int shape = random.nextInt(shapes.length);
        int color = random.nextInt(colors.length);

        String appearance = shapes[shape] + " and " + colors[color];

        return appearance;
    }
    
    /**
     * Generates a random personality, e.g. "serious and modest"
     * @return The generated personality as a String
     */
    public String personality() {
        
        String[] traits = {
            "loud", "quiet", "nervous", "brave", "cheerful", "gentle", "grumpy",
            "depressed", "greedy", "lazy", "obsessed", "serious", "emotional", "blunt",
            "stubborn", "energetic", "dishonest", "unbothered", "loyal", "mischievous",
            "mean", "proud", "sensitive", "nosy", "compassionate", "modest",
            "helpful", "ambitious", "erratic", "reserved", "open", "manipulative"
        };
        
        int trait = random.nextInt(traits.length);
        int trait2 = random.nextInt(traits.length);
        
        String personality = traits[trait] + " and " + traits[trait2];
        
        return personality;
    }
    
    /**
     * Generates a random goal, e.g. "power"
     * @return The generated goal as a String
     */
    public String goal() {
        
        String[] wants = {
            "peace", "love", "fame", "power", "riches", "revenge",
            "redemption", "chaos", "entertainment", "order", "food", "self-healing",
            "a moment of peace", "keeping a promise", "friends", "a home", "knowledge", "strength",
            "family", "discovery", "adventure", "popularity", "peace of mind", "fulfilling a destiny",
            "impressing someone", "self-improvement", "continuing a legacy", "making others smile"
        };
        
        int want = random.nextInt(wants.length);
        
        String goal = wants[want];
        
        return goal;
    }
    
    /**
     * Generates two random abilities, e.g. "cooking and gardening"
     * @return The generated abilities as a String
     */
    public String ability() {
        
        String[] talents = {
            "medicine", "cooking", "martial arts", "arcane powers", "magic items", "diplomacy",
            "history", "sneaking", "leadership", "hunting", "navigation", "art",
            "music", "crafting", "building", "spiritual powers", "persuading", "performing",
            "math", "divine powers", "archery", "dueling", "weaving", "gardening",
            "fishing", "mobility", "animal caretaking", "perception", "writing", "endurance",
            "connections", "feral powers"
        };
        
        int talent = random.nextInt(talents.length);
        int talent2 = random.nextInt(talents.length);
        
        String ability = talents[talent] + " and " + talents[talent2];
        
        return ability;
    }
    
    /**
     * Generates a random weakness, e.g. "procrastinator"
     * @return The generated weakness as a String
     */
    public String weakness() {
        
        String[] flaws = {
            "frail", "clumsy", "prejudiced", "overconfident", "allergic to something common", "dull-witted",
            "unaware of surroundings", "cursed", "unlucky", "doormat", "easily provoked", "easily distracted",
            "phobic of something common", "easily intimidated", "bad speaker", "no common sense", "sickly", "overworks self to exhaustion",
            "addict", "gambler", "gullible", "irresponsible", "antisocial", "debilitating injury",
            "the blade of evil's bane", "impatient", "the full moon", "terrible liar", "accidentally rude", "the power of friendship",
            "always hungry", "always tired", "bad hygiene", "procrastinator", "group projects"
        };
        
        int flaw = random.nextInt(flaws.length);
        
        String weakness = flaws[flaw];
        
        return weakness;
    }
    
    /**
     * Generates a random settlement description, e.g. "recently founded"
     * @return The generated description as a String
     */
    public String description() {
        
        String[] traits = {
            "has walls", "has a school of magic", "has catacombs", "has a huge tree", "has barracks", "has a research center",
            "has a den of criminals", "has very high buildings", "used to be a military fortress", "ancient", "recently founded"
        };
        
        int trait = random.nextInt(traits.length);
        
        String description = traits[trait];
        
        return description;
    }
    
    /**
     * Generates a random population description, e.g. "huge city"
     * @return The generated population as a String
     */
    public String population() {
        
        String[] traits = {
            "diverse", "conforming", "village", "small town", "big town", "city",
            "huge city", "hamlet"
        };
        
        int trait = random.nextInt(traits.length);
        
        String population = traits[trait];
        
        return population;
    }
    
    /**
     * Generates a random government style or leader, e.g. "democratically elected"
     * @return The generated government as a String
     */
    public String government() {
        
        String[] leaders = {
            "a royal", "a noble family", "merchants", "a religion", "a cult", "a council",
            "an elder", "a military", "a mage", "a supernatural being", "aliens", "democratically elected",
            "the strongest warrior"
        };
        
        int leader = random.nextInt(leaders.length);
        
        String government = leaders[leader];
        
        return government;
    }
    
    /**
     * Generates a random culture description, e.g. "agricultural"
     * @return The generated culture as a String
     */
    public String culture() {
        
        String[] traits = {
            "religious", "mercantile", "militaristic", "agricultural", "peaceful", "closed-off",
            "welcoming", "cut-throat", "artistic"
        };
        
        int trait = random.nextInt(traits.length);
        
        String culture = traits[trait];
        
        return culture;
    }
    
    /**
     * Generates a random geographical description, e.g. "next to a forest"
     * @return The generated geography as a String
     */
    public String geography() {
        
        String[] terrains = {
            "coastal", "on a mountain", "next to a lake", "divided by a river", "on an island", "very hot climate",
            "very cold climate", "arid climate", "humid climate", "underground", "in a forest", "next to a forest",
            "in a desert", "next to a volcano", "in the sky", "on a ship", "underwater"
        };
        
        int terrain = random.nextInt(terrains.length);
        
        String geography = terrains[terrain];
        
        return geography;
    }
    
}
