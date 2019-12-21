/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          A test class for planet
 */
public class PlanetTest extends student.TestCase {
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;


    /**
     * a set up for planet test
     */
    public void setUp() {
        planet1 = new Planet("earth", 2, 6, 7, 8);
        planet2 = new Planet("venus", 3, 4, 5, 6);
        planet3 = new Planet("", 3, 4, 5, 6);
    }


    /**
     * test method for a class
     */
    public void testSetName() {
        planet3.setName("xyz");
        assertEquals("xyz", planet3.getName());
    }


    /**
     * test method for a class
     */
    public void testGetName() {
        assertEquals("earth", planet1.getName());
        assertEquals("venus", planet2.getName());
        assertEquals("", planet3.getName());
    }


    /**
     * test method for a class
     */
    public void testGetSkills() {
        Skills skill1 = new Skills(2, 6, 7);
        assertEquals(skill1, planet1.getSkills());
    }


    /**
     * test method for a class
     */
    public void testGetPopulation() {
        assertEquals(8, planet1.getPopulation().length);
    }


    /**
     * test method for a class
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet1.getPopulationSize());
    }


    /**
     * test method for a class
     */
    public void testGetCapacity() {
        assertEquals(8, planet1.getCapacity());
    }


    /**
     * test method for a class
     */
    public void testGetAvailability() {
        assertEquals(8, planet1.getAvailability());
    }


    /**
     * test method for a class
     */
    public void testIsFull() {
        assertFalse(planet1.isFull());
        Person person1 = new Person("x", 8, 8, 8, "");
        for (int i = 0; i < 9; i++) {
            planet1.addPerson(person1);
        }
        assertTrue(planet1.isFull());
    }


    /**
     * test method for a class
     */
    public void testIsQualified() {
        Person person1 = new Person("x", 8, 8, 8, "");
        Person person2 = new Person("y", 1, 1, 1, "");
        assertFalse(planet1.isQualified(person2));
        assertTrue(planet1.isQualified(person1));
    }


    /**
     * test method for a class
     */
    public void testAddPerson() {
        Person person1 = new Person("x", 8, 8, 8, "");
        Person person2 = new Person("y", 1, 1, 1, "");
        assertTrue(planet1.addPerson(person1));
        assertFalse(planet1.addPerson(person2));
        for (int i = 0; i < 9; i++) {
            planet1.addPerson(person1);
        }
        assertFalse(planet1.addPerson(person1));
    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals(
            "earth, population 0 (cap: 8), Requires: A>=2, M>=6, T>=7)", planet1
                .toString());
    }


    /**
     * test method for a class
     */
    public void testGetCompareTo() {
        assertEquals(2, planet1.compareTo(planet2));
        assertEquals(-2, planet2.compareTo(planet1));
        assertEquals(0, planet2.compareTo(planet2));
        Planet planet4 = null;
        Exception exception = null;
        try {
            planet1.compareTo(planet4);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * test method for a class
     */
    public void testEquals() {
        String x = "a";
        String y = null;
        assertFalse(planet1.equals(y));
        assertTrue(planet1.equals(planet1));
        assertFalse(planet1.equals(planet2));
        assertFalse(planet1.equals(x));
        Planet planet4 = new Planet("x", 2, 6, 7, 8);
        assertFalse(planet1.equals(planet4));
        Planet planet5 = new Planet("earth", 2, 6, 7, 8);
        assertTrue(planet1.equals(planet5));
        Person person1 = new Person("j", 5, 5, 5, "earth");
        planet1.addPerson(person1);
        assertTrue(planet1.equals(planet5));
        Planet planet6 = new Planet("x", 1, 6, 7, 8);
        assertFalse(planet4.equals(planet6));
        Planet planet7 = new Planet("x", 2, 5, 7, 8);
        assertFalse(planet4.equals(planet7));
        Planet planet8 = new Planet("x", 2, 6, 8, 8);
        assertFalse(planet4.equals(planet8));
        Planet planet9 = new Planet("x", 2, 6, 7, 9);
        assertFalse(planet4.equals(planet9));
        assertEquals(0, planet1.getPopulationSize());

    }

}
