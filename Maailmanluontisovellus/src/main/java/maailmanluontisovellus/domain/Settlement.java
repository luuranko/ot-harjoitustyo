package maailmanluontisovellus.domain;

public class Settlement implements Comparable<Settlement> {
    private int id;
    private String name;
    private String descrip;
    private String population;
    private String govern;
    private String culture;
    private String geography;
    
    public Settlement(String name, int id) {
        this.name = name;
        this.id = id;
        descrip = " ";
        population = " ";
        govern = " ";
        culture = " ";
        geography = " ";
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        if (descrip.isEmpty()) {
            descrip = " ";
        }
        if (descrip.length() > 50) {
            String d = descrip.substring(0, 50);
            descrip = d;
        }
        this.descrip = descrip;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        if (population.isEmpty()) {
            population = " ";
        }
        if (population.length() > 50) {
            String p = population.substring(0, 50);
            population = p;
        }
        this.population = population;
    }

    public String getGovern() {
        return govern;
    }

    public void setGovern(String govern) {
        if (govern.isEmpty()) {
            govern = " ";
        }
        if (govern.length() > 50) {
            String g = govern.substring(0, 50);
            govern = g;
        }
        this.govern = govern;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        if (culture.isEmpty()) {
            culture = " ";
        }
        if (culture.length() > 50) {
            String c = culture.substring(0, 50);
            culture = c;
        }
        this.culture = culture;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        if (geography.isEmpty()) {
            geography = " ";
        }
        if (geography.length() > 50) {
            String g = geography.substring(0, 50);
            geography = g;
        }
        this.geography = geography;
    }
    
    /**
     * Calls the setters for all features except name and id.
     * @param description
     * @param population
     * @param government
     * @param culture
     * @param geography 
     */
    public void massModify(String description, String population, String government, String culture, String geography) {
        setDescrip(description);
        setPopulation(population);
        setGovern(government);
        setCulture(culture);
        setGeography(geography);
    }

    @Override
    public int compareTo(Settlement s) {
        String own = this.name.toUpperCase();
        String other = s.getName().toUpperCase();
        return own.compareTo(other);
    }
    
    
}
