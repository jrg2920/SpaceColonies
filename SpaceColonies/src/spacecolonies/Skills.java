/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          Skills class which getters
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * A constructor with three parameters
     * 
     * @param ag
     *            agricultural skill
     * @param med
     *            medicinal skill
     * @param tec
     *            technological skill
     */
    public Skills(int ag, int med, int tec) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tec;

    }


    /**
     * a getter for the agriculture
     * 
     * @return agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * a getter for medicine
     * 
     * @return medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * a getter for the technology
     * 
     * @return technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * a method to determine the skill level
     * 
     * @param other
     *            a skill parameter
     * @return true if the skills are below the given
     */
    public boolean isBelow(Skills other) {
        return this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology;
    }


    /**
     * a method to get string representation of skills
     * 
     * @return String version of skills
     */
    public String toString() {
        return "A:" + this.getAgriculture() + " M:" + this.getMedicine() + " T:"
            + this.getTechnology();
    }


    /**
     * equals method for comparing skills
     * 
     * @param obj
     *            of the type Object
     * @return true if the skills are same
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            return (this.agriculture == (((Skills)obj).agriculture))
                && (this.medicine == (((Skills)obj).medicine))
                && (this.technology == (((Skills)obj).technology));
        }
        return false;
    }

}
