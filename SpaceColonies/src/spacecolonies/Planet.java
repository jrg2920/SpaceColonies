/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          Planet class that implements comparable
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkill;
    private Person[] population;
    private int populationSize;
    private int capacity;


    /**
     * A planet constructor with five parameters
     * 
     * @param planetName
     *            name of the planet
     * @param planetAgri
     *            Agricultural value for the planet
     * @param planetMedi
     *            Medicinal value for the planet
     * @param planetTech
     *            technological value for the planet
     * @param planetCap
     *            capacity for the planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        this.name = planetName;
        this.minSkill = new Skills(planetAgri, planetMedi, planetTech);
        this.population = new Person[planetCap];
        this.capacity = planetCap;
        this.populationSize = 0;
    }


    /**
     * A setter for the planet name
     * 
     * @param planetName
     *            name of the planet
     */
    public void setName(String planetName) {
        this.name = planetName;
    }


    /**
     * a getter for the planet name
     * 
     * @return name of the planet
     */
    public String getName() {
        return name;
    }


    /**
     * getter for the skills
     * 
     * @return the minimum skills required
     */
    public Skills getSkills() {
        return minSkill;
    }


    /**
     * getter for the population
     * 
     * @return the population array
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * a getter for the population size
     * 
     * @return the size of the population
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * a getter for the capacity of the planet
     * 
     * @return the capacity for the planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * a getter for the availability for the planet
     * 
     * @return the availability for the planet
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * checks if the planet is full
     * 
     * @return true if the planet is full
     */
    public boolean isFull() {
        return populationSize == capacity;
    }


    /**
     * checks if the person is qualified for a planet
     * 
     * @param person
     *            the person who is getting checked
     * @return true if all the requirements are met
     */
    public boolean isQualified(Person person) {
        return this.getSkills().isBelow(person.getSkills());
    }


    /**
     * adds the person on the planet
     * 
     * @param newbie
     *            a new person who might be added on the planet
     * @return true if the person is added
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * to_string method for the string representation of planet
     * 
     * @return the string version of the planet
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ", ");
        builder.append("population " + getPopulationSize() + " (cap: "
            + getCapacity() + ")");
        builder.append(", Requires: A>=" + minSkill.getAgriculture() + ", M>="
            + minSkill.getMedicine() + ", T>=" + minSkill.getTechnology()
            + ")");
        return builder.toString();
    }


    /**
     * compares two planets based on the availibility
     * 
     * @return integers based on cases
     */
    @Override
    public int compareTo(Planet other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }

        return this.getAvailability() - other.getAvailability();
    }


    /**
     * equals method for planet
     * 
     * @param obj
     *            of type Object
     * @return true if two planets are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Planet planet = (Planet)obj;
            return this.getSkills().equals(planet.getSkills()) && this.getName()
                .equals(planet.getName()) && this.getCapacity() == planet
                    .getCapacity() && this.getPopulationSize() == planet
                        .getPopulationSize();
        }
        return false;
    }
}
