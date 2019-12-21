/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          Person class with all the methods
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * A constructor with three parameters
     * 
     * @param name
     *            the person's name
     * @param agri
     *            agricultural skills
     * @param medi
     *            medicinal skills
     * @param tech
     *            technological skills
     * @param planet
     *            name of the planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * getter method for the name
     * 
     * @return the name of the person
     */
    public String getName() {
        return name;
    }


    /**
     * getter for the skills
     * 
     * @return the skill type of the person
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * getter for the planet name
     * 
     * @return the planet preferred by the person
     */
    public String getPlanetName() {

        return planetPreference;
    }


    /**
     * String representation of the person
     * 
     * @return String of the type person
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (planetPreference.length() != 0) {
            builder.append(name + " " + skills.toString());
            builder.append(" Wants: " + getPlanetName());
        }
        else {
            builder.append("No-Planet " + name + " " + skills.toString());
        }
        return builder.toString();
    }


    /**
     * checks to see if two persons are equal
     * 
     * @param obj
     *            of type Object
     * @return true if two people are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Person person = (Person)obj;
            return person.getName().equals(this.getName()) && person
                .getPlanetName().equals(this.getPlanetName()) && (person
                    .getSkills().equals(this.getSkills()));
        }
        return false;
    }

}
