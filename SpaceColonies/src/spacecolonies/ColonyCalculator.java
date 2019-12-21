/**
 * 
 */
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          A class where all the colony calculation is done
 */
public class ColonyCalculator {
    /**
     * number of planets in the colony
     */
    public static final int NUM_PLANETS = 3;
    /**
     * minimum number of skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * maximum number of skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * a constructor for ColonyCalculator
     * 
     * @param person
     *            an arrayQueue of people
     * @param planet
     *            an array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> person, Planet[] planet) {
        if (person == null) {
            throw new IllegalArgumentException("the queue is empty");
        }
        rejectBus = new AList<Person>();
        this.applicantQueue = person;
        ColonyCalculator.planets = planet;
    }


    /**
     * a getter for the queue for people
     * 
     * @return the queue for the applicants
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * a getter for the planets
     * 
     * @return the array for the planets
     */
    public static Planet[] getPlanets() {
        return ColonyCalculator.planets;
    }


    /**
     * a person's preferred planet is decided
     * 
     * @param person
     *            who has preferred planet
     * @param number
     *            the index of the Planets array
     * @return the planet which can be preferred by the person
     */
    private Planet getPreferredPlanet(Person person, int number) {

        if (number != 0 && ColonyCalculator.planets[number].isQualified(
            person)) {
            return ColonyCalculator.planets[number];

        }
        return null;
    }


    /**
     * calculates the most available planet in the colony
     * 
     * @param person
     *            who is getting added on the planet
     * @return the planet on which a person is getting added
     */
    private Planet getMostAvailablePlanet(Person person) {
        Planet[] planet = Arrays.copyOfRange(planets, 1, planets.length);
        Arrays.sort(planet);
        for (int x = planet.length - 1; x > 0; x--) {
            if (planet[x].isQualified(person) && !planet[x].isFull()) {
                return planetByNumber(getPlanetIndex(planet[x].getName()));
            }
        }
        return null;
    }


    /**
     * getter for the planet
     * 
     * @param nextPerson
     *            who is qualified for a particular planet
     * @return the planet which has space for the person
     */
    public Planet getPlanetForPerson(Person nextPerson) {

        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        int i = getPlanetIndex(nextPerson.getPlanetName());
        if (i == 0) {
            return getMostAvailablePlanet(nextPerson);
        }
        return getPreferredPlanet(nextPerson, i);

    }


    /**
     * a method to accept the person on the planet
     * 
     * @return true if the person is qualified
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person firstPerson = applicantQueue.getFront();
            Planet preferredPlanet = getPlanetForPerson(firstPerson);
            if (preferredPlanet != null && preferredPlanet.addPerson(
                firstPerson)) {
                applicantQueue.dequeue();
                return true;
            }
        }
        return false;
    }


    /**
     * a method to reject a person if they are not qualified
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * a method to arrange planets by number
     * 
     * @param planet
     *            number of planets
     * @return the array of the planet
     */
    public Planet planetByNumber(int planet) {
        if (planet >= 1 && planet < ColonyCalculator.NUM_PLANETS + 1) {
            return ColonyCalculator.planets[planet];
        }
        return null;
    }


    /**
     * a method to get the index of the planet
     * 
     * @param planet
     *            to get the index of
     * @return the index of the planet
     */
    public int getPlanetIndex(String planet) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return 0;
    }
}
