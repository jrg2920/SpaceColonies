/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          A test class for colonycalculator
 */
public class ColonyCalculatorTest extends student.TestCase {
    private ColonyCalculator calculator;
    private ArrayQueue<Person> queue1;
    private Planet[] planet;


    /**
     * set up method for a class
     */
    public void setUp() {
        planet = new Planet[4];
        queue1 = new ArrayQueue<Person>();
        planet[1] = new Planet("Saturn", 1, 2, 1, 6);
        planet[2] = new Planet("Venus", 3, 4, 5, 6);
        planet[3] = new Planet("Mars", 1, 2, 2, 7);
        Person person1 = new Person("x", 2, 3, 4, "Mars");
        Person person2 = new Person("y", 2, 3, 4, "Saturn");
        queue1.enqueue(person1);
        queue1.enqueue(person2);
        calculator = new ColonyCalculator(queue1, planet);
        Exception exception = null;
        try {
            calculator = new ColonyCalculator(null, planet);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * test method for a class
     */
    public void testGetQueue() {
        assertEquals(queue1, calculator.getQueue());
    }


    /**
     * test method for a class
     */
    @SuppressWarnings("static-access")
    public void testGetPlanet() {
        assertEquals(planet, calculator.getPlanets());
    }


    /**
     * test method for a class
     */
    public void testGetPlanetForPerson() {
        Person x = new Person("v", 5, 5, 5, "");
        assertEquals(planet[3], calculator.getPlanetForPerson(x));
        assertEquals(null, calculator.getPlanetForPerson(null));

        Person a = new Person("a", 5, 5, 5, "");
        assertEquals(planet[3], calculator.getPlanetForPerson(a));

        Person h = new Person("h", 1, 1, 1, "Saturn");
        assertNull(calculator.getPlanetForPerson(h));

        Person l = new Person("l", 1, 1, 1, "Venus");
        assertNull(calculator.getPlanetForPerson(l));

        Person t = new Person("t", 6, 1, 1, "");
        assertNull(calculator.getPlanetForPerson(t));
        queue1.clear();
        for (int i = 0; i < 10; i++) {
            queue1.enqueue(new Person("a", 6, 1, 1, ""));
        }
        assertFalse(calculator.accept());
        queue1.clear();
        Person kj = null;
        assertNull(calculator.getPlanetForPerson(kj));

    }


    /**
     * test method for a class
     */
    public void testAccept() {
        assertTrue(calculator.accept());
        queue1.clear();
        assertFalse(calculator.accept());
        Person p = new Person("x", 5, 5, 5, "");
        queue1.enqueue(p);
        assertTrue(calculator.accept());

    }


    /**
     * test method for a class
     */
    public void testPlanetByNumber() {
        assertEquals(planet[1].toString(), calculator.planetByNumber(1)
            .toString());
        assertNull(calculator.planetByNumber(8));
        assertNull(calculator.planetByNumber(0));

    }


    /**
     * test method for a class
     */
    public void testReject() {
        assertTrue(calculator.accept());
        Person person = new Person("x", 1, 1, 1, "");
        queue1.enqueue(person);
        calculator.accept();
        calculator.accept();
        calculator.reject();
        assertFalse(calculator.accept());
    }


    /**
     * test method for a class
     */
    public void testGetPlanetIndex() {
        assertEquals(1, calculator.getPlanetIndex("Saturn"));
        assertEquals(0, calculator.getPlanetIndex("j"));
    }

}
